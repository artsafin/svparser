package parser

import parser.loader.Loader
import java.util.*

data class SeasonInfo(
        val imgUrl: String,
        val description: String,
        val genres: Set<String>,
        val year: String,
        val originalName: String?,
        val numSeasons: Short?
) {
    constructor(b: Builder) : this(
            b.imgUrl ?: "",
            b.description ?: "",
            b.genres ?: hashSetOf(),
            b.year ?: "",
            b.originalName,
            b.numSeasons)

    class Builder {
        var imgUrl: String? = null
        var description: String? = null
        var genres: Set<String>? = null
        var year: String? = null
        var originalName: String? = null
        var numSeasons: Short? = null

        fun normalize(s: String) = s.trim()
        fun splitByComma(s: String) = s.trim().split(",").map { it.trim() }.toHashSet()

        fun set(b: Builder.() -> Unit): Builder {
            this.b()
            return this
        }

        fun build() = SeasonInfo(this)
    }
}