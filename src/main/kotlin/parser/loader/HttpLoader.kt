package parser.loader

import okhttp3.*
import parser.SeasonInfo
import parser.dto.SeasonLink

class HttpLoader : Loader {
    val http = OkHttpClient()

    private val BASE_URL = "http://seasonvar.ru"
    private val INDEX_URL = BASE_URL + "/index.php"
    private val FILTER_POST_MEDIATYPE = MediaType.parse("application/x-www-form-urlencoded")
    private val FILTER_POST_BODY = "filter%5BengName%5D=&filter%5Bonly%5D=&filter%5Brait%5D=kp&filter%5Bhd%5D=&filter%5Bexp%5D=&filter%5Bsub%5D=&filter%5Bblock%5D=&filter%5Bhistory%5D=&filter%5Bmark%5D=&filter%5Bnw%5D=";
    private val HEADERS = mapOf(
            "Referer" to BASE_URL + "/",
            "User-Agent" to "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.116 Safari/537.36",
            "Accept" to "*/*",
            "X-Requested-With" to "XMLHttpRequest"
    )

    private fun defaultRequestBuilder(url: String): Request.Builder {
        return Request.Builder()
                .url(url)
                .headers(Headers.of(HEADERS))
    }

    override fun loadFromFilter(): String {
        val request = defaultRequestBuilder(INDEX_URL)
                .method("POST", RequestBody.create(FILTER_POST_MEDIATYPE, FILTER_POST_BODY))
                .build()

        val response = http.newCall(request).execute()

        return response.body().string()
    }

    override fun loadUrl(url: String): String {
        val request = defaultRequestBuilder(url)
                .build()

        val response = http.newCall(request).execute()

        return response.body().string()
    }

    override fun loadInfo(dataUrl: String): String {
        val request = defaultRequestBuilder(BASE_URL + dataUrl)
                .method("POST", RequestBody.create(FILTER_POST_MEDIATYPE, ""))
                .build()

        val response = http.newCall(request).execute()

        return response.body().string();
    }
}