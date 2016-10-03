package parser

data class Serial(
        val id: String,
        val name: String,
        val url: String,
        val dataUrl: String?,
        val data: SeasonInfo?
)