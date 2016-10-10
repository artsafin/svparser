package com.artsafin.api

import com.artsafin.shared.DATABASE_DEFAULT
import com.artsafin.shared.Database
import com.artsafin.shared.dto.PlainSeason
import com.artsafin.shared.dto.Serial
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class SerialController(@Value("\${db}") val dbHost: String) {

    val db = Database(dbHost, DATABASE_DEFAULT)

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