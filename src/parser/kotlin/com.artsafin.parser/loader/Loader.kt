package com.artsafin.parser.loader

import `in`.artsaf.dto.SeasonInfo
import `in`.artsaf.dto.SeasonLink

interface Loader {
    fun loadFilter(): String
    fun loadUrl(url: String): String
    fun loadInfo(dataUrl: String): String
}