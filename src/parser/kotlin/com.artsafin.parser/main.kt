package com.artsafin.parser

import com.artsafin.parser.loader.HttpLoader
import com.artsafin.shared.Database
import com.artsafin.shared.dto.Season
import java.util.concurrent.Executors

fun main(args: Array<String>) {
    val db = Database("svparser2")
    val loader = HttpLoader(500)
    val parser = Parser()


    println("[MAIN] begin")

    val pool = Executors.newFixedThreadPool(4)

    for (lastSeason in parser.parseFromFilter(loader.loadFilter())) {
        pool.submit {
            val tid = "[" + Thread.currentThread().id.toString() + "] "
            println(tid + "Parsed from filter: " + lastSeason)
            val seasonLinkList = parser.parsePage(loader.loadUrl(lastSeason.pageUrl), Parser.Flags(onlySeasonList = true))
            println(tid + "Season list num: " + seasonLinkList.size)

            val lastSeasonInfo = parser.parseInfo(loader.loadInfo(lastSeason.dataUrl))

            val seasonList = seasonLinkList.reversed().map {
                Season(lastSeason.name, it, lastSeasonInfo)
            }
            db.insert(seasonList)

            println(tid + "finished")
        }
    }

    println("[MAIN] complete")
}