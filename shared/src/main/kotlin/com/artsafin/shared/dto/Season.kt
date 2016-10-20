package com.artsafin.shared.dto

import org.bson.Document

data class Season(
        val commonName: String,
        val link: SeasonLink,
        val info: SeasonInfo
) {
    constructor(doc: Document) : this(
            doc.getString("commonName") ?: "",
            SeasonLink(doc),
            SeasonInfo(doc)
    )
}