package com.artsafin.api

import dto.PlainSeason
import dto.Serial
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import parser.Database
import java.util.concurrent.atomic.AtomicLong

@RestController
class SerialController {

    val db = Database("svparser2")

    @RequestMapping("/serial")
    fun serialList(@RequestParam(value = "search", defaultValue = "") search: String): List<Serial> {
        return if (search.length >= 2) db.findSerialsByName(search) else db.findAllSerials()
    }

    @RequestMapping("/serial/{name}")
    fun serial(@PathVariable(name = "name") name: String): List<PlainSeason> {
        return db.findSeasonsByName(name).map {
            PlainSeason(it.link.id, it.commonName, it.link.name, it.link.pageUrl,
                        it.info.description, it.info.genres, it.info.year, it.info.imgUrl,
                        it.info.originalName, it.info.numSeasons)
        }
    }
}