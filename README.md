<!doctype html>
<html lang="es">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1,viewport-fit=cover">
<meta name="theme-color" content="#22BFBF">
<meta name="description" content="Huellitas Felices — cuidado preventivo, salud y bienestar de perros y gatos.">
<title>Huellitas Felices</title>
<style>
:root{
  --turquesa:#1FB6B6; --turquesa-700:#159C9C; --turquesa-900:#0E7C7C;
  --verde-agua:#5FD6C4; --menta:#D6F5EE; --menta-2:#EAFBF6;
  --crema:#FFF7EE; --blanco:#FFFFFF;
  --coral:#FF7E67; --rosado:#FF9BC0; --amarillo:#FFCB57; --verde:#5EC46B;
  --azul:#5B9BD5; --morado:#A578E6;
  --texto:#213F3D; --muted:#6E8F8B; --linea:#E7F0ED; --danger:#E5533C;
  --sombra:0 12px 30px rgba(19,86,86,.10); --sombra-sm:0 6px 16px rgba(19,86,86,.08);
  --r-lg:22px; --r-md:16px; --r-sm:12px;
  --safe-b:env(safe-area-inset-bottom,0px);
}
*{box-sizing:border-box}
html,body{height:100%}
body{
  margin:0;color:var(--texto);
  font-family:"Segoe UI",system-ui,-apple-system,BlinkMacSystemFont,"Trebuchet MS",Roboto,sans-serif;
  background:linear-gradient(160deg,#BFEDE6 0%,#E9FBF6 40%,#FFF7EE 100%);
  -webkit-font-smoothing:antialiased;line-height:1.45;
}
button,input,select,textarea{font:inherit;color:inherit}
button{cursor:pointer;border:0;background:none}
img,svg{display:block}
:focus-visible{outline:3px solid var(--turquesa);outline-offset:2px;border-radius:8px}
::selection{background:var(--verde-agua);color:#093f3b}

/* ---------- Contenedor tipo dispositivo ---------- */
.app{
  position:relative;max-width:480px;margin:0 auto;min-height:100vh;min-height:100dvh;
  background:var(--crema);display:flex;flex-direction:column;overflow:hidden;
}
@media(min-width:900px){
  body{padding:26px 0;align-items:flex-start}
  .app{min-height:auto;height:min(880px,calc(100vh - 52px));border-radius:34px;
    box-shadow:0 40px 90px rgba(15,80,80,.28);border:10px solid #0d3a3a;overflow:hidden}
}

/* ---------- Barra superior ---------- */
.topbar{
  position:sticky;top:0;z-index:20;color:#fff;
  background:linear-gradient(120deg,var(--turquesa) 0%,var(--verde-agua) 100%);
  padding:calc(12px + env(safe-area-inset-top,0px)) 14px 12px;
  display:flex;align-items:center;gap:10px;box-shadow:0 6px 18px rgba(20,120,120,.22);
}
.topbar .brand{display:flex;align-items:center;gap:9px;font-weight:800;letter-spacing:.2px;font-size:18px}
.topbar .brand small{display:block;font-weight:600;font-size:11px;opacity:.9;letter-spacing:.3px;margin-top:-2px}
.icon-btn{width:44px;height:44px;border-radius:14px;display:grid;place-items:center;color:#fff;transition:.15s}
.icon-btn:hover,.icon-btn:active{background:rgba(255,255,255,.18)}
.spacer{flex:1}
.bell{position:relative}
.bell .dot{position:absolute;top:7px;right:8px;min-width:18px;height:18px;padding:0 4px;border-radius:9px;background:var(--coral);
  color:#fff;font-size:11px;font-weight:800;display:grid;place-items:center;border:2px solid #fff}

/* ---------- Vista con scroll ---------- */
.view{flex:1;overflow-y:auto;overflow-x:hidden;padding:16px 14px calc(96px + var(--safe-b));-webkit-overflow-scrolling:touch}
.view::-webkit-scrollbar{width:8px}.view::-webkit-scrollbar-thumb{background:#cfe6e1;border-radius:8px}

/* ---------- Tipografía / secciones ---------- */
h1,h2,h3{margin:0;line-height:1.2}
.page-title{font-size:22px;font-weight:800;color:var(--turquesa-900);display:flex;align-items:center;gap:8px}
.page-sub{color:var(--muted);font-size:13px;margin:2px 0 14px}
.section-title{font-size:15px;font-weight:800;margin:18px 4px 8px;color:var(--texto);display:flex;align-items:center;gap:7px}
.section-title .link{margin-left:auto;font-size:12px;color:var(--turquesa-700);font-weight:700}

/* ---------- Tarjetas ---------- */
.card{background:var(--blanco);border-radius:var(--r-lg);box-shadow:var(--sombra-sm);padding:16px;margin-bottom:12px;border:1px solid #eef6f3}
.card.flat{box-shadow:none;border:1px solid var(--linea)}
.tile{display:flex;align-items:center;gap:13px}
.avatar{width:52px;height:52px;border-radius:16px;display:grid;place-items:center;font-size:26px;flex:none;
  background:var(--menta);color:var(--turquesa-900)}
.avatar.coral{background:#ffe4dd}.avatar.rosa{background:#ffe1ee}.avatar.amar{background:#fff0cf}
.avatar.verde{background:#dcf3de}.avatar.azul{background:#e0edf9}.avatar.mora{background:#eee2fb}
.grow{flex:1;min-width:0}
.ellip{white-space:nowrap;overflow:hidden;text-overflow:ellipsis}
.muted{color:var(--muted)}.small{font-size:12px}.tiny{font-size:11px}
.strong{font-weight:800}

/* ---------- Chips / badges ---------- */
.badge{display:inline-flex;align-items:center;gap:5px;font-size:11px;font-weight:800;padding:4px 9px;border-radius:999px;line-height:1;white-space:nowrap}
.b-verde{background:#e0f5e2;color:#2f8b3c}.b-coral{background:#ffe6e0;color:#d1543e}
.b-mora{background:#efe4fc;color:#7c48c9}.b-azul{background:#e2eefb;color:#3d76b8}
.b-amar{background:#fff2d2;color:#b5820f}.b-gris{background:#eef3f2;color:#6a8783}
.b-danger{background:#fde3de;color:#c23c26}
.dot-status{width:9px;height:9px;border-radius:50%;display:inline-block;flex:none}

/* ---------- Botones ---------- */
.btn{display:inline-flex;align-items:center;justify-content:center;gap:8px;min-height:46px;padding:11px 18px;border-radius:14px;
  font-weight:800;font-size:15px;transition:.15s;background:var(--menta);color:var(--turquesa-900)}
.btn:hover{filter:brightness(.98)}.btn:active{transform:translateY(1px)}
.btn.block{width:100%}
.btn.primary{background:linear-gradient(120deg,var(--turquesa),var(--verde-agua));color:#fff;box-shadow:0 8px 18px rgba(31,182,182,.32)}
.btn.coral{background:var(--coral);color:#fff}
.btn.ghost{background:#fff;border:1.5px solid var(--linea);color:var(--texto)}
.btn.danger{background:#fdeae6;color:var(--danger)}
.btn.sm{min-height:38px;padding:8px 14px;font-size:13px;border-radius:12px}

/* Accesos rápidos */
.quick{display:grid;grid-template-columns:repeat(2,1fr);gap:10px}
.quick .q{display:flex;flex-direction:column;gap:8px;align-items:flex-start;padding:14px;border-radius:var(--r-md);
  background:#fff;border:1px solid #eef6f3;box-shadow:var(--sombra-sm);text-align:left}
.quick .q .ic{width:40px;height:40px;border-radius:12px;display:grid;place-items:center}
.quick .q b{font-size:14px}.quick .q span{font-size:11.5px;color:var(--muted)}

/* Stats */
.stats{display:grid;grid-template-columns:repeat(3,1fr);gap:10px}
.stat{background:#fff;border-radius:var(--r-md);padding:12px;text-align:center;box-shadow:var(--sombra-sm);border:1px solid #eef6f3}
.stat b{font-size:22px;color:var(--turquesa-900);display:block}.stat span{font-size:11px;color:var(--muted)}

/* Hero dashboard */
.hero{background:linear-gradient(120deg,var(--turquesa),var(--verde-agua));color:#fff;border-radius:var(--r-lg);
  padding:16px;display:flex;align-items:center;gap:14px;box-shadow:0 12px 26px rgba(31,182,182,.30);margin-bottom:14px}
.hero .hi{font-size:13px;opacity:.92}.hero .nm{font-size:20px;font-weight:800}
.hero .ill{width:74px;height:74px;flex:none}

/* Lista pill filtros */
.filters{display:flex;gap:8px;overflow-x:auto;padding:2px 2px 8px;margin:0 -2px}
.filters::-webkit-scrollbar{display:none}
.chip{flex:none;padding:9px 14px;border-radius:999px;background:#fff;border:1.5px solid var(--linea);font-weight:700;font-size:13px;color:var(--muted)}
.chip.active{background:var(--turquesa);border-color:var(--turquesa);color:#fff}

/* Search */
.search{display:flex;align-items:center;gap:9px;background:#fff;border:1.5px solid var(--linea);border-radius:14px;padding:0 12px;margin-bottom:10px}
.search input{border:0;outline:0;background:none;flex:1;padding:13px 0;font-size:15px}

/* Calendario */
.cal{background:#fff;border-radius:var(--r-lg);box-shadow:var(--sombra-sm);padding:14px;border:1px solid #eef6f3}
.cal-head{display:flex;align-items:center;justify-content:space-between;margin-bottom:10px}
.cal-head b{font-weight:800;text-transform:capitalize}
.cal-grid{display:grid;grid-template-columns:repeat(7,1fr);gap:4px;text-align:center}
.cal-grid .dow{font-size:10px;font-weight:800;color:var(--muted);padding:4px 0;text-transform:uppercase}
.cal-cell{aspect-ratio:1;display:flex;flex-direction:column;align-items:center;justify-content:center;border-radius:10px;font-size:13px;position:relative}
.cal-cell.pad{visibility:hidden}
.cal-cell.today{outline:2px solid var(--turquesa);font-weight:800}
.cal-cell .mk{position:absolute;bottom:4px;width:6px;height:6px;border-radius:50%}
.cal-cell.has{color:#fff;font-weight:800}
.cal-legend{display:flex;flex-wrap:wrap;gap:10px 14px;margin-top:12px;font-size:11.5px;color:var(--muted)}
.cal-legend span{display:inline-flex;align-items:center;gap:6px}

/* Perfil mascota header (vacunas) */
.pet-head{background:#fff;border-radius:var(--r-lg);box-shadow:var(--sombra-sm);border:1px solid #eef6f3;padding:14px;display:flex;align-items:center;gap:12px;margin-bottom:12px}

/* Estados vacíos */
.empty{text-align:center;color:var(--muted);padding:34px 16px}
.empty .ill{width:120px;height:120px;margin:0 auto 10px;opacity:.95}
.empty b{display:block;color:var(--texto);font-size:16px;margin-bottom:4px}

/* Aviso preventivo */
.notice{display:flex;gap:11px;align-items:flex-start;background:#eaf7f4;border:1px solid #cfeee7;border-radius:var(--r-md);padding:12px 13px;color:#2b625c;font-size:12.5px}
.notice svg{flex:none;color:var(--turquesa-700)}

/* Formularios */
.field{margin-bottom:12px}
.field label{display:block;font-size:12.5px;font-weight:800;color:var(--texto);margin-bottom:6px}
.field .req{color:var(--coral)}
.field input,.field select,.field textarea{width:100%;border:1.5px solid var(--linea);background:#fff;border-radius:12px;
  padding:12px;outline:none;font-size:15px;transition:.15s}
.field textarea{min-height:80px;resize:vertical}
.field input:focus,.field select:focus,.field textarea:focus{border-color:var(--turquesa);box-shadow:0 0 0 3px rgba(31,182,182,.14)}
.field .err{color:var(--danger);font-size:12px;margin-top:5px;display:none}
.field.invalid input,.field.invalid select,.field.invalid textarea{border-color:var(--danger);box-shadow:0 0 0 3px rgba(229,83,60,.12)}
.field.invalid .err{display:block}
.grid2{display:grid;grid-template-columns:1fr 1fr;gap:10px}
.seg{display:flex;gap:8px}
.seg .opt{flex:1;border:1.5px solid var(--linea);background:#fff;border-radius:12px;padding:11px;text-align:center;font-weight:800;font-size:14px;color:var(--muted)}
.seg .opt.on{background:var(--menta);border-color:var(--turquesa);color:var(--turquesa-900)}

/* ---------- Bottom nav ---------- */
.bottom-nav{
  position:absolute;left:0;right:0;bottom:0;z-index:25;background:#fff;border-top:1px solid var(--linea);
  display:grid;grid-template-columns:repeat(5,1fr);padding:6px 4px calc(6px + var(--safe-b));box-shadow:0 -6px 20px rgba(19,86,86,.06)}
.bn{display:flex;flex-direction:column;align-items:center;gap:3px;padding:7px 2px;border-radius:12px;color:var(--muted);font-size:10.5px;font-weight:700;min-height:46px}
.bn svg{width:23px;height:23px}
.bn.active{color:var(--turquesa-900)}
.bn.active .ico{background:var(--menta);border-radius:12px}
.bn .ico{padding:3px 12px;transition:.15s}

/* ---------- Drawer ---------- */
.scrim{position:absolute;inset:0;background:rgba(10,50,50,.45);opacity:0;pointer-events:none;transition:.2s;z-index:40}
.scrim.show{opacity:1;pointer-events:auto}
.drawer{position:absolute;top:0;bottom:0;left:0;width:82%;max-width:320px;background:#fff;z-index:45;transform:translateX(-104%);
  transition:transform .24s cubic-bezier(.2,.8,.2,1);box-shadow:12px 0 40px rgba(10,50,50,.2);display:flex;flex-direction:column}
.drawer.show{transform:translateX(0)}
.drawer-head{background:linear-gradient(120deg,var(--turquesa),var(--verde-agua));color:#fff;padding:calc(18px + env(safe-area-inset-top,0px)) 16px 18px}
.drawer-head .who{display:flex;align-items:center;gap:11px;margin-top:10px}
.drawer-head .who .av{width:46px;height:46px;border-radius:14px;background:rgba(255,255,255,.22);display:grid;place-items:center;font-size:22px}
.drawer-nav{padding:8px;overflow-y:auto;flex:1}
.dn{display:flex;align-items:center;gap:13px;width:100%;padding:12px 12px;border-radius:12px;font-weight:700;font-size:14.5px;color:var(--texto);text-align:left}
.dn:hover{background:var(--menta-2)}
.dn.active{background:var(--menta);color:var(--turquesa-900)}
.dn svg{width:22px;height:22px;color:var(--turquesa-700)}
.dn.danger{color:var(--danger)}.dn.danger svg{color:var(--danger)}
.dn-sep{height:1px;background:var(--linea);margin:8px 10px}

/* ---------- Modal ---------- */
.modal-scrim{position:absolute;inset:0;background:rgba(10,50,50,.5);z-index:60;display:flex;align-items:flex-end;justify-content:center;
  opacity:0;pointer-events:none;transition:.2s}
.modal-scrim.show{opacity:1;pointer-events:auto}
.modal{width:100%;max-width:480px;background:#fff;border-radius:24px 24px 0 0;max-height:92%;display:flex;flex-direction:column;
  transform:translateY(20px);transition:.24s}
.modal-scrim.show .modal{transform:none}
@media(min-width:900px){.modal-scrim{align-items:center}.modal{border-radius:24px;max-height:86%}}
.modal-head{display:flex;align-items:center;gap:10px;padding:16px 16px 8px}
.modal-head h3{font-size:18px;font-weight:800;flex:1}
.modal-body{padding:6px 16px;overflow-y:auto}
.modal-foot{padding:12px 16px calc(16px + var(--safe-b));display:flex;gap:10px;border-top:1px solid var(--linea)}
.modal-foot .btn{flex:1}
.grabber{width:44px;height:5px;border-radius:3px;background:#d9e7e3;margin:8px auto 0}

/* ---------- Bienvenida / Login ---------- */
.welcome{min-height:100vh;min-height:100dvh;display:flex;flex-direction:column;align-items:center;justify-content:center;padding:30px 22px calc(30px + var(--safe-b));text-align:center;
  background:radial-gradient(120% 60% at 50% 0%,#8fe4d8 0%,transparent 60%),linear-gradient(160deg,#BFEDE6,#FFF7EE)}
.welcome .logo-mark{width:150px;height:150px;margin-bottom:6px;filter:drop-shadow(0 12px 20px rgba(20,120,120,.25))}
.welcome h1{font-size:30px;font-weight:900;color:var(--turquesa-900);letter-spacing:.4px}
.welcome .tag{color:#3c6a64;font-size:14px;max-width:300px;margin:8px 0 22px}
.welcome .card{width:100%;max-width:340px;text-align:left}
.welcome .paw-strip{display:flex;gap:8px;justify-content:center;margin:16px 0 0;color:var(--turquesa-700);opacity:.6}
.link-btn{background:none;color:var(--turquesa-700);font-weight:800;font-size:13.5px;padding:8px}
@media(min-width:900px){.welcome{border-radius:24px}}

/* Toast */
.toast{position:absolute;left:50%;bottom:calc(86px + var(--safe-b));transform:translate(-50%,14px);z-index:80;
  background:#0f4f4f;color:#eafffb;padding:12px 18px;border-radius:14px;font-weight:700;font-size:14px;box-shadow:var(--sombra);
  opacity:0;pointer-events:none;transition:.25s;display:flex;align-items:center;gap:9px;max-width:88%}
.toast.show{opacity:1;transform:translate(-50%,0)}
.toast.ok{background:#1f7a5a}.toast.err{background:#b23b28}

.hidden{display:none!important}
@media(prefers-reduced-motion:reduce){*{transition:none!important}}
</style>
</head>
<body>
<div class="app" id="app" aria-live="polite"></div>
<div class="toast" id="toast" role="status" aria-live="assertive"></div>

<script>
"use strict";
/* ================================================================
   HUELLITAS FELICES · App de cuidado preventivo de mascotas
   Un solo archivo · HTML + CSS + JS puro · IndexedDB (+ fallback)
================================================================ */

/* ---------------- Iconos SVG ---------------- */
const I = {
  menu:'<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2.2" stroke-linecap="round"><path d="M4 7h16M4 12h16M4 17h16"/></svg>',
  bell:'<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><path d="M6 9a6 6 0 1 1 12 0c0 5 2 6 2 6H4s2-1 2-6"/><path d="M10 20a2 2 0 0 0 4 0"/></svg>',
  home:'<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><path d="M4 11l8-7 8 7"/><path d="M6 10v9h12v-9"/></svg>',
  paw:'<svg viewBox="0 0 24 24" fill="currentColor"><circle cx="6" cy="11" r="2"/><circle cx="10" cy="6.5" r="2"/><circle cx="14" cy="6.5" r="2"/><circle cx="18" cy="11" r="2"/><path d="M12 12c-2.6 0-4.7 1.7-5.3 3.7-.5 1.7.8 3.3 2.6 3.3.9 0 1.7-.3 2.7-.3s1.8.3 2.7.3c1.8 0 3.1-1.6 2.6-3.3C16.7 13.7 14.6 12 12 12z"/></svg>',
  heart:'<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><path d="M12 20s-7-4.4-9.2-8.4C1.2 8.7 2.6 5.5 5.7 5.5c1.9 0 3.1 1.1 3.8 2.2.4.6 1.4.6 1.8 0 .7-1.1 1.9-2.2 3.8-2.2 3.1 0 4.5 3.2 2.9 6.1C19 15.6 12 20 12 20z"/><path d="M6 11h2l1-2 2 4 1.5-3 1 1h3.5"/></svg>',
  vaccine:'<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><path d="M17 3l4 4M18 6l-8.5 8.5-3.5 1 1-3.5L15.5 3.5z"/><path d="M8 16l-3 3M12 9l2 2M9.5 11.5l2 2"/></svg>',
  gear:'<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><circle cx="12" cy="12" r="3"/><path d="M19 12a7 7 0 0 0-.1-1l2-1.6-2-3.4-2.3.9a7 7 0 0 0-1.7-1L14.5 2h-5l-.4 2.3a7 7 0 0 0-1.7 1L5.1 4.4l-2 3.4L5.1 9.4a7 7 0 0 0 0 5.2L3.1 16.2l2 3.4 2.3-.9a7 7 0 0 0 1.7 1L9.5 22h5l.4-2.3a7 7 0 0 0 1.7-1l2.3.9 2-3.4-2-1.6c.1-.3.1-.7.1-1z"/></svg>',
  book:'<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><path d="M4 5a2 2 0 0 1 2-2h11v16H6a2 2 0 0 0-2 2z"/><path d="M17 3l3 0v16l-3 0"/></svg>',
  clock:'<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><circle cx="12" cy="12" r="9"/><path d="M12 7v5l3 2"/></svg>',
  chat:'<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><path d="M21 12a8 8 0 0 1-11.5 7.2L4 20l1-4.2A8 8 0 1 1 21 12z"/></svg>',
  shield:'<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><path d="M12 3l7 3v5c0 5-3.4 8.4-7 10-3.6-1.6-7-5-7-10V6z"/><path d="M9 12l2 2 4-4"/></svg>',
  user:'<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><circle cx="12" cy="8" r="4"/><path d="M4 21c0-4 3.6-6 8-6s8 2 8 6"/></svg>',
  admin:'<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><path d="M12 3l7 3v5c0 5-3.4 8.4-7 10-3.6-1.6-7-5-7-10V6z"/><circle cx="12" cy="10" r="2.2"/><path d="M8.5 16c.6-1.6 2-2.4 3.5-2.4s2.9.8 3.5 2.4"/></svg>',
  plus:'<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2.4" stroke-linecap="round"><path d="M12 5v14M5 12h14"/></svg>',
  search:'<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"><circle cx="11" cy="11" r="7"/><path d="M21 21l-4-4"/></svg>',
  close:'<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2.2" stroke-linecap="round"><path d="M6 6l12 12M18 6L6 18"/></svg>',
  edit:'<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><path d="M4 20h4L19 9l-4-4L4 16z"/><path d="M14 6l4 4"/></svg>',
  trash:'<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><path d="M4 7h16M9 7V4h6v3M6 7l1 13h10l1-13"/></svg>',
  download:'<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><path d="M12 4v11m0 0l-4-4m4 4l4-4"/><path d="M5 19h14"/></svg>',
  upload:'<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><path d="M12 20V9m0 0L8 13m4-4l4 4"/><path d="M5 5h14"/></svg>',
  refresh:'<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><path d="M4 12a8 8 0 0 1 14-5l2 2M20 12a8 8 0 0 1-14 5l-2-2"/><path d="M18 4v5h-5M6 20v-5h5"/></svg>',
  check:'<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2.4" stroke-linecap="round" stroke-linejoin="round"><path d="M5 12l5 5L20 6"/></svg>',
  logout:'<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><path d="M15 12H3m0 0l4-4m-4 4l4 4"/><path d="M11 4h6a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2h-6"/></svg>',
  chev:'<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><path d="M9 6l6 6-6 6"/></svg>',
  info:'<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><circle cx="12" cy="12" r="9"/><path d="M12 11v5M12 8h.01"/></svg>',
  scale:'<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><path d="M12 3v3M6 6h12M4 20h16M8 20v-2a4 4 0 0 1 8 0v2"/></svg>',
  bath:'<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><path d="M4 12h16v3a4 4 0 0 1-4 4H8a4 4 0 0 1-4-4z"/><path d="M6 12V6a2 2 0 0 1 4 0"/><path d="M8 6h.01"/></svg>',
};

/* Ilustración logo (perro + gato, original) */
const LOGO = `
<svg class="logo-mark" viewBox="0 0 200 200" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Huellitas Felices">
  <circle cx="100" cy="100" r="92" fill="#fff"/>
  <circle cx="100" cy="100" r="92" fill="none" stroke="#1FB6B6" stroke-width="9"/>
  <!-- perro -->
  <g transform="translate(58 96)">
    <ellipse cx="0" cy="14" rx="34" ry="30" fill="#F6C177"/>
    <path d="M-30 -6c-10-6-16 2-14 12 2 8 12 10 16 6z" fill="#E0A24E"/>
    <path d="M30 -6c10-6 16 2 14 12-2 8-12 10-16 6z" fill="#E0A24E"/>
    <circle cx="-11" cy="8" r="4.5" fill="#3a2a1a"/><circle cx="11" cy="8" r="4.5" fill="#3a2a1a"/>
    <ellipse cx="0" cy="20" rx="7" ry="5.5" fill="#3a2a1a"/>
    <path d="M-7 30q7 6 14 0" fill="none" stroke="#3a2a1a" stroke-width="3" stroke-linecap="round"/>
    <circle cx="-20" cy="22" r="5" fill="#FF9BC0" opacity=".7"/><circle cx="20" cy="22" r="5" fill="#FF9BC0" opacity=".7"/>
  </g>
  <!-- gato -->
  <g transform="translate(128 108)">
    <path d="M-22 -20l-6-16 16 8z" fill="#9FB0BC"/><path d="M22 -20l6-16-16 8z" fill="#9FB0BC"/>
    <ellipse cx="0" cy="6" rx="26" ry="24" fill="#B9C6CF"/>
    <circle cx="-9" cy="2" r="3.6" fill="#274b48"/><circle cx="9" cy="2" r="3.6" fill="#274b48"/>
    <path d="M0 9l-3 4h6z" fill="#FF7E67"/>
    <path d="M-6 16q6 5 12 0" fill="none" stroke="#274b48" stroke-width="2.6" stroke-linecap="round"/>
    <path d="M-24 8h-12M-24 13h-11M24 8h12M24 13h11" stroke="#8a99a3" stroke-width="2" stroke-linecap="round"/>
  </g>
  <path d="M100 150c8 0 10 6 6 10s-14 4-18 0-2-10 6-10z" fill="#FF7E67"/>
  <g fill="#FFCB57"><circle cx="40" cy="52" r="4"/><circle cx="160" cy="60" r="4"/><circle cx="150" cy="150" r="4"/></g>
</svg>`;

const ILL = {
  duo:`<svg class="ill" viewBox="0 0 100 100"><circle cx="50" cy="50" r="48" fill="rgba(255,255,255,.18)"/><g transform="translate(30 46)"><ellipse cx="0" cy="9" rx="20" ry="17" fill="#F6C177"/><path d="M-18 -3c-6-4-9 1-8 7 1 5 7 6 10 3z" fill="#E0A24E"/><path d="M18 -3c6-4 9 1 8 7-1 5-7 6-10 3z" fill="#E0A24E"/><circle cx="-6" cy="5" r="2.6" fill="#3a2a1a"/><circle cx="6" cy="5" r="2.6" fill="#3a2a1a"/><ellipse cx="0" cy="12" rx="4" ry="3" fill="#3a2a1a"/></g><g transform="translate(70 54)"><path d="M-12 -12l-3-9 9 5z" fill="#9FB0BC"/><path d="M12 -12l3-9-9 5z" fill="#9FB0BC"/><ellipse cx="0" cy="3" rx="15" ry="14" fill="#B9C6CF"/><circle cx="-5" cy="0" r="2.2" fill="#274b48"/><circle cx="5" cy="0" r="2.2" fill="#274b48"/><path d="M0 4l-2 2h4z" fill="#FF7E67"/></g></svg>`,
  empty:`<svg class="ill" viewBox="0 0 120 120"><circle cx="60" cy="60" r="56" fill="#EAFBF6"/><g transform="translate(60 62)"><ellipse cx="0" cy="12" rx="26" ry="22" fill="#F6C177"/><path d="M-24 -6c-8-5-12 2-10 9s10 8 13 4z" fill="#E0A24E"/><path d="M24 -6c8-5 12 2 10 9s-10 8-13 4z" fill="#E0A24E"/><circle cx="-8" cy="6" r="3.4" fill="#3a2a1a"/><circle cx="8" cy="6" r="3.4" fill="#3a2a1a"/><ellipse cx="0" cy="15" rx="5" ry="4" fill="#3a2a1a"/><path d="M-6 24q6 5 12 0" fill="none" stroke="#3a2a1a" stroke-width="2.4" stroke-linecap="round"/></g><g fill="#1FB6B6" opacity=".5"><circle cx="24" cy="28" r="3"/><circle cx="96" cy="34" r="3"/><circle cx="92" cy="92" r="3"/></g></svg>`
};

/* ================================================================
   Capa de datos: IndexedDB con respaldo en localStorage
================================================================ */
const DB_NAME='huellitas_felices_db', DB_VERSION=1;
const STORES=['usuarios','mascotas','vacunas','registros_salud','recordatorios','solicitudes_asesoria','configuracion','contenidos_educativos'];

const Backend = {
  idb:null, useIDB:false,
  async init(){
    try{
      if(!('indexedDB' in window)) throw new Error('sin idb');
      this.idb = await new Promise((res,rej)=>{
        const r=indexedDB.open(DB_NAME,DB_VERSION);
        r.onupgradeneeded=e=>{const d=e.target.result;STORES.forEach(s=>{if(!d.objectStoreNames.contains(s))d.createObjectStore(s,{keyPath:'id'});});};
        r.onsuccess=()=>res(r.result); r.onerror=()=>rej(r.error);
        setTimeout(()=>rej(new Error('timeout')),3000);
      });
      this.useIDB=true;
    }catch(e){ this.useIDB=false; console.warn('IndexedDB no disponible, usando localStorage.'); }
  },
  _lsKey(s){return 'hf_ls:'+s;},
  _lsGet(s){try{return JSON.parse(localStorage.getItem(this._lsKey(s)))||[];}catch(_){return [];}},
  _lsSet(s,arr){try{localStorage.setItem(this._lsKey(s),JSON.stringify(arr));}catch(_){}},
  getAll(store){
    if(!this.useIDB) return Promise.resolve(this._lsGet(store));
    return new Promise((res,rej)=>{const r=this.idb.transaction(store).objectStore(store).getAll();r.onsuccess=()=>res(r.result||[]);r.onerror=()=>rej(r.error);});
  },
  put(store,obj){
    if(!this.useIDB){const a=this._lsGet(store);const i=a.findIndex(x=>x.id===obj.id);if(i>=0)a[i]=obj;else a.push(obj);this._lsSet(store,a);return Promise.resolve(obj);}
    return new Promise((res,rej)=>{const t=this.idb.transaction(store,'readwrite');t.objectStore(store).put(obj);t.oncomplete=()=>res(obj);t.onerror=()=>rej(t.error);});
  },
  del(store,id){
    if(!this.useIDB){this._lsSet(store,this._lsGet(store).filter(x=>x.id!==id));return Promise.resolve();}
    return new Promise((res,rej)=>{const t=this.idb.transaction(store,'readwrite');t.objectStore(store).delete(id);t.oncomplete=()=>res();t.onerror=()=>rej(t.error);});
  },
  clear(store){
    if(!this.useIDB){this._lsSet(store,[]);return Promise.resolve();}
    return new Promise((res,rej)=>{const t=this.idb.transaction(store,'readwrite');t.objectStore(store).clear();t.oncomplete=()=>res();t.onerror=()=>rej(t.error);});
  }
};

/* CRUD reutilizable de alto nivel */
const Data = {
  crear:(s,o)=>{o.id=o.id||uid(s.slice(0,3));o.creado=o.creado||Date.now();return Backend.put(s,o).then(()=>o);},
  actualizar:(s,o)=>Backend.put(s,o).then(()=>o),
  obtener:async(s,id)=>(await Backend.getAll(s)).find(x=>x.id===id)||null,
  listar:(s)=>Backend.getAll(s),
  eliminar:(s,id)=>Backend.del(s,id),
  buscar:async(s,texto,campos)=>{const q=(texto||'').toLowerCase().trim();const all=await Backend.getAll(s);if(!q)return all;
    return all.filter(o=>campos.some(c=>String(o[c]||'').toLowerCase().includes(q)));},
  filtrar:async(s,pred)=>(await Backend.getAll(s)).filter(pred),
  exportarTodo:async()=>{const out={_app:'Huellitas Felices',_version:1,_fecha:new Date().toISOString(),data:{}};
    for(const s of STORES) out.data[s]=await Backend.getAll(s);return out;},
  importarTodo:async(obj)=>{if(!obj||!obj.data)throw new Error('Archivo inválido');
    for(const s of STORES){await Backend.clear(s);const arr=Array.isArray(obj.data[s])?obj.data[s]:[];for(const o of arr)await Backend.put(s,o);}}
};

/* ================================================================
   Utilidades
================================================================ */
const $=(s,r=document)=>r.querySelector(s);
const $$=(s,r=document)=>[...r.querySelectorAll(s)];
const uid=(p='id')=>p+'_'+Date.now().toString(36)+Math.random().toString(36).slice(2,7);
const esc=s=>String(s??'').replace(/[&<>"]/g,c=>({'&':'&amp;','<':'&lt;','>':'&gt;','"':'&quot;'}[c]));
const app=$('#app');

function isoDate(d){const x=new Date(d);return new Date(x.getTime()-x.getTimezoneOffset()*60000).toISOString().slice(0,10);}
function hoyISO(){return isoDate(new Date());}
function addDays(base,n){const d=new Date(base);d.setDate(d.getDate()+n);return d;}
function diffDias(iso){const a=new Date(iso+'T00:00:00');const b=new Date(hoyISO()+'T00:00:00');return Math.round((a-b)/86400000);}
const MESES=['Enero','Febrero','Marzo','Abril','Mayo','Junio','Julio','Agosto','Septiembre','Octubre','Noviembre','Diciembre'];
const DOW=['Dom','Lun','Mar','Mié','Jue','Vie','Sáb'];
function fechaLarga(iso){if(!iso)return '';const d=new Date(iso+'T00:00:00');return `${d.getDate()} ${MESES[d.getMonth()].slice(0,3)} ${d.getFullYear()}`;}
function edad(nac){if(!nac)return '';const d=new Date(nac+'T00:00:00'),n=new Date();let m=(n.getFullYear()-d.getFullYear())*12+(n.getMonth()-d.getMonth());if(n.getDate()<d.getDate())m--;if(m<0)return '';const a=Math.floor(m/12),r=m%12;if(a<=0)return `${r} ${r===1?'mes':'meses'}`;return r?`${a} ${a===1?'año':'años'} ${r}m`:`${a} ${a===1?'año':'años'}`;}

let toastT;
function toast(msg,type='ok'){const t=$('#toast');t.innerHTML=(type==='err'?I.info:I.check)+`<span>${esc(msg)}</span>`;t.className='toast show '+type;clearTimeout(toastT);toastT=setTimeout(()=>t.className='toast '+type,2400);}

/* Estado de la app */
const State={ usuario:null, ruta:'inicio', mascotaActiva:null, calY:new Date().getFullYear(), calM:new Date().getMonth(), filtroEnf:'todos', buscaEnf:'' };

/* ================================================================
   Datos demo (semilla)
================================================================ */
async function seedDemo(){
  const t=hoyISO();
  const u_admin={id:'u_admin',nombre:'Katherine Ortiz',email:'admin@huellitas.co',rol:'admin',password:'admin',emoji:'👩‍⚕️',creado:Date.now()};
  const u_demo ={id:'u_demo', nombre:'Familia Correa',email:'familia@huellitas.co',rol:'usuario',password:'demo',emoji:'👨‍👩‍👧',creado:Date.now()};
  await Data.crear('usuarios',u_admin); await Data.crear('usuarios',u_demo);

  const max={id:'m_max',usuarioId:'u_demo',nombre:'Max',especie:'perro',raza:'Golden Retriever',sexo:'Macho',nacimiento:isoDate(addDays(new Date(),-430)),peso:12.5,color:'Dorado',emoji:'🐶',notas:'Muy juguetón y sociable.'};
  const luna={id:'m_luna',usuarioId:'u_demo',nombre:'Luna',especie:'gato',raza:'Doméstico',sexo:'Hembra',nacimiento:isoDate(addDays(new Date(),-900)),peso:4.2,color:'Gris atigrado',emoji:'🐱',notas:'Tranquila, le gusta dormir al sol.'};
  await Data.crear('mascotas',max); await Data.crear('mascotas',luna);

  const V=(id,mid,nombre,dias,tipo,notas)=>({id,mascotaId:mid,nombre,fecha:isoDate(addDays(new Date(),dias)),tipo,notas:notas||''});
  await Promise.all([
    Data.crear('vacunas',V('v1','m_max','Polivalente (DHPPi)',-120,'aplicada','Primera dosis aplicada.')),
    Data.crear('vacunas',V('v2','m_max','Refuerzo Polivalente',-4,'refuerzo','Refuerzo anual.')),
    Data.crear('vacunas',V('v3','m_max','Rabia',9,'programada','Protección contra la rabia.')),
    Data.crear('vacunas',V('v4','m_max','Desparasitación',25,'programada','Antiparasitario interno.')),
    Data.crear('vacunas',V('v5','m_luna','Triple Felina',-200,'aplicada','')),
    Data.crear('vacunas',V('v6','m_luna','Rabia',18,'programada','')),
  ]);

  const R=(id,mid,titulo,dias,tipo,estado)=>({id,mascotaId:mid,titulo,fecha:isoDate(addDays(new Date(),dias)),tipo,estado});
  await Promise.all([
    Data.crear('recordatorios',R('r1','m_max','Baño mensual',2,'higiene','pendiente')),
    Data.crear('recordatorios',R('r2','m_max','Aplicar vacuna Rabia',9,'vacuna','pendiente')),
    Data.crear('recordatorios',R('r3','m_luna','Corte de uñas',-1,'higiene','pendiente')),
    Data.crear('recordatorios',R('r4','m_max','Control de peso',-6,'control','completado')),
  ]);

  const S=(id,mid,dias,peso,apetito,actividad,sintomas,notas)=>({id,mascotaId:mid,fecha:isoDate(addDays(new Date(),dias)),peso,apetito,actividad,sintomas,notas});
  await Promise.all([
    Data.crear('registros_salud',S('s1','m_max',-20,12.1,'Normal','Alta','','Todo en orden en el chequeo.')),
    Data.crear('registros_salud',S('s2','m_max',-6,12.5,'Normal','Alta','','Aumentó peso saludablemente.')),
    Data.crear('registros_salud',S('s3','m_luna',-3,4.2,'Bajo','Media','Estornudos leves','Vigilar 48 horas.')),
  ]);

  await Data.crear('solicitudes_asesoria',{id:'a1',usuarioId:'u_demo',mascotaId:'m_luna',tema:'salud',mensaje:'Luna estornuda un poco desde ayer, ¿es urgente?',estado:'pendiente',fecha:hoyISO()});

  await Data.crear('configuracion',{id:'cfg',notificaciones:true,tema:'claro'});

  /* Contenidos educativos: enfermedades */
  const E=(id,nombre,cat,especie,emoji,color,desc,sint,prev,ir)=>({id,tipo:'enfermedad',nombre,categoria:cat,especie,emoji,color,descripcion:desc,sintomas:sint,prevencion:prev,cuando_ir:ir});
  await Promise.all([
    Data.crear('contenidos_educativos',E('e1','Parvovirus','Digestivos','perro','🦠','coral','Enfermedad viral muy contagiosa que afecta principalmente a cachorros no vacunados.','Vómito, diarrea con sangre, decaimiento, fiebre y pérdida de apetito.','Cumplir el esquema de vacunación desde cachorro y evitar contacto con perros enfermos.','Acude de inmediato: puede ser mortal sin atención rápida.')),
    Data.crear('contenidos_educativos',E('e2','Sarna','Piel','perro','🐛','amar','Enfermedad de la piel causada por ácaros que produce mucha molestia.','Picazón intensa, enrojecimiento, costras y caída de pelo.','Higiene adecuada, revisiones de piel y control antiparasitario externo.','Consulta si la picazón es intensa o hay heridas por rascado.')),
    Data.crear('contenidos_educativos',E('e3','Gastritis','Digestivos','ambos','🍽️','rosa','Inflamación del estómago por mala alimentación o infecciones.','Vómito, pérdida de apetito, decaimiento y dolor abdominal.','Alimentación balanceada, horarios fijos y evitar sobras o alimentos dañados.','Consulta si el vómito persiste más de un día o hay sangre.')),
    Data.crear('contenidos_educativos',E('e4','Moquillo','Respiratorias','perro','🤒','azul','Enfermedad viral grave que afecta varios sistemas del cuerpo.','Secreción nasal y ocular, tos, fiebre, convulsiones en casos graves.','Vacunación oportuna con la polivalente y refuerzos anuales.','Acude pronto: requiere manejo veterinario urgente.')),
    Data.crear('contenidos_educativos',E('e5','Pulgas y garrapatas','Parasitarias','ambos','🕷️','verde','Parásitos externos que transmiten otras enfermedades.','Rascado constante, puntos negros en el pelo, anemia en casos graves.','Antipulgas/garrapatas periódico y limpieza del entorno.','Consulta si hay muchas garrapatas o signos de anemia.')),
    Data.crear('contenidos_educativos',E('e6','Otitis','Piel','ambos','👂','mora','Inflamación del oído, común en razas de orejas caídas.','Sacudir la cabeza, mal olor, secreción y enrojecimiento del oído.','Limpieza suave y secar bien las orejas después del baño.','Consulta si hay dolor, secreción o mal olor persistente.')),
    Data.crear('contenidos_educativos',E('e7','Conjuntivitis','Respiratorias','gato','😿','coral','Inflamación de los ojos frecuente en gatos.','Ojos rojos, lagrimeo, secreción y párpados hinchados.','Ambiente limpio y evitar corrientes de aire y polvo.','Consulta si no mejora en 2-3 días o afecta ambos ojos.')),
    Data.crear('contenidos_educativos',E('e8','Obesidad','Digestivos','ambos','⚖️','amar','Exceso de peso que afecta articulaciones y corazón.','Dificultad para moverse, cansancio y aumento notable de peso.','Porciones medidas, ejercicio diario y evitar premios en exceso.','Consulta para un plan nutricional adecuado.')),
  ]);

  /* Contenidos educativos: orientación preventiva */
  const O=(id,titulo,emoji,color,resumen,cuerpo)=>({id,tipo:'orientacion',titulo,emoji,color,resumen,cuerpo});
  await Promise.all([
    Data.crear('contenidos_educativos',O('o1','Alimentación adecuada','🥣','verde','Qué y cuánto darle según su edad.','Ofrece alimento de calidad según especie, edad y tamaño. Respeta horarios, mide las porciones y ten siempre agua fresca disponible. Evita darle huesos cocidos, chocolate, uvas y cebolla.')),
    Data.crear('contenidos_educativos',O('o2','Higiene y baño','🛁','azul','Frecuencia y cuidados básicos.','Baña a tu perro cada 3-4 semanas con champú especial; los gatos se asean solos y rara vez necesitan baño. Cepilla el pelo con frecuencia, limpia orejas con cuidado y revisa las uñas.')),
    Data.crear('contenidos_educativos',O('o3','Ejercicio diario','🎾','coral','Actividad para cuerpo y mente.','Los perros necesitan paseos y juego diario según su raza y edad. Los gatos se mantienen activos con juguetes y rascadores. El ejercicio previene la obesidad y el estrés.')),
    Data.crear('contenidos_educativos',O('o4','Desparasitación','💊','mora','Interna y externa, al día.','Aplica antiparasitarios internos y externos según la indicación del veterinario. Mantén el esquema al día para prevenir enfermedades y proteger también a la familia.')),
    Data.crear('contenidos_educativos',O('o5','Vacunación preventiva','💉','rosa','La mejor forma de proteger.','Cumple el calendario de vacunas y los refuerzos anuales. Es la manera más eficaz de prevenir enfermedades graves como el parvovirus, el moquillo y la rabia.')),
  ]);
}

async function initData(){
  await Backend.init();
  const us=await Data.listar('usuarios');
  if(!us.length) await seedDemo();
}

async function resetDemo(){
  for(const s of STORES) await Backend.clear(s);
  await seedDemo();
}

/* ================================================================
   Sesión
================================================================ */
const SESSION_KEY='hf_session';
function guardarSesion(id){try{localStorage.setItem(SESSION_KEY,id);}catch(_){}}
function limpiarSesion(){try{localStorage.removeItem(SESSION_KEY);}catch(_){}}
async function cargarSesion(){const id=localStorage.getItem(SESSION_KEY);if(!id)return null;return Data.obtener('usuarios',id);}

/* helpers de dominio */
async function misMascotas(){const all=await Data.listar('mascotas');return State.usuario?.rol==='admin'?all:all.filter(m=>m.usuarioId===State.usuario.id);}
function estadoVacuna(v){
  if(v.tipo==='aplicada')return {k:'aplicada',txt:'Completado',cls:'b-verde',color:'var(--verde)'};
  const d=diffDias(v.fecha);
  if(d<0)return {k:'vencida',txt:'Vencida',cls:'b-danger',color:'var(--danger)'};
  if(v.tipo==='refuerzo')return {k:'refuerzo',txt:'Refuerzo',cls:'b-mora',color:'var(--morado)'};
  if(d<=15)return {k:'proxima',txt:'Próxima',cls:'b-coral',color:'var(--coral)'};
  return {k:'programado',txt:'Programado',cls:'b-azul',color:'var(--azul)'};
}

/* ================================================================
   Render: cascarón (shell)
================================================================ */
const NAV_BOTTOM=[
  {r:'inicio',t:'Inicio',ic:I.home},
  {r:'mascotas',t:'Mascotas',ic:I.paw},
  {r:'salud',t:'Salud',ic:I.heart},
  {r:'vacunas',t:'Vacunas',ic:I.vaccine},
  {r:'ajustes',t:'Ajustes',ic:I.gear},
];
const NAV_MENU=[
  {r:'inicio',t:'Inicio',ic:I.home},
  {r:'mascotas',t:'Mascotas',ic:I.paw},
  {r:'salud',t:'Salud',ic:I.heart},
  {r:'vacunas',t:'Vacunas',ic:I.vaccine},
  {r:'enfermedades',t:'Enfermedades',ic:I.book},
  {r:'recordatorios',t:'Recordatorios',ic:I.clock},
  {r:'orientacion',t:'Orientación preventiva',ic:I.shield},
  {r:'asesoria',t:'Asesoría',ic:I.chat},
  {r:'perfil',t:'Perfil',ic:I.user},
];

async function renderShell(){
  const pend=(await Data.filtrar('recordatorios',r=>r.estado==='pendiente'&&diffDias(r.fecha)<=3)).length;
  app.innerHTML=`
    <header class="topbar">
      <button class="icon-btn" data-action="drawer-open" aria-label="Abrir menú">${I.menu}</button>
      <div class="brand"><span style="width:26px;height:26px;display:inline-grid;place-items:center;background:rgba(255,255,255,.2);border-radius:9px">${I.paw}</span>
        <div>Huellitas Felices<small>Cuidado preventivo</small></div>
      </div>
      <div class="spacer"></div>
      <button class="icon-btn bell" data-action="go" data-route="recordatorios" aria-label="Recordatorios">
        ${I.bell}${pend?`<span class="dot">${pend}</span>`:''}
      </button>
    </header>
    <main class="view" id="view" tabindex="-1"></main>
    <nav class="bottom-nav" aria-label="Navegación principal">
      ${NAV_BOTTOM.map(n=>`<button class="bn ${State.ruta===n.r?'active':''}" data-action="go" data-route="${n.r}">
        <span class="ico">${n.ic}</span>${n.t}</button>`).join('')}
    </nav>

    <div class="scrim" id="scrim" data-action="drawer-close"></div>
    <aside class="drawer" id="drawer" aria-label="Menú" aria-hidden="true">
      <div class="drawer-head">
        <div style="display:flex;align-items:center;gap:9px;font-weight:800;font-size:17px">${I.paw} Huellitas Felices</div>
        <div class="who"><div class="av">${esc(State.usuario?.emoji||'👤')}</div>
          <div><div style="font-weight:800">${esc(State.usuario?.nombre||'Invitado')}</div>
          <div style="font-size:12px;opacity:.9">${State.usuario?.rol==='admin'?'Administrador':'Propietario'}</div></div></div>
      </div>
      <nav class="drawer-nav">
        ${NAV_MENU.map(n=>`<button class="dn ${State.ruta===n.r?'active':''}" data-action="go" data-route="${n.r}" data-close="1">${n.ic}<span>${n.t}</span></button>`).join('')}
        ${State.usuario?.rol==='admin'?`<button class="dn ${State.ruta==='admin'?'active':''}" data-action="go" data-route="admin" data-close="1">${I.admin}<span>Administración</span></button>`:''}
        <button class="dn ${State.ruta==='ajustes'?'active':''}" data-action="go" data-route="ajustes" data-close="1">${I.gear}<span>Ajustes</span></button>
        <div class="dn-sep"></div>
        <button class="dn danger" data-action="logout">${I.logout}<span>Cerrar sesión</span></button>
      </nav>
    </aside>
  `;
  await renderView();
}

/* ================================================================
   Router
================================================================ */
async function go(ruta){State.ruta=ruta;await renderShell();$('#view')?.focus();}

async function renderView(){
  const v=$('#view'); if(!v)return;
  const mapa={inicio:vInicio,mascotas:vMascotas,salud:vSalud,vacunas:vVacunas,enfermedades:vEnfermedades,
    recordatorios:vRecordatorios,orientacion:vOrientacion,asesoria:vAsesoria,perfil:vPerfil,admin:vAdmin,ajustes:vAjustes};
  const fn=mapa[State.ruta]||vInicio;
  v.innerHTML='<div class="empty">Cargando…</div>';
  v.innerHTML=await fn();
  if(fn.after)await fn.after();
}

/* ================================================================
   Vistas
================================================================ */

/* ---- Inicio ---- */
async function vInicio(){
  const mascotas=await misMascotas();
  const recs=(await Data.filtrar('recordatorios',r=>r.estado==='pendiente')).filter(r=>mascotas.some(m=>m.id===r.mascotaId)).sort((a,b)=>a.fecha.localeCompare(b.fecha));
  const vacs=(await Data.listar('vacunas')).filter(v=>v.tipo!=='aplicada'&&mascotas.some(m=>m.id===v.mascotaId)).sort((a,b)=>a.fecha.localeCompare(b.fecha));
  const prox=vacs[0];
  const nombre=(State.usuario?.nombre||'').split(' ')[0];
  return `
    <div class="hero">
      <div class="grow"><div class="hi">¡Hola, ${esc(nombre)}! 🐾</div>
        <div class="nm">Cuidemos juntos a tus ${mascotas.length>1?'mascotas':'mascota'}</div>
        <div class="small" style="opacity:.9;margin-top:3px">${mascotas.length} registrada${mascotas.length===1?'':'s'} · ${recs.length} recordatorio${recs.length===1?'':'s'} pendiente${recs.length===1?'':'s'}</div>
      </div>${ILL.duo}
    </div>

    <div class="stats">
      <div class="stat"><b>${mascotas.length}</b><span>Mascotas</span></div>
      <div class="stat"><b>${vacs.length}</b><span>Vacunas por venir</span></div>
      <div class="stat"><b>${recs.length}</b><span>Recordatorios</span></div>
    </div>

    <div class="section-title">Accesos rápidos</div>
    <div class="quick">
      <button class="q" data-action="pet-new"><span class="ic avatar coral">${I.paw}</span><b>Agregar mascota</b><span>Registra a tu compañero</span></button>
      <button class="q" data-action="go" data-route="vacunas"><span class="ic avatar azul">${I.vaccine}</span><b>Calendario</b><span>Vacunas al día</span></button>
      <button class="q" data-action="go" data-route="salud"><span class="ic avatar verde">${I.heart}</span><b>Registrar salud</b><span>Peso y síntomas</span></button>
      <button class="q" data-action="go" data-route="enfermedades"><span class="ic avatar amar">${I.book}</span><b>Enfermedades</b><span>Guía preventiva</span></button>
    </div>

    <div class="section-title">Próxima vacuna <button class="link" data-action="go" data-route="vacunas">Ver todo</button></div>
    ${prox?(()=>{const m=mascotas.find(x=>x.id===prox.mascotaId);const st=estadoVacuna(prox);return `
      <div class="card tile" data-action="go" data-route="vacunas">
        <div class="avatar azul">${I.vaccine}</div>
        <div class="grow"><div class="strong">${esc(prox.nombre)}</div>
          <div class="small muted">${esc(m?.nombre||'')} · ${fechaLarga(prox.fecha)}</div></div>
        <span class="badge ${st.cls}">${st.txt}</span>
      </div>`;})():`<div class="card"><div class="muted small">No hay vacunas próximas. ¡Todo al día! ✅</div></div>`}

    <div class="section-title">Recordatorios <button class="link" data-action="go" data-route="recordatorios">Ver todo</button></div>
    ${recs.length?recs.slice(0,3).map(r=>{const m=mascotas.find(x=>x.id===r.mascotaId);const d=diffDias(r.fecha);
      const b=d<0?'<span class="badge b-danger">Vencido</span>':d===0?'<span class="badge b-coral">Hoy</span>':`<span class="badge b-amar">En ${d} día${d===1?'':'s'}</span>`;
      return `<div class="card tile"><div class="avatar amar">${I.clock}</div>
        <div class="grow"><div class="strong">${esc(r.titulo)}</div><div class="small muted">${esc(m?.nombre||'')} · ${fechaLarga(r.fecha)}</div></div>${b}</div>`;}).join('')
      :`<div class="card"><div class="muted small">Sin recordatorios pendientes.</div></div>`}

    <div class="notice" style="margin-top:14px">${I.info}<div>Huellitas Felices es una herramienta <b>orientativa y preventiva</b>. No reemplaza el diagnóstico ni el tratamiento de un médico veterinario.</div></div>
  `;
}

/* ---- Mascotas ---- */
async function vMascotas(){
  const mascotas=await misMascotas();
  return `
    <div class="page-title">${I.paw} Mascotas</div>
    <div class="page-sub">Administra los perfiles de tus compañeros.</div>
    <button class="btn primary block" data-action="pet-new" style="margin-bottom:14px">${I.plus} Agregar mascota</button>
    ${mascotas.length?mascotas.map(m=>`
      <div class="card tile" data-action="pet-open" data-id="${m.id}">
        <div class="avatar ${m.especie==='gato'?'rosa':'coral'}">${esc(m.emoji||(m.especie==='gato'?'🐱':'🐶'))}</div>
        <div class="grow"><div class="strong">${esc(m.nombre)}</div>
          <div class="small muted ellip">${esc(m.raza||m.especie)} · ${esc(m.sexo||'')} · ${edad(m.nacimiento)||'—'}</div></div>
        <span class="muted">${I.chev}</span>
      </div>`).join('')
      :`<div class="empty">${ILL.empty}<b>Aún no hay mascotas</b>Agrega tu primera mascota para comenzar a cuidarla.</div>`}
  `;
}

/* ---- Salud ---- */
async function vSalud(){
  const mascotas=await misMascotas();
  if(!mascotas.length)return `<div class="page-title">${I.heart} Salud</div><div class="empty">${ILL.empty}<b>Sin mascotas</b>Registra una mascota para llevar su historial de salud.</div>`;
  if(!State.mascotaActiva||!mascotas.some(m=>m.id===State.mascotaActiva))State.mascotaActiva=mascotas[0].id;
  const regs=(await Data.filtrar('registros_salud',r=>r.mascotaId===State.mascotaActiva)).sort((a,b)=>b.fecha.localeCompare(a.fecha));
  return `
    <div class="page-title">${I.heart} Salud</div>
    <div class="page-sub">Historial de peso, apetito y síntomas.</div>
    ${selectorMascota(mascotas)}
    <button class="btn primary block" data-action="salud-new" style="margin:6px 0 14px">${I.plus} Registrar control de salud</button>
    ${regs.length?regs.map(r=>`
      <div class="card">
        <div class="tile"><div class="avatar verde">${I.scale}</div>
          <div class="grow"><div class="strong">${r.peso?esc(r.peso)+' kg':'Control'} · <span class="small muted">${fechaLarga(r.fecha)}</span></div>
            <div class="small muted">Apetito: ${esc(r.apetito||'—')} · Actividad: ${esc(r.actividad||'—')}</div></div>
          <button class="icon-btn" style="color:var(--danger)" data-action="salud-del" data-id="${r.id}" aria-label="Eliminar">${I.trash}</button>
        </div>
        ${r.sintomas?`<div class="small" style="margin-top:8px"><span class="badge b-coral">Síntomas</span> ${esc(r.sintomas)}</div>`:''}
        ${r.notas?`<div class="small muted" style="margin-top:6px">${esc(r.notas)}</div>`:''}
      </div>`).join('')
      :`<div class="empty">${ILL.empty}<b>Sin registros</b>Agrega el primer control de salud de tu mascota.</div>`}
  `;
}

/* ---- Vacunas (calendario) ---- */
async function vVacunas(){
  const mascotas=await misMascotas();
  if(!mascotas.length)return `<div class="page-title">${I.vaccine} Vacunas</div><div class="empty">${ILL.empty}<b>Sin mascotas</b>Registra una mascota para gestionar sus vacunas.</div>`;
  if(!State.mascotaActiva||!mascotas.some(m=>m.id===State.mascotaActiva))State.mascotaActiva=mascotas[0].id;
  const m=mascotas.find(x=>x.id===State.mascotaActiva);
  const vacs=(await Data.filtrar('vacunas',v=>v.mascotaId===State.mascotaActiva)).sort((a,b)=>a.fecha.localeCompare(b.fecha));
  return `
    <div class="page-title">${I.vaccine} Calendario de vacunación</div>
    <div class="page-sub">Mantén al día las vacunas y protégela siempre.</div>
    ${selectorMascota(mascotas)}
    <div class="pet-head">
      <div class="avatar ${m.especie==='gato'?'rosa':'coral'}">${esc(m.emoji||'🐶')}</div>
      <div class="grow"><div class="strong">${esc(m.nombre)}</div><div class="small muted">${esc(m.raza)} · ${edad(m.nacimiento)||'—'}</div></div>
      <button class="btn sm ghost" data-action="pet-open" data-id="${m.id}">Ver perfil</button>
    </div>
    ${calendarioHTML(vacs)}
    <div class="section-title" style="margin-top:16px">Próximas vacunas
      <button class="link" data-action="vac-new">+ Agregar</button></div>
    ${(()=>{const pend=vacs.filter(v=>v.tipo!=='aplicada');return pend.length?pend.map(v=>{const st=estadoVacuna(v);
      return `<div class="card tile">
        <span class="dot-status" style="background:${st.color}"></span>
        <div class="grow"><div class="strong">${esc(v.nombre)}</div><div class="small muted">${fechaLarga(v.fecha)}${v.notas?' · '+esc(v.notas):''}</div></div>
        <span class="badge ${st.cls}">${st.txt}</span>
        ${v.tipo!=='aplicada'?`<button class="icon-btn" data-action="vac-aplicar" data-id="${v.id}" aria-label="Marcar aplicada" style="color:var(--verde)">${I.check}</button>`:''}
      </div>`;}).join('')
      :`<div class="card"><div class="muted small">Sin vacunas pendientes. 🎉</div></div>`;})()}

    <div class="section-title">Vacunas aplicadas</div>
    ${(()=>{const ap=vacs.filter(v=>v.tipo==='aplicada');return ap.length?ap.map(v=>`
      <div class="card tile flat"><span class="dot-status" style="background:var(--verde)"></span>
        <div class="grow"><div class="strong">${esc(v.nombre)}</div><div class="small muted">${fechaLarga(v.fecha)}</div></div>
        <span class="badge b-verde">Completado</span>
        <button class="icon-btn" style="color:var(--danger)" data-action="vac-del" data-id="${v.id}" aria-label="Eliminar">${I.trash}</button>
      </div>`).join(''):`<div class="card"><div class="muted small">Aún no hay vacunas aplicadas registradas.</div></div>`;})()}

    <div class="notice" style="margin-top:14px">${I.shield}<div>¡No olvides! Las vacunas son la mejor forma de cuidar la salud de tu mascota.</div></div>
  `;
}

function calendarioHTML(vacs){
  const y=State.calY,mo=State.calM;
  const first=new Date(y,mo,1).getDay();
  const days=new Date(y,mo+1,0).getDate();
  const t=hoyISO();
  const porDia={};vacs.forEach(v=>{const d=new Date(v.fecha+'T00:00:00');if(d.getFullYear()===y&&d.getMonth()===mo){porDia[d.getDate()]=estadoVacuna(v);}});
  let cells='';
  DOW.forEach(d=>cells+=`<div class="dow">${d}</div>`);
  for(let i=0;i<first;i++)cells+=`<div class="cal-cell pad"></div>`;
  for(let d=1;d<=days;d++){
    const iso=`${y}-${String(mo+1).padStart(2,'0')}-${String(d).padStart(2,'0')}`;
    const st=porDia[d];const isToday=iso===t;
    const bg=st?`style="background:${st.color}"`:'';
    cells+=`<div class="cal-cell ${st?'has':''} ${isToday?'today':''}" ${bg} title="${st?st.txt:''}">${d}${st?`<span class="mk" style="background:#fff"></span>`:''}</div>`;
  }
  return `
    <div class="cal">
      <div class="cal-head">
        <button class="icon-btn" data-action="cal-prev" aria-label="Mes anterior" style="color:var(--turquesa-700);transform:rotate(180deg)">${I.chev}</button>
        <b>${MESES[mo]} ${y}</b>
        <button class="icon-btn" data-action="cal-next" aria-label="Mes siguiente" style="color:var(--turquesa-700)">${I.chev}</button>
      </div>
      <div class="cal-grid">${cells}</div>
      <div class="cal-legend">
        <span><i class="dot-status" style="background:var(--verde)"></i>Completado</span>
        <span><i class="dot-status" style="background:var(--coral)"></i>Próxima</span>
        <span><i class="dot-status" style="background:var(--morado)"></i>Refuerzo</span>
        <span><i class="dot-status" style="background:var(--azul)"></i>Programado</span>
        <span><i class="dot-status" style="background:var(--danger)"></i>Vencida</span>
      </div>
    </div>`;
}

/* ---- Enfermedades ---- */
async function vEnfermedades(){
  let enf=await Data.filtrar('contenidos_educativos',c=>c.tipo==='enfermedad');
  const q=State.buscaEnf.toLowerCase(), f=State.filtroEnf;
  const cats=['todos','perro','gato','Digestivos','Piel','Parasitarias','Respiratorias'];
  const rotulo={todos:'Todos',perro:'Perros',gato:'Gatos'};
  let list=enf.filter(e=>{
    const okF = f==='todos' || (f==='perro'&&(e.especie==='perro'||e.especie==='ambos')) || (f==='gato'&&(e.especie==='gato'||e.especie==='ambos')) || e.categoria===f;
    const okQ = !q || e.nombre.toLowerCase().includes(q) || (e.sintomas||'').toLowerCase().includes(q) || (e.descripcion||'').toLowerCase().includes(q);
    return okF&&okQ;
  });
  return `
    <div class="page-title">${I.book} Enfermedades y síntomas</div>
    <div class="page-sub">Información para cuidar la salud de tu mascota.</div>
    <div class="search">${I.search}<input id="enfSearch" type="search" placeholder="Buscar enfermedad…" value="${esc(State.buscaEnf)}" aria-label="Buscar enfermedad"></div>
    <div class="filters">
      ${cats.map(c=>`<button class="chip ${f===c?'active':''}" data-action="enf-filter" data-cat="${c}">${rotulo[c]||c}</button>`).join('')}
    </div>
    ${list.length?list.map(e=>`
      <div class="card" data-action="enf-open" data-id="${e.id}">
        <div class="tile"><div class="avatar ${e.color==='rosa'?'rosa':e.color==='amar'?'amar':e.color==='azul'?'azul':e.color==='verde'?'verde':e.color==='mora'?'mora':'coral'}">${esc(e.emoji)}</div>
          <div class="grow"><div class="strong">${esc(e.nombre)} <span class="badge b-gris" style="margin-left:4px">${esc(e.categoria)}</span></div>
            <div class="small muted">${esc(e.descripcion)}</div></div>
          <span class="muted">${I.chev}</span></div>
        <div class="small" style="margin-top:8px"><b>Síntomas:</b> <span class="muted">${esc(e.sintomas)}</span></div>
      </div>`).join('')
      :`<div class="empty">${ILL.empty}<b>Sin resultados</b>Prueba con otro término o filtro.</div>`}
    <div class="notice" style="margin-top:8px">${I.info}<div>Recuerda: ante cualquier síntoma, consulta a tu médico veterinario.</div></div>
  `;
}
vEnfermedades.after=async()=>{
  const s=$('#enfSearch');
  if(s)s.addEventListener('input',e=>{State.buscaEnf=e.target.value;const list=e.target.value;renderView().then(()=>{const el=$('#enfSearch');if(el){el.focus();el.setSelectionRange(list.length,list.length);}});});
};

/* ---- Recordatorios ---- */
async function vRecordatorios(){
  const mascotas=await misMascotas();
  const recs=(await Data.listar('recordatorios')).filter(r=>mascotas.some(m=>m.id===r.mascotaId)).sort((a,b)=>a.fecha.localeCompare(b.fecha));
  const pend=recs.filter(r=>r.estado==='pendiente'),done=recs.filter(r=>r.estado==='completado');
  const card=r=>{const m=mascotas.find(x=>x.id===r.mascotaId);const d=diffDias(r.fecha);const done=r.estado==='completado';
    const b=done?'<span class="badge b-verde">Completado</span>':d<0?'<span class="badge b-danger">Vencido</span>':d===0?'<span class="badge b-coral">Hoy</span>':`<span class="badge b-amar">${d} día${d===1?'':'s'}</span>`;
    return `<div class="card tile"><div class="avatar ${done?'verde':'amar'}">${done?I.check:I.clock}</div>
      <div class="grow"><div class="strong ${done?'muted':''}">${esc(r.titulo)}</div><div class="small muted">${esc(m?.nombre||'')} · ${fechaLarga(r.fecha)} · ${esc(r.tipo)}</div></div>
      ${b}
      ${!done?`<button class="icon-btn" style="color:var(--verde)" data-action="rec-done" data-id="${r.id}" aria-label="Completar">${I.check}</button>`:''}
      <button class="icon-btn" style="color:var(--danger)" data-action="rec-del" data-id="${r.id}" aria-label="Eliminar">${I.trash}</button></div>`;};
  return `
    <div class="page-title">${I.clock} Recordatorios</div>
    <div class="page-sub">No olvides ningún cuidado importante.</div>
    <button class="btn primary block" data-action="rec-new" style="margin-bottom:14px" ${mascotas.length?'':'disabled'}>${I.plus} Nuevo recordatorio</button>
    ${!mascotas.length?`<div class="empty">${ILL.empty}<b>Sin mascotas</b>Agrega una mascota para crear recordatorios.</div>`:''}
    ${pend.length?`<div class="section-title">Pendientes (${pend.length})</div>${pend.map(card).join('')}`:mascotas.length?`<div class="card"><div class="muted small">No hay recordatorios pendientes. ✅</div></div>`:''}
    ${done.length?`<div class="section-title">Completados</div>${done.map(card).join('')}`:''}
  `;
}

/* ---- Orientación preventiva ---- */
async function vOrientacion(){
  const o=await Data.filtrar('contenidos_educativos',c=>c.tipo==='orientacion');
  return `
    <div class="page-title">${I.shield} Orientación preventiva</div>
    <div class="page-sub">Buenos hábitos para una vida sana y feliz.</div>
    ${o.map(c=>`<div class="card" data-action="ori-open" data-id="${c.id}">
      <div class="tile"><div class="avatar ${c.color==='rosa'?'rosa':c.color==='amar'?'amar':c.color==='azul'?'azul':c.color==='verde'?'verde':c.color==='mora'?'mora':'coral'}">${esc(c.emoji)}</div>
        <div class="grow"><div class="strong">${esc(c.titulo)}</div><div class="small muted">${esc(c.resumen)}</div></div>
        <span class="muted">${I.chev}</span></div></div>`).join('')}
  `;
}

/* ---- Asesoría ---- */
async function vAsesoria(){
  const mascotas=await misMascotas();
  const mias=(await Data.listar('solicitudes_asesoria')).filter(s=>s.usuarioId===State.usuario.id||State.usuario.rol==='admin').sort((a,b)=>(b.fecha||'').localeCompare(a.fecha||''));
  return `
    <div class="page-title">${I.chat} Asesoría</div>
    <div class="page-sub">Envía tu inquietud y recibe orientación.</div>
    <div class="notice" style="margin-bottom:12px">${I.info}<div>La teleorientación <b>no reemplaza</b> la consulta presencial. Si hay una urgencia, acude directamente al veterinario.</div></div>
    <button class="btn primary block" data-action="ase-new" style="margin-bottom:14px" ${mascotas.length?'':'disabled'}>${I.plus} Nueva solicitud</button>
    <div class="section-title">Mis solicitudes</div>
    ${mias.length?mias.map(s=>{const m=mascotas.find(x=>x.id===s.mascotaId);
      const b=s.estado==='respondida'?'b-verde':s.estado==='en_proceso'?'b-azul':'b-amar';
      return `<div class="card"><div class="tile"><div class="avatar mora">${I.chat}</div>
        <div class="grow"><div class="strong">${esc({salud:'Salud',conducta:'Conducta',nutricion:'Nutrición'}[s.tema]||s.tema)} · <span class="small muted">${esc(m?.nombre||'')}</span></div>
          <div class="small muted">${fechaLarga(s.fecha)}</div></div>
        <span class="badge ${b}">${esc(s.estado.replace('_',' '))}</span></div>
        <div class="small" style="margin-top:8px">${esc(s.mensaje)}</div>
        ${s.respuesta?`<div class="notice" style="margin-top:8px">${I.shield}<div><b>Respuesta:</b> ${esc(s.respuesta)}</div></div>`:''}
      </div>`;}).join('')
      :`<div class="empty">${ILL.empty}<b>Sin solicitudes</b>Aún no has enviado ninguna consulta.</div>`}
  `;
}

/* ---- Perfil ---- */
async function vPerfil(){
  const u=State.usuario;const mascotas=await misMascotas();
  return `
    <div class="page-title">${I.user} Mi perfil</div>
    <div class="card">
      <div class="tile"><div class="avatar" style="font-size:30px">${esc(u.emoji||'👤')}</div>
        <div class="grow"><div class="strong" style="font-size:18px">${esc(u.nombre)}</div>
          <div class="small muted">${esc(u.email||'')}</div>
          <span class="badge ${u.rol==='admin'?'b-mora':'b-verde'}" style="margin-top:6px">${u.rol==='admin'?'Administrador':'Propietario'}</span></div></div>
      <button class="btn ghost block" data-action="perfil-edit" style="margin-top:12px">${I.edit} Editar perfil</button>
    </div>
    <div class="stats">
      <div class="stat"><b>${mascotas.length}</b><span>Mascotas</span></div>
      <div class="stat"><b>${(await Data.listar('vacunas')).filter(v=>mascotas.some(m=>m.id===v.mascotaId)).length}</b><span>Vacunas</span></div>
      <div class="stat"><b>${(await Data.listar('registros_salud')).filter(r=>mascotas.some(m=>m.id===r.mascotaId)).length}</b><span>Controles</span></div>
    </div>
  `;
}

/* ---- Administración ---- */
async function vAdmin(){
  const [us,ma,va,rs,re,so]=await Promise.all(['usuarios','mascotas','vacunas','registros_salud','recordatorios','solicitudes_asesoria'].map(s=>Data.listar(s)));
  return `
    <div class="page-title">${I.admin} Administración</div>
    <div class="page-sub">Panel exclusivo para el administrador · Backend: ${Backend.useIDB?'IndexedDB':'localStorage'}.</div>
    <div class="stats" style="grid-template-columns:repeat(3,1fr)">
      <div class="stat"><b>${us.length}</b><span>Usuarios</span></div>
      <div class="stat"><b>${ma.length}</b><span>Mascotas</span></div>
      <div class="stat"><b>${va.length}</b><span>Vacunas</span></div>
      <div class="stat"><b>${rs.length}</b><span>Controles</span></div>
      <div class="stat"><b>${re.length}</b><span>Recordatorios</span></div>
      <div class="stat"><b>${so.length}</b><span>Asesorías</span></div>
    </div>
    <div class="section-title">Usuarios</div>
    ${us.map(u=>`<div class="card tile flat"><div class="avatar ${u.rol==='admin'?'mora':'verde'}">${esc(u.emoji||'👤')}</div>
      <div class="grow"><div class="strong">${esc(u.nombre)}</div><div class="small muted">${esc(u.email||'')}</div></div>
      <span class="badge ${u.rol==='admin'?'b-mora':'b-verde'}">${u.rol}</span></div>`).join('')}
    <div class="section-title">Solicitudes de asesoría</div>
    ${so.length?so.map(s=>{const m=ma.find(x=>x.id===s.mascotaId);return `<div class="card">
      <div class="tile"><div class="grow"><div class="strong">${esc(m?.nombre||'—')} · ${esc(s.tema)}</div><div class="small muted">${esc(s.mensaje)}</div></div>
      <span class="badge ${s.estado==='respondida'?'b-verde':'b-amar'}">${esc(s.estado)}</span></div>
      <button class="btn sm ghost block" data-action="ase-responder" data-id="${s.id}" style="margin-top:8px">Responder / actualizar</button></div>`;}).join('')
      :`<div class="card"><div class="muted small">No hay solicitudes.</div></div>`}
  `;
}

/* ---- Ajustes ---- */
async function vAjustes(){
  const cfg=(await Data.obtener('configuracion','cfg'))||{notificaciones:true};
  return `
    <div class="page-title">${I.gear} Ajustes</div>
    <div class="page-sub">Preferencias y copias de seguridad.</div>

    <div class="card">
      <div class="tile"><div class="avatar amar">${I.bell}</div>
        <div class="grow"><div class="strong">Recordatorios activos</div><div class="small muted">Resalta pendientes y vencidos</div></div>
        <button class="btn sm ${cfg.notificaciones?'primary':'ghost'}" data-action="cfg-notif">${cfg.notificaciones?'Activado':'Desactivado'}</button></div>
    </div>

    <div class="section-title">Copia de seguridad</div>
    <div class="card">
      <button class="btn ghost block" data-action="exportar" style="margin-bottom:10px">${I.download} Exportar copia de seguridad</button>
      <button class="btn ghost block" data-action="importar" style="margin-bottom:10px">${I.upload} Importar copia de seguridad</button>
      <button class="btn danger block" data-action="reset-demo">${I.refresh} Restablecer datos demo</button>
      <input type="file" id="fileImport" accept="application/json,.json" hidden>
    </div>

    <div class="section-title">Acerca de</div>
    <div class="card">
      <div class="small muted">Huellitas Felices · Proyecto C.T.C. 2026.<br>Almacenamiento local: <b>${Backend.useIDB?'IndexedDB':'localStorage'}</b>. Tus datos se guardan en este dispositivo y no se envían a ningún servidor.</div>
    </div>
    <button class="btn danger block" data-action="logout" style="margin-top:6px">${I.logout} Cerrar sesión</button>
  `;
}

/* Selector de mascota reutilizable */
function selectorMascota(mascotas){
  if(mascotas.length<=1)return '';
  return `<div class="filters" style="margin-bottom:6px">${mascotas.map(m=>`<button class="chip ${State.mascotaActiva===m.id?'active':''}" data-action="set-pet" data-id="${m.id}">${esc(m.emoji||'🐾')} ${esc(m.nombre)}</button>`).join('')}</div>`;
}

/* ================================================================
   Modales
================================================================ */
let modalEl=null;
function abrirModal(titulo,bodyHTML,foot){
  cerrarModal();
  const scrim=document.createElement('div');scrim.className='modal-scrim';scrim.id='modalScrim';
  scrim.innerHTML=`<div class="modal" role="dialog" aria-modal="true" aria-label="${esc(titulo)}">
    <div class="grabber"></div>
    <div class="modal-head"><h3>${esc(titulo)}</h3><button class="icon-btn" data-action="modal-close" aria-label="Cerrar" style="color:var(--muted)">${I.close}</button></div>
    <div class="modal-body">${bodyHTML}</div>
    ${foot?`<div class="modal-foot">${foot}</div>`:''}
  </div>`;
  app.appendChild(scrim);modalEl=scrim;
  requestAnimationFrame(()=>scrim.classList.add('show'));
  scrim.addEventListener('click',e=>{if(e.target===scrim)cerrarModal();});
  const first=scrim.querySelector('input,select,textarea,button');setTimeout(()=>first?.focus(),120);
}
function cerrarModal(){if(modalEl){modalEl.classList.remove('show');const m=modalEl;modalEl=null;setTimeout(()=>m.remove(),200);}}

function confirmar(msg,{ok='Confirmar',danger=false}={}){
  return new Promise(res=>{
    abrirModal('Confirmar',`<p style="margin:6px 0 8px">${esc(msg)}</p>`,
      `<button class="btn ghost" data-action="modal-close">Cancelar</button><button class="btn ${danger?'danger':'primary'}" id="confirmOk">${esc(ok)}</button>`);
    $('#confirmOk').addEventListener('click',()=>{cerrarModal();res(true);});
    modalEl.addEventListener('click',e=>{if(e.target===modalEl)res(false);},{once:true});
  });
}

/* --- formularios --- */
function campo(id,label,{type='text',value='',req=false,ph='',attrs=''}={}){
  return `<div class="field" id="f_${id}"><label for="${id}">${esc(label)} ${req?'<span class="req">*</span>':''}</label>
    <input id="${id}" type="${type}" value="${esc(value)}" placeholder="${esc(ph)}" ${attrs}>
    <div class="err">Este campo es obligatorio.</div></div>`;
}
function area(id,label,{value='',req=false,ph=''}={}){
  return `<div class="field" id="f_${id}"><label for="${id}">${esc(label)} ${req?'<span class="req">*</span>':''}</label>
    <textarea id="${id}" placeholder="${esc(ph)}">${esc(value)}</textarea><div class="err">Este campo es obligatorio.</div></div>`;
}
function selectF(id,label,opts,val,req=false){
  return `<div class="field" id="f_${id}"><label for="${id}">${esc(label)} ${req?'<span class="req">*</span>':''}</label>
    <select id="${id}">${opts.map(o=>`<option value="${esc(o.v)}" ${o.v===val?'selected':''}>${esc(o.t)}</option>`).join('')}</select>
    <div class="err">Selecciona una opción.</div></div>`;
}
function validar(ids){let ok=true;ids.forEach(id=>{const f=$('#f_'+id),el=$('#'+id);const v=(el.value||'').trim();
  if(!v){f.classList.add('invalid');ok=false;}else f.classList.remove('invalid');});return ok;}

/* Mascota */
function formMascota(m){
  const editar=!!m;m=m||{especie:'perro',sexo:'Macho'};
  abrirModal(editar?'Editar mascota':'Agregar mascota',`
    ${campo('nombre','Nombre',{value:m.nombre,req:true,ph:'Ej: Max'})}
    <div class="field"><label>Especie <span class="req">*</span></label>
      <div class="seg" id="segEspecie">
        <button type="button" class="opt ${m.especie==='perro'?'on':''}" data-v="perro">🐶 Perro</button>
        <button type="button" class="opt ${m.especie==='gato'?'on':''}" data-v="gato">🐱 Gato</button>
      </div></div>
    <div class="grid2">${campo('raza','Raza',{value:m.raza,ph:'Ej: Golden'})}
      ${selectF('sexo','Sexo',[{v:'Macho',t:'Macho'},{v:'Hembra',t:'Hembra'}],m.sexo)}</div>
    <div class="grid2">${campo('nacimiento','Fecha de nacimiento',{type:'date',value:m.nacimiento})}
      ${campo('peso','Peso (kg)',{type:'number',value:m.peso,attrs:'step="0.1" min="0"'})}</div>
    ${campo('color','Color',{value:m.color,ph:'Ej: Dorado'})}
    ${area('notas','Notas',{value:m.notas,ph:'Datos importantes, carácter…'})}
  `,`<button class="btn ghost" data-action="modal-close">Cancelar</button><button class="btn primary" id="saveMascota">${I.check} Guardar</button>`);
  let especie=m.especie;
  $$('#segEspecie .opt').forEach(b=>b.addEventListener('click',()=>{especie=b.dataset.v;$$('#segEspecie .opt').forEach(x=>x.classList.toggle('on',x===b));}));
  $('#saveMascota').addEventListener('click',async()=>{
    if(!validar(['nombre']))return;
    const obj={...(editar?m:{}),usuarioId:m.usuarioId||State.usuario.id,nombre:$('#nombre').value.trim(),especie,
      raza:$('#raza').value.trim(),sexo:$('#sexo').value,nacimiento:$('#nacimiento').value,
      peso:parseFloat($('#peso').value)||null,color:$('#color').value.trim(),notas:$('#notas').value.trim(),
      emoji:especie==='gato'?'🐱':'🐶'};
    if(editar)await Data.actualizar('mascotas',obj);else{await Data.crear('mascotas',obj);State.mascotaActiva=obj.id;}
    cerrarModal();toast(editar?'Mascota actualizada':'¡Mascota agregada! 🐾');await renderView();
  });
}

/* Detalle mascota */
async function abrirDetalleMascota(id){
  const m=await Data.obtener('mascotas',id);if(!m)return;
  const vacs=(await Data.filtrar('vacunas',v=>v.mascotaId===id));
  const regs=(await Data.filtrar('registros_salud',r=>r.mascotaId===id));
  abrirModal(m.nombre,`
    <div class="tile" style="margin-bottom:10px"><div class="avatar ${m.especie==='gato'?'rosa':'coral'}" style="width:60px;height:60px;font-size:30px">${esc(m.emoji)}</div>
      <div class="grow"><div class="strong" style="font-size:18px">${esc(m.nombre)}</div>
        <div class="small muted">${esc(m.raza||m.especie)} · ${esc(m.sexo||'')} · ${edad(m.nacimiento)||'—'}</div>
        <div class="small muted">${m.peso?m.peso+' kg':''}${m.color?' · '+esc(m.color):''}</div></div></div>
    ${m.notas?`<div class="card flat small">${esc(m.notas)}</div>`:''}
    <div class="stats" style="margin:10px 0"><div class="stat"><b>${vacs.length}</b><span>Vacunas</span></div>
      <div class="stat"><b>${vacs.filter(v=>v.tipo==='aplicada').length}</b><span>Aplicadas</span></div>
      <div class="stat"><b>${regs.length}</b><span>Controles</span></div></div>
    <button class="btn ghost block" data-action="pet-edit" data-id="${m.id}" style="margin-bottom:8px">${I.edit} Editar</button>
    <button class="btn danger block" data-action="pet-del" data-id="${m.id}">${I.trash} Eliminar mascota</button>
  `);
}

/* Vacuna */
async function formVacuna(){
  abrirModal('Agregar vacuna',`
    ${campo('vnombre','Nombre de la vacuna',{req:true,ph:'Ej: Rabia'})}
    ${campo('vfecha','Fecha',{type:'date',value:hoyISO(),req:true})}
    ${selectF('vtipo','Estado',[{v:'programada',t:'Programada'},{v:'refuerzo',t:'Refuerzo'},{v:'aplicada',t:'Ya aplicada'}],'programada')}
    ${area('vnotas','Notas',{ph:'Opcional'})}
  `,`<button class="btn ghost" data-action="modal-close">Cancelar</button><button class="btn primary" id="saveVac">${I.check} Guardar</button>`);
  $('#saveVac').addEventListener('click',async()=>{
    if(!validar(['vnombre','vfecha']))return;
    await Data.crear('vacunas',{mascotaId:State.mascotaActiva,nombre:$('#vnombre').value.trim(),fecha:$('#vfecha').value,tipo:$('#vtipo').value,notas:$('#vnotas').value.trim()});
    cerrarModal();toast('Vacuna registrada 💉');await renderView();
  });
}

/* Registro de salud */
async function formSalud(){
  abrirModal('Control de salud',`
    ${campo('sfecha','Fecha',{type:'date',value:hoyISO(),req:true})}
    <div class="grid2">${campo('speso','Peso (kg)',{type:'number',attrs:'step="0.1" min="0"',ph:'Ej: 12.5'})}
      ${selectF('sapetito','Apetito',[{v:'Normal',t:'Normal'},{v:'Bajo',t:'Bajo'},{v:'Alto',t:'Alto'}],'Normal')}</div>
    ${selectF('sactividad','Actividad',[{v:'Alta',t:'Alta'},{v:'Media',t:'Media'},{v:'Baja',t:'Baja'}],'Alta')}
    ${campo('ssintomas','Síntomas observados',{ph:'Ej: estornudos, decaimiento…'})}
    ${area('snotas','Notas',{ph:'Observaciones'})}
  `,`<button class="btn ghost" data-action="modal-close">Cancelar</button><button class="btn primary" id="saveSalud">${I.check} Guardar</button>`);
  $('#saveSalud').addEventListener('click',async()=>{
    if(!validar(['sfecha']))return;
    await Data.crear('registros_salud',{mascotaId:State.mascotaActiva,fecha:$('#sfecha').value,peso:parseFloat($('#speso').value)||null,
      apetito:$('#sapetito').value,actividad:$('#sactividad').value,sintomas:$('#ssintomas').value.trim(),notas:$('#snotas').value.trim()});
    cerrarModal();toast('Control registrado 💚');await renderView();
  });
}

/* Recordatorio */
async function formRecordatorio(){
  const mascotas=await misMascotas();
  abrirModal('Nuevo recordatorio',`
    ${campo('rtitulo','Título',{req:true,ph:'Ej: Baño mensual'})}
    ${selectF('rmascota','Mascota',mascotas.map(m=>({v:m.id,t:m.nombre})),State.mascotaActiva||mascotas[0]?.id,true)}
    <div class="grid2">${campo('rfecha','Fecha',{type:'date',value:hoyISO(),req:true})}
      ${selectF('rtipo','Tipo',[{v:'higiene',t:'Higiene'},{v:'vacuna',t:'Vacuna'},{v:'control',t:'Control'},{v:'alimentacion',t:'Alimentación'},{v:'medicamento',t:'Medicamento'}],'higiene')}</div>
  `,`<button class="btn ghost" data-action="modal-close">Cancelar</button><button class="btn primary" id="saveRec">${I.check} Guardar</button>`);
  $('#saveRec').addEventListener('click',async()=>{
    if(!validar(['rtitulo','rfecha']))return;
    await Data.crear('recordatorios',{titulo:$('#rtitulo').value.trim(),mascotaId:$('#rmascota').value,fecha:$('#rfecha').value,tipo:$('#rtipo').value,estado:'pendiente'});
    cerrarModal();toast('Recordatorio creado ⏰');await renderView();
  });
}

/* Asesoría */
async function formAsesoria(){
  const mascotas=await misMascotas();
  abrirModal('Nueva solicitud de asesoría',`
    ${selectF('amascota','Mascota',mascotas.map(m=>({v:m.id,t:m.nombre})),mascotas[0]?.id,true)}
    ${selectF('atema','Tema',[{v:'salud',t:'Salud'},{v:'conducta',t:'Conducta'},{v:'nutricion',t:'Nutrición'}],'salud')}
    ${area('amsg','Describe tu inquietud',{req:true,ph:'Cuéntanos qué observas en tu mascota…'})}
  `,`<button class="btn ghost" data-action="modal-close">Cancelar</button><button class="btn primary" id="saveAse">${I.check} Enviar</button>`);
  $('#saveAse').addEventListener('click',async()=>{
    if(!validar(['amsg']))return;
    await Data.crear('solicitudes_asesoria',{usuarioId:State.usuario.id,mascotaId:$('#amascota').value,tema:$('#atema').value,mensaje:$('#amsg').value.trim(),estado:'pendiente',fecha:hoyISO()});
    cerrarModal();toast('Solicitud enviada 💬');await renderView();
  });
}
async function formResponder(id){
  const s=await Data.obtener('solicitudes_asesoria',id);if(!s)return;
  abrirModal('Responder solicitud',`
    <div class="card flat small" style="margin-bottom:10px">${esc(s.mensaje)}</div>
    ${selectF('restado','Estado',[{v:'pendiente',t:'Pendiente'},{v:'en_proceso',t:'En proceso'},{v:'respondida',t:'Respondida'}],s.estado)}
    ${area('rresp','Respuesta',{value:s.respuesta||'',ph:'Escribe la orientación…'})}
  `,`<button class="btn ghost" data-action="modal-close">Cancelar</button><button class="btn primary" id="saveResp">${I.check} Guardar</button>`);
  $('#saveResp').addEventListener('click',async()=>{
    s.estado=$('#restado').value;s.respuesta=$('#rresp').value.trim();await Data.actualizar('solicitudes_asesoria',s);
    cerrarModal();toast('Solicitud actualizada');await renderView();
  });
}

/* Perfil */
function formPerfil(){
  const u=State.usuario;
  abrirModal('Editar perfil',`
    ${campo('pnombre','Nombre',{value:u.nombre,req:true})}
    ${campo('pemail','Correo',{type:'email',value:u.email})}
  `,`<button class="btn ghost" data-action="modal-close">Cancelar</button><button class="btn primary" id="savePerfil">${I.check} Guardar</button>`);
  $('#savePerfil').addEventListener('click',async()=>{
    if(!validar(['pnombre']))return;
    u.nombre=$('#pnombre').value.trim();u.email=$('#pemail').value.trim();await Data.actualizar('usuarios',u);
    cerrarModal();toast('Perfil actualizado');await renderShell();
  });
}

/* Detalle enfermedad / orientación */
async function abrirEnfermedad(id){
  const e=await Data.obtener('contenidos_educativos',id);if(!e)return;
  abrirModal(e.nombre,`
    <div class="tile" style="margin-bottom:10px"><div class="avatar coral" style="font-size:28px">${esc(e.emoji)}</div>
      <div class="grow"><span class="badge b-gris">${esc(e.categoria)}</span> <span class="badge b-azul">${e.especie==='ambos'?'Perros y gatos':e.especie==='gato'?'Gatos':'Perros'}</span></div></div>
    <p class="small">${esc(e.descripcion)}</p>
    <div class="card flat"><div class="strong small" style="color:var(--coral)">⚠️ Síntomas</div><div class="small">${esc(e.sintomas)}</div></div>
    <div class="card flat"><div class="strong small" style="color:var(--verde)">🛡️ Prevención</div><div class="small">${esc(e.prevencion)}</div></div>
    <div class="notice">${I.info}<div><b>¿Cuándo ir al veterinario?</b> ${esc(e.cuando_ir)}</div></div>
  `,`<button class="btn primary block" data-action="modal-close">Entendido</button>`);
}
async function abrirOrientacion(id){
  const o=await Data.obtener('contenidos_educativos',id);if(!o)return;
  abrirModal(o.titulo,`<div class="tile" style="margin-bottom:10px"><div class="avatar verde" style="font-size:28px">${esc(o.emoji)}</div>
    <div class="grow"><div class="strong">${esc(o.titulo)}</div><div class="small muted">${esc(o.resumen)}</div></div></div>
    <p class="small">${esc(o.cuerpo)}</p>`,`<button class="btn primary block" data-action="modal-close">Entendido</button>`);
}

/* ================================================================
   Backup: exportar / importar
================================================================ */
async function exportarBackup(){
  const data=await Data.exportarTodo();
  const blob=new Blob([JSON.stringify(data,null,2)],{type:'application/json'});
  const url=URL.createObjectURL(blob);const a=document.createElement('a');
  a.href=url;a.download='huellitas_felices_backup_'+hoyISO()+'.json';document.body.appendChild(a);a.click();a.remove();
  setTimeout(()=>URL.revokeObjectURL(url),1500);toast('Copia exportada ⬇️');
}
function importarBackup(){
  const inp=$('#fileImport');if(!inp)return;inp.value='';inp.click();
  inp.onchange=async()=>{const f=inp.files?.[0];if(!f)return;
    const reader=new FileReader();
    reader.onload=async()=>{try{const obj=JSON.parse(reader.result);
      const ok=await confirmar('Se reemplazará toda la información actual con la copia importada. ¿Continuar?',{ok:'Importar',danger:true});
      if(!ok)return;await Data.importarTodo(obj);State.usuario=await cargarSesion()||(await Data.listar('usuarios'))[0];toast('Copia importada ✅');await renderShell();
    }catch(err){toast('Archivo JSON inválido','err');}};
    reader.onerror=()=>toast('No se pudo leer el archivo','err');reader.readAsText(f);};
}

/* ================================================================
   Drawer
================================================================ */
function drawer(open){const d=$('#drawer'),s=$('#scrim');if(!d)return;d.classList.toggle('show',open);s.classList.toggle('show',open);d.setAttribute('aria-hidden',open?'false':'true');}

/* ================================================================
   Delegación de eventos
================================================================ */
document.addEventListener('click',async e=>{
  const t=e.target.closest('[data-action]');if(!t)return;
  const a=t.dataset.action,id=t.dataset.id;
  switch(a){
    case 'drawer-open':drawer(true);break;
    case 'drawer-close':drawer(false);break;
    case 'go':drawer(false);if(t.dataset.close)drawer(false);await go(t.dataset.route);break;
    case 'logout':{const ok=await confirmar('¿Cerrar sesión?');if(ok){limpiarSesion();State.usuario=null;renderWelcome();}break;}
    case 'set-pet':State.mascotaActiva=id;await renderView();break;
    case 'pet-new':formMascota(null);break;
    case 'pet-open':await abrirDetalleMascota(id);break;
    case 'pet-edit':{const m=await Data.obtener('mascotas',id);cerrarModal();setTimeout(()=>formMascota(m),210);break;}
    case 'pet-del':{const ok=await confirmar('¿Eliminar esta mascota y sus registros? Esta acción no se puede deshacer.',{ok:'Eliminar',danger:true});
      if(ok){await Data.eliminar('mascotas',id);
        for(const s of ['vacunas','registros_salud','recordatorios']){const arr=await Data.filtrar(s,x=>x.mascotaId===id);for(const x of arr)await Data.eliminar(s,x.id);}
        State.mascotaActiva=null;cerrarModal();toast('Mascota eliminada');await renderView();}break;}
    case 'vac-new':formVacuna();break;
    case 'vac-aplicar':{const v=await Data.obtener('vacunas',id);v.tipo='aplicada';v.fecha=hoyISO();await Data.actualizar('vacunas',v);toast('Vacuna aplicada ✅');await renderView();break;}
    case 'vac-del':{const ok=await confirmar('¿Eliminar esta vacuna?',{ok:'Eliminar',danger:true});if(ok){await Data.eliminar('vacunas',id);toast('Vacuna eliminada');await renderView();}break;}
    case 'cal-prev':State.calM--;if(State.calM<0){State.calM=11;State.calY--;}await renderView();break;
    case 'cal-next':State.calM++;if(State.calM>11){State.calM=0;State.calY++;}await renderView();break;
    case 'salud-new':formSalud();break;
    case 'salud-del':{const ok=await confirmar('¿Eliminar este control de salud?',{ok:'Eliminar',danger:true});if(ok){await Data.eliminar('registros_salud',id);toast('Registro eliminado');await renderView();}break;}
    case 'rec-new':formRecordatorio();break;
    case 'rec-done':{const r=await Data.obtener('recordatorios',id);r.estado='completado';await Data.actualizar('recordatorios',r);toast('¡Completado! ✅');await renderShell();break;}
    case 'rec-del':{const ok=await confirmar('¿Eliminar este recordatorio?',{ok:'Eliminar',danger:true});if(ok){await Data.eliminar('recordatorios',id);toast('Recordatorio eliminado');await renderShell();}break;}
    case 'enf-filter':State.filtroEnf=t.dataset.cat;await renderView();break;
    case 'enf-open':await abrirEnfermedad(id);break;
    case 'ori-open':await abrirOrientacion(id);break;
    case 'ase-new':formAsesoria();break;
    case 'ase-responder':await formResponder(id);break;
    case 'perfil-edit':formPerfil();break;
    case 'cfg-notif':{const cfg=(await Data.obtener('configuracion','cfg'))||{id:'cfg'};cfg.notificaciones=!cfg.notificaciones;await Data.actualizar('configuracion',cfg);await renderView();break;}
    case 'exportar':await exportarBackup();break;
    case 'importar':importarBackup();break;
    case 'reset-demo':{const ok=await confirmar('Se borrarán tus datos y se cargarán los datos de demostración. ¿Continuar?',{ok:'Restablecer',danger:true});
      if(ok){await resetDemo();State.usuario=(await Data.listar('usuarios')).find(u=>u.id==='u_demo');guardarSesion(State.usuario.id);State.mascotaActiva=null;toast('Datos demo restablecidos 🔄');await renderShell();}break;}
    case 'modal-close':cerrarModal();break;
    /* Login */
    case 'login-demo':await login('u_demo');break;
    case 'login-admin':await login('u_admin');break;
    case 'register':formRegistro();break;
  }
});
document.addEventListener('keydown',e=>{if(e.key==='Escape'){if(modalEl)cerrarModal();else drawer(false);}});

/* ================================================================
   Bienvenida / Login
================================================================ */
function renderWelcome(){
  app.innerHTML=`
    <section class="welcome">
      ${LOGO}
      <h1>Huellitas Felices</h1>
      <p class="tag">Cuidado preventivo, salud y bienestar para perros y gatos. 🐾</p>
      <div class="card">
        <button class="btn primary block" data-action="login-demo" style="margin-bottom:10px">${I.paw} Ingresar (Familia demo)</button>
        <button class="btn ghost block" data-action="login-admin" style="margin-bottom:10px">${I.admin} Ingresar como administrador</button>
        <div style="text-align:center"><button class="link-btn" data-action="register">Crear una cuenta nueva</button></div>
      </div>
      <div class="paw-strip">${I.paw}${I.paw}${I.paw}</div>
      <p class="small muted" style="margin-top:14px">Herramienta orientativa · no reemplaza al veterinario</p>
    </section>`;
}
async function login(id){
  const u=await Data.obtener('usuarios',id);if(!u){toast('Usuario no encontrado','err');return;}
  State.usuario=u;guardarSesion(u.id);State.ruta='inicio';State.mascotaActiva=null;
  toast('¡Bienvenido, '+u.nombre.split(' ')[0]+'! 🐾');await renderShell();
}
function formRegistro(){
  abrirModal('Crear cuenta',`
    ${campo('rnombre','Nombre',{req:true,ph:'Tu nombre'})}
    ${campo('remail','Correo',{type:'email',ph:'correo@ejemplo.com'})}
  `,`<button class="btn ghost" data-action="modal-close">Cancelar</button><button class="btn primary" id="doReg">${I.check} Crear e ingresar</button>`);
  $('#doReg').addEventListener('click',async()=>{
    if(!validar(['rnombre']))return;
    const u=await Data.crear('usuarios',{nombre:$('#rnombre').value.trim(),email:$('#remail').value.trim(),rol:'usuario',emoji:'🧑',password:''});
    cerrarModal();await login(u.id);
  });
}

/* ================================================================
   Arranque
================================================================ */
(async function main(){
  try{
    await initData();
    State.usuario=await cargarSesion();
    if(State.usuario)await renderShell(); else renderWelcome();
  }catch(err){
    console.error(err);
    app.innerHTML='<div class="empty" style="padding:60px 20px"><b>Ups…</b>No se pudo iniciar la aplicación.<br><span class="small muted">'+esc(err.message)+'</span></div>';
  }
})();
</script>
</body>
</html>
