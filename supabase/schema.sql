-- ================================================================
-- Parqueadero · Licenciamiento
-- Pega y ejecuta este script completo, una sola vez, en:
-- Supabase → tu proyecto → SQL Editor → New query → Run
-- ================================================================

create extension if not exists pgcrypto;

-- ---------- Tablas ----------

create table if not exists clientes (
  id uuid primary key default gen_random_uuid(),
  nombre_negocio text not null,
  contacto text,
  celular text,
  email text,
  notas text,
  creado_en timestamptz not null default now()
);

create table if not exists licencias (
  id uuid primary key default gen_random_uuid(),
  cliente_id uuid not null references clientes(id) on delete cascade,
  clave text not null unique
    default ('PQ-' || upper(substr(encode(gen_random_bytes(6), 'hex'), 1, 8))),
  tipo text not null check (tipo in ('mensual', 'alquiler', 'anual')),
  estado text not null default 'activa' check (estado in ('activa', 'suspendida', 'cancelada')),
  fecha_inicio date not null default current_date,
  fecha_vencimiento date not null,
  dias_gracia int not null default 5,
  valor numeric,
  device_id text,
  creado_en timestamptz not null default now(),
  actualizado_en timestamptz not null default now()
);

create table if not exists pagos (
  id uuid primary key default gen_random_uuid(),
  licencia_id uuid not null references licencias(id) on delete cascade,
  monto numeric not null,
  medio text,
  fecha date not null default current_date,
  periodo_desde date,
  periodo_hasta date,
  nota text,
  creado_en timestamptz not null default now()
);

create index if not exists idx_licencias_clave on licencias (clave);
create index if not exists idx_licencias_cliente on licencias (cliente_id);
create index if not exists idx_pagos_licencia on pagos (licencia_id);

-- ---------- actualizado_en automático en licencias ----------

create or replace function set_actualizado_en()
returns trigger
language plpgsql
as $$
begin
  new.actualizado_en = now();
  return new;
end;
$$;

drop trigger if exists trg_licencias_actualizado on licencias;
create trigger trg_licencias_actualizado
  before update on licencias
  for each row execute function set_actualizado_en();

-- ---------- Seguridad: RLS ----------
-- No se crea ninguna política para "anon": las tablas quedan denegadas por
-- defecto para cualquiera que no sea un usuario autenticado (tú, desde el
-- panel admin). La app nunca lee estas tablas directamente: solo llama a
-- la función verificar_licencia() de abajo.

alter table clientes enable row level security;
alter table licencias enable row level security;
alter table pagos enable row level security;

drop policy if exists admin_acceso_clientes on clientes;
create policy admin_acceso_clientes on clientes
  for all to authenticated using (true) with check (true);

drop policy if exists admin_acceso_licencias on licencias;
create policy admin_acceso_licencias on licencias
  for all to authenticated using (true) with check (true);

drop policy if exists admin_acceso_pagos on pagos;
create policy admin_acceso_pagos on pagos
  for all to authenticated using (true) with check (true);

-- ---------- Función pública de validación ----------
-- Única puerta que usa la app Android. No expone las tablas ni datos de
-- otros clientes: solo devuelve si ESA clave está vigente.

create or replace function verificar_licencia(p_clave text, p_device text default null)
returns json
language plpgsql
security definer
set search_path = public
as $$
declare
  r licencias%rowtype;
  v_valido boolean;
  v_mensaje text;
begin
  select * into r from licencias where clave = p_clave;

  if not found then
    return json_build_object(
      'valido', false, 'estado', 'no_existe',
      'vence', null, 'dias_gracia', 5, 'mensaje', 'Licencia no encontrada'
    );
  end if;

  -- Registra el dispositivo en la primera activación (no bloquea si luego
  -- cambia de celular: solo queda visible para ti en el panel admin).
  if r.device_id is null and p_device is not null then
    update licencias set device_id = p_device where id = r.id;
  end if;

  if r.estado = 'suspendida' then
    v_valido := false;
    v_mensaje := 'Licencia suspendida por el administrador';
  elsif r.estado = 'cancelada' then
    v_valido := false;
    v_mensaje := 'Licencia cancelada';
  elsif r.fecha_vencimiento < current_date then
    v_valido := false;
    v_mensaje := 'Licencia vencida el ' || to_char(r.fecha_vencimiento, 'DD/MM/YYYY');
  else
    v_valido := true;
    v_mensaje := 'Licencia activa';
  end if;

  return json_build_object(
    'valido', v_valido, 'estado', r.estado,
    'vence', r.fecha_vencimiento, 'dias_gracia', r.dias_gracia, 'mensaje', v_mensaje
  );
end;
$$;

revoke all on function verificar_licencia(text, text) from public;
grant execute on function verificar_licencia(text, text) to anon, authenticated;

-- ================================================================
-- Verificación rápida (opcional, puedes correr esto después):
--
--   select verificar_licencia('clave-que-no-existe', null);
--   -- debe devolver {"valido":false,"estado":"no_existe",...}
--
--   insert into clientes (nombre_negocio, celular)
--     values ('Cliente de prueba', '3000000000') returning id;
--   -- copia el id que devuelve y úsalo abajo:
--   insert into licencias (cliente_id, tipo, fecha_vencimiento, valor)
--     values ('<id-del-cliente>', 'mensual', current_date + 30, 50000)
--     returning clave;
--   -- copia la clave que devuelve y prueba:
--   select verificar_licencia('<clave-devuelta>', 'dispositivo-prueba');
--   -- debe devolver {"valido":true,"estado":"activa",...}
-- ================================================================
