package com.artsafin.shared.loader

import okhttp3.*

class DelayingHttpLoader(val delayMs: Long) : HttpLoader() {

    override fun defaultRequestBuilder(url: String): Request.Builder {
        if (delayMs > 0) Thread.sleep(delayMs)

        return super.defaultRequestBuilder(url)
    }
}