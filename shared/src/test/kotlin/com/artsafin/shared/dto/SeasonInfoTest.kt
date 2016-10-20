package com.artsafin.shared.dto

import com.artsafin.shared.dto.SeasonInfo
import org.bson.Document
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class SeasonInfoTest {
    var parent: SeasonInfo? = null

    @Before
    fun setUp() {
        parent = SeasonInfo("parent imgUrl",
                "parent description",
                hashSetOf("parent genre1", "parent genre2"),
                "parent year",
                "parent original Name",
                20)
    }

    @Test
    fun deriveFromParentOfFullSelf() {
        val self = SeasonInfo("self imgUrl",
                "self description",
                hashSetOf("self genre1", "self genre2"),
                "self year",
                "self original Name",
                10)

        val result = self.deriveFrom(parent)

        assertEquals(result.imgUrl, self.imgUrl)
        assertEquals(result.description, self.description)
        assertEquals(result.genres, self.genres)
        assertEquals(result.year, self.year)
        assertEquals(result.originalName, self.originalName)
        assertEquals(result.numSeasons, self.numSeasons)
    }

    @Test
    fun deriveFromParentOfEmptySelf() {
        val self = SeasonInfo(null,
                null,
                hashSetOf(),
                null,
                null,
                null)

        val result = self.deriveFrom(parent)

        assertEquals(result.imgUrl, parent?.imgUrl)
        assertEquals(result.description, parent?.description)
        assertEquals(result.genres, parent?.genres)
        assertFalse(result.genres.isEmpty())
        assertEquals(result.year, null)
        assertEquals(result.originalName, parent?.originalName)
        assertEquals(result.numSeasons, parent?.numSeasons)
    }

    @Test
    fun docCtorNormalItem() {
        val doc = Document.parse(TestData.singleItem)

        val info = SeasonInfo(doc)

        assertEquals("http://cdn.seasonvar.ru/oblojka/12909.jpg", info.imgUrl)
        assertEquals("Девятнадцатый век. Лондон. Канун Рождества. К великому сыщику", info.description)
        assertEquals(setOf("детективы", "триллеры"), info.genres)
        assertEquals("2016", info.year)
        assertEquals("Sherlock", info.originalName)
        assertEquals(4.toShort(), info.numSeasons)
    }
    @Test
    fun docCtorNullNumSeasons() {
        val doc = Document.parse(TestData.singleItemNullNumSeasons)

        val info = SeasonInfo(doc)

        assertEquals("http://cdn.seasonvar.ru/oblojka/12909.jpg", info.imgUrl)
        assertNull(info.numSeasons)
    }

    @Test
    fun docCtorEmptyGenres() {
        val doc = Document.parse(TestData.singleItemEmptyGenres)

        val info = SeasonInfo(doc)

        assertEquals(setOf<String>(), info.genres)
    }

    @Test
    fun docCtorNullGenres() {
        val doc = Document.parse(TestData.singleItemNullGenres)

        val info = SeasonInfo(doc)

        assertEquals(setOf<String>(), info.genres)
    }
}