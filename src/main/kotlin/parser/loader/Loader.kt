package parser.loader

import parser.SeasonInfo
import parser.dto.SeasonLink

interface Loader {
    fun loadFromFilter(): String
    fun loadUrl(url: String): String
    fun loadInfo(dataUrl: String): String
}