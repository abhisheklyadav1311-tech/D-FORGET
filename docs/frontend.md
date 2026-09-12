<!-- Home Dashboard (Bauhaus) -->
<!DOCTYPE html>

<html lang="en"><head><meta charset="utf-8"/><meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no, viewport-fit=cover" name="viewport"/><link href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:wght,FILL@100..700,0..1&amp;display=swap" rel="stylesheet"/><link href="https://fonts.googleapis.com" rel="preconnect"/><link crossorigin="" href="https://fonts.gstatic.com" rel="preconnect"/><link href="https://fonts.googleapis.com/css2?family=Space+Grotesk:wght@400;500;600;700&amp;family=Inter:wght@400;500;600;700&amp;display=swap" rel="stylesheet"/><style>@layer base{html,body{width:100vw;margin:0;padding:0;background-color:#f5f0e8;}body{overscroll-behavior:none;}.pb-safe{padding-bottom:env(safe-area-inset-bottom,0px);}.pt-safe{padding-top:env(safe-area-inset-top,0px);}main>:first-child{margin-top:0!important;}main>:last-child{margin-bottom:0!important;}}::-webkit-scrollbar{display:none;}.brutal-shadow{box-shadow:3px 3px 0px #1a1a1a;}.brutal-shadow-lg{box-shadow:4px 4px 0px #1a1a1a;}.brutal-shadow-sm{box-shadow:2px 2px 0px #1a1a1a;}</style><script src="https://cdn.tailwindcss.com"></script><script id="tailwind-config">tailwind.config = {
    darkMode: "class",
    theme: {
      extend: {
        colors: {
          "on-primary-container": "#1a1a1a",
          "tertiary-container": "#d6e3ff",
          "on-primary-fixed": "#1a1a1a",
          "primary-fixed-dim": "#e6b800",
          "outline-variant": "#d0cbc3",
          "surface-container-high": "#e8e3da",
          "secondary": "#e63b2e",
          "surface-container-lowest": "#ffffff",
          "primary-container": "#ffcc00",
          "outline": "#1a1a1a",
          "on-surface": "#1a1a1a",
          "surface-container-low": "#f2ede5",
          "on-primary": "#ffffff",
          "surface-dim": "#d6d1c9",
          "error": "#cc0000",
          "on-error": "#ffffff",
          "on-tertiary-container": "#1a1a1a",
          "tertiary-fixed": "#d6e3ff",
          "on-tertiary-fixed-variant": "#1a1a1a",
          "inverse-primary": "#f5f0e8",
          "secondary-fixed": "#ffdad6",
          "primary": "#1a1a1a",
          "on-surface-variant": "#4a4a4a",
          "secondary-container": "#ffdad6",
          "background": "#f5f0e8",
          "on-error-container": "#93000a",
          "tertiary": "#0055ff",
          "on-primary-fixed-variant": "#1a1a1a",
          "on-secondary-fixed": "#1a1a1a",
          "surface-bright": "#faf7f2",
          "on-secondary": "#1a1a1a",
          "on-tertiary": "#ffffff",
          "inverse-on-surface": "#f5f0e8",
          "surface-variant": "#e8e3da",
          "surface-container-highest": "#e2ddd4",
          "surface-container": "#eee9e0",
          "tertiary-fixed-dim": "#a8c6ff",
          "on-secondary-fixed-variant": "#1a1a1a",
          "secondary-fixed-dim": "#ffb3ab",
          "surface": "#f5f0e8",
          "inverse-surface": "#1a1a1a",
          "on-background": "#1a1a1a",
          "primary-fixed": "#ffcc00",
          "error-container": "#ffdad6",
          "on-secondary-container": "#1a1a1a",
          "on-tertiary-fixed": "#1a1a1a",
          "surface-tint": "#1a1a1a"
        },
        borderRadius: {
          "DEFAULT": "0.125rem",
          "lg": "0.25rem",
          "xl": "0.5rem",
          "full": "0.75rem"
        },
        spacing: {
          "gutter": "1rem",
          "margin": "1rem",
          "space-xs": "0.25rem",
          "space-md": "1rem",
          "space-xl": "2rem",
          "space-lg": "1.5rem",
          "space-sm": "0.5rem"
        },
        fontFamily: {
          "headline": ["Space Grotesk", "sans-serif"],
          "display": ["Space Grotesk", "sans-serif"],
          "body": ["Inter", "sans-serif"],
          "label": ["Space Grotesk", "sans-serif"]
        }
      }
    }
  };</script><style>
    body {
      min-height: max(884px, 100dvh);
      font-family: 'Inter', sans-serif;
    }
  </style></head><body class="bg-[#f5f0e8] text-[#1a1a1a] flex flex-col min-h-screen antialiased"><header class="fixed top-0 w-full z-50 bg-[#f5f0e8] border-b-2 border-[#1a1a1a]"><div class="w-full h-7 px-4 pt-1 flex items-center justify-between text-[#1a1a1a] font-headline select-none"><span class="text-xs font-bold tracking-wider">9:41</span><div class="flex items-center gap-1.5 text-[#1a1a1a]"><span class="material-symbols-outlined text-[16px]">signal_cellular_alt</span><span class="material-symbols-outlined text-[16px]">wifi</span><span class="material-symbols-outlined text-[16px]">battery_full</span></div></div><div class="h-14 px-4 flex items-center justify-between"><div class="flex items-center gap-2"><div class="w-9 h-9 bg-[#ffcc00] border-2 border-[#1a1a1a] brutal-shadow-sm flex items-center justify-center"><span class="material-symbols-outlined text-[#1a1a1a] text-[22px]">auto_awesome</span></div><h1 class="font-headline text-xl font-bold tracking-tight uppercase text-[#1a1a1a]">Dashboard</h1></div><div class="flex items-center gap-2"><button aria-label="Notifications" class="w-10 h-10 bg-white border-2 border-[#1a1a1a] brutal-shadow-sm flex items-center justify-center text-[#1a1a1a] active:translate-x-0.5 active:translate-y-0.5 transition-transform"><span class="material-symbols-outlined text-[20px]">notifications</span></button><div class="w-10 h-10 bg-[#0055ff] border-2 border-[#1a1a1a] brutal-shadow-sm flex items-center justify-center"><span class="material-symbols-outlined text-white text-[20px]">person</span></div></div></div></header><main class="flex flex-col relative w-full pt-24 bg-[#f5f0e8] pb-28 min-h-screen"><div class="flex flex-col w-full">
<!-- Top Greeting & Contextual Header -->
<div class="px-4 pt-3 pb-2 flex items-center justify-between"><div class="flex items-center gap-3 min-w-0"><div class="relative w-12 h-12 border-2 border-[#1a1a1a] shrink-0 brutal-shadow-sm overflow-hidden bg-white"><img class="w-full h-full object-cover grayscale contrast-125" data-alt="Close up portrait photograph of Alex, an energetic software engineer and college student with glasses, warm smiling expression, studio rim lighting in soft cool indigo hues, modern clean minimalist background." src="https://lh3.googleusercontent.com/aida-public/AB6AXuBnrrBu86aVkRRXYRMhn-pm8Cwm-uuaC3GOu9Wb1r9iKIRnjYBGZKsR1k5TZP_d7nFztRs9BDTnj2Xxp2soeBWNNwkWOwnwwnl4v0-3u9xMPns4P5N-qvCDIK6mZAWu5-_46BbLI2DfJG73kP0LXloHq5WA9WVP9H3ZDOOzh1OISCuUGVMt6O9_-v-RUZpULM17hKJ0MQ9gnS2bBXTXNI0JeAjAdlyK7iuIWvSCWz04s2kmz66QEsnS"/><div class="absolute bottom-0 right-0 w-3 h-3 bg-[#e63b2e] border border-[#1a1a1a]"></div></div><div class="flex flex-col min-w-0"><h2 class="font-headline text-lg font-bold uppercase tracking-tight text-[#1a1a1a] truncate">Good morning, Alex</h2><p class="font-body text-xs text-[#4a4a4a] font-medium truncate">Here's what needs your attention.</p></div></div><button aria-label="Search and organize" class="w-11 h-11 bg-[#ffcc00] border-2 border-[#1a1a1a] text-[#1a1a1a] flex items-center justify-center brutal-shadow-sm active:translate-x-0.5 active:translate-y-0.5 transition-transform"><span class="material-symbols-outlined text-[20px]">search</span></button></div>
<!-- Metrics Overview Row -->
<div class="px-4 py-2"><div class="grid grid-cols-3 gap-2.5"><div class="bg-white border-2 border-[#1a1a1a] brutal-shadow p-2.5 flex flex-col justify-between"><div class="flex items-center justify-between mb-1.5"><span class="font-headline text-[11px] font-bold tracking-wider uppercase text-[#1a1a1a]">Today</span><span class="w-3 h-3 bg-[#0055ff] border border-[#1a1a1a]"></span></div><div class="flex items-baseline gap-1"><span class="font-headline text-2xl font-bold text-[#1a1a1a]">3</span><span class="font-body text-xs text-[#4a4a4a] uppercase font-semibold">tasks</span></div></div><div class="bg-white border-2 border-[#1a1a1a] brutal-shadow p-2.5 flex flex-col justify-between"><div class="flex items-center justify-between mb-1.5"><span class="font-headline text-[11px] font-bold tracking-wider uppercase text-[#1a1a1a]">Upcoming</span><span class="w-3 h-3 bg-[#ffcc00] border border-[#1a1a1a]"></span></div><div class="flex items-baseline gap-1"><span class="font-headline text-2xl font-bold text-[#1a1a1a]">7</span><span class="font-body text-xs text-[#4a4a4a] uppercase font-semibold">tasks</span></div></div><div class="bg-white border-2 border-[#1a1a1a] brutal-shadow p-2.5 flex flex-col justify-between"><div class="flex items-center justify-between mb-1.5"><span class="font-headline text-[11px] font-bold tracking-wider uppercase text-[#1a1a1a]">Overdue</span><span class="w-3 h-3 bg-[#e63b2e] border border-[#1a1a1a]"></span></div><div class="flex items-baseline gap-1"><span class="font-headline text-2xl font-bold text-[#e63b2e]">1</span><span class="font-body text-xs text-[#4a4a4a] uppercase font-semibold">task</span></div></div></div></div>
<!-- Prominent AI Inbox Card -->
<div class="px-4 pt-2 pb-2"><div class="relative bg-[#ffffff] border-2 border-[#1a1a1a] brutal-shadow-lg p-4"><div class="relative z-10 flex flex-col gap-2"><div class="flex items-center justify-between"><div class="inline-flex items-center gap-1.5 px-2.5 py-1 bg-[#ffcc00] border-2 border-[#1a1a1a] text-[#1a1a1a] font-headline text-xs font-bold uppercase"><span class="material-symbols-outlined text-[16px]">auto_awesome</span><span>AI Inbox</span></div><span class="font-headline text-[10px] uppercase font-bold tracking-wider text-white bg-[#1a1a1a] px-2 py-0.5 border border-[#1a1a1a]">Auto-Parser</span></div><p class="font-body text-sm text-[#1a1a1a] font-semibold leading-snug">Turn classroom notices, syllabus screenshots, and PDFs into actionable sub-tasks.</p><div class="pt-2 flex items-center justify-between gap-2"><button class="h-11 min-h-[44px] px-4 bg-[#0055ff] hover:bg-[#0044cc] text-white border-2 border-[#1a1a1a] font-headline text-sm font-bold uppercase tracking-wider flex items-center gap-2 brutal-shadow-sm active:translate-x-0.5 active:translate-y-0.5 transition-transform" id="analyze-btn"><span class="material-symbols-outlined text-[18px]">document_scanner</span><span>Analyze something</span><span class="material-symbols-outlined text-[16px]">arrow_forward</span></button><div class="hidden xs:flex items-center gap-1 text-[#1a1a1a] border-2 border-[#1a1a1a] bg-[#e8e3da] px-2 py-1"><span class="material-symbols-outlined text-[16px]">attachment</span><span class="font-headline text-[11px] font-bold uppercase">Ready</span></div></div></div></div></div>
<!-- Quick Context Prompt Ribbon -->
<div class="px-4 py-2"><div class="flex items-center gap-2 overflow-x-auto no-scrollbar py-0.5"><button class="shrink-0 h-8 px-3 bg-white border-2 border-[#1a1a1a] text-[#1a1a1a] font-headline text-xs font-bold uppercase flex items-center gap-1.5 brutal-shadow-sm hover:bg-[#ffcc00] transition-colors"><span class="material-symbols-outlined text-[#1a1a1a] text-[16px]">bolt</span><span>Prioritize today</span></button><button class="shrink-0 h-8 px-3 bg-white border-2 border-[#1a1a1a] text-[#1a1a1a] font-headline text-xs font-bold uppercase flex items-center gap-1.5 brutal-shadow-sm hover:bg-[#ffcc00] transition-colors"><span class="material-symbols-outlined text-[#1a1a1a] text-[16px]">schedule</span><span>Sync calendar</span></button><button class="shrink-0 h-8 px-3 bg-white border-2 border-[#1a1a1a] text-[#1a1a1a] font-headline text-xs font-bold uppercase flex items-center gap-1.5 brutal-shadow-sm hover:bg-[#ffcc00] transition-colors"><span class="material-symbols-outlined text-[#1a1a1a] text-[16px]">checklist_rtl</span><span>Clean backlog</span></button></div></div>
<!-- Section Header: Today Tasks -->
<div class="px-4 pt-3 pb-2 flex items-center justify-between"><div class="flex items-center gap-2"><h3 class="font-headline text-lg font-bold uppercase tracking-tight text-[#1a1a1a]">Today</h3><span class="inline-flex items-center justify-center min-w-[22px] h-5 px-1.5 bg-[#1a1a1a] text-white font-headline text-xs font-bold border border-[#1a1a1a]">3</span></div><div class="flex items-center gap-1 text-[#1a1a1a] font-headline text-xs font-bold uppercase border-b-2 border-[#1a1a1a] pb-0.5"><span class="material-symbols-outlined text-[16px]">tune</span><span>By Deadline</span></div></div>
<!-- Task Cards Feed -->
<div class="px-4 flex flex-col gap-3 pb-6">
<!-- Task Card 1 -->
<div class="task-card bg-white border-2 border-[#1a1a1a] p-3.5 brutal-shadow transition-transform"><div class="flex items-start gap-3"><button aria-label="Mark DBMS Assignment completed" class="task-checkbox shrink-0 w-7 h-7 border-2 border-[#1a1a1a] bg-white flex items-center justify-center mt-0.5 transition-colors"><span class="material-symbols-outlined text-[18px] font-bold opacity-0 text-[#1a1a1a]">check</span></button><div class="flex-1 min-w-0"><div class="flex items-start justify-between gap-1"><h4 class="task-title font-headline text-base font-bold uppercase tracking-tight text-[#1a1a1a] truncate">DBMS Assignment</h4><span class="shrink-0 px-2 py-0.5 bg-[#ffdad6] text-[#e63b2e] border border-[#1a1a1a] font-headline text-[10px] font-bold tracking-wider uppercase">High Priority</span></div><div class="mt-1.5 flex items-center gap-1.5 flex-wrap"><span class="inline-flex items-center px-2 py-0.5 bg-[#ffcc00] text-[#1a1a1a] border border-[#1a1a1a] font-headline text-[11px] font-bold uppercase">DBMS • Assignment</span><span class="inline-flex items-center gap-1 text-[#4a4a4a] font-body text-xs font-semibold"><span class="material-symbols-outlined text-[14px]">psychology</span><span>Schema design</span></span></div><div class="mt-3 pt-2 border-t border-[#1a1a1a]/20 flex items-center justify-between flex-wrap gap-y-1"><div class="flex items-center gap-1 text-[#e63b2e] font-headline text-xs font-bold uppercase"><span class="material-symbols-outlined text-[16px]">schedule</span><span>Due today, 5:00 PM</span></div><div class="flex items-center gap-1 text-[#1a1a1a] font-body text-[11px] font-semibold bg-[#e8e3da] border border-[#1a1a1a] px-1.5 py-0.5"><span class="material-symbols-outlined text-[14px]">notifications_active</span><span>Reminder 8:00 PM</span></div></div></div></div></div>
<!-- Task Card 2 -->
<div class="task-card bg-white border-2 border-[#1a1a1a] p-3.5 brutal-shadow transition-transform"><div class="flex items-start gap-3"><button aria-label="Mark DSA Presentation completed" class="task-checkbox shrink-0 w-7 h-7 border-2 border-[#1a1a1a] bg-white flex items-center justify-center mt-0.5 transition-colors"><span class="material-symbols-outlined text-[18px] font-bold opacity-0 text-[#1a1a1a]">check</span></button><div class="flex-1 min-w-0"><div class="flex items-start justify-between gap-1"><h4 class="task-title font-headline text-base font-bold uppercase tracking-tight text-[#1a1a1a] truncate">DSA Presentation</h4><span class="shrink-0 px-2 py-0.5 bg-[#ffcc00] text-[#1a1a1a] border border-[#1a1a1a] font-headline text-[10px] font-bold tracking-wider uppercase">Medium Priority</span></div><div class="mt-1.5 flex items-center gap-1.5 flex-wrap"><span class="inline-flex items-center px-2 py-0.5 bg-[#d6e3ff] text-[#0055ff] border border-[#1a1a1a] font-headline text-[11px] font-bold uppercase">DSA • Presentation</span><span class="inline-flex items-center gap-1 text-[#4a4a4a] font-body text-xs font-semibold"><span class="material-symbols-outlined text-[14px]">slideshow</span><span>Slide deck (7/10)</span></span></div><div class="mt-3 pt-2 border-t border-[#1a1a1a]/20 flex items-center justify-between flex-wrap gap-y-1"><div class="flex items-center gap-1 text-[#1a1a1a] font-headline text-xs font-bold uppercase"><span class="material-symbols-outlined text-[16px]">schedule</span><span>Due today, 8:00 PM</span></div><div class="flex items-center gap-1 text-[#1a1a1a] font-body text-[11px] font-semibold bg-[#e8e3da] border border-[#1a1a1a] px-1.5 py-0.5"><span class="material-symbols-outlined text-[14px]">groups</span><span>Team Hall</span></div></div></div></div></div>
<!-- Task Card 3 -->
<div class="task-card bg-white border-2 border-[#1a1a1a] p-3.5 brutal-shadow transition-transform"><div class="flex items-start gap-3"><button aria-label="Mark OS Lab Submission completed" class="task-checkbox shrink-0 w-7 h-7 border-2 border-[#1a1a1a] bg-white flex items-center justify-center mt-0.5 transition-colors"><span class="material-symbols-outlined text-[18px] font-bold opacity-0 text-[#1a1a1a]">check</span></button><div class="flex-1 min-w-0"><div class="flex items-start justify-between gap-1"><h4 class="task-title font-headline text-base font-bold uppercase tracking-tight text-[#1a1a1a] truncate">OS Lab Submission</h4><span class="shrink-0 px-2 py-0.5 bg-[#e8e3da] text-[#1a1a1a] border border-[#1a1a1a] font-headline text-[10px] font-bold tracking-wider uppercase">Low Priority</span></div><div class="mt-1.5 flex items-center gap-1.5 flex-wrap"><span class="inline-flex items-center px-2 py-0.5 bg-[#e8e3da] text-[#1a1a1a] border border-[#1a1a1a] font-headline text-[11px] font-bold uppercase">OS • Lab</span><span class="inline-flex items-center gap-1 text-[#4a4a4a] font-body text-xs font-semibold"><span class="material-symbols-outlined text-[14px]">terminal</span><span>C Semaphore patch</span></span></div><div class="mt-3 pt-2 border-t border-[#1a1a1a]/20 flex items-center justify-between flex-wrap gap-y-1"><div class="flex items-center gap-1 text-[#4a4a4a] font-headline text-xs font-bold uppercase"><span class="material-symbols-outlined text-[16px]">schedule</span><span>Due today, 11:59 PM</span></div><div class="flex items-center gap-1 text-[#1a1a1a] font-body text-[11px] font-semibold bg-[#e8e3da] border border-[#1a1a1a] px-1.5 py-0.5"><span class="material-symbols-outlined text-[14px]">cloud_upload</span><span>Git repo linked</span></div></div></div></div></div>
</div>
<!-- Floating Action Button Container -->
<div class="fixed right-4 bottom-24 z-40">
<button aria-label="Add new task" class="group flex items-center gap-1.5 h-12 px-4 bg-[#ffcc00] hover:bg-[#e6b800] text-[#1a1a1a] border-2 border-[#1a1a1a] brutal-shadow font-headline font-bold uppercase text-sm active:translate-x-0.5 active:translate-y-0.5 transition-all" id="add-task-fab"><span class="material-symbols-outlined text-[22px] font-bold">add</span><span class="tracking-wider">New Task</span></button>
</div>
<!-- Interactive Client Micro-Interactions Script -->
<script>
    (function() {
      // Toggle Task Completion State with neo-brutalist feedback
      const checkboxes = document.querySelectorAll('.task-checkbox');
      checkboxes.forEach(function(btn) {
        btn.addEventListener('click', function(e) {
          e.stopPropagation();
          const card = this.closest('.task-card');
          const title = card.querySelector('.task-title');
          const checkIcon = this.querySelector('span');

          const isChecked = checkIcon.classList.contains('opacity-100');
          if (!isChecked) {
            checkIcon.classList.remove('opacity-0');
            checkIcon.classList.add('opacity-100');
            this.classList.add('bg-[#ffcc00]');
            title.classList.add('line-through', 'opacity-60');
            card.classList.add('opacity-75', 'bg-[#eee9e0]');
          } else {
            checkIcon.classList.remove('opacity-100');
            checkIcon.classList.add('opacity-0');
            this.classList.remove('bg-[#ffcc00]');
            title.classList.remove('line-through', 'opacity-60');
            card.classList.remove('opacity-75', 'bg-[#eee9e0]');
          }
        });
      });

      // Quick visual feedback on Analyze action
      const analyzeBtn = document.getElementById('analyze-btn');
      if (analyzeBtn) {
        analyzeBtn.addEventListener('click', function() {
          const originalText = this.innerHTML;
          this.innerHTML = '<span class="material-symbols-outlined text-[18px] animate-spin">sync</span><span>Scanning...</span>';
          setTimeout(() => {
            this.innerHTML = originalText;
          }, 1400);
        });
      }
    })();
  </script>
</div></main><nav class="fixed bottom-0 w-full z-50 pb-safe bg-[#f5f0e8] border-t-4 border-[#1a1a1a]"><div class="flex items-center justify-around h-16 px-1"><a aria-current="page" class="flex flex-col items-center justify-center min-w-[44px] min-h-[44px] w-14 py-1 text-[#1a1a1a] font-headline font-bold" data-path="dashboard" href="#"><div class="w-8 h-8 bg-[#ffcc00] border-2 border-[#1a1a1a] flex items-center justify-center brutal-shadow-sm"><span class="material-symbols-outlined text-[20px]">dashboard</span></div><span class="text-[10px] tracking-wider uppercase mt-1">Home</span></a><a class="flex flex-col items-center justify-center min-w-[44px] min-h-[44px] w-14 py-1 text-[#4a4a4a] hover:text-[#1a1a1a] font-headline font-bold" data-path="task-list" href="#"><span class="material-symbols-outlined text-[22px]">checklist</span><span class="text-[10px] tracking-wider uppercase mt-1">Tasks</span></a><a class="flex flex-col items-center justify-center min-w-[44px] min-h-[44px] -mt-4 transition-transform active:translate-y-0.5" data-path="ai-inbox" href="#"><div class="w-12 h-12 bg-[#0055ff] text-white border-2 border-[#1a1a1a] flex items-center justify-center brutal-shadow"><span class="material-symbols-outlined text-[24px]">auto_awesome</span></div><span class="font-headline text-[10px] text-[#1a1a1a] font-bold uppercase tracking-wider mt-1">AI Inbox</span></a><a class="flex flex-col items-center justify-center min-w-[44px] min-h-[44px] w-14 py-1 text-[#4a4a4a] hover:text-[#1a1a1a] font-headline font-bold" data-path="completed-tasks" href="#"><span class="material-symbols-outlined text-[22px]">check_circle</span><span class="text-[10px] tracking-wider uppercase mt-1">Done</span></a><a class="flex flex-col items-center justify-center min-w-[44px] min-h-[44px] w-14 py-1 text-[#4a4a4a] hover:text-[#1a1a1a] font-headline font-bold" data-path="app-settings" href="#"><span class="material-symbols-outlined text-[22px]">tune</span><span class="text-[10px] tracking-wider uppercase mt-1">Settings</span></a></div></nav></body></html>

<!-- Task Detail (Bauhaus) -->
<!DOCTYPE html>

<html lang="en"><head><meta charset="utf-8"/><meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no, viewport-fit=cover" name="viewport"/><link href="https://fonts.googleapis.com" rel="preconnect"/><link crossorigin="" href="https://fonts.gstatic.com" rel="preconnect"/><link href="https://fonts.googleapis.com/css2?family=Space+Grotesk:wght@400;500;600;700&amp;family=Inter:wght@400;500;600;700&amp;display=swap" rel="stylesheet"/><link href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" rel="stylesheet"/><style>@layer base{html,body{width:100vw;margin:0;padding:0;background-color:#f5f0e8;}body{overscroll-behavior:none;}.pb-safe{padding-bottom:env(safe-area-inset-bottom,0px);}.pt-safe{padding-top:env(safe-area-inset-top,0px);}main>:first-child{margin-top:0!important;}main>:last-child{margin-bottom:0!important;}}::-webkit-scrollbar{display:none;}body{min-height:max(884px,100dvh);}</style><script src="https://cdn.tailwindcss.com?plugins=forms,container-queries"></script><script id="tailwind-config">
  tailwind.config = {
    darkMode: "class",
    theme: {
      extend: {
        "colors": {
          "on-primary-container": "#1a1a1a",
          "tertiary-container": "#d6e3ff",
          "on-primary-fixed": "#1a1a1a",
          "primary-fixed-dim": "#e6b800",
          "outline-variant": "#d0cbc3",
          "surface-container-high": "#e8e3da",
          "secondary": "#e63b2e",
          "surface-container-lowest": "#ffffff",
          "primary-container": "#ffcc00",
          "outline": "#1a1a1a",
          "on-surface": "#1a1a1a",
          "surface-container-low": "#f2ede5",
          "on-primary": "#ffffff",
          "surface-dim": "#d6d1c9",
          "error": "#cc0000",
          "on-error": "#ffffff",
          "on-tertiary-container": "#1a1a1a",
          "tertiary-fixed": "#d6e3ff",
          "on-tertiary-fixed-variant": "#1a1a1a",
          "inverse-primary": "#f5f0e8",
          "secondary-fixed": "#ffdad6",
          "primary": "#1a1a1a",
          "on-surface-variant": "#4a4a4a",
          "secondary-container": "#ffdad6",
          "background": "#f5f0e8",
          "on-error-container": "#93000a",
          "tertiary": "#0055ff",
          "on-primary-fixed-variant": "#1a1a1a",
          "on-secondary-fixed": "#1a1a1a",
          "surface-bright": "#faf7f2",
          "on-secondary": "#1a1a1a",
          "on-tertiary": "#ffffff",
          "inverse-on-surface": "#f5f0e8",
          "surface-variant": "#e8e3da",
          "surface-container-highest": "#e2ddd4",
          "surface-container": "#eee9e0",
          "tertiary-fixed-dim": "#a8c6ff",
          "on-secondary-fixed-variant": "#1a1a1a",
          "secondary-fixed-dim": "#ffb3ab",
          "surface": "#f5f0e8",
          "inverse-surface": "#1a1a1a",
          "on-background": "#1a1a1a",
          "primary-fixed": "#ffcc00",
          "error-container": "#ffdad6",
          "on-secondary-container": "#1a1a1a",
          "on-tertiary-fixed": "#1a1a1a",
          "surface-tint": "#1a1a1a"
        },
        "borderRadius": {
          "DEFAULT": "0.125rem",
          "lg": "0.25rem",
          "xl": "0.5rem",
          "full": "0.75rem"
        },
        "fontFamily": {
          "headline": ["Space Grotesk", "sans-serif"],
          "display": ["Space Grotesk", "sans-serif"],
          "body": ["Inter", "sans-serif"],
          "label": ["Space Grotesk", "sans-serif"]
        }
      },
    },
  }
</script></head><body class="bg-surface font-body text-on-surface flex flex-col min-h-screen antialiased"><header class="fixed top-0 w-full z-50 bg-surface border-b-2 border-primary shadow-[0_3px_0px_#1a1a1a]"><div class="w-full h-7 px-4 pt-1 flex items-center justify-between text-on-surface select-none font-label"><span class="text-xs font-bold tracking-tight">9:41</span><div class="flex items-center gap-1.5"><span class="material-symbols-outlined text-[16px]">signal_cellular_alt</span><span class="material-symbols-outlined text-[16px]">wifi</span><span class="material-symbols-outlined text-[16px]">battery_full</span></div></div><div class="h-14 px-4 flex items-center justify-between"><div class="flex items-center gap-2"><button aria-label="Navigate back" class="w-10 h-10 border-2 border-primary bg-surface-container-lowest rounded flex items-center justify-center text-on-surface shadow-[2px_2px_0px_#1a1a1a] active:translate-x-[1px] active:translate-y-[1px] active:shadow-[1px_1px_0px_#1a1a1a] transition-all" onclick="history.back()"><span class="material-symbols-outlined text-[22px]">arrow_back</span></button><h1 class="font-headline text-lg font-bold uppercase tracking-tight text-on-surface truncate max-w-[200px]">Task Detail</h1></div><div class="flex items-center gap-2"><button aria-label="More options" class="w-10 h-10 border-2 border-primary bg-surface-container-lowest rounded flex items-center justify-center text-on-surface shadow-[2px_2px_0px_#1a1a1a] active:translate-x-[1px] active:translate-y-[1px] active:shadow-[1px_1px_0px_#1a1a1a] transition-all"><span class="material-symbols-outlined text-[20px]">more_vert</span></button><div class="w-10 h-10 border-2 border-primary bg-primary-container rounded flex items-center justify-center shadow-[2px_2px_0px_#1a1a1a]"><span class="material-symbols-outlined text-primary text-[20px]">person</span></div></div></div></header><main class="flex flex-col relative w-full pt-24 bg-surface pb-safe min-h-screen"><div class="flex flex-col w-full px-4 pb-28 gap-4">
<!-- Micro Progress / AI Reliability Strip -->
<div class="w-full flex items-center justify-between px-3.5 py-2.5 rounded border-2 border-primary bg-[#e6f0ff] shadow-[3px_3px_0px_#1a1a1a]">
<div class="flex items-center gap-2 text-tertiary font-label">
<span class="material-symbols-outlined text-[20px]" style="font-variation-settings: 'FILL' 1;">auto_awesome</span>
<span class="font-bold text-xs uppercase tracking-wider text-on-surface">AI Parsed &amp; Synchronized</span>
</div>
<span class="font-label text-xs font-bold uppercase tracking-wider bg-tertiary text-white px-2 py-0.5 border border-primary shadow-[1px_1px_0px_#1a1a1a]">98% Confidence</span>
</div>
<!-- Task Header Card -->
<div class="w-full bg-surface-container-lowest rounded border-2 border-primary p-4 shadow-[3px_3px_0px_#1a1a1a] flex flex-col gap-3 relative">
<div class="flex items-center justify-between gap-2 flex-wrap">
<span class="inline-flex items-center gap-1.5 px-2.5 py-1 rounded-sm bg-secondary text-white font-label text-xs font-bold uppercase tracking-wider border-2 border-primary shadow-[2px_2px_0px_#1a1a1a]">
<span class="w-2 h-2 rounded-full bg-white animate-pulse"></span>
        High Priority
      </span>
<div class="flex items-center gap-2">
<span class="inline-flex items-center px-2 py-0.5 border-2 border-primary bg-surface-container font-label text-xs font-bold uppercase tracking-wider shadow-[1.5px_1.5px_0px_#1a1a1a]">
          Assignment
        </span>
<span class="inline-flex items-center px-2 py-0.5 border-2 border-primary bg-primary-container font-label text-xs font-bold uppercase tracking-wider shadow-[1.5px_1.5px_0px_#1a1a1a]">
          DBMS
        </span>
</div>
</div>
<div class="border-t-2 border-primary/20 pt-2">
<h2 class="font-headline text-2xl font-bold uppercase tracking-tight text-on-surface">DBMS Assignment</h2>
<p class="font-body text-xs font-semibold text-on-surface-variant mt-1">Course Code: CS-302 • Prof. V. Sharma</p>
</div>
</div>
<!-- Description Card -->
<div class="w-full bg-surface-container-lowest rounded border-2 border-primary p-4 shadow-[3px_3px_0px_#1a1a1a] flex flex-col gap-2">
<div class="flex items-center justify-between border-b-2 border-primary/20 pb-2">
<h3 class="font-label text-xs font-bold uppercase tracking-widest text-primary flex items-center gap-1.5">
<span class="w-2 h-2 bg-secondary inline-block"></span>
        Description
      </h3>
<button class="bg-primary-container border-2 border-primary px-2.5 py-0.5 font-label text-xs font-bold uppercase flex items-center gap-1 text-primary shadow-[2px_2px_0px_#1a1a1a] active:translate-x-[1px] active:translate-y-[1px] active:shadow-none transition-all" id="copyDescBtn" onclick="copyDescription()">
<span class="material-symbols-outlined text-[15px]">content_copy</span>
<span>Copy</span>
</button>
</div>
<p class="font-body text-sm text-on-surface leading-relaxed font-normal pt-1">
      Complete the DBMS assignment and upload the PDF to the college portal before the deadline. Ensure ER diagram diagrams and normalized tables up to BCNF are cleanly annotated.
    </p>
</div>
<!-- Metadata Grid / Info Cards -->
<div class="grid grid-cols-2 gap-3 w-full">
<!-- Deadline Card -->
<div class="bg-surface-container-lowest rounded border-2 border-primary p-3.5 shadow-[3px_3px_0px_#1a1a1a] flex flex-col justify-between">
<div class="flex items-center gap-1.5 text-primary mb-2">
<span class="material-symbols-outlined text-[18px]">calendar_today</span>
<span class="font-label text-xs font-bold uppercase tracking-wider">Deadline</span>
</div>
<div>
<p class="font-headline text-xl font-bold text-on-surface leading-tight">20 Sep</p>
<div class="flex items-center gap-1 text-on-surface-variant font-label text-xs font-semibold mt-1">
<span class="material-symbols-outlined text-[14px]">schedule</span>
<span>5:00 PM</span>
</div>
</div>
</div>
<!-- Status Card -->
<div class="bg-surface-container-lowest rounded border-2 border-primary p-3.5 shadow-[3px_3px_0px_#1a1a1a] flex flex-col justify-between">
<div class="flex items-center gap-1.5 text-primary mb-2">
<span class="material-symbols-outlined text-[18px]">pending_actions</span>
<span class="font-label text-xs font-bold uppercase tracking-wider">Status</span>
</div>
<div>
<div class="flex items-center gap-2">
<span class="w-3 h-3 bg-secondary border border-primary"></span>
<p class="font-headline text-xl font-bold text-on-surface leading-tight" id="statusLabel">Pending</p>
</div>
<p class="font-label text-xs font-semibold text-on-surface-variant mt-1">Due in 2 days</p>
</div>
</div>
<!-- Subject Card -->
<div class="bg-surface-container-lowest rounded border-2 border-primary p-3.5 shadow-[3px_3px_0px_#1a1a1a] flex flex-col justify-between">
<div class="flex items-center gap-1.5 text-primary mb-1">
<span class="material-symbols-outlined text-[18px]">menu_book</span>
<span class="font-label text-xs font-bold uppercase tracking-wider">Subject</span>
</div>
<div>
<p class="font-headline text-sm font-bold text-on-surface leading-snug">Database Systems</p>
<span class="font-body text-xs text-on-surface-variant font-medium">Core Lab • Module 4</span>
</div>
</div>
<!-- Category Card -->
<div class="bg-surface-container-lowest rounded border-2 border-primary p-3.5 shadow-[3px_3px_0px_#1a1a1a] flex flex-col justify-between">
<div class="flex items-center gap-1.5 text-primary mb-1">
<span class="material-symbols-outlined text-[18px]">folder</span>
<span class="font-label text-xs font-bold uppercase tracking-wider">Category</span>
</div>
<div>
<p class="font-headline text-sm font-bold text-on-surface leading-snug">Assignment</p>
<span class="font-body text-xs text-on-surface-variant font-medium">Weighted: 15% Total</span>
</div>
</div>
</div>
<!-- Reminders Section -->
<div class="w-full bg-surface-container-lowest rounded border-2 border-primary p-4 shadow-[3px_3px_0px_#1a1a1a] flex flex-col gap-3">
<div class="flex items-center justify-between border-b-2 border-primary/20 pb-2">
<div class="flex items-center gap-2">
<span class="material-symbols-outlined text-primary text-[20px]">notifications_active</span>
<h3 class="font-label text-xs font-bold uppercase tracking-widest text-primary">Reminders</h3>
</div>
<span class="font-label text-xs font-bold uppercase bg-surface-container px-2 py-0.5 border border-primary">1 Active</span>
</div>
<!-- Active Reminder Card -->
<div class="flex items-center justify-between p-3 bg-surface-container-low rounded border-2 border-primary shadow-[2px_2px_0px_#1a1a1a] transition-all" id="reminderRow">
<div class="flex items-center gap-2.5">
<div class="w-9 h-9 border-2 border-primary bg-primary-container rounded flex items-center justify-center text-primary shadow-[1px_1px_0px_#1a1a1a]">
<span class="material-symbols-outlined text-[18px]">alarm</span>
</div>
<div class="flex flex-col">
<span class="font-headline text-sm font-bold text-on-surface">19 September</span>
<span class="font-label text-xs text-on-surface-variant">8:00 PM • Evening before</span>
</div>
</div>
<div class="flex items-center gap-1.5">
<button aria-label="Toggle reminder" class="w-11 h-6 bg-primary border-2 border-primary rounded-full p-0.5 transition-colors relative flex items-center shadow-[1px_1px_0px_#1a1a1a]" onclick="toggleReminder(this)">
<div class="w-4 h-4 rounded-full bg-primary-container border border-primary shadow-none transform translate-x-5 transition-transform"></div>
</button>
<button aria-label="Delete reminder" class="w-7 h-7 border border-primary bg-surface-container hover:bg-secondary hover:text-white rounded flex items-center justify-center text-primary transition-colors ml-1 active:translate-y-0.5" onclick="deleteReminder()">
<span class="material-symbols-outlined text-[16px]">close</span>
</button>
</div>
</div>
<!-- Add Reminder Action Button -->
<button class="w-full py-2.5 px-4 rounded border-2 border-dashed border-primary bg-surface-container-low flex items-center justify-center gap-2 text-primary font-label text-xs font-bold uppercase tracking-wider hover:bg-surface-container transition-all active:translate-x-[1px] active:translate-y-[1px]" onclick="addReminderPrompt()">
<span class="material-symbols-outlined text-[18px]">add_alert</span>
<span>Add Reminder</span>
</button>
</div>
<!-- Source Transparency Card -->
<div class="w-full bg-surface-container-lowest rounded border-2 border-primary p-4 shadow-[3px_3px_0px_#1a1a1a] flex flex-col gap-3">
<div class="flex items-center justify-between border-b-2 border-primary/20 pb-2">
<div class="flex items-center gap-2">
<div class="w-6 h-6 border border-primary bg-tertiary-container flex items-center justify-center text-primary">
<span class="material-symbols-outlined text-[16px]">document_scanner</span>
</div>
<h3 class="font-label text-xs font-bold uppercase tracking-widest text-primary">Source Transparency</h3>
</div>
<span class="font-label text-xs font-bold uppercase text-tertiary flex items-center gap-1">
<span class="material-symbols-outlined text-[16px]" style="font-variation-settings: 'FILL' 1;">verified</span>
        Verified Source
      </span>
</div>
<div class="flex items-start gap-3 p-3 bg-surface-container-low rounded border-2 border-primary shadow-[2px_2px_0px_#1a1a1a]">
<div class="w-12 h-14 bg-secondary border-2 border-primary rounded flex flex-col items-center justify-center shrink-0 text-white shadow-[1px_1px_0px_#1a1a1a]">
<span class="material-symbols-outlined text-[24px]">picture_as_pdf</span>
<span class="font-label text-[10px] font-bold uppercase mt-0.5">PDF</span>
</div>
<div class="flex flex-col min-w-0 flex-1">
<span class="font-headline text-sm font-bold text-on-surface truncate">College Notice_Fall2024.pdf</span>
<p class="font-body text-xs text-on-surface-variant mt-1 leading-snug">Task automatically extracted from page 3, section 4.1 "Deadlines &amp; Deliverables".</p>
</div>
</div>
<button class="w-full py-2.5 px-4 rounded border-2 border-primary bg-surface-container-lowest hover:bg-surface-container flex items-center justify-center gap-2 text-on-surface font-label text-xs font-bold uppercase tracking-wider shadow-[2px_2px_0px_#1a1a1a] active:translate-x-[1px] active:translate-y-[1px] active:shadow-none transition-all" onclick="openDocumentPreview()">
<span class="material-symbols-outlined text-[18px]">visibility</span>
<span>View Original Document</span>
</button>
</div>
<!-- Toast Notification Container -->
<div class="fixed top-20 left-1/2 -translate-x-1/2 bg-primary text-white border-2 border-primary px-4 py-2 rounded font-label text-xs font-bold uppercase tracking-wider shadow-[4px_4px_0px_#ffcc00] flex items-center gap-2 pointer-events-none opacity-0 transition-opacity duration-300 z-50" id="toastNotification">
<span class="material-symbols-outlined text-[18px] text-primary-container" id="toastIcon">check_circle</span>
<span id="toastMessage">Action completed</span>
</div>
<!-- Sticky Fixed Bottom Actions -->
<div class="fixed bottom-0 left-0 w-full px-4 py-3 bg-surface border-t-2 border-primary shadow-[0_-3px_0px_#1a1a1a] z-40">
<div class="max-w-md mx-auto flex items-center gap-3">
<!-- Edit Task Button -->
<button class="flex-1 h-12 rounded border-2 border-primary bg-surface-container-lowest hover:bg-surface-container-high text-on-surface font-label text-sm font-bold uppercase tracking-wider flex items-center justify-center gap-2 shadow-[3px_3px_0px_#1a1a1a] active:translate-x-[2px] active:translate-y-[2px] active:shadow-[1px_1px_0px_#1a1a1a] transition-all" onclick="triggerEditModal()">
<span class="material-symbols-outlined text-[20px]">edit</span>
<span>Edit Task</span>
</button>
<!-- Mark Complete Button -->
<button class="flex-1 h-12 rounded border-2 border-primary bg-primary-container hover:bg-[#ffe066] text-primary font-label text-sm font-bold uppercase tracking-wider flex items-center justify-center gap-2 shadow-[3px_3px_0px_#1a1a1a] active:translate-x-[2px] active:translate-y-[2px] active:shadow-[1px_1px_0px_#1a1a1a] transition-all" id="markCompleteBtn" onclick="toggleTaskCompletion()">
<span class="material-symbols-outlined text-[20px]" id="completionIcon">check_circle</span>
<span id="completionLabel">Mark Complete</span>
</button>
</div>
</div>
</div>
<script>
  let isComplete = false;
  let reminderActive = true;

  function showToast(message, icon = 'check_circle') {
    const toast = document.getElementById('toastNotification');
    const msg = document.getElementById('toastMessage');
    const ico = document.getElementById('toastIcon');
    if (!toast) return;
    
    msg.textContent = message;
    ico.textContent = icon;
    toast.classList.remove('opacity-0');
    toast.classList.add('opacity-100');
    
    setTimeout(() => {
      toast.classList.remove('opacity-100');
      toast.classList.add('opacity-0');
    }, 2400);
  }

  function copyDescription() {
    navigator.clipboard?.writeText("Complete the DBMS assignment and upload the PDF to the college portal before the deadline.");
    showToast("Description copied to clipboard", "content_copy");
  }

  function toggleReminder(button) {
    reminderActive = !reminderActive;
    const indicator = button.querySelector('div');
    if (reminderActive) {
      button.classList.remove('bg-surface-variant');
      button.classList.add('bg-primary');
      indicator.classList.remove('translate-x-0', 'bg-surface-dim');
      indicator.classList.add('translate-x-5', 'bg-primary-container');
      showToast("Reminder enabled");
    } else {
      button.classList.remove('bg-primary');
      button.classList.add('bg-surface-variant');
      indicator.classList.remove('translate-x-5', 'bg-primary-container');
      indicator.classList.add('translate-x-0', 'bg-surface-dim');
      showToast("Reminder muted", "notifications_off");
    }
  }

  function deleteReminder() {
    const row = document.getElementById('reminderRow');
    if (row) {
      row.style.opacity = '0';
      row.style.transform = 'scale(0.95)';
      setTimeout(() => {
        row.remove();
        showToast("Reminder deleted", "delete");
      }, 200);
    }
  }

  function addReminderPrompt() {
    showToast("Setting new reminder...", "schedule");
  }

  function openDocumentPreview() {
    showToast("Opening College Notice.pdf...", "open_in_new");
  }

  function triggerEditModal() {
    showToast("Opening task editor...", "edit");
  }

  function toggleTaskCompletion() {
    isComplete = !isComplete;
    const btn = document.getElementById('markCompleteBtn');
    const lbl = document.getElementById('completionLabel');
    const ico = document.getElementById('completionIcon');
    const statusLabel = document.getElementById('statusLabel');

    if (isComplete) {
      btn.classList.remove('bg-primary-container');
      btn.classList.add('bg-secondary', 'text-white');
      lbl.textContent = 'Mark Pending';
      ico.textContent = 'replay';
      statusLabel.textContent = 'Completed';
      statusLabel.classList.add('text-secondary');
      showToast("Assignment marked as completed!", "task_alt");
    } else {
      btn.classList.add('bg-primary-container');
      btn.classList.remove('bg-secondary', 'text-white');
      lbl.textContent = 'Mark Complete';
      ico.textContent = 'check_circle';
      statusLabel.textContent = 'Pending';
      statusLabel.classList.remove('text-secondary');
      showToast("Assignment reverted to pending", "undo");
    }
  }
</script></main></body></html>

<!-- Tasks List (Bauhaus) -->
<!DOCTYPE html>

<html lang="en"><head><meta charset="utf-8"/><meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no, viewport-fit=cover" name="viewport"/><link href="https://fonts.googleapis.com" rel="preconnect"/><link crossorigin="" href="https://fonts.gstatic.com" rel="preconnect"/><link href="https://fonts.googleapis.com/css2?family=Space+Grotesk:wght@400;500;600;700&amp;family=Inter:wght@400;500;600;700&amp;display=swap" rel="stylesheet"/><link href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:wght,FILL@100..700,0..1&amp;display=swap" rel="stylesheet"/><script src="https://cdn.tailwindcss.com?plugins=forms,container-queries"></script><script id="tailwind-config">
  tailwind.config = {
    darkMode: "class",
    theme: {
      extend: {
        "colors": {
          "on-primary-container": "#1a1a1a",
          "tertiary-container": "#d6e3ff",
          "on-primary-fixed": "#1a1a1a",
          "primary-fixed-dim": "#e6b800",
          "outline-variant": "#d0cbc3",
          "surface-container-high": "#e8e3da",
          "secondary": "#e63b2e",
          "surface-container-lowest": "#ffffff",
          "primary-container": "#ffcc00",
          "outline": "#1a1a1a",
          "on-surface": "#1a1a1a",
          "surface-container-low": "#f2ede5",
          "on-primary": "#ffffff",
          "surface-dim": "#d6d1c9",
          "error": "#cc0000",
          "on-error": "#ffffff",
          "on-tertiary-container": "#1a1a1a",
          "tertiary-fixed": "#d6e3ff",
          "on-tertiary-fixed-variant": "#1a1a1a",
          "inverse-primary": "#f5f0e8",
          "secondary-fixed": "#ffdad6",
          "primary": "#1a1a1a",
          "on-surface-variant": "#4a4a4a",
          "secondary-container": "#ffdad6",
          "background": "#f5f0e8",
          "on-error-container": "#93000a",
          "tertiary": "#0055ff",
          "on-primary-fixed-variant": "#1a1a1a",
          "on-secondary-fixed": "#1a1a1a",
          "surface-bright": "#faf7f2",
          "on-secondary": "#1a1a1a",
          "on-tertiary": "#ffffff",
          "inverse-on-surface": "#f5f0e8",
          "surface-variant": "#e8e3da",
          "surface-container-highest": "#e2ddd4",
          "surface-container": "#eee9e0",
          "tertiary-fixed-dim": "#a8c6ff",
          "on-secondary-fixed-variant": "#1a1a1a",
          "secondary-fixed-dim": "#ffb3ab",
          "surface": "#f5f0e8",
          "inverse-surface": "#1a1a1a",
          "on-background": "#1a1a1a",
          "primary-fixed": "#ffcc00",
          "error-container": "#ffdad6",
          "on-secondary-container": "#1a1a1a",
          "on-tertiary-fixed": "#1a1a1a",
          "surface-tint": "#1a1a1a"
        },
        "borderRadius": {
          "DEFAULT": "0.125rem",
          "lg": "0.25rem",
          "xl": "0.5rem",
          "full": "0.75rem"
        },
        "spacing": {
          "gutter": "1rem",
          "margin": "1rem",
          "space-xs": "0.25rem",
          "space-sm": "0.5rem",
          "space-md": "1rem",
          "space-lg": "1.5rem",
          "space-xl": "2rem"
        },
        "fontFamily": {
          "headline": ["Space Grotesk", "sans-serif"],
          "display": ["Space Grotesk", "sans-serif"],
          "body": ["Inter", "sans-serif"],
          "label": ["Space Grotesk", "sans-serif"]
        }
      },
    },
  }
</script><style>
  @layer base {
    html, body {
      width: 100vw;
      margin: 0;
      padding: 0;
      background-color: #f5f0e8;
    }
    body {
      overscroll-behavior: none;
    }
    .pb-safe {
      padding-bottom: env(safe-area-inset-bottom, 0px);
    }
    .pt-safe {
      padding-top: env(safe-area-inset-top, 0px);
    }
  }
  ::-webkit-scrollbar {
    display: none;
  }
  body {
    min-height: max(884px, 100dvh);
  }
</style></head><body class="bg-surface font-body text-on-surface flex flex-col min-h-screen selection:bg-primary-container selection:text-on-primary-container"><header class="fixed top-0 w-full z-50 bg-surface border-b-2 border-primary"><div class="w-full h-7 px-margin pt-1 flex items-center justify-between text-on-surface select-none border-b border-primary/20"><span class="font-label text-xs font-bold tracking-wider">09:41</span><div class="flex items-center gap-2 font-mono"><span class="material-symbols-outlined text-[16px]">signal_cellular_alt</span><span class="material-symbols-outlined text-[16px]">wifi</span><span class="material-symbols-outlined text-[16px]">battery_full</span></div></div><div class="h-14 px-margin flex items-center justify-between"><div class="flex items-center gap-2"><div class="w-8 h-8 bg-primary-container border-2 border-primary shadow-[2px_2px_0px_#1a1a1a] flex items-center justify-center"><span class="material-symbols-outlined text-[18px] text-primary">terminal</span></div><h1 class="font-headline text-lg font-bold uppercase tracking-tight text-primary">Task_List//01</h1></div><div class="flex items-center gap-2"><button aria-label="Notifications" class="w-9 h-9 border-2 border-primary bg-surface-container-lowest shadow-[2px_2px_0px_#1a1a1a] flex items-center justify-center active:translate-x-0.5 active:translate-y-0.5 active:shadow-none transition-all" type="button"><span class="material-symbols-outlined text-[19px]">notifications</span></button><div class="w-9 h-9 border-2 border-primary bg-primary text-on-primary shadow-[2px_2px_0px_#ffcc00] flex items-center justify-center font-headline text-xs font-bold"><span class="material-symbols-outlined text-[18px]">person</span></div></div></div></header><main class="flex flex-col relative w-full pt-[5.75rem] pb-28 min-h-screen"><div class="flex flex-col w-full">
<!-- Screen Header & Actions -->
<section class="px-margin pt-3 pb-4 flex flex-col gap-3"><div class="flex items-start justify-between"><div class="flex flex-col"><div class="inline-flex items-center gap-1.5"><span class="w-2.5 h-2.5 bg-secondary border border-primary"></span><span class="font-label text-xs font-bold uppercase tracking-widest text-secondary">Registry</span></div><h2 class="font-headline text-3xl font-bold tracking-tight text-primary uppercase mt-0.5">Tasks</h2><span class="font-body text-xs font-medium text-on-surface-variant">System Status: Stay on top of everything.</span></div><div class="flex items-center gap-1.5"><button aria-label="Search tasks" class="w-10 h-10 border-2 border-primary bg-surface-container-lowest shadow-[3px_3px_0px_#1a1a1a] flex items-center justify-center active:translate-x-0.5 active:translate-y-0.5 active:shadow-none transition-all" type="button"><span class="material-symbols-outlined text-[20px]">search</span></button><button aria-label="Filter tasks" class="relative w-10 h-10 border-2 border-primary bg-surface-container-lowest shadow-[3px_3px_0px_#1a1a1a] flex items-center justify-center active:translate-x-0.5 active:translate-y-0.5 active:shadow-none transition-all" type="button"><span class="material-symbols-outlined text-[20px]">tune</span><span class="absolute top-1.5 right-1.5 w-2 h-2 bg-secondary border border-primary"></span></button><button class="h-10 px-3.5 border-2 border-primary bg-primary-container text-primary font-headline text-xs font-bold tracking-wide uppercase shadow-[3px_3px_0px_#1a1a1a] active:translate-x-0.5 active:translate-y-0.5 active:shadow-none transition-all flex items-center gap-1" id="btn-quick-new" type="button"><span class="material-symbols-outlined text-[18px]">add</span><span>New</span></button></div></div><!-- AI Suggestion Brutalist Banner --><div class="w-full border-2 border-primary bg-surface-container-lowest p-3 shadow-[3px_3px_0px_#1a1a1a] flex items-center justify-between gap-3"><div class="flex items-center gap-2.5 min-w-0"><div class="w-7 h-7 bg-tertiary text-on-tertiary border-2 border-primary flex items-center justify-center flex-shrink-0"><span class="material-symbols-outlined text-[16px]">bolt</span></div><p class="font-label text-xs truncate text-primary leading-tight"><strong class="font-bold uppercase tracking-wider bg-tertiary-container px-1 py-0.5 border border-primary text-[10px] mr-1">AI Suggestion</strong> Reorder DBMS Assignment before 3 PM for peak focus</p></div><button class="font-headline text-xs font-bold uppercase tracking-wider flex-shrink-0 px-2.5 py-1.5 border-2 border-primary bg-primary text-on-primary shadow-[2px_2px_0px_#1a1a1a] active:translate-x-0.5 active:translate-y-0.5 active:shadow-none transition-all" type="button">Apply</button></div></section>
<!-- Segmented Tabs Ribbon -->
<section class="w-full px-margin pb-3 overflow-x-auto no-scrollbar"><div class="flex items-center gap-2 min-w-max"><button class="h-8 px-3.5 border-2 border-primary bg-surface-container-lowest font-headline text-xs font-bold uppercase tracking-wider text-primary shadow-[2px_2px_0px_#1a1a1a] active:translate-x-0.5 active:translate-y-0.5 active:shadow-none transition-all" type="button">All</button><button class="h-8 px-4 border-2 border-primary bg-primary text-on-primary font-headline text-xs font-bold uppercase tracking-wider flex items-center gap-1.5 shadow-[2px_2px_0px_#1a1a1a]" type="button"><span>Today</span><span class="w-1.5 h-1.5 bg-primary-container border border-primary"></span></button><button class="h-8 px-3.5 border-2 border-primary bg-surface-container-lowest font-headline text-xs font-bold uppercase tracking-wider text-primary shadow-[2px_2px_0px_#1a1a1a] active:translate-x-0.5 active:translate-y-0.5 active:shadow-none transition-all" type="button">Upcoming</button><button class="h-8 px-3.5 border-2 border-primary bg-surface-container-lowest font-headline text-xs font-bold uppercase tracking-wider text-primary shadow-[2px_2px_0px_#1a1a1a] flex items-center gap-2 active:translate-x-0.5 active:translate-y-0.5 active:shadow-none transition-all" type="button"><span>Overdue</span><span class="px-1.5 py-0.2 bg-secondary text-white border border-primary text-[10px] font-bold">1</span></button></div></section>
<!-- Main Tasks List Container -->
<div class="px-margin flex flex-col gap-6 pt-1 pb-6"><!-- Group 1: TODAY --><section class="flex flex-col gap-2.5"><div class="flex items-center justify-between border-b-2 border-primary pb-1"><div class="flex items-center gap-2"><span class="w-3 h-3 bg-primary border border-primary"></span><h2 class="font-headline text-xs tracking-widest font-bold uppercase text-primary">Today // 2 Tasks</h2></div><span class="font-label text-xs font-bold uppercase bg-primary-container px-2 py-0.5 border border-primary text-primary">85% focus score</span></div><!-- Task Card 1: High Priority --><article class="task-card w-full border-2 border-primary bg-surface-container-lowest p-3.5 flex flex-col gap-3 shadow-[4px_4px_0px_#1a1a1a] transition-all"><div class="flex items-start gap-3"><button aria-checked="false" class="task-toggle mt-0.5 w-6 h-6 min-w-[24px] border-2 border-primary bg-surface flex items-center justify-center text-transparent hover:bg-surface-container-high transition-colors shadow-[1px_1px_0px_#1a1a1a]" role="checkbox" type="button"><span class="material-symbols-outlined text-[16px] font-bold">check</span></button><div class="flex flex-col min-w-0 flex-1"><div class="flex items-center justify-between gap-2"><h3 class="task-title font-headline text-base font-bold text-primary truncate tracking-tight">DBMS Assignment</h3><span class="flex items-center gap-1 px-2 py-0.5 border-2 border-primary font-headline text-[10px] font-bold uppercase bg-secondary text-white shadow-[2px_2px_0px_#1a1a1a] flex-shrink-0"><span class="w-1.5 h-1.5 bg-white border border-primary"></span>High</span></div><div class="flex items-center gap-1.5 mt-1.5"><span class="font-label text-[11px] font-semibold uppercase px-2 py-0.5 border border-primary bg-surface-container-low text-primary">DBMS • Assignment</span></div></div></div><div class="flex items-center justify-between pt-2 border-t border-primary/20 pl-9"><div class="flex items-center gap-1.5 font-label text-xs font-bold text-secondary uppercase"><span class="material-symbols-outlined text-[16px]">schedule</span><span>Due 5:00 PM</span></div><div class="flex items-center gap-2"><span class="w-7 h-7 border border-primary bg-primary-container text-primary flex items-center justify-center shadow-[1px_1px_0px_#1a1a1a]" title="Reminder Active"><span class="material-symbols-outlined text-[15px]">notifications_active</span></span><button class="w-7 h-7 border border-primary bg-surface text-primary flex items-center justify-center hover:bg-surface-container active:translate-x-0.5 active:translate-y-0.5 transition-all" type="button"><span class="material-symbols-outlined text-[15px]">more_vert</span></button></div></div></article><!-- Task Card 2: Medium Priority --><article class="task-card w-full border-2 border-primary bg-surface-container-lowest p-3.5 flex flex-col gap-3 shadow-[4px_4px_0px_#1a1a1a] transition-all"><div class="flex items-start gap-3"><button aria-checked="false" class="task-toggle mt-0.5 w-6 h-6 min-w-[24px] border-2 border-primary bg-surface flex items-center justify-center text-transparent hover:bg-surface-container-high transition-colors shadow-[1px_1px_0px_#1a1a1a]" role="checkbox" type="button"><span class="material-symbols-outlined text-[16px] font-bold">check</span></button><div class="flex flex-col min-w-0 flex-1"><div class="flex items-center justify-between gap-2"><h3 class="task-title font-headline text-base font-bold text-primary truncate tracking-tight">DSA Presentation</h3><span class="flex items-center gap-1 px-2 py-0.5 border-2 border-primary font-headline text-[10px] font-bold uppercase bg-primary-container text-primary shadow-[2px_2px_0px_#1a1a1a] flex-shrink-0"><span class="w-1.5 h-1.5 bg-primary border border-primary"></span>Medium</span></div><div class="flex items-center gap-1.5 mt-1.5"><span class="font-label text-[11px] font-semibold uppercase px-2 py-0.5 border border-primary bg-surface-container-low text-primary">DSA • Presentation</span></div></div></div><div class="flex items-center justify-between pt-2 border-t border-primary/20 pl-9"><div class="flex items-center gap-1.5 font-label text-xs font-bold text-on-surface-variant uppercase"><span class="material-symbols-outlined text-[16px]">schedule</span><span>Due 8:00 PM</span></div><div class="flex items-center gap-2"><button class="w-7 h-7 border border-primary bg-surface text-primary flex items-center justify-center hover:bg-surface-container active:translate-x-0.5 active:translate-y-0.5 transition-all" type="button"><span class="material-symbols-outlined text-[15px]">more_vert</span></button></div></div></article></section><!-- Group 2: TOMORROW --><section class="flex flex-col gap-2.5"><div class="flex items-center justify-between border-b-2 border-primary pb-1"><div class="flex items-center gap-2"><span class="w-3 h-3 bg-tertiary border border-primary"></span><h2 class="font-headline text-xs tracking-widest font-bold uppercase text-primary">Tomorrow // 1 Task</h2></div></div><!-- Task Card 3: Normal Priority --><article class="task-card w-full border-2 border-primary bg-surface-container-lowest p-3.5 flex flex-col gap-3 shadow-[4px_4px_0px_#1a1a1a] transition-all"><div class="flex items-start gap-3"><button aria-checked="false" class="task-toggle mt-0.5 w-6 h-6 min-w-[24px] border-2 border-primary bg-surface flex items-center justify-center text-transparent hover:bg-surface-container-high transition-colors shadow-[1px_1px_0px_#1a1a1a]" role="checkbox" type="button"><span class="material-symbols-outlined text-[16px] font-bold">check</span></button><div class="flex flex-col min-w-0 flex-1"><div class="flex items-center justify-between gap-2"><h3 class="task-title font-headline text-base font-bold text-primary truncate tracking-tight">Operating Systems Notes</h3><span class="flex items-center gap-1 px-2 py-0.5 border-2 border-primary font-headline text-[10px] font-bold uppercase bg-surface-container-high text-primary shadow-[2px_2px_0px_#1a1a1a] flex-shrink-0">Normal</span></div><div class="flex items-center gap-1.5 mt-1.5"><span class="font-label text-[11px] font-semibold uppercase px-2 py-0.5 border border-primary bg-surface-container-low text-primary">OS • Study</span></div></div></div><div class="flex items-center justify-between pt-2 border-t border-primary/20 pl-9"><div class="flex items-center gap-1.5 font-label text-xs font-bold text-on-surface-variant uppercase"><span class="material-symbols-outlined text-[16px]">calendar_today</span><span>Tomorrow, 2:00 PM</span></div><div class="flex items-center gap-2"><button class="w-7 h-7 border border-primary bg-surface text-primary flex items-center justify-center hover:bg-surface-container active:translate-x-0.5 active:translate-y-0.5 transition-all" type="button"><span class="material-symbols-outlined text-[15px]">more_vert</span></button></div></div></article></section><!-- Group 3: LATER THIS WEEK --><section class="flex flex-col gap-2.5"><div class="flex items-center justify-between border-b-2 border-primary pb-1"><div class="flex items-center gap-2"><span class="w-3 h-3 bg-surface-dim border border-primary"></span><h2 class="font-headline text-xs tracking-widest font-bold uppercase text-primary">Later This Week</h2></div></div><!-- Task Card 4: Normal Priority --><article class="task-card w-full border-2 border-primary bg-surface-container-lowest p-3.5 flex flex-col gap-3 shadow-[4px_4px_0px_#1a1a1a] transition-all"><div class="flex items-start gap-3"><button aria-checked="false" class="task-toggle mt-0.5 w-6 h-6 min-w-[24px] border-2 border-primary bg-surface flex items-center justify-center text-transparent hover:bg-surface-container-high transition-colors shadow-[1px_1px_0px_#1a1a1a]" role="checkbox" type="button"><span class="material-symbols-outlined text-[16px] font-bold">check</span></button><div class="flex flex-col min-w-0 flex-1"><div class="flex items-center justify-between gap-2"><h3 class="task-title font-headline text-base font-bold text-primary truncate tracking-tight">Computer Networks Quiz Prep</h3><span class="flex items-center gap-1 px-2 py-0.5 border-2 border-primary font-headline text-[10px] font-bold uppercase bg-surface-container-high text-primary shadow-[2px_2px_0px_#1a1a1a] flex-shrink-0">Normal</span></div><div class="flex items-center gap-1.5 mt-1.5"><span class="font-label text-[11px] font-semibold uppercase px-2 py-0.5 border border-primary bg-surface-container-low text-primary">CN • Exam Prep</span></div></div></div><div class="flex items-center justify-between pt-2 border-t border-primary/20 pl-9"><div class="flex items-center gap-1.5 font-label text-xs font-bold text-on-surface-variant uppercase"><span class="material-symbols-outlined text-[16px]">event</span><span>Thursday</span></div><div class="flex items-center gap-2"><button class="w-7 h-7 border border-primary bg-surface text-primary flex items-center justify-center hover:bg-surface-container active:translate-x-0.5 active:translate-y-0.5 transition-all" type="button"><span class="material-symbols-outlined text-[15px]">more_vert</span></button></div></div></article></section><!-- Visual Companion Card: Productive Study Corner --><section class="mt-2 w-full border-2 border-primary bg-surface-container-lowest p-3.5 flex items-center gap-3.5 shadow-[4px_4px_0px_#1a1a1a]"><div class="w-20 h-20 border-2 border-primary overflow-hidden flex-shrink-0 shadow-[2px_2px_0px_#1a1a1a]"><img class="w-full h-full object-cover" data-alt="A tidy university student wooden desk with an organized laptop, notebook with neat blue diagrams, ceramic coffee mug, and gentle morning sunlight streaming through soft window blinds in serene indigo and warm tones." src="https://lh3.googleusercontent.com/aida-public/AB6AXuBuf7gj088N02qV5oZLZvMUyyWu8Wn6dJp6qQQTlBzUmlo7ExjpYJVFl3_UxmQpsmjjGoPk5Lo5qRtnBZvVYQrVAgfUL6xqNUPWpvb8x-mNsHQ3EKgRJaYQ4alcoSlM-AUu_iYXDiAJMvGQ0KZMLyuHJmE4yrTWuSCV_6COEh3bnbYcgec5kcjxoQw1gU49cdwm0xUwLfKVyUsQjPnoI0gibbfyUDxKOI2jFvBtxAsvrYnP_WVHSS0B"/></div><div class="flex flex-col min-w-0 flex-1"><div class="inline-flex items-center gap-1"><span class="w-2 h-2 bg-primary"></span><span class="font-headline text-[11px] font-bold uppercase tracking-wider text-primary">Weekly Momentum</span></div><h4 class="font-headline text-base font-bold text-primary truncate mt-0.5">3 of 7 tasks done</h4><p class="font-body text-xs text-on-surface-variant mt-0.5 leading-snug">Keep pacing steadily to clear your Thursday quiz effortlessly.</p></div></section></div>
</div>
<script>
  document.querySelectorAll('.task-toggle').forEach((btn) => {
    btn.addEventListener('click', (e) => {
      e.stopPropagation();
      const card = btn.closest('.task-card');
      const title = card.querySelector('.task-title');
      const isChecked = btn.getAttribute('aria-checked') === 'true';

      if (!isChecked) {
        btn.setAttribute('aria-checked', 'true');
        btn.classList.remove('bg-surface', 'text-transparent');
        btn.classList.add('bg-primary', 'text-white');
        title.classList.add('line-through', 'opacity-50');
        card.classList.add('opacity-75', 'bg-surface-container-low');
      } else {
        btn.setAttribute('aria-checked', 'false');
        btn.classList.add('bg-surface', 'text-transparent');
        btn.classList.remove('bg-primary', 'text-white');
        title.classList.remove('line-through', 'opacity-50');
        card.classList.remove('opacity-75', 'bg-surface-container-low');
      }
    });
  });
</script></main><nav class="fixed bottom-0 w-full z-50 pb-safe bg-surface border-t-2 border-primary" data-active-classes="text-primary font-bold"><div class="flex items-center justify-around h-16 px-space-xs"><a class="flex flex-col items-center justify-center min-w-[44px] min-h-[44px] w-14 py-1 font-headline text-[11px] font-bold uppercase text-on-surface-variant hover:text-primary transition-colors" data-path="dashboard" href="#"><span class="material-symbols-outlined text-[22px]">dashboard</span><span class="mt-0.5">Home</span></a><a aria-current="page" class="flex flex-col items-center justify-center min-w-[44px] min-h-[44px] w-14 py-1 font-headline text-[11px] font-bold uppercase text-primary border-b-4 border-primary pb-0.5" data-path="task-list" href="#"><span class="material-symbols-outlined text-[22px]">checklist</span><span class="mt-0.5">Tasks</span></a><a class="flex flex-col items-center justify-center min-w-[48px] min-h-[48px] -mt-4 transition-transform active:translate-y-0.5" data-path="ai-inbox" href="#"><div class="w-12 h-12 border-2 border-primary bg-primary-container text-primary shadow-[3px_3px_0px_#1a1a1a] flex items-center justify-center"><span class="material-symbols-outlined text-[22px]">bolt</span></div><span class="font-headline text-[10px] font-bold uppercase tracking-wider text-primary mt-1">AI Inbox</span></a><a class="flex flex-col items-center justify-center min-w-[44px] min-h-[44px] w-14 py-1 font-headline text-[11px] font-bold uppercase text-on-surface-variant hover:text-primary transition-colors" data-path="completed-tasks" href="#"><span class="material-symbols-outlined text-[22px]">check_box</span><span class="mt-0.5">Done</span></a><a class="flex flex-col items-center justify-center min-w-[44px] min-h-[44px] w-14 py-1 font-headline text-[11px] font-bold uppercase text-on-surface-variant hover:text-primary transition-colors" data-path="app-settings" href="#"><span class="material-symbols-outlined text-[22px]">tune</span><span class="mt-0.5">Settings</span></a></div></nav></body></html>

<!-- AI Analysis Result (Bauhaus) -->
<!DOCTYPE html>

<html lang="en"><head><meta charset="utf-8"/><meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no, viewport-fit=cover" name="viewport"/><link href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" rel="stylesheet"/><link href="https://fonts.googleapis.com" rel="preconnect"/><link crossorigin="" href="https://fonts.gstatic.com" rel="preconnect"/><link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&amp;family=Space+Grotesk:wght@500;600;700;800&amp;display=swap" rel="stylesheet"/>
<link href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:wght,FILL@100..700,0..1&amp;display=swap" rel="stylesheet"/><style>@layer base{html,body{width:100vw;margin:0;padding:0;background-color:#f5f0e8;}body{overscroll-behavior:none;}.pb-safe{padding-bottom:env(safe-area-inset-bottom,0px);}.pt-safe{padding-top:env(safe-area-inset-top,0px);}main>:first-child{margin-top:0!important;}main>:last-child{margin-bottom:0!important;}}::-webkit-scrollbar{display:none;}</style><script src="https://cdn.tailwindcss.com?plugins=forms,container-queries"></script><script id="tailwind-config">tailwind.config = {
  darkMode: "class",
  theme: {
    extend: {
      colors: {
        "on-primary-container": "#1a1a1a",
        "tertiary-container": "#d6e3ff",
        "on-primary-fixed": "#1a1a1a",
        "primary-fixed-dim": "#e6b800",
        "outline-variant": "#d0cbc3",
        "surface-container-high": "#e8e3da",
        "secondary": "#e63b2e",
        "surface-container-lowest": "#ffffff",
        "primary-container": "#ffcc00",
        "outline": "#1a1a1a",
        "on-surface": "#1a1a1a",
        "surface-container-low": "#f2ede5",
        "on-primary": "#ffffff",
        "surface-dim": "#d6d1c9",
        "error": "#cc0000",
        "on-error": "#ffffff",
        "on-tertiary-container": "#1a1a1a",
        "tertiary-fixed": "#d6e3ff",
        "on-tertiary-fixed-variant": "#1a1a1a",
        "inverse-primary": "#f5f0e8",
        "secondary-fixed": "#ffdad6",
        "primary": "#1a1a1a",
        "on-surface-variant": "#4a4a4a",
        "secondary-container": "#ffdad6",
        "background": "#f5f0e8",
        "on-error-container": "#93000a",
        "tertiary": "#0055ff",
        "on-primary-fixed-variant": "#1a1a1a",
        "on-secondary-fixed": "#1a1a1a",
        "surface-bright": "#faf7f2",
        "on-secondary": "#1a1a1a",
        "on-tertiary": "#ffffff",
        "inverse-on-surface": "#f5f0e8",
        "surface-variant": "#e8e3da",
        "surface-container-highest": "#e2ddd4",
        "surface-container": "#eee9e0",
        "tertiary-fixed-dim": "#a8c6ff",
        "on-secondary-fixed-variant": "#1a1a1a",
        "secondary-fixed-dim": "#ffb3ab",
        "surface": "#f5f0e8",
        "inverse-surface": "#1a1a1a",
        "on-background": "#1a1a1a",
        "primary-fixed": "#ffcc00",
        "error-container": "#ffdad6",
        "on-secondary-container": "#1a1a1a",
        "on-tertiary-fixed": "#1a1a1a",
        "surface-tint": "#1a1a1a"
      },
      fontFamily: {
        headline: ["Space Grotesk", "sans-serif"],
        display: ["Space Grotesk", "sans-serif"],
        body: ["Inter", "sans-serif"],
        label: ["Space Grotesk", "sans-serif"]
      },
      boxShadow: {
        'brutal': '3px 3px 0px #1a1a1a',
        'brutal-sm': '2px 2px 0px #1a1a1a',
        'brutal-lg': '4px 4px 0px #1a1a1a'
      }
    }
  }
};</script></head><body class="bg-surface font-body text-on-surface flex flex-col min-h-screen selection:bg-primary-container selection:text-on-primary-container"><header class="fixed top-0 w-full z-50 bg-surface/95 border-b-[2.5px] border-outline backdrop-blur-sm"><div class="w-full h-7 px-4 pt-1 flex items-center justify-between text-on-surface select-none font-label"><span class="text-xs font-bold tracking-tight">9:41</span><div class="flex items-center gap-1.5 text-on-surface"><span class="material-symbols-outlined text-[15px] font-bold">signal_cellular_alt</span><span class="material-symbols-outlined text-[15px] font-bold">wifi</span><span class="material-symbols-outlined text-[15px] font-bold">battery_full</span></div></div><div class="h-14 px-4 flex items-center justify-between"><div class="flex items-center gap-2.5"><div class="w-9 h-9 border-2 border-outline bg-primary-container shadow-brutal-sm flex items-center justify-center"><span class="material-symbols-outlined text-outline text-[22px] font-bold">auto_awesome</span></div><h1 class="font-headline text-xl text-on-surface font-extrabold uppercase tracking-tight">Ai Inbox</h1></div><div class="flex items-center gap-2"><button aria-label="Notifications" class="w-9 h-9 border-2 border-outline bg-surface-container-lowest shadow-brutal-sm flex items-center justify-center text-on-surface active:translate-x-[1px] active:translate-y-[1px] active:shadow-none transition-all"><span class="material-symbols-outlined text-[20px]">notifications</span></button><div class="w-9 h-9 border-2 border-outline bg-primary shadow-brutal-sm flex items-center justify-center text-on-primary"><span class="material-symbols-outlined text-[18px]">person</span></div></div></div></header><main class="flex flex-col relative w-full pt-20 bg-surface pb-28 min-h-screen"><div class="flex flex-col w-full pb-6">
<div class="px-4 pt-2 pb-3 flex items-center justify-between">
<div class="flex items-center gap-2.5">
<button aria-label="Go back or dismiss" class="w-9 h-9 border-2 border-outline bg-surface-container-lowest shadow-brutal-sm flex items-center justify-center text-on-surface active:translate-x-[1px] active:translate-y-[1px] active:shadow-none transition-all" type="button">
<span class="material-symbols-outlined text-[20px] font-bold">arrow_back</span>
</button>
<div>
<div class="flex items-center gap-1.5">
<span class="material-symbols-outlined text-[20px] text-tertiary font-bold">auto_awesome</span>
<h2 class="font-headline text-lg font-bold uppercase tracking-tight text-on-surface">Analysis Complete</h2>
</div>
<div class="flex items-center gap-1.5 mt-0.5">
<span class="w-2 h-2 bg-secondary border border-outline"></span>
<p class="font-label text-xs font-semibold uppercase text-on-surface-variant tracking-wider">Source: College Notice.pdf</p>
</div>
</div>
</div>
<span class="px-2.5 py-1 border-2 border-outline bg-primary-container shadow-brutal-sm font-label text-xs font-bold uppercase text-on-surface flex items-center gap-1">
<span class="material-symbols-outlined text-[15px] font-bold">verified</span>
      Synced
    </span>
</div>
<div class="px-4 space-y-4 mt-1">
<div class="border-[2.5px] border-outline bg-surface-container-low p-4 shadow-brutal relative">
<div class="flex items-center justify-between mb-2">
<span class="font-label text-xs tracking-wider uppercase font-bold text-on-surface bg-primary-container px-2 py-0.5 border border-outline">Summary</span>
<span class="font-label text-xs font-bold flex items-center gap-1 text-on-surface-variant">
<span class="material-symbols-outlined text-[15px]">history</span> 2s ago
</span>
</div>
<blockquote class="font-body text-sm font-semibold italic relative pl-3 my-3 text-on-surface border-l-[3.5px] border-secondary">
  “Submit the DBMS assignment through the college portal before 20 September at 5:00 PM.”
</blockquote>
<div class="flex flex-wrap gap-2 mt-4 pt-1">
<div class="flex items-center gap-1.5 px-2.5 py-1 border-2 border-outline bg-surface-container-lowest text-on-surface font-label text-xs font-bold shadow-brutal-sm">
<span class="material-symbols-outlined text-[16px] text-tertiary font-bold">task_alt</span>
<span>1 Task Found</span>
</div>
<div class="flex items-center gap-1.5 px-2.5 py-1 border-2 border-outline bg-surface-container-lowest text-on-surface font-label text-xs font-bold shadow-brutal-sm">
<span class="material-symbols-outlined text-[16px] text-secondary font-bold">event</span>
<span>1 Deadline</span>
</div>
<div class="flex items-center gap-1.5 px-2.5 py-1 border-2 border-outline bg-surface-container-lowest text-on-surface font-label text-xs font-bold shadow-brutal-sm">
<span class="material-symbols-outlined text-[16px] text-primary-fixed-dim font-bold">bolt</span>
<span>1 Required Action</span>
</div>
</div>
</div>
<div class="border-[2.5px] border-outline bg-surface-container-lowest p-4 space-y-4 relative shadow-brutal">
<div class="flex items-start justify-between gap-2">
<div class="flex flex-wrap items-center gap-2">
<div class="inline-flex items-center gap-1 px-2.5 py-1 border-2 border-outline bg-primary-container font-label text-xs font-extrabold uppercase text-on-surface shadow-brutal-sm">
<span class="material-symbols-outlined text-[15px] font-bold">magic_button</span>
<span>AI Suggested Task</span>
</div>
<div class="inline-flex items-center gap-1.5 px-2.5 py-1 border-2 border-outline bg-surface-container font-label text-xs font-bold text-on-surface shadow-brutal-sm">
<span class="w-2 h-2 bg-secondary border border-outline"></span>
<span>High Confidence (98%)</span>
</div>
</div>
<button aria-label="Inspect raw excerpt" class="border-2 border-outline bg-surface-container-low hover:bg-surface-container w-7 h-7 flex items-center justify-center text-on-surface active:shadow-none transition-colors" type="button">
<span class="material-symbols-outlined text-[16px] font-bold">info</span>
</button>
</div>
<div>
<h3 class="font-headline text-lg font-extrabold uppercase tracking-tight text-on-surface">DBMS Assignment</h3>
<p class="font-body text-sm font-medium mt-1 text-on-surface-variant">Complete and upload the DBMS assignment PDF to the portal.</p>
</div>
<div class="space-y-2.5 pt-1">
<button class="w-full h-12 border-[2.5px] border-outline bg-primary-container text-on-surface font-label text-sm uppercase tracking-wider font-extrabold flex items-center justify-center gap-2 shadow-brutal active:translate-x-[2px] active:translate-y-[2px] active:shadow-none transition-all" id="confirmTaskBtn" type="button">
<span class="material-symbols-outlined text-[20px] font-bold">check</span>
<span>Add Task</span>
</button>
<div class="grid grid-cols-2 gap-2.5">
<button class="h-11 border-[2.5px] border-outline bg-surface-container-lowest text-on-surface font-label text-sm uppercase font-bold flex items-center justify-center gap-1.5 shadow-brutal active:translate-x-[2px] active:translate-y-[2px] active:shadow-none transition-all hover:bg-surface-container-low" id="editTaskBtn" type="button">
<span class="material-symbols-outlined text-[18px] text-on-surface font-bold">edit</span>
<span>Edit Details</span>
</button>
<button class="h-11 border-[2.5px] border-outline bg-secondary text-on-primary font-label text-sm uppercase font-bold flex items-center justify-center gap-1.5 shadow-brutal active:translate-x-[2px] active:translate-y-[2px] active:shadow-none transition-all hover:opacity-95" id="rejectTaskBtn" type="button">
<span class="material-symbols-outlined text-[18px] font-bold">close</span>
<span>Reject</span>
</button>
</div>
</div>
<div class="p-3 border-2 border-outline bg-surface-container flex items-start gap-2.5">
<span class="material-symbols-outlined text-[20px] shrink-0 text-on-surface mt-0.5 font-bold">shield</span>
<p class="font-body text-xs text-on-surface font-medium leading-normal">
  Review before saving. AI will never add tasks to your schedule without your explicit confirmation.
</p>
</div>
</div>
<div class="hidden p-3 border-2 border-outline bg-inverse-surface text-inverse-on-surface flex items-center justify-between shadow-brutal transition-opacity duration-200 opacity-0" id="feedbackToast">
<div class="flex items-center gap-2">
<span class="material-symbols-outlined text-primary-container text-[20px] font-bold">check_circle</span>
<span class="font-label text-xs uppercase font-bold tracking-wide" id="toastMessage">Task saved to local schedule</span>
</div>
<button class="text-inverse-on-surface hover:text-primary-container p-1" onclick="document.getElementById('feedbackToast').classList.add('hidden')" type="button">
<span class="material-symbols-outlined text-[18px] font-bold">close</span>
</button>
</div>
</div>
</div>
<script>
  (function() {
    const confirmBtn = document.getElementById('confirmTaskBtn');
    const editBtn = document.getElementById('editTaskBtn');
    const rejectBtn = document.getElementById('rejectTaskBtn');
    const toast = document.getElementById('feedbackToast');
    const toastMsg = document.getElementById('toastMessage');

    function showFeedback(text, isDestructive) {
      if (!toast) return;
      toastMsg.textContent = text;
      toast.classList.remove('hidden');
      requestAnimationFrame(() => {
        toast.classList.remove('opacity-0');
        toast.classList.add('opacity-100');
      });
      setTimeout(() => {
        toast.classList.remove('opacity-100');
        toast.classList.add('opacity-0');
        setTimeout(() => toast.classList.add('hidden'), 200);
      }, 3200);
    }

    if (confirmBtn) {
      confirmBtn.addEventListener('click', () => {
        showFeedback('✨ Saved to your local tasks successfully!');
      });
    }

    if (editBtn) {
      editBtn.addEventListener('click', () => {
        showFeedback('Editing mode opened.');
      });
    }

    if (rejectBtn) {
      rejectBtn.addEventListener('click', () => {
        showFeedback('Suggestion dismissed.');
      });
    }
  })();
</script></main><nav class="fixed bottom-0 w-full z-50 pb-safe bg-surface border-t-[2.5px] border-outline">
<div class="flex items-center justify-around h-16 px-2">
<a class="flex flex-col items-center justify-center min-w-[44px] min-h-[44px] w-14 py-1 text-on-surface-variant hover:text-on-surface transition-colors" data-path="dashboard" href="#">
<span class="material-symbols-outlined text-[23px]">dashboard</span>
<span class="font-label text-[11px] uppercase font-bold mt-0.5 tracking-wider">Home</span>
</a>
<a class="flex flex-col items-center justify-center min-w-[44px] min-h-[44px] w-14 py-1 text-on-surface-variant hover:text-on-surface transition-colors" data-path="task-list" href="#">
<span class="material-symbols-outlined text-[23px]">checklist</span>
<span class="font-label text-[11px] uppercase font-bold mt-0.5 tracking-wider">Tasks</span>
</a>
<a aria-current="page" class="flex flex-col items-center justify-center min-w-[48px] min-h-[48px] -translate-y-1.5 transition-transform font-bold" data-path="ai-inbox" href="#">
<div class="w-11 h-11 border-2 border-outline bg-primary-container text-on-surface shadow-brutal-sm flex items-center justify-center">
<span class="material-symbols-outlined text-[22px] font-bold">auto_awesome</span>
</div>
<span class="font-label text-[10px] uppercase font-extrabold mt-1 tracking-wider text-on-surface">AI Inbox</span>
</a>
<a class="flex flex-col items-center justify-center min-w-[44px] min-h-[44px] w-14 py-1 text-on-surface-variant hover:text-on-surface transition-colors" data-path="completed-tasks" href="#">
<span class="material-symbols-outlined text-[23px]">check_circle</span>
<span class="font-label text-[11px] uppercase font-bold mt-0.5 tracking-wider">Done</span>
</a>
<a class="flex flex-col items-center justify-center min-w-[44px] min-h-[44px] w-14 py-1 text-on-surface-variant hover:text-on-surface transition-colors" data-path="app-settings" href="#">
<span class="material-symbols-outlined text-[23px]">tune</span>
<span class="font-label text-[11px] uppercase font-bold mt-0.5 tracking-wider">Settings</span>
</a>
</div>
</nav>
</body></html>

<!-- AI Inbox (Bauhaus) -->
<!DOCTYPE html>

<html lang="en"><head><meta charset="utf-8"/><meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no, viewport-fit=cover" name="viewport"/><link href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" rel="stylesheet"/><link href="https://fonts.googleapis.com" rel="preconnect"/><link crossorigin="" href="https://fonts.gstatic.com" rel="preconnect"/><link href="https://fonts.googleapis.com/css2?family=Space+Grotesk:wght@400;500;600;700&amp;family=Inter:wght@400;500;600&amp;display=swap" rel="stylesheet"/>
<link href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:wght,FILL@100..700,0..1&amp;display=swap" rel="stylesheet"/><style>@layer base{html,body{width:100vw;margin:0;padding:0;background-color:#f5f0e8;}body{overscroll-behavior:none;}.pb-safe{padding-bottom:env(safe-area-inset-bottom,0px);}.pt-safe{padding-top:env(safe-area-inset-top,0px);}main>:first-child{margin-top:0!important;}main>:last-child{margin-bottom:0!important;}}::-webkit-scrollbar{display:none;}</style><script src="https://cdn.tailwindcss.com?plugins=forms,container-queries"></script><script id="tailwind-config">
  tailwind.config = {
    darkMode: "class",
    theme: {
      extend: {
        "colors": {
          "on-primary-container": "#1a1a1a",
          "tertiary-container": "#d6e3ff",
          "on-primary-fixed": "#1a1a1a",
          "primary-fixed-dim": "#e6b800",
          "outline-variant": "#d0cbc3",
          "surface-container-high": "#e8e3da",
          "secondary": "#e63b2e",
          "surface-container-lowest": "#ffffff",
          "primary-container": "#ffcc00",
          "outline": "#1a1a1a",
          "on-surface": "#1a1a1a",
          "surface-container-low": "#f2ede5",
          "on-primary": "#ffffff",
          "surface-dim": "#d6d1c9",
          "error": "#cc0000",
          "on-error": "#ffffff",
          "on-tertiary-container": "#1a1a1a",
          "tertiary-fixed": "#d6e3ff",
          "on-tertiary-fixed-variant": "#1a1a1a",
          "inverse-primary": "#f5f0e8",
          "secondary-fixed": "#ffdad6",
          "primary": "#1a1a1a",
          "on-surface-variant": "#4a4a4a",
          "secondary-container": "#ffdad6",
          "background": "#f5f0e8",
          "on-error-container": "#93000a",
          "tertiary": "#0055ff",
          "on-primary-fixed-variant": "#1a1a1a",
          "on-secondary-fixed": "#1a1a1a",
          "surface-bright": "#faf7f2",
          "on-secondary": "#1a1a1a",
          "on-tertiary": "#ffffff",
          "inverse-on-surface": "#f5f0e8",
          "surface-variant": "#e8e3da",
          "surface-container-highest": "#e2ddd4",
          "surface-container": "#eee9e0",
          "tertiary-fixed-dim": "#a8c6ff",
          "on-secondary-fixed-variant": "#1a1a1a",
          "secondary-fixed-dim": "#ffb3ab",
          "surface": "#f5f0e8",
          "inverse-surface": "#1a1a1a",
          "on-background": "#1a1a1a",
          "primary-fixed": "#ffcc00",
          "error-container": "#ffdad6",
          "on-secondary-container": "#1a1a1a",
          "on-tertiary-fixed": "#1a1a1a",
          "surface-tint": "#1a1a1a"
        },
        "borderRadius": {
          "DEFAULT": "0.125rem",
          "lg": "0.25rem",
          "xl": "0.5rem",
          "full": "0.75rem"
        },
        "spacing": {},
        "fontFamily": {
          "headline": ["Space Grotesk", "sans-serif"],
          "display": ["Space Grotesk", "sans-serif"],
          "body": ["Inter", "sans-serif"],
          "label": ["Space Grotesk", "sans-serif"]
        }
      },
    },
  }
</script><style>
    body {
      min-height: max(884px, 100dvh);
      font-family: 'Space Grotesk', sans-serif;
    }
    .neo-shadow {
      box-shadow: 4px 4px 0px #1a1a1a;
    }
    .neo-shadow-sm {
      box-shadow: 2px 2px 0px #1a1a1a;
    }
    .neo-border {
      border: 2px solid #1a1a1a;
    }
    .neo-border-3 {
      border: 3px solid #1a1a1a;
    }
  </style>
</head><body class="bg-surface font-headline text-on-surface flex flex-col min-h-screen"><header class="fixed top-0 w-full z-50 bg-surface neo-border border-t-0 border-x-0 border-b-2 bg-[#f5f0e8]"><div class="w-full h-7 px-4 pt-1 flex items-center justify-between text-on-surface select-none border-b border-outline/20"><span class="font-headline text-xs text-on-surface font-bold tracking-tight">9:41</span><div class="flex items-center gap-1 text-on-surface"><span class="material-symbols-outlined text-[16px]">signal_cellular_alt</span><span class="material-symbols-outlined text-[16px]">wifi</span><span class="material-symbols-outlined text-[16px]">battery_full</span></div></div><div class="h-14 px-4 flex items-center justify-between"><div class="flex items-center gap-2"><div class="w-9 h-9 bg-primary-container neo-border neo-shadow-sm flex items-center justify-center"><span class="material-symbols-outlined text-primary text-[22px] font-bold">auto_awesome</span></div><h1 class="font-headline text-xl text-on-surface font-bold tracking-tight uppercase">Ai Inbox</h1></div><div class="flex items-center gap-2"><button aria-label="Notifications" class="w-9 h-9 neo-border bg-surface-container-lowest neo-shadow-sm flex items-center justify-center text-on-surface hover:bg-primary-container transition-all active:translate-x-0.5 active:translate-y-0.5"><span class="material-symbols-outlined text-[20px]">notifications</span></button><div class="w-9 h-9 bg-primary text-on-primary neo-border neo-shadow-sm flex items-center justify-center font-bold"><span class="material-symbols-outlined text-[20px]">person</span></div></div></div></header><main class="flex flex-col relative w-full pt-20 bg-surface pb-28 min-h-screen"><div class="flex flex-col w-full px-4 space-y-4">
<!-- Interactive Status Scrim Overlay for AI Synthesis Simulation -->
<div class="fixed inset-0 z-50 bg-black/60 hidden items-center justify-center p-4 transition-opacity duration-300" id="ai-processing-modal">
<div class="w-full max-w-sm bg-[#faf7f2] neo-border-3 neo-shadow p-6 flex flex-col items-center text-center space-y-4">
<div class="relative w-16 h-16 flex items-center justify-center">
<div class="w-14 h-14 bg-primary-container neo-border neo-shadow-sm flex items-center justify-center text-primary">
<span class="material-symbols-outlined text-[32px] animate-spin">cyclone</span>
</div>
</div>
<div class="space-y-1">
<h3 class="font-headline text-lg font-bold text-on-surface uppercase">Distilling Raw Content</h3>
<p class="font-body text-xs text-on-surface-variant font-medium">Extracting actionable deadlines, subject references, and subtasks...</p>
</div>
<div class="w-full bg-surface-container neo-border h-3 overflow-hidden">
<div class="bg-secondary h-full transition-all duration-700 w-3/4"></div>
</div>
<button class="px-4 py-2 neo-border bg-surface neo-shadow-sm text-primary font-headline text-xs uppercase font-bold hover:bg-primary-container transition-all active:translate-x-0.5 active:translate-y-0.5" onclick="dismissProcessor()">
        Cancel Process
      </button>
</div>
</div>
<!-- Screen Header Sub-Context -->
<div class="flex items-center justify-between pt-1">
<div class="space-y-0.5">
<div class="flex items-center gap-1.5">
<h2 class="font-headline text-xl text-on-surface font-extrabold uppercase tracking-tight">AI Ingestion Hub</h2>
<span class="material-symbols-outlined text-secondary text-[22px]" style="font-variation-settings: 'FILL' 1;">auto_awesome</span>
</div>
<p class="font-body text-xs text-on-surface-variant font-medium">Drop anything here. I'll structure it.</p>
</div>
<button class="flex items-center gap-1.5 px-3 py-1.5 neo-border neo-shadow-sm bg-surface-container-lowest text-on-surface hover:bg-primary-container transition-all active:translate-x-0.5 active:translate-y-0.5">
<span class="material-symbols-outlined text-[18px]">history</span>
<span class="font-headline text-xs font-bold uppercase tracking-wider">History</span>
</button>
</div>
<!-- Central Ingestion Hero Canvas -->
<div class="relative overflow-hidden neo-border-3 neo-shadow bg-surface-container-lowest p-5 flex flex-col items-center text-center space-y-4">
<div class="absolute top-2 right-2 px-2 py-0.5 bg-primary-container neo-border text-[10px] font-headline font-bold uppercase tracking-widest">
  RAW INTAKE
</div>
<div class="relative w-20 h-20 flex items-center justify-center neo-border-3 bg-[#faf7f2] neo-shadow-sm">
<div class="w-12 h-12 bg-secondary neo-border flex items-center justify-center text-white">
<span class="material-symbols-outlined text-[28px]" style="font-variation-settings: 'FILL' 1;">neurology</span>
</div>
<div class="absolute -top-2 -right-2 w-6 h-6 bg-primary-container neo-border flex items-center justify-center shadow">
<span class="material-symbols-outlined text-[16px] text-on-surface font-bold">bolt</span>
</div>
</div>
<div class="max-w-xs space-y-1.5">
<h3 class="font-headline text-lg font-bold uppercase tracking-tight text-on-surface">Paste, capture, or drop files</h3>
<p class="font-body text-xs text-on-surface-variant leading-relaxed">Turn unstructured circulars, dense syllabi, meeting transcripts, or whiteboard photos into prioritized schedules.</p>
</div>
<div class="w-full py-3 px-4 neo-border-3 neo-shadow-sm bg-primary-container hover:bg-[#ffe033] cursor-pointer transition-all flex items-center justify-center gap-2 active:translate-x-0.5 active:translate-y-0.5" onclick="simulateIngest('Pasted Clipboard Text')">
<span class="material-symbols-outlined text-[22px] text-primary">content_paste_go</span>
<span class="font-headline text-sm font-bold uppercase tracking-wide text-primary">Analyze Current Clipboard</span>
<span class="px-2 py-0.5 neo-border bg-primary text-white font-headline text-[10px] font-bold uppercase tracking-wider ml-1">Auto-Detect</span>
</div>
</div>
<!-- Primary Ingestion Modalities Grid -->
<div class="grid grid-cols-3 gap-2.5">
<button class="flex flex-col items-center text-center p-3 neo-border-3 neo-shadow-sm bg-surface-container-lowest hover:bg-surface-container transition-all active:translate-x-0.5 active:translate-y-0.5 space-y-1.5" onclick="simulateIngest('Raw Text Snippet')">
<div class="w-11 h-11 neo-border bg-tertiary-container text-tertiary flex items-center justify-center">
<span class="material-symbols-outlined text-[22px]">content_paste</span>
</div>
<span class="font-headline text-xs font-bold uppercase tracking-tight text-on-surface">Paste Text</span>
<span class="font-body text-[11px] text-on-surface-variant leading-tight">Notice, chat or syllabus</span>
</button>
<button class="flex flex-col items-center text-center p-3 neo-border-3 neo-shadow-sm bg-surface-container-lowest hover:bg-surface-container transition-all active:translate-x-0.5 active:translate-y-0.5 space-y-1.5" onclick="simulateIngest('Screenshot Document')">
<div class="w-11 h-11 neo-border bg-primary-container text-primary flex items-center justify-center">
<span class="material-symbols-outlined text-[22px]">photo_camera_back</span>
</div>
<span class="font-headline text-xs font-bold uppercase tracking-tight text-on-surface">Image</span>
<span class="font-body text-[11px] text-on-surface-variant leading-tight">Screenshot or snap photo</span>
</button>
<button class="flex flex-col items-center text-center p-3 neo-border-3 neo-shadow-sm bg-surface-container-lowest hover:bg-surface-container transition-all active:translate-x-0.5 active:translate-y-0.5 space-y-1.5" onclick="simulateIngest('PDF Circular File')">
<div class="w-11 h-11 neo-border bg-secondary-container text-secondary flex items-center justify-center">
<span class="material-symbols-outlined text-[22px]">picture_as_pdf</span>
</div>
<span class="font-headline text-xs font-bold uppercase tracking-tight text-on-surface">PDF Doc</span>
<span class="font-body text-[11px] text-on-surface-variant leading-tight">Circular, brief or deck</span>
</button>
</div>
<!-- Native Integration & Share Sheet Spotlight -->
<div class="neo-border-3 neo-shadow bg-surface-container-lowest p-4 flex items-start gap-3 relative overflow-hidden">
<div class="w-11 h-11 min-w-[44px] neo-border bg-tertiary text-white flex items-center justify-center">
<span class="material-symbols-outlined text-[24px]">share</span>
</div>
<div class="flex flex-col space-y-1 pr-1">
<div class="flex items-center gap-1.5">
<h4 class="font-headline text-sm font-bold uppercase tracking-wide text-on-surface">Share from other apps</h4>
<span class="material-symbols-outlined text-[16px] text-secondary font-bold">verified</span>
</div>
<p class="font-body text-xs text-on-surface-variant leading-relaxed">Forward directly from WhatsApp, Gallery, Chrome, or Slack to "AI Inbox" via your Android share sheet—zero manual copying required.</p>
<div class="flex items-center gap-2 pt-1">
<span class="inline-flex items-center gap-1 font-headline text-xs font-bold uppercase tracking-wider text-tertiary cursor-pointer hover:underline">
<span class="material-symbols-outlined text-[15px]">tune</span> Configure Handlers
</span>
</div>
</div>
</div>
<!-- Smart Ingestion Playground Preview / Mock Carousel -->
<div class="space-y-2">
<div class="flex items-center justify-between">
<span class="font-headline text-xs text-on-surface font-extrabold uppercase tracking-widest">Example Sources</span>
<span class="font-headline text-[11px] text-on-surface-variant uppercase font-semibold">Tap to inspect schema</span>
</div>
<div class="grid grid-cols-2 gap-2.5">
<div class="neo-border-3 neo-shadow-sm bg-surface-container-lowest p-2 space-y-2 overflow-hidden">
<div class="w-full h-24 neo-border overflow-hidden relative bg-surface-container">
<img class="w-full h-full object-cover grayscale contrast-125" data-alt="A macro studio shot of a printed academic examination schedule paper with yellow highlighter marks, neat modern corporate aesthetic, cool high contrast lighting, lavender desk surface" src="https://lh3.googleusercontent.com/aida-public/AB6AXuB9pyUPoZL6eGpHcrONKvGFEyL3V8IFhem15rMktlwh47yNMJQ_Hd83iAwy_rLieHQqwXciVt3M89Aia26dolxQekhB6Elm_pycRnbbmgrFgNjyl0nBJzJsSPD3yxAVZ-stj0VMfzNG7bE6ZN1HwCs2lwRSASoTWcD8AAid2ja4hA1Ge8ShLqN_Nbc_ft8634NuX-BDGZqKFcA2bAe3tOOsjy8PglgweU7dCTBRHQt1y553Ln7aq-oL"/>
<div class="absolute bottom-1 right-1 px-1.5 py-0.5 neo-border bg-primary-container text-on-primary-container font-headline text-[10px] font-bold">
Exam_Deck.pdf
</div>
</div>
<div class="flex items-center justify-between pt-0.5">
<span class="font-headline text-xs font-bold text-on-surface uppercase">Term Exam Notice</span>
<span class="material-symbols-outlined text-[18px] text-tertiary font-bold">check_circle</span>
</div>
</div>
<div class="neo-border-3 neo-shadow-sm bg-surface-container-lowest p-2 space-y-2 overflow-hidden">
<div class="w-full h-24 neo-border overflow-hidden relative bg-surface-container">
<img class="w-full h-full object-cover grayscale contrast-125" data-alt="A smartphone screenshot preview of a clean group messaging thread with bullet points and project deadlines, modern slate and indigo interface accents" src="https://lh3.googleusercontent.com/aida-public/AB6AXuBqAWjBl6Yh0J2p8-my4Q_xzLKA0xVrhj4IfGu_kWrc-k_GL6qHjGWj3mk_queTAqOZ0GqcUnfOn3CyWK2tuws5VK0D2vjscAk_seRnwfjM553g96Ks_-QNubXomcJUC8ffosnRyDzMBkp4zx1VufU3XXcbJxRtwk8jAzrHpjkkGRzRNNW5-nRcAcE7sK3yyK795psW9w19oNC3BY8HJRVVMQwsMjeltFIwssvfuAowOjkYe7CSDEfZ"/>
<div class="absolute bottom-1 right-1 px-1.5 py-0.5 neo-border bg-primary-container text-on-primary-container font-headline text-[10px] font-bold">
IMG_8492.png
</div>
</div>
<div class="flex items-center justify-between pt-0.5">
<span class="font-headline text-xs font-bold text-on-surface uppercase">Chat Milestones</span>
<span class="material-symbols-outlined text-[18px] text-secondary font-bold">arrow_back_ios_new</span>
</div>
</div>
</div>
</div>
<!-- Recent Ingestions / Analysis Feed -->
<div class="space-y-2 pt-1">
<div class="flex items-center justify-between">
<h3 class="font-headline text-sm font-extrabold uppercase tracking-wide text-on-surface">Recently Analyzed Sources</h3>
<span class="font-headline text-xs font-bold uppercase tracking-wider text-tertiary cursor-pointer hover:underline">View All</span>
</div>
<div class="space-y-2">
<div class="p-3 neo-border-3 neo-shadow-sm bg-surface-container-lowest flex items-center justify-between">
<div class="flex items-center gap-3 min-w-0">
<div class="w-10 h-10 min-w-[40px] neo-border bg-secondary text-white flex items-center justify-center font-bold">
<span class="material-symbols-outlined text-[20px]">description</span>
</div>
<div class="flex flex-col min-w-0">
<span class="font-headline text-xs font-bold truncate text-on-surface uppercase tracking-tight">College Notice.pdf</span>
<div class="flex items-center gap-1.5 font-body text-[11px] text-on-surface-variant">
<span>Analyzed 2h ago</span>
<span>•</span>
<span class="font-bold text-on-surface">2 tasks created</span>
</div>
</div>
</div>
<div class="flex items-center gap-1.5 pl-2">
<span class="px-2 py-0.5 neo-border bg-primary-container font-headline text-[10px] font-bold uppercase">Review</span>
<button class="w-7 h-7 neo-border bg-surface-container flex items-center justify-center text-on-surface">
<span class="material-symbols-outlined text-[18px]">chevron_right</span>
</button>
</div>
</div>
<div class="p-3 neo-border-3 neo-shadow-sm bg-surface-container-lowest flex items-center justify-between">
<div class="flex items-center gap-3 min-w-0">
<div class="w-10 h-10 min-w-[40px] neo-border bg-primary-container text-on-primary-container flex items-center justify-center font-bold">
<span class="material-symbols-outlined text-[20px]">image</span>
</div>
<div class="flex flex-col min-w-0">
<span class="font-headline text-xs font-bold truncate text-on-surface uppercase tracking-tight">Screenshot_20250918.png</span>
<div class="flex items-center gap-1.5 font-body text-[11px] text-on-surface-variant">
<span>Analyzed Yesterday</span>
<span>•</span>
<span class="font-bold text-on-surface">1 task created</span>
</div>
</div>
</div>
<div class="flex items-center gap-1.5 pl-2">
<span class="px-2 py-0.5 neo-border bg-surface-container font-headline text-[10px] font-bold uppercase text-on-surface">Archived</span>
<button class="w-7 h-7 neo-border bg-surface-container flex items-center justify-center text-on-surface">
<span class="material-symbols-outlined text-[18px]">chevron_right</span>
</button>
</div>
</div>
<div class="p-3 neo-border-3 neo-shadow-sm bg-surface-container-lowest flex items-center justify-between">
<div class="flex items-center gap-3 min-w-0">
<div class="w-10 h-10 min-w-[40px] neo-border bg-tertiary text-white flex items-center justify-center font-bold">
<span class="material-symbols-outlined text-[20px]">notes</span>
</div>
<div class="flex flex-col min-w-0">
<span class="font-headline text-xs font-bold truncate text-on-surface uppercase tracking-tight">Sprint_Briefing_Raw.txt</span>
<div class="flex items-center gap-1.5 font-body text-[11px] text-on-surface-variant">
<span>Analyzed Sep 16</span>
<span>•</span>
<span class="font-bold text-on-surface">4 tasks created</span>
</div>
</div>
</div>
<div class="flex items-center gap-1.5 pl-2">
<span class="px-2 py-0.5 neo-border bg-surface-container font-headline text-[10px] font-bold uppercase text-on-surface">Synced</span>
<button class="w-7 h-7 neo-border bg-surface-container flex items-center justify-center text-on-surface">
<span class="material-symbols-outlined text-[18px]">chevron_right</span>
</button>
</div>
</div>
</div>
</div>
<!-- AI Cognitive Tip Footer Banner -->
<div class="neo-border-3 neo-shadow bg-primary-container p-3 flex items-center gap-2.5 mb-6 text-on-primary-container">
<span class="material-symbols-outlined text-[22px] flex-shrink-0 text-primary font-bold">lightbulb</span>
<p class="font-body text-xs leading-snug">
<strong class="font-headline font-bold uppercase">Pro tip:</strong> Handwritten lecture notes and blurry photo whiteboards can also be transcribed with over 95% accuracy.
</p>
</div>
</div>
<script>
  function simulateIngest(sourceName) {
    const modal = document.getElementById('ai-processing-modal');
    if (modal) {
      modal.classList.remove('hidden');
      modal.classList.add('flex');
      setTimeout(() => {
        modal.classList.add('hidden');
        modal.classList.remove('flex');
      }, 2400);
    }
  }

  function dismissProcessor() {
    const modal = document.getElementById('ai-processing-modal');
    if (modal) {
      modal.classList.add('hidden');
      modal.classList.remove('flex');
    }
  }
</script></main><nav class="fixed bottom-0 w-full z-50 pb-safe bg-[#f5f0e8] neo-border border-b-0 border-x-0 border-t-2"><div class="flex items-center justify-around h-16 px-1">
<a class="flex flex-col items-center justify-center min-w-[44px] min-h-[44px] w-14 py-1 text-on-surface hover:text-primary transition-colors font-headline" data-path="dashboard" href="#">
<span class="material-symbols-outlined text-[22px]">dashboard</span>
<span class="text-[10px] uppercase font-bold mt-0.5 tracking-wider">Home</span>
</a>
<a class="flex flex-col items-center justify-center min-w-[44px] min-h-[44px] w-14 py-1 text-on-surface hover:text-primary transition-colors font-headline" data-path="task-list" href="#">
<span class="material-symbols-outlined text-[22px]">checklist</span>
<span class="text-[10px] uppercase font-bold mt-0.5 tracking-wider">Tasks</span>
</a>
<a aria-current="page" class="flex flex-col items-center justify-center min-w-[48px] min-h-[48px] font-headline" data-path="ai-inbox" href="#">
<div class="w-10 h-10 neo-border-3 neo-shadow-sm bg-primary-container text-on-surface flex items-center justify-center font-bold">
<span class="material-symbols-outlined text-[22px]" style="font-variation-settings: 'FILL' 1;">auto_awesome</span>
</div>
<span class="text-[10px] uppercase font-extrabold mt-0.5 tracking-wider text-primary">AI Inbox</span>
</a>
<a class="flex flex-col items-center justify-center min-w-[44px] min-h-[44px] w-14 py-1 text-on-surface hover:text-primary transition-colors font-headline" data-path="completed-tasks" href="#">
<span class="material-symbols-outlined text-[22px]">check_circle</span>
<span class="text-[10px] uppercase font-bold mt-0.5 tracking-wider">Done</span>
</a>
<a class="flex flex-col items-center justify-center min-w-[44px] min-h-[44px] w-14 py-1 text-on-surface hover:text-primary transition-colors font-headline" data-path="app-settings" href="#">
<span class="material-symbols-outlined text-[22px]">tune</span>
<span class="text-[10px] uppercase font-bold mt-0.5 tracking-wider">Settings</span>
</a>
</div>
</nav></body></html>