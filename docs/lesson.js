(function(){
  var KW = /^(public|private|class|static|void|package|new|final|return|true|false|this|null)$/;
  var TY = /^(int|double|boolean|String|char|long|float)$/;

  function esc(s){
    return s.replace(/[&<>]/g, function(ch){
      return ch === '&' ? '&amp;' : ch === '<' ? '&lt;' : '&gt;';
    });
  }

  var RE = /(\/\/[^\n]*)|("(?:\\.|[^"\\])*")|('(?:\\.|[^'\\])*')|(\b\d+(?:\.\d+)?\b)|([A-Za-z_$][A-Za-z0-9_$]*)/g;

  function highlight(src){
    var out = '', last = 0, m;
    RE.lastIndex = 0;
    while ((m = RE.exec(src)) !== null){
      out += esc(src.slice(last, m.index));
      var tok = m[0];
      if (m[1])            out += '<span class="c">' + esc(tok) + '</span>';
      else if (m[2] || m[3]) out += '<span class="s">' + esc(tok) + '</span>';
      else if (m[4])       out += '<span class="n">' + esc(tok) + '</span>';
      else if (KW.test(tok)) out += '<span class="k">' + tok + '</span>';
      else if (TY.test(tok)) out += '<span class="t">' + tok + '</span>';
      else                 out += esc(tok);
      last = m.index + tok.length;
    }
    return out + esc(src.slice(last));
  }

  var blocks = document.querySelectorAll('pre.code > code');
  for (var i = 0; i < blocks.length; i++){
    blocks[i].innerHTML = highlight(blocks[i].textContent);
  }

  // highlight the contents entry for whatever section is on screen
  var links = {};
  var anchors = document.querySelectorAll('nav.toc a');
  for (var j = 0; j < anchors.length; j++){
    links[anchors[j].getAttribute('href').slice(1)] = anchors[j];
  }

  var targets = document.querySelectorAll('section[id], h3[id]');
  if ('IntersectionObserver' in window){
    var seen = {};
    var obs = new IntersectionObserver(function(entries){
      for (var k = 0; k < entries.length; k++){
        seen[entries[k].target.id] = entries[k].isIntersecting;
      }
      var current = null;
      for (var m2 = 0; m2 < targets.length; m2++){
        if (seen[targets[m2].id]) { current = targets[m2].id; break; }
      }
      for (var id in links) links[id].classList.remove('on');
      if (current && links[current]) links[current].classList.add('on');
    }, { rootMargin: '-10% 0px -70% 0px' });
    for (var n = 0; n < targets.length; n++) obs.observe(targets[n]);
  }
})();

// ---------- Lesson 6: letter strips, compare figures and the String lab ----------
(function(){
  function el(tag, cls, text){
    var e = document.createElement(tag);
    if (cls) e.className = cls;
    if (text !== undefined) e.textContent = text;
    return e;
  }

  // o: {edges, from, to, marks:[i..], mlen, diff, ghost}
  function strip(word, o){
    o = o || {};
    var s = el('div', 'strip' + (o.edges ? ' edges' : ''));
    var n = Math.max(word.length, o.ghost || 0);
    for (var i = 0; i < n; i++){
      var ch = i < word.length ? word.charAt(i) : '';
      var c = el('div', 'cell', ch === ' ' ? '␣' : ch === '\n' ? '↵' : ch === '\t' ? '⇥' : ch);
      if (ch === ' ' || ch === '\n' || ch === '\t') c.classList.add('sp');
      if (i >= word.length) c.classList.add('ghost');
      if (o.from !== undefined && i >= o.from && i < o.to) c.classList.add('in');
      if (o.marks){
        for (var m = 0; m < o.marks.length; m++){
          if (i >= o.marks[m] && i < o.marks[m] + (o.mlen || 1)) c.classList.add('hit');
        }
      }
      if (o.diff === i) c.classList.add('diff');
      if (o.bad && o.bad.indexOf(i) !== -1) c.classList.add('diff');
      if (i < word.length){
        var ix = el('span', 'ix', String(i));
        if (o.edges && (i === o.from || i === o.to)) ix.classList.add('on');
        if (!o.edges && o.from !== undefined && i >= o.from && i < o.to) ix.classList.add('on');
        c.appendChild(ix);
        if (o.edges && i === word.length - 1){
          var end = el('span', 'ix end', String(word.length));
          if (o.from === word.length || o.to === word.length) end.classList.add('on');
          c.appendChild(end);
        }
      }
      s.appendChild(c);
    }
    if (o.edges && o.from !== undefined){
      [o.from, o.to].forEach(function(k){
        var f = el('span', 'fence');
        f.style.setProperty('--k', k);
        s.appendChild(f);
      });
    }
    return s;
  }

  function num(v){ return v === undefined || v === '' ? undefined : parseInt(v, 10); }

  var strips = document.querySelectorAll('.strip-wrap[data-word]');
  for (var i = 0; i < strips.length; i++){
    var d = strips[i].dataset, cap = strips[i].querySelector('.strip-cap');
    strips[i].textContent = '';
    strips[i].appendChild(strip(d.word, {
      edges: d.edges !== undefined,
      from: num(d.from), to: num(d.to),
      marks: d.marks ? d.marks.split(',').map(Number) : null,
      mlen: num(d.mlen)
    }));
    if (cap) strips[i].appendChild(cap);
  }

  // Java's String.compareTo, step by step
  function compare(a, b){
    var n = Math.min(a.length, b.length);
    for (var i = 0; i < n; i++){
      if (a.charCodeAt(i) !== b.charCodeAt(i)) return { value: a.charCodeAt(i) - b.charCodeAt(i), at: i };
    }
    return { value: a.length - b.length, at: -1 };
  }

  function q(s){ return '"' + s.replace(/\\/g, '\\\\').replace(/"/g, '\\"') + '"'; }

  // what Java stores for the text typed between two quote marks
  function unescape(lit){
    var v = '';
    for (var i = 0; i < lit.length; i++){
      var ch = lit.charAt(i);
      if (ch === '"') return { error: 'will not compile — the " at index ' + i + ' ends the String early. Write \\" instead.' };
      if (ch !== '\\'){ v += ch; continue; }
      if (i + 1 >= lit.length) return { error: 'will not compile — unclosed string literal: the last \\ turns the closing " into a character.' };
      var nx = lit.charAt(++i);
      if (nx === 'n') v += '\n';
      else if (nx === 't') v += '\t';
      else if (nx === '"') v += '"';
      else if (nx === '\\') v += '\\';
      else if ('rbfs\'01234567u'.indexOf(nx) !== -1) return { error: 'Java knows \\' + nx + ', but it is not one of our four escapes: \\n \\t \\" \\\\' };
      else return { error: 'will not compile — illegal escape character: \\' + nx };
    }
    return { value: v };
  }
  function show(ch){ return ch === ' ' ? 'space' : "'" + ch + "'"; }

  function explain(a, b, r){
    if (r.at >= 0){
      var x = a.charAt(r.at), y = b.charAt(r.at);
      return 'First difference at index ' + r.at + ': ' + show(x) + ' is ' + x.charCodeAt(0) +
        ', ' + show(y) + ' is ' + y.charCodeAt(0) + '. ' + x.charCodeAt(0) + ' − ' + y.charCodeAt(0) + ' = ';
    }
    if (a.length === b.length) return 'Same length, no letter differs. The answer is ';
    return 'No letter differs until one word runs out, so Java subtracts the lengths: ' +
      a.length + ' − ' + b.length + ' = ';
  }

  function cmpFig(host, a, b){
    host.textContent = '';
    var r = compare(a, b), n = Math.max(a.length, b.length);
    var r1 = el('div', 'row'); r1.appendChild(el('span', 'who', q(a).length > 10 ? 'this' : q(a)));
    r1.appendChild(strip(a, { diff: r.at, ghost: n }));
    var r2 = el('div', 'row'); r2.appendChild(el('span', 'who', q(b).length > 10 ? 'other' : q(b)));
    r2.appendChild(strip(b, { diff: r.at, ghost: n }));
    host.appendChild(r1); host.appendChild(r2);
    var v = el('p', 'verdict', explain(a, b, r));
    v.appendChild(el('b', null, String(r.value)));
    host.appendChild(v);
    return r;
  }

  var figs = document.querySelectorAll('.cmpfig[data-a]');
  for (var f = 0; f < figs.length; f++) cmpFig(figs[f], figs[f].dataset.a, figs[f].dataset.b);

  // the lab
  var labs = document.querySelectorAll('.lab[data-mode]');
  for (var l = 0; l < labs.length; l++) (function(lab){
    var mode = lab.dataset.mode;
    var inputs = lab.querySelectorAll('input');
    var view = lab.querySelector('.lab-view');
    var code = lab.querySelector('.lab-code');
    var out = lab.querySelector('.lab-out');

    function val(id){ return lab.querySelector('[data-f="' + id + '"]'); }

    function render(){
      view.textContent = '';
      out.textContent = '';
      var word = val('word').value;
      if (mode === 'index'){
        var part = val('part').value;
        var at = word.indexOf(part);
        view.appendChild(strip(word, { marks: at >= 0 ? [at] : null, mlen: part.length }));
        code.textContent = 'String word = ' + q(word) + ';\nSystem.out.println(word.length());\nSystem.out.println(word.indexOf(' + q(part) + '));';
        out.textContent = word.length + '\n' + at;
      } else if (mode === 'sub'){
        var b = parseInt(val('from').value, 10);
        var two = val('two').checked;
        val('to').disabled = !two;
        var e = two ? parseInt(val('to').value, 10) : word.length;
        if (isNaN(b)) b = 0;
        if (isNaN(e)) e = word.length;
        var bad = b < 0 || e > word.length || b > e;
        var ok = !bad;
        view.appendChild(strip(word, ok ? { edges: true, from: b, to: e } : { edges: true }));
        code.textContent = 'String word = ' + q(word) + ';\nSystem.out.println(word.substring(' + b + (two ? ', ' + e : '') + '));';
        if (ok){
          out.textContent = word.slice(b, e);
          if (b === e) out.appendChild(el('span', 'bad', '(an empty line — the empty String "")'));
        } else {
          out.appendChild(el('span', 'bad', 'Exception in thread "main" java.lang.StringIndexOutOfBoundsException: Range [' + b + ', ' + e + ') out of bounds for length ' + word.length));
        }
      } else if (mode === 'esc'){
        var r = unescape(word);
        code.textContent = 'String s = "' + word + '";\nSystem.out.println(s);\nSystem.out.println(s.length());';
        if (r.error){
          out.appendChild(el('span', 'bad', r.error));
        } else {
          view.appendChild(strip(r.value));
          out.textContent = r.value + '\n' + r.value.length;
        }
      } else if (mode === 'pass'){
        var U = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', L = 'abcdefghijklmnopqrstuvwxyz', S = '!@#$%^&*';
        var cu = 0, cl = 0, cs = 0, ok = [], bad = [];
        for (var p = 0; p < word.length; p++){
          var ch = word.charAt(p);
          if (U.indexOf(ch) !== -1) cu++;
          if (L.indexOf(ch) !== -1) cl++;
          if (S.indexOf(ch) !== -1) cs++;
          if ((U + L + S).indexOf(ch) !== -1) ok.push(p); else bad.push(p);
        }
        var why = word.length < 6 ? 'too short (' + word.length + ' characters, need 6 to 12)'
          : word.length > 12 ? 'too long (' + word.length + ' characters, need 6 to 12)'
          : cu === 0 ? 'needs a capital letter'
          : cl === 0 ? 'needs a small letter'
          : cs === 0 ? 'needs a symbol from !@#$%^&*'
          : cu + cl + cs !== word.length ? 'counts add up to ' + (cu + cl + cs) + ', length is ' + word.length + ': something is in no group'
          : 'every rule holds';
        view.appendChild(strip(word, { marks: ok, mlen: 1, bad: bad }));
        view.appendChild(el('p', 'lab-why', 'countUpper = ' + cu + ' · countLower = ' + cl + ' · countSymbol = ' + cs + ' · length = ' + word.length + ' — ' + why));
        code.textContent = 'System.out.println(isValid(' + q(word) + '));';
        out.textContent = String(why === 'every rule holds');
      } else if (mode === 'cmp'){
        var other = val('other').value;
        var r = cmpFig(view, word, other);
        code.textContent = 'String a = ' + q(word) + ';\nString b = ' + q(other) + ';\nSystem.out.println(a.equals(b));\nSystem.out.println(a.compareTo(b));';
        out.textContent = (word === other) + '\n' + r.value;
      }
    }
    for (var k = 0; k < inputs.length; k++){
      inputs[k].addEventListener('input', render);
      inputs[k].addEventListener('change', render);
    }
    render();
  })(labs[l]);

  var codes = document.querySelectorAll('.codes[data-on]');
  for (var c = 0; c < codes.length; c++){
    var on = codes[c].dataset.on;
    var cells = codes[c].querySelectorAll('div');
    for (var z = 0; z < cells.length; z++){
      if (on.indexOf(cells[z].querySelector('b').textContent) !== -1) cells[z].classList.add('on');
    }
  }
})();

// ---------- Lesson 6: a window sliding along a word, one row per pass ----------
(function(){
  var hosts = document.querySelectorAll('.slides[data-word]');
  for (var h = 0; h < hosts.length; h++){
    var d = hosts[h].dataset, word = d.word, w = parseInt(d.w || '1', 10);
    var back = d.back !== undefined, want = d.want, over = d.over !== undefined;
    var last = over ? word.length - w + 1 : word.length - w;
    var idx = [];
    for (var i = 0; i <= last; i++) idx.push(i);
    if (back) idx.reverse();
    hosts[h].textContent = '';
    idx.forEach(function(i){
      var row = document.createElement('div'); row.className = 'row';
      var who = document.createElement('span'); who.className = 'who'; who.textContent = 'i = ' + i;
      var s = document.createElement('div'); s.className = 'strip';
      var n = Math.max(word.length, i + w);
      for (var k = 0; k < n; k++){
        var c = document.createElement('div');
        c.className = 'cell';
        var ch = k < word.length ? word.charAt(k) : '';
        c.textContent = ch === ' ' ? '␣' : ch;
        if (ch === ' ') c.classList.add('sp');
        if (k >= word.length) c.classList.add('ghost');
        if (k >= i && k < i + w) c.classList.add(want && word.substr(i, w) === want ? 'hit' : 'in');
        s.appendChild(c);
      }
      var got = document.createElement('span'); got.className = 'got';
      if (i + w > word.length){
        row.classList.add('boom');
        got.textContent = 'substring(' + i + ', ' + (i + w) + ') → exception';
      } else {
        var part = word.substr(i, w);
        got.textContent = 'substring(' + i + ', ' + (i + w) + ') → "' + part + '"';
        if (want && part === want){ var b = document.createElement('b'); b.textContent = '  count++'; got.appendChild(b); }
      }
      row.appendChild(who); row.appendChild(s); row.appendChild(got);
      hosts[h].appendChild(row);
    });
  }
})();

// ---------- Lesson 8: the inch grid, a Student object lab, a Height object lab ----------
(function(){
  function el(tag, cls, text){
    var e = document.createElement(tag);
    if (cls) e.className = cls;
    if (text !== undefined) e.textContent = text;
    return e;
  }
  // Java's int division and % (both round toward zero, like JS trunc and %)
  function idiv(a, b){ return Math.trunc(a / b); }
  function jd(x){ return Number.isInteger(x) ? x.toFixed(1) : String(x); }
  function q(s){ return '"' + s.replace(/\\/g, '\\\\').replace(/"/g, '\\"') + '"'; }

  // n inches drawn in rows of 12 — every full row is one foot
  function inchGrid(n){
    var g = el('div', 'inchgrid');
    if (n < 0 || n > 240){
      g.appendChild(el('div', 'sum', n + ' inches → ' + n + ' / 12 = ' + idiv(n, 12) + ' ft, ' + n + ' % 12 = ' + (n % 12) + ' inc.'));
      return g;
    }
    for (var r = 0; r * 12 < n; r++){
      var left = Math.min(12, n - r * 12);
      var row = el('div', 'ir' + (left === 12 ? ' full' : ''));
      var cells = el('div', 'cells');
      for (var k = 0; k < left; k++) cells.appendChild(el('span', 'i'));
      row.appendChild(cells);
      row.appendChild(el('span', 'lbl', left === 12 ? '12 inc. = 1 ft' : left + ' inc. left over'));
      g.appendChild(row);
    }
    g.appendChild(el('div', 'sum', n + ' inches → ' + n + ' / 12 = ' + idiv(n, 12) + ' ft, ' + n + ' % 12 = ' + (n % 12) + ' inc.'));
    return g;
  }
  var grids = document.querySelectorAll('.inchgrid-host[data-n]');
  for (var i = 0; i < grids.length; i++){
    var cap = grids[i].querySelector('.strip-cap');
    grids[i].insertBefore(inchGrid(parseInt(grids[i].dataset.n, 10)), grids[i].firstChild);
  }

  // one object card: rows = [[field, value, state]]
  function card(name, type, rows){
    var c = el('div', 'obj');
    var h = el('div', 'obj-h'); h.appendChild(el('b', null, name)); h.appendChild(el('span', null, type));
    c.appendChild(h);
    rows.forEach(function(r){
      var f = el('div', 'f' + (r[2] ? ' ' + r[2] : ''));
      f.appendChild(el('span', 'k', r[0]));
      f.appendChild(el('span', 'v' + (r[1] === 'null' ? ' nul' : ''), r[1]));
      c.appendChild(f);
    });
    return c;
  }

  var labs = document.querySelectorAll('.lab[data-mode="student"], .lab[data-mode="height"]');
  for (var l = 0; l < labs.length; l++) (function(lab){
    var mode = lab.dataset.mode;
    var view = lab.querySelector('.lab-view');
    var code = lab.querySelector('.lab-code');
    var out = lab.querySelector('.lab-out');
    var pick = lab.querySelector('[data-f="method"]');
    var arg = lab.querySelector('[data-f="arg"]');
    var s, lines, outs, mark, extra;

    function reset(){
      s = mode === 'student' ? { name: null, birthYear: 0, email: null, average: 0 } : { feet: 0, inches: 0 };
      lines = [mode === 'student' ? 'Student stu1 = new Student();' : 'Height h = new Height();'];
      outs = []; mark = {}; extra = null;
    }
    function say(t, bad){ outs.push({ t: t, bad: bad }); }

    function student(m, raw){
      var v = raw.trim();
      if (m === 'direct'){
        lines.push('stu1.birthYear = ' + v + ';');
        say('error: birthYear has private access in Student — nothing runs until this line is removed', true);
        mark = { birthYear: 'bad' };
        return;
      }
      if (m === 'print'){
        lines.push('stu1.printStudentInfos();');
        say('*****STUDENT INFOS=====');
        say("Student's name: " + s.name);
        say("Student's age: " + (2026 - s.birthYear));
        say("Student's mail: " + s.email);
        say("Student's average: " + jd(s.average));
        return;
      }
      if (m === 'setName' || m === 'setMail'){
        lines.push('stu1.' + m + '(' + q(raw) + ');');
        if (m === 'setName'){
          if (raw.length === 0){ say('Invalid name!'); mark = { name: 'bad' }; }
          else { s.name = raw; mark = { name: 'new' }; }
        } else {
          if (raw.length === 0 || raw.indexOf('@') <= 0){ say('Invalid mail!'); mark = { email: 'bad' }; }
          else { s.email = raw; mark = { email: 'new' }; }
        }
        return;
      }
      lines.push('stu1.' + m + '(' + v + ');');
      if (m === 'setYear'){
        if (!/^-?\d{1,9}$/.test(v)){ say('will not compile — setYear needs an int, like 2009', true); return; }
        var y = parseInt(v, 10);
        if (y > 1900 && y <= 2026){ s.birthYear = y; mark = { birthYear: 'new' }; }
        else { say('Invalid value!'); mark = { birthYear: 'bad' }; }
      } else {
        if (!/^-?\d{1,6}(\.\d{1,6})?$/.test(v)){ say('will not compile — setAvg needs a number, like 88.5', true); return; }
        var a = parseFloat(v);
        if (a < 0 || a > 100){ say('Invalid value!'); mark = { average: 'bad' }; }
        else { s.average = a; mark = { average: 'new' }; }
      }
    }

    function height(m, raw){
      var v = raw.trim();
      if (m === 'printHeight'){ lines.push('h.printHeight();'); say(s.feet + ' ft. ' + s.inches + ' inc.'); return; }
      lines.push('h.' + m + '(' + v + ');');
      if (!/^-?\d{1,4}$/.test(v)){ say('will not compile — ' + m + ' needs an int', true); return; }
      var n = parseInt(v, 10);
      if (m === 'setFeet'){
        if (n > 0){ s.feet = n; mark = { feet: 'new' }; } else mark = { feet: 'bad' };
        return;
      }
      var before = s.inches;
      if (m === 'setInches'){ if (n > 0) s.inches = n; else mark = { inches: 'bad' }; }
      else s.inches += n;
      // simplify()
      extra = s.inches;
      s.feet += idiv(s.inches, 12);
      s.inches = s.inches % 12;
      if (!(m === 'setInches' && n <= 0)) mark = { feet: 'new', inches: 'new' };
    }

    function render(){
      view.textContent = '';
      var row = el('div', 'objs');
      if (mode === 'student'){
        row.appendChild(card('stu1', 'Student', [
          ['name', s.name === null ? 'null' : q(s.name), mark.name],
          ['birthYear', String(s.birthYear), mark.birthYear],
          ['email', s.email === null ? 'null' : q(s.email), mark.email],
          ['average', jd(s.average), mark.average]
        ]));
      } else {
        row.appendChild(card('h', 'Height', [
          ['feet', String(s.feet), mark.feet],
          ['inches', String(s.inches), mark.inches]
        ]));
      }
      view.appendChild(row);
      if (mode === 'height' && extra !== null){
        view.appendChild(el('p', 'lab-why', 'simplify() saw inches = ' + extra + ':'));
        view.appendChild(inchGrid(extra));
      }
      code.textContent = lines.join('\n');
      out.textContent = '';
      outs.forEach(function(o){
        out.appendChild(o.bad ? el('span', 'bad', o.t) : document.createTextNode(o.t));
        out.appendChild(document.createTextNode('\n'));
      });
    }

    function run(m){
      mark = {}; extra = null;
      if (mode === 'student') student(m, arg.value); else height(m, arg.value);
      render();
    }

    lab.querySelector('[data-act="run"]').addEventListener('click', function(){ run(pick.value); });
    arg.addEventListener('keydown', function(e){ if (e.key === 'Enter'){ e.preventDefault(); run(pick.value); } });
    var more = lab.querySelectorAll('[data-act="call"]');
    for (var b = 0; b < more.length; b++) (function(btn){
      btn.addEventListener('click', function(){ run(btn.dataset.m); });
    })(more[b]);
    lab.querySelector('[data-act="reset"]').addEventListener('click', function(){ reset(); render(); });

    // open in a working state: the first lines of the class file
    reset();
    var seed = (lab.dataset.seed || '').split('|');
    for (var z = 0; z + 1 < seed.length; z += 2){
      mark = {}; extra = null;
      if (mode === 'student') student(seed[z], seed[z + 1]); else height(seed[z], seed[z + 1]);
    }
    render();
  })(labs[l]);
})();

/* ---------- Lesson 10: the reference lab (Lesson30 step by step) and the bank lab (static fields) ---------- */
(function(){
  function el(tag, cls, text){
    var e = document.createElement(tag);
    if (cls) e.className = cls;
    if (text !== undefined && text !== null) e.textContent = text;
    return e;
  }
  function jd(x){ return Number.isInteger(x) && Math.abs(x) < 1e7 ? x.toFixed(1) : String(x); }
  function card(name, type, rows, cls){
    var c = el('div', 'obj' + (cls ? ' ' + cls : ''));
    var h = el('div', 'obj-h'); h.appendChild(el('b', null, name)); h.appendChild(el('span', null, type));
    c.appendChild(h);
    rows.forEach(function(r){
      var f = el('div', 'f' + (r[2] ? ' ' + r[2] : ''));
      f.appendChild(el('span', 'k', r[0]));
      f.appendChild(el('span', 'v' + (r[1] === 'null' ? ' nul' : ''), r[1]));
      c.appendChild(f);
    });
    return c;
  }

  /* ----- reference lab: every line of Lesson30's main, one click at a time ----- */
  var STEPS = [
    { code: 'Height a = new Height(3,9);', note: 'new makes object #1. The variable a does not hold the object, it holds the way to it: an arrow to #1.' },
    { code: 'Height b = new Height(5,3);', note: 'A second object, #2, and a second arrow.' },
    { code: 'a.printHeight();\nb.printHeight();', note: 'Each arrow leads to a different object, so two different heights.' },
    { code: 'a = b ;', note: 'The arrow in b is copied into a. No Height is copied. #1 has no arrow left: nobody can ever reach it again.' },
    { code: 'a.printHeight();\nb.printHeight();', note: 'Two names, one object: both lines print #2.' },
    { code: 'b.add(2);', note: 'Changed through b ...' },
    { code: 'a.printHeight();\nb.printHeight();', note: '... and a sees it too, because there is only one object.' },
    { code: 'a.add(3);', note: 'Changed through a this time. Still the same object #2.' },
    { code: 'a.printHeight();\nb.printHeight();', note: 'Both 5 ft 8.' },
    { code: 'Height c = a ;', note: 'c gets a copy of the arrow in a. Three names for #2 now, and still no new object.' },
    { code: 'b.add(3);', note: 'One change, through b.' },
    { code: 'a.printHeight();\nb.printHeight();\nc.printHeight();', note: 'All three names print the same object.' },
    { code: 'a = new Height();', note: 'A brand-new object #3 (99 ft 11, the no-argument constructor). Only a moves; b and c still point at #2.' },
    { code: 'int x = 8 ;\nint y = 4 ;', note: 'Primitive variables: the number itself is in the box. No arrows.' },
    { code: 'x = y ;', note: 'The value 4 is copied into x.' },
    { code: 'y = 9 ;', note: 'y changes, x does not. Two boxes, two separate numbers.' }
  ];

  function refState(n){
    var s = { vars: {}, order: [], objs: {}, next: 1, out: [], moved: {}, changed: {} };
    function mk(f, i){ var id = s.next++; s.objs[id] = { f: f, i: i }; return id; }
    function setv(k, v){ if (s.order.indexOf(k) === -1) s.order.push(k); s.vars[k] = v; }
    function add(id, inc){ var o = s.objs[id]; o.i += inc; o.f += Math.floor(o.i / 12); o.i = o.i % 12; }
    function pr(k){ var o = s.objs[s.vars[k].ref]; s.out.push(o.f + ' ft. ' + o.i + ' inc.'); }
    for (var k = 0; k < n; k++){
      s.moved = {}; s.changed = {};
      switch (k){
        case 0: setv('a', { ref: mk(3, 9) }); s.moved.a = 1; break;
        case 1: setv('b', { ref: mk(5, 3) }); s.moved.b = 1; break;
        case 2: case 4: case 6: case 8: pr('a'); pr('b'); break;
        case 3: setv('a', { ref: s.vars.b.ref }); s.moved.a = 1; break;
        case 5: add(s.vars.b.ref, 2); s.changed[s.vars.b.ref] = 1; break;
        case 7: add(s.vars.a.ref, 3); s.changed[s.vars.a.ref] = 1; break;
        case 9: setv('c', { ref: s.vars.a.ref }); s.moved.c = 1; break;
        case 10: add(s.vars.b.ref, 3); s.changed[s.vars.b.ref] = 1; break;
        case 11: pr('a'); pr('b'); pr('c'); break;
        case 12: setv('a', { ref: mk(99, 11) }); s.moved.a = 1; break;
        case 13: setv('x', { val: 8 }); setv('y', { val: 4 }); s.moved.x = 1; s.moved.y = 1; break;
        case 14: s.vars.x = { val: s.vars.y.val }; s.moved.x = 1; break;
        case 15: s.vars.y = { val: 9 }; s.moved.y = 1; break;
      }
    }
    return s;
  }

  var rl = document.querySelectorAll('.lab[data-mode="refs"]');
  for (var r = 0; r < rl.length; r++) (function(lab){
    var view = lab.querySelector('.lab-view');
    var code = lab.querySelector('.lab-code');
    var out = lab.querySelector('.lab-out');
    var stepLbl = lab.querySelector('.lab-step');
    var why = lab.querySelector('.lab-why');
    var n = 0;
    function render(){
      var s = refState(n);
      view.textContent = '';
      var mem = el('div', 'mem');
      var left = el('div'); left.appendChild(el('p', 'mem-lbl', 'variables'));
      var vars = el('div', 'vars');
      if (!s.order.length) vars.appendChild(el('div', 'lab-step', '(nothing yet)'));
      s.order.forEach(function(k){
        var v = s.vars[k], prim = v.val !== undefined;
        var box = el('div', 'var' + (prim ? ' prim' : '') + (s.moved[k] ? ' moved' : ''));
        box.appendChild(el('b', null, (prim ? 'int ' : 'Height ') + k));
        box.appendChild(el('span', 'to', prim ? String(v.val) : '→ #' + v.ref));
        vars.appendChild(box);
      });
      left.appendChild(vars);
      var right = el('div'); right.appendChild(el('p', 'mem-lbl', 'objects'));
      var heap = el('div', 'heap');
      Object.keys(s.objs).forEach(function(id){
        var o = s.objs[id];
        var names = s.order.filter(function(k){ return s.vars[k].ref === +id; });
        var c = card('#' + id, 'Height', [
          ['feet', String(o.f), s.changed[id] ? 'new' : null],
          ['inches', String(o.i), s.changed[id] ? 'new' : null]
        ], names.length ? null : 'gone');
        c.appendChild(el('div', 'who', names.length ? 'arrows from: ' + names.join(', ') : 'no arrows · garbage'));
        heap.appendChild(c);
      });
      if (!Object.keys(s.objs).length) heap.appendChild(el('div', 'lab-step', '(no objects yet)'));
      right.appendChild(heap);
      mem.appendChild(left); mem.appendChild(right);
      view.appendChild(mem);
      var lines = [];
      STEPS.forEach(function(st, i){
        st.code.split('\n').forEach(function(line){
          lines.push((i === n - 1 ? '→ ' : i < n ? '  ' : '  ') + (i < n ? line : '// ' + line));
        });
      });
      code.textContent = lines.join('\n');
      out.textContent = s.out.join('\n');
      stepLbl.textContent = 'step ' + n + ' of ' + STEPS.length;
      why.textContent = n ? STEPS[n - 1].note : 'Press Next to run the first line of Lesson30.main.';
    }
    lab.querySelector('[data-act="next"]').addEventListener('click', function(){ if (n < STEPS.length){ n++; render(); } });
    lab.querySelector('[data-act="prev"]').addEventListener('click', function(){ if (n > 0){ n--; render(); } });
    lab.querySelector('[data-act="reset"]').addEventListener('click', function(){ n = 0; render(); });
    render();
  })(rl[r]);

  /* ----- bank lab: BankAccount with its three static fields ----- */
  var bl = document.querySelectorAll('.lab[data-mode="bank"]');
  for (var b = 0; b < bl.length; b++) (function(lab){
    var view = lab.querySelector('.lab-view');
    var code = lab.querySelector('.lab-code');
    var out = lab.querySelector('.lab-out');
    var fName = lab.querySelector('[data-f="name"]');
    var fBal = lab.querySelector('[data-f="bal"]');
    var pick = lab.querySelector('[data-f="acc"]');
    var fAmt = lab.querySelector('[data-f="amt"]');
    var st, lines, outs, mark;
    function reset(){
      st = { count: 0, fees: 0, accs: [] };
      lines = []; outs = []; mark = {};
    }
    function say(t, bad){ outs.push({ t: t, bad: bad }); }
    function q(s){ return '"' + s.replace(/\\/g, '\\\\').replace(/"/g, '\\"') + '"'; }
    function money(raw){
      var v = raw.trim();
      if (!/^-?\d{1,6}(\.\d{1,2})?$/.test(v)) return null;
      return parseFloat(v);
    }
    function open(nameRaw, balRaw){
      if (st.accs.length >= 4){ say('(this lab keeps at most four accounts — press start over)', true); return; }
      var v = 'acc' + (st.accs.length + 1);
      var hasBal = balRaw.trim() !== '';
      var amt = hasBal ? money(balRaw) : 0;
      lines.push('BankAccount ' + v + ' = new BankAccount(' + q(nameRaw) + (hasBal ? ', ' + balRaw.trim() : '') + ');');
      if (amt === null){ say('will not compile — the balance must be a number, like 5000', true); lines.pop(); return; }
      var a = { v: v, first: null, last: null, bal: 0 };
      var i = nameRaw.indexOf(' ');
      if (i !== -1){ a.first = nameRaw.substring(0, i); a.last = nameRaw.substring(i + 1); }
      else say('Invalid name');
      if (amt > 0) a.bal = amt;
      st.accs.push(a);
      st.count++;
      mark = { count: 1, acc: v };
    }
    function fee(a, amount){ var f = amount * 0.05; st.fees += f; a.bal -= f; }
    function move(kind){
      var a = st.accs[+pick.value];
      if (!a){ say('make an account first', true); return; }
      var raw = fAmt.value.trim();
      lines.push(a.v + '.' + kind + '(' + raw + ');');
      var amount = money(raw);
      if (amount === null){ say('will not compile — ' + kind + ' needs a number', true); return; }
      if (kind === 'deposit'){
        if (amount > 0){ a.bal += amount; fee(a, amount); say('Current balance: ' + jd(a.bal)); mark = { fees: 1, acc: a.v }; }
        else say('Amount must be positive!');
      } else {
        if (amount > 0 && amount <= a.bal){ a.bal -= amount; fee(a, amount); say('Current balance: ' + jd(a.bal)); mark = { fees: 1, acc: a.v }; }
        else say('Invalid amount!');
      }
    }
    function render(){
      view.textContent = '';
      var share = el('div', 'share');
      share.appendChild(card('BankAccount', 'static · one copy for all', [
        ['bankName', '"Garanti"'],
        ['customersCount', String(st.count), mark.count ? 'new' : null],
        ['totalFees', jd(st.fees), mark.fees ? 'new' : null]
      ], 'static'));
      if (st.accs.length){
        share.appendChild(el('div', 'down', '↓ every object reads and writes this one box ↓'));
        var row = el('div', 'objs');
        st.accs.forEach(function(a){
          row.appendChild(card(a.v, 'one per object', [
            ['firstName', a.first === null ? 'null' : q(a.first)],
            ['lastName', a.last === null ? 'null' : q(a.last)],
            ['balance', jd(a.bal), mark.acc === a.v ? 'new' : null]
          ]));
        });
        share.appendChild(row);
      }
      view.appendChild(share);
      var keep = pick.value;
      pick.textContent = '';
      st.accs.forEach(function(a, i){ var o = el('option', null, a.v); o.value = i; pick.appendChild(o); });
      if (keep !== '' && +keep < st.accs.length) pick.value = keep;
      else if (st.accs.length) pick.value = st.accs.length - 1;
      code.textContent = lines.length ? lines.join('\n') : '// make an account';
      out.textContent = '';
      outs.forEach(function(o){
        out.appendChild(o.bad ? el('span', 'bad', o.t) : document.createTextNode(o.t));
        out.appendChild(document.createTextNode('\n'));
      });
    }
    lab.querySelector('[data-act="open"]').addEventListener('click', function(){ mark = {}; open(fName.value, fBal.value); render(); });
    lab.querySelector('[data-act="deposit"]').addEventListener('click', function(){ mark = {}; move('deposit'); render(); });
    lab.querySelector('[data-act="withdrawal"]').addEventListener('click', function(){ mark = {}; move('withdrawal'); render(); });
    lab.querySelector('[data-act="count"]').addEventListener('click', function(){ mark = {}; lines.push('BankAccount.printCount();'); say(String(st.count)); render(); });
    lab.querySelector('[data-act="fees"]').addEventListener('click', function(){ mark = {}; lines.push('BankAccount.printTotalFees();'); say(jd(st.fees)); render(); });
    lab.querySelector('[data-act="reset"]').addEventListener('click', function(){ reset(); render(); });
    reset();
    open('Selin Kavas', '5000');
    open('Ceyda Yazıcı', '');
    mark = {};
    render();
  })(bl[b]);
})();
