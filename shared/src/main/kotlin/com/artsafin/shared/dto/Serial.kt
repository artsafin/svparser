package com.artsafin.shared.dto

import org.bson.Document

data class Serial(val name: String, val image: String) {
    constructor(doc: Document) : this(doc.getString("name") ?: "", doc.getString("image") ?: "")
}