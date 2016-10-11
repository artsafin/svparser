package com.artsafin.shared.loader

interface Loader {
    fun loadFilter(): String
    fun loadUrl(url: String): String
    fun loadInfo(dataUrl: String): String
}