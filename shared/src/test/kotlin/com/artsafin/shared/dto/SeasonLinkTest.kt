package com.artsafin.shared.dto

import org.bson.Document
import org.junit.Assert.*
import org.junit.Test

class SeasonLinkTest {

    @Test
    fun docCtorNormalItem() {
        val doc = Document.parse(TestData.singleItem)

        val link = SeasonLink(doc)

        assertEquals(12909, link.id)
        assertEquals("Сериал Шерлок/Sherlock 4 сезон", link.name)
        assertEquals("/serial-12909-SHerlok-4-sezon.html", link.pageUrl)
        assertEquals("/serialinfo/12909/", link.dataUrl)
    }

    @Test
    fun docCtorNullItem() {
        val doc = Document.parse(TestData.singleItemNullLinkInfo)

        val link = SeasonLink(doc)

        assertEquals(12909, link.id)
        assertEquals("", link.name)
        assertEquals("", link.pageUrl)
        assertEquals("/serialinfo/12909/", link.dataUrl)
    }
}