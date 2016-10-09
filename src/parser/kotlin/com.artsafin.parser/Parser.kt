package com.artsafin.parser

import org.jsoup.Jsoup
import org.jsoup.nodes.TextNode
import java.util.regex.Pattern

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
            imgUrl = if (imgUrl?.contains("/.")?:true) null else imgUrl

            val contentTd = doc.select("td:last-of-type").first()
            description = normalize(if (contentTd != null && contentTd.childNodeSize() > 0 && contentTd.childNode(0) is TextNode) contentTd.childNode(0).outerHtml() else null)

            val genresString = doc.select("span:containsOwn(Жанр)").first()?.nextSibling()?.outerHtml()?.replace("<br>", "")
            genres = splitByComma(genresString)

            year = normalize(doc.select("span:containsOwn(Вышел)").first()?.nextSibling()?.outerHtml()?.replace("<br>", ""))
            year = if (year == "") null else year

            originalName = normalize(doc.select("span:containsOwn(Оригинал)").first()?.nextSibling()?.outerHtml()?.replace("<br>", ""))
            originalName = if (originalName == "") null else originalName

            numSeasons = normalizeShort(doc.select("span:containsOwn(Сезонов)").first()?.nextSibling()?.outerHtml()?.replace("<br>", ""))
        }.build()
    }
}