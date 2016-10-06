package dto

data class SeasonLink(
        val id: Int,
        val name: String,
        val pageUrl: String
) {
    val dataUrl: String
        get() = "/serialinfo/${id}/"
}