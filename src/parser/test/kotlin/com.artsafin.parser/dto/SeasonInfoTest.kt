package com.artsafin.parser.dto

import `in`.artsaf.dto.SeasonInfo
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

}