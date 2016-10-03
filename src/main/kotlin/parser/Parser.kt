package parser

import parser.loader.Loader
import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern

/*
<a id="a587"
                   data="/serialinfo/587/"
                   href="/serial-587-Plantatciya-1-season.html"
                   class="betterT alf-link" >
                                        Плантация</a>
 */

class Parser(val loader: Loader) {
    val rowPattern: Pattern = Pattern.compile("<a([^>]*)>([^<]*)</a>");
    val attrPattern: Pattern = Pattern.compile("\\b([^=]+)=\\s*[\"']([^'\"]*)[\"']")
    val idPattern: Pattern = Pattern.compile("serial-(\\d+)")
    val dataImgSrcPattern: Pattern = Pattern.compile("img[^>]+src=['\"]([^'\"]+)['\"]")
    val dataDescrPattern: Pattern = Pattern.compile("<td.*?<td[^>]*>(.*?)<br", Pattern.DOTALL)
    val dataGenrePattern: Pattern = Pattern.compile("Жанр.*?>(.*?)<br", Pattern.DOTALL)
    val dataYearPattern: Pattern = Pattern.compile("Вышел.*?>(.*?)<br", Pattern.DOTALL)

    fun parse(processCb: (Serial) -> Unit): ArrayList<Serial> {
        val result: ArrayList<Serial> = ArrayList<Serial>()
        val data = loader.loadSerialList()

        val rowMatcher = rowPattern.matcher(data)
        while (rowMatcher.find()) {
            val serial = parseSerial(rowMatcher)
            result.add(serial)
            processCb(serial)
        }

        return result
    }

    private fun parseSerial(matcher: Matcher): Serial {
        val link = matcher.group(1).replace(Regex("\\s+"), " ").trim()
        val name = matcher.group(2).replace(Regex("\\s+"), " ").trim()

        var id: String? = null
        var dataLink: String? = null
        var hrefLink: String? = null
        val attrMatcher = attrPattern.matcher(link)
        while (attrMatcher.find()) {
            if (attrMatcher.group(1) == "id") {
                id = attrMatcher.group(2)
            }
            if (attrMatcher.group(1) == "data") {
                dataLink = attrMatcher.group(2)
            }
            if (attrMatcher.group(1) == "href") {
                hrefLink = attrMatcher.group(2)
            }
        }

        if (hrefLink == null || id == null) {
            throw IllegalStateException("href or id is not set: " + matcher.group(0))
        }

        var seasonInfo: SeasonInfo? = null
        if (dataLink != null) {
            val str = loader.loadSerialData(dataLink)
            seasonInfo = parseData(str)
        }

        return Serial(id, name, hrefLink, dataLink, seasonInfo)
    }

    private fun parseData(str: String): SeasonInfo {
        val builder = SeasonInfo.Builder()

        val imgSrcMatcher = dataImgSrcPattern.matcher(str)
        if (imgSrcMatcher.find()) {
            builder.imgUrl(imgSrcMatcher.group(1))
        }

        val descrMatcher = dataDescrPattern.matcher(str)
        if (descrMatcher.find()) {
            builder.description(descrMatcher.group(1))
        }

        val genreMatcher = dataGenrePattern.matcher(str)
        if (genreMatcher.find()) {
            builder.genres(genreMatcher.group(1))
        }
        val yearMatcher = dataYearPattern.matcher(str)
        if (yearMatcher.find()) {
            builder.year(yearMatcher.group(1))
        }

        return builder.build()
    }
}