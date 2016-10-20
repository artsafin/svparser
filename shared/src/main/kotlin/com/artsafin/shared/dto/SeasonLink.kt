package com.artsafin.shared.dto

import org.bson.Document

data class SeasonLink(
        val id: Int,
        val name: String,
        val pageUrl: String
) {
    val dataUrl = "/serialinfo/$id/"

    constructor(doc: Document) : this(
            doc.getInteger("id", 0),
            doc.getString("name") ?: "",
            doc.getString("url") ?: ""
    )
}