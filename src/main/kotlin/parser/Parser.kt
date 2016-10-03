package parser

import org.jsoup.Jsoup
import parser.dto.SeasonInfo
import parser.dto.SeasonLink
import java.util.regex.Pattern

/*
<a id="a587"
                   data="/serialinfo/587/"
                   href="/serial-587-Plantatciya-1-season.html"
                   class="betterT alf-link" >
                                        Плантация</a>
 */

class Parser() {
    data class Flags(val onlySeasonList: Boolean)

    fun parseFromFilter(filterStr: String): List<SeasonLink> {
        val doc = Jsoup.parseBodyFragment(filterStr)
        return doc.select("a[data]").map {
            val id = it.id().substring(1).toInt()
            SeasonLink(id, it.text().trim(), it.attr("href"))
        }
    }

    fun parsePage(str: String, flags: Flags): List<SeasonLink> {
        val doc = Jsoup.parse(str)

        val selector = if (flags.onlySeasonList) ".seasonlist a[href^=/serial-]" else "a[href^=/serial-]"

        return doc.select(selector).map {
            val text = it.ownText().replace(">>>", "").trim()

            val href = it.attr("href")
            val idMatcher = Pattern.compile("serial-(\\d+)-").matcher(href)
            val id = if (idMatcher.find()) idMatcher.group(1).toInt() else 0
            SeasonLink(id, text, href)
        }
    }

    fun parseInfo(str: String): SeasonInfo {
        val doc = Jsoup.parseBodyFragment(str)

        return SeasonInfo.Builder {
            imgUrl = normalize(doc.select("img[src]").first()?.attr("src"))

            val contentTd = doc.select("td:last-of-type").first()
            description = normalize(if (contentTd != null && contentTd.childNodeSize() > 0) contentTd.childNode(0)?.outerHtml() else "")
            genres = splitByComma(doc.select("span:containsOwn(Жанр)").first()?.nextSibling()?.outerHtml())
            year = normalize(doc.select("span:containsOwn(Вышел)").first()?.nextSibling()?.outerHtml())
            originalName = normalize(doc.select("span:containsOwn(Оригинал)").first()?.nextSibling()?.outerHtml())
            numSeasons = normalizeShort(doc.select("span:containsOwn(Сезонов)").first()?.nextSibling()?.outerHtml())
        }.build()
    }
}