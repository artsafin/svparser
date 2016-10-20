package com.artsafin.shared.dto

import org.bson.Document
import org.junit.Assert.*
import org.junit.Test

class SeasonTest {

    @Test
    fun docCtorNormalItem() {
        val doc = Document.parse(TestData.singleItem)

        val season = Season(doc)

        assertEquals("Шерлок", season.commonName)
        assertNotNull(season.info)
        assertNotNull(season.link)
    }
}