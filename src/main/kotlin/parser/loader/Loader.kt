package parser.loader

import parser.dto.SeasonInfo
import parser.dto.SeasonLink

interface Loader {
    fun loadFilter(): String
    fun loadUrl(url: String): String
    fun loadInfo(dataUrl: String): String
}