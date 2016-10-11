package com.artsafin.parser

import com.artsafin.shared.loader.HttpLoader
import com.artsafin.shared.DATABASE_DEFAULT
import com.artsafin.shared.Database
import com.artsafin.shared.dto.Season
import com.artsafin.shared.loader.DelayingHttpLoader
import org.apache.commons.cli.*
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import kotlin.system.exitProcess

val optsScheme = Options()
        .addOption(Option.builder()
                .longOpt("db")
                .required()
                .hasArg()
                .type(String::class.java)
                .desc("Database host to use")
                .build())

private fun getCmd(args: Array<String>): CommandLine {
    try {
        return DefaultParser().parse(optsScheme, args)
    } catch (e: MissingOptionException) {
        HelpFormatter().printHelp("parser", optsScheme)
        exitProcess(1)
    }
}

fun main(args: Array<String>) {
    val opts = getCmd(args)

    val db = Database(opts.getOptionValue("db"), DATABASE_DEFAULT)
    if (!db.isAlive()) {
        println("[MAIN] db is down. Exiting")
        exitProcess(1)
    }

    val loader = DelayingHttpLoader(500)
    val parser = Parser()

    val cores = Runtime.getRuntime().availableProcessors()

    println("[MAIN] begin (%d cpus)".format(cores))

    val pool = Executors.newFixedThreadPool(cores)

    for (lastSeason in parser.parseFromFilter(loader.loadFilter())) {
        pool.submit {
            try {
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
            } catch (eInt: InterruptedException) {
                eInt.printStackTrace()
            }
        }
    }

    pool.shutdown()
    if (!pool.awaitTermination(1, TimeUnit.MINUTES)) {
        println("[MAIN] didn't wait until pool has exited")
    } else {
        println("[MAIN] complete")
    }
}