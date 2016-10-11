package com.artsafin.api

import org.junit.Test
import org.junit.Assert.*

class SeasonvarParserTest {
    @Test
    fun parseSessionKeyFromHtml() {
        val sk = SeasonvarParser.parseSessionKey(TestData.pageHtml)

        assertEquals("d136a088be7b02acf3801f6c4ccdd7738", sk)
    }

    @Test
    fun parseSeasonIdFromUrl() {
        val si = SeasonvarParser.parseSeasonIdFromUrl("serial-130-Proslushka-1-sezon.html")

        assertEquals(130, si)
    }

    @Test
    fun parseSeasonIdFromHtml() {
        val si = SeasonvarParser.parseSeasonId(TestData.pageHtml)

        assertEquals(14258, si)
    }

    @Test
    fun parsePlaylistUrls() {
        val urls = SeasonvarParser.parsePlaylistUrls(TestData.pageHtml)

        assertEquals(mapOf(
                "Стандартный" to "/playls2/d136a088be7b02acf3801f6c4ccdd7738/trans%D0%A1%D1%82%D0%B0%D0%BD%D0%B4%D0%B0%D1%80%D1%82%D0%BD%D1%8B%D0%B9/14258/list.xml?time=1476219230",
                "кубик в кубе" to "/playls2/d136a088be7b02acf3801f6c4ccdd7738/trans%D0%BA%D1%83%D0%B1%D0%B8%D0%BA+%D0%B2+%D0%BA%D1%83%D0%B1%D0%B5/14258/list.xml?time=1476219230",
                "default" to "/playls2/d136a088be7b02acf3801f6c4ccdd7738/trans/14258/list.xml?time=1476219230"
        ), urls)
    }

}