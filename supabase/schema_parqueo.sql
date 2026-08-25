-- ================================================================
-- Parqueadero · Sincronización entre celulares de una misma licencia
-- Requiere haber corrido antes supabase/schema.sql (tablas de licencias).
-- Pega y ejecuta este script completo, una sola vez, en:
-- Supabase → tu proyecto → SQL Editor → New query → Run
-- ================================================================

-- ---------- Seguridad: quién puede ver/escribir qué ----------
-- La app nunca hace login: manda la clave de licencia en el encabezado
-- HTTP "x-licencia-clave" en cada solicitud. Esta función la resuelve al
-- id de una licencia ACTIVA y VIGENTE (o null si no lo es), y las tablas
-- de abajo usan ese id tanto para filtrar qué se puede leer/escribir como
-- para rellenarlo automáticamente al insertar (la app nunca necesita
-- conocer ese id, solo su propia clave).

create or replace function licencia_id_desde_encabezado()
returns uuid
language sql
stable
security definer
set search_path = public
as $$
  select id from licencias
  where clave = coalesce(current_setting('request.headers', true)::json->>'x-licencia-clave', '')
    and estado = 'activa'
    and fecha_vencimiento >= current_date
  limit 1;
$$;

grant execute on function licencia_id_desde_encabezado() to anon, authenticated;

-- ---------- Tablas (un juego de datos de parqueo por licencia) ----------

create table if not exists parqueo_config (
  licencia_id uuid primary key references licencias(id) on delete cascade
    default licencia_id_desde_encabezado(),
  cfg jsonb not null default '{}'::jsonb,
  tarifas jsonb not null default '{}'::jsonb,
  consecutivo int not null default 1001,
  actualizado_en timestamptz not null default now()
);

create table if not exists parqueo_clientes (
  id text primary key,
  licencia_id uuid not null references licencias(id) on delete cascade
    default licencia_id_desde_encabezado(),
  placa text, nombre text, celular text, tipo text,
  actualizado_en timestamptz not null default now()
);

create table if not exists parqueo_ingresos (
  id text primary key,
  licencia_id uuid not null references licencias(id) on delete cascade
    default licencia_id_desde_encabezado(),
  recibo text, placa text, tipo text, electrico boolean, kwh numeric,
  nombre text, celular text, obs text,
  entrada timestamptz, salida timestamptz,
  valor numeric, valor_parqueo numeric, valor_recarga numeric,
  medio text, operario text,
  actualizado_en timestamptz not null default now()
);

create table if not exists parqueo_mensualidades (
  id text primary key,
  licencia_id uuid not null references licencias(id) on delete cascade
    default licencia_id_desde_encabezado(),
  recibo text, placa text, tipo text, titular text, celular text,
  desde date, hasta date, incluye_recarga boolean, valor numeric,
  medio text, fecha timestamptz, operario text,
  actualizado_en timestamptz not null default now()
);

create index if not exists idx_pc_licencia on parqueo_clientes (licencia_id);
create index if not exists idx_pi_licencia_act on parqueo_ingresos (licencia_id, actualizado_en);
create index if not exists idx_pm_licencia_act on parqueo_mensualidades (licencia_id, actualizado_en);

-- ---------- actualizado_en automático (reutiliza la función que ya existe
-- desde supabase/schema.sql para las licencias) ----------

drop trigger if exists trg_pcfg_actualizado on parqueo_config;
create trigger trg_pcfg_actualizado before update on parqueo_config
  for each row execute function set_actualizado_en();

drop trigger if exists trg_pc_actualizado on parqueo_clientes;
create trigger trg_pc_actualizado before update on parqueo_clientes
  for each row execute function set_actualizado_en();

drop trigger if exists trg_pi_actualizado on parqueo_ingresos;
create trigger trg_pi_actualizado before update on parqueo_ingresos
  for each row execute function set_actualizado_en();

drop trigger if exists trg_pm_actualizado on parqueo_mensualidades;
create trigger trg_pm_actualizado before update on parqueo_mensualidades
  for each row execute function set_actualizado_en();

-- ---------- RLS: cada licencia solo ve y modifica sus propios datos ----------

alter table parqueo_config enable row level security;
alter table parqueo_clientes enable row level security;
alter table parqueo_ingresos enable row level security;
alter table parqueo_mensualidades enable row level security;

drop policy if exists tenant_parqueo_config on parqueo_config;
create policy tenant_parqueo_config on parqueo_config
  for all to anon, authenticated
  using (licencia_id = licencia_id_desde_encabezado())
  with check (licencia_id = licencia_id_desde_encabezado());

drop policy if exists tenant_parqueo_clientes on parqueo_clientes;
create policy tenant_parqueo_clientes on parqueo_clientes
  for all to anon, authenticated
  using (licencia_id = licencia_id_desde_encabezado())
  with check (licencia_id = licencia_id_desde_encabezado());

drop policy if exists tenant_parqueo_ingresos on parqueo_ingresos;
create policy tenant_parqueo_ingresos on parqueo_ingresos
  for all to anon, authenticated
  using (licencia_id = licencia_id_desde_encabezado())
  with check (licencia_id = licencia_id_desde_encabezado());

drop policy if exists tenant_parqueo_mensualidades on parqueo_mensualidades;
create policy tenant_parqueo_mensualidades on parqueo_mensualidades
  for all to anon, authenticated
  using (licencia_id = licencia_id_desde_encabezado())
  with check (licencia_id = licencia_id_desde_encabezado());

-- ---------- Numeración de recibo sin choques entre celulares ----------
-- Entrega el siguiente consecutivo de forma atómica (a prueba de que dos
-- celulares lo pidan casi al mismo tiempo). La app la llama cuando hay
-- internet; sin internet sigue numerando localmente como respaldo.

create or replace function siguiente_consecutivo(p_clave text)
returns int
language plpgsql
security definer
set search_path = public
as $$
declare
  v_licencia_id uuid;
  v_valor int;
begin
  select id into v_licencia_id from licencias
  where clave = p_clave and estado = 'activa' and fecha_vencimiento >= current_date;

  if v_licencia_id is null then
    raise exception 'Licencia no válida';
  end if;

  insert into parqueo_config (licencia_id, consecutivo)
  values (v_licencia_id, 1001)
  on conflict (licencia_id) do update set consecutivo = parqueo_config.consecutivo + 1
  returning consecutivo into v_valor;

  return v_valor;
end;
$$;

revoke all on function siguiente_consecutivo(text) from public;
grant execute on function siguiente_consecutivo(text) to anon;

-- ================================================================
-- Verificación rápida (opcional):
--
--   select siguiente_consecutivo('TU-CLAVE-DE-PRUEBA');
--   -- debe devolver 1001 la primera vez, 1002 la segunda, etc.
--
-- Prueba de RLS (simula el encabezado que manda la app):
--   set local request.headers = '{"x-licencia-clave":"TU-CLAVE-DE-PRUEBA"}';
--   select * from parqueo_ingresos;  -- debe funcionar sin error de permisos
-- ================================================================
