package dto

data class PlainSeason(
        var id: Int? = null,
        var commonName: String? = null,
        var name: String? = null,
        var url: String? = null,
        var description: String? = null,
        var genres: Set<String>? = null,
        var year: String? = null,
        var img: String? = null,
        var originalName: String? = null,
        var numSeasons: Short? = null
)