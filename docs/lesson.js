(function(){
  var KW = /^(public|class|static|void|package|new|final|return|true|false|this|null)$/;
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
      var c = el('div', 'cell', ch === ' ' ? '␣' : ch);
      if (ch === ' ') c.classList.add('sp');
      if (i >= word.length) c.classList.add('ghost');
      if (o.from !== undefined && i >= o.from && i < o.to) c.classList.add('in');
      if (o.marks){
        for (var m = 0; m < o.marks.length; m++){
          if (i >= o.marks[m] && i < o.marks[m] + (o.mlen || 1)) c.classList.add('hit');
        }
      }
      if (o.diff === i) c.classList.add('diff');
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

  function q(s){ return '"' + s + '"'; }
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
