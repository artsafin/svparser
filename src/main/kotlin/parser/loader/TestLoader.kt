package parser.loader

import okhttp3.Headers
import okhttp3.MediaType
import okhttp3.RequestBody

class TestLoader : Loader {
    override fun loadImage(url: String): ByteArray {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadSerialData(urlPath: String): String {
        return """
<table width="100%"  border="0" cellpadding="3" cellspacing="0"><tr><td valign="top" align="center" width="120" ><img src="http://cdn.seasonvar.ru/oblojka/9886.jpg" width="120" style="border: 5px white solid;"></td><td valign="top" align="left">
            Познавательная телепрограмма с телеведущим Дмитрием Пучковым. Передача расскажет об истории танкостроения, эволюция первых машин Первой Мировой войны до суперсовременных мощных машин... Мы наглядно увидим особенности каждой машины...
                        <br><br><br><br><span style="color: #be0750;">Жанр:</span>документальные, исторические, отечественные
                        <br><span style="color: #be0750;">Вышел:</span> 2014<br><br></td></tr></table>
"""
    }

    override fun loadSerialList(): String {
return """
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
    }
}