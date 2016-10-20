package com.artsafin.shared.dto

import org.bson.Document

data class SeasonInfo(
        val imgUrl: String?,
        val description: String?,
        val genres: Set<String>,
        val year: String?,
        val originalName: String?,
        val numSeasons: Short?
) {
    constructor(doc: Document) : this(SeasonInfo.Builder {
        description = doc.getString("description")

        genres = setOf()
        val genresDoc = doc["genres"]
        if (genresDoc != null) {
            try {
                genres = (genresDoc as List<String>).toSet()
            } catch (exc: TypeCastException) {
                // Just leave default empty set
            }
        }

        year = doc.getString("year")
        imgUrl = doc.getString("img")
        originalName = doc.getString("originalName")
        numSeasons = doc.getInteger("numSeasons")?.toShort()
    })

    constructor(b: Builder) : this(
            b.imgUrl,
            b.description,
            b.genres ?: hashSetOf(),
            b.year,
            b.originalName,
            b.numSeasons)

    class Builder constructor() {
        var imgUrl: String? = null
        var description: String? = null
        var genres: Set<String>? = null
        var year: String? = null
        var originalName: String? = null
        var numSeasons: Short? = null

        constructor(b: Builder.() -> Unit) : this() {
            set(b)
        }

        fun normalizeShort(s: String?) = normalizeInt(s)?.toShort()

        fun normalizeInt(s: String?): Int? {
            try {
                return s?.trim()?.toInt()
            } catch (e: NumberFormatException) {
                return null
            }
        }

        fun normalize(s: String?) = s?.trim()
        fun splitByComma(s: String?) =
                if (s != null && s.trim().length > 0)
                    s.trim().split(",").map { it.trim() }.toHashSet()
                else hashSetOf()

        fun set(b: Builder.() -> Unit): Builder {
            this.b()
            return this
        }

        fun build() = SeasonInfo(this)
    }

    fun deriveFrom(other: SeasonInfo?): SeasonInfo {
        if (other == null) {
            return this
        }
        return Builder {
            imgUrl = this@SeasonInfo.imgUrl ?: other.imgUrl
            description = this@SeasonInfo.description ?: other.description
            genres = if (this@SeasonInfo.genres.isNotEmpty()) this@SeasonInfo.genres else other.genres
            year = this@SeasonInfo.year
            originalName = this@SeasonInfo.originalName ?: other.originalName
            numSeasons = this@SeasonInfo.numSeasons ?: other.numSeasons
        }.build()
    }
}