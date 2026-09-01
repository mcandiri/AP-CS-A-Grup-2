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
