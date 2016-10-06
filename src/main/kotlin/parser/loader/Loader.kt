package parser.loader

import dto.SeasonInfo
import dto.SeasonLink

interface Loader {
    fun loadFilter(): String
    fun loadUrl(url: String): String
    fun loadInfo(dataUrl: String): String
}