package com.artsafin.api

import com.artsafin.shared.loader.HttpLoader
import org.springframework.web.bind.annotation.*
import kotlin.system.exitProcess

@RestController
class EpisodesController {
    private fun playlistPath(sessId: String, seasonId: Int): String =
            "/playls2/${sessId}/trans/${seasonId}/list.xml?time=${ System.currentTimeMillis() }"

    @PostMapping("/episodes/parse")
    fun episodesParse(@RequestBody html: String): String {
        val pls = SeasonvarParser.parsePlaylistUrls(html)

        if (pls.isNotEmpty()) {
            val loader = HttpLoader()
            return "{" + pls.map {
                "\"${it.key}\": ${ loader.loadUrl(it.value) }"
            }.joinToString(",") + "}"
        }

        throw Exception("Input html couldn't be parsed")
    }
}