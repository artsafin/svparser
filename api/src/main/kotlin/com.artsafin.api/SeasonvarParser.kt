package com.artsafin.api;

import java.net.URLDecoder
import java.util.regex.Pattern;

object SeasonvarParser
{
    fun parseSessionKey(input: String): String?
    {
        val pattern = Pattern.compile("/([a-z0-9]{33})/")

        return with (pattern.matcher(input)) { if (find()) group(1) else null }

    }

    fun parseSeasonIdFromUrl(url: String): Int?
    {
        // serial-130-Proslushka-1-sezon.html
        val pattern = Pattern.compile("serial-(\\d+)-")

        return with (pattern.matcher(url)) { if (find()) group(1)?.toInt() else null }
    }

    fun parseSeasonId(html: String): Int? {
        // var id = "14003";
        val pattern = Pattern.compile("var id = ['\"]?([^'\"]+)['\"]?;")

        return with (pattern.matcher(html)) { if (find()) group(1)?.toInt() else null }
    }

    fun parsePlaylistUrls(html: String): Map<String, String> {
        // var pl0 = "/playls2/d136a088be7b02acf3801f6c4ccdd7738/trans%D0%A1%D1%82%D0%B0%D0%BD%D0%B4%D0%B0%D1%80%D1%82%D0%BD%D1%8B%D0%B9/14258/list.xml?time=1476219230";

        val urlPattern = Pattern.compile("(/playls2[^'\"]+)")
        val urlMatcher = urlPattern.matcher(html)

        val transPattern = Pattern.compile("/trans([^/]+)/")

        val res = mutableMapOf<String, String>()
        while (urlMatcher.find()) {
            val url = urlMatcher.group(1)
            val trans:String? = with (transPattern.matcher(url)) { if (find()) group(1) else null }
            val transDecoded = URLDecoder.decode(trans ?: "default", "UTF-8");

            res.put(transDecoded, url)
        }

        return res
    }
}
