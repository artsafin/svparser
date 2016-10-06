package parser

import org.junit.Assert.*
import org.junit.Test
import parser.dto.SeasonLink

class ParserTest {
    @Test
    fun parseFromFilter() {
        val parser = Parser()
        val seq = parser.parseFromFilter(TestData.filterHtml)
        assertEquals(listOf(
                SeasonLink(587, "Плантация", "/serial-587-Plantatciya-1-season.html"),
                SeasonLink(11529, "Пластиковые Воспоминания", "/serial-11529-Plastikovye_Vospominaniya.html"),
                SeasonLink(6270, "Плата за любовь", "/serial-6270-Plata_za_lyubov.html"),
                SeasonLink(7809, "Плата не по заслугам", "/serial-7809-Plata_ne_po_zaslugam.html")
        ), seq)

    }

    @Test
    fun parseSeasonList() {
        val parser = Parser()
        val seq = parser.parsePage(TestData.pageHtml, Parser.Flags(onlySeasonList = true))

        assertEquals(listOf(
                SeasonLink(1026, "Сериал Южный Парк/South Park 1 сезон", "/serial-1026-YUzhnij_Park-1-season.html"),
                SeasonLink(1034, "Сериал Южный Парк/South Park 2 сезон", "/serial-1034-YUzhnij_Park-2-season.html"),
                SeasonLink(1041, "Сериал Южный Парк/South Park 3 сезон", "/serial-1041-YUzhnij_Park-3-season.html"),
                SeasonLink(1082, "Сериал Южный Парк/South Park 4 сезон", "/serial-1082-YUzhnij_Park-4-season.html"),
                SeasonLink(1085, "Сериал Южный Парк/South Park 5 сезон", "/serial-1085-YUzhnij_Park-5-season.html"),
                SeasonLink(1118, "Сериал Южный Парк/South Park 6 сезон", "/serial-1118-YUzhnij_Park-6-season.html"),
                SeasonLink(1232, "Сериал Южный Парк/South Park 7 сезон", "/serial-1232-YUzhnij_Park-7-season.html"),
                SeasonLink(1240, "Сериал Южный Парк/South Park 8 сезон", "/serial-1240-YUzhnij_Park-8-season.html"),
                SeasonLink(1250, "Сериал Южный Парк/South Park 9 сезон", "/serial-1250-YUzhnij_Park-9-season.html"),
                SeasonLink(1258, "Сериал Южный Парк/South Park 10 сезон", "/serial-1258-YUzhnij_Park-10-season.html"),
                SeasonLink(1276, "Сериал Южный Парк/South Park 11 сезон", "/serial-1276-YUzhnij_Park-11-season.html"),
                SeasonLink(1282, "Сериал Южный Парк/South Park 12 сезон", "/serial-1282-YUzhnij_Park-12-season.html"),
                SeasonLink(1289, "Сериал Южный Парк/South Park 13 сезон", "/serial-1289-YUzhnij_Park-13-season.html"),
                SeasonLink(1304, "Сериал Южный Парк/South Park 14 сезон", "/serial-1304-YUzhnij_Park-14-season.html"),
                SeasonLink(2390, "Сериал Южный Парк/South Park 15 сезон", "/serial-2390-YUzhnij_Park-15-season.html"),
                SeasonLink(3929, "Сериал Южный Парк/South Park 16 сезон", "/serial-3929-YUzhnij_Park-16-season.html"),
                SeasonLink(7779, "Сериал Южный Парк/South Park 17 сезон", "/serial-7779-YUzhnyj_Park-17-season.html"),
                SeasonLink(10435, "Сериал Южный Парк/South Park 18 сезон", "/serial-10435-YUzhnyj_Park-18-season.html"),
                SeasonLink(12363, "Сериал Южный Парк/South Park 19 сезон", "/serial-12363-YUzhnyj_Park-19-season.html"),
                SeasonLink(14258, "Сериал Южный Парк/South Park 20 сезон", "/serial-14258-YUzhnyj_Park-20-season.html")
        ), seq)
    }

    @Test
    fun parseInfoMinimal() {
        val parser = Parser()
        val info = parser.parseInfo(TestData.infoMinimal)

        assertEquals("Познавательная телепрограмма с телеведущим Дмитрием Пучковым. Передача расскажет об истории танкостроения, эволюция первых машин Первой Мировой войны до суперсовременных мощных машин... Мы наглядно увидим особенности каждой машины...", info.description)
        assertEquals(hashSetOf("документальные", "исторические", "отечественные"), info.genres)
        assertEquals("http://cdn.seasonvar.ru/oblojka/9886.jpg", info.imgUrl)
        assertNull(info.numSeasons)
        assertNull(info.originalName)
        assertEquals("2014", info.year)
    }

    @Test
    fun parseInfoFancyYear() {
        val parser = Parser()
        val info = parser.parseInfo(TestData.infoFancyYear)

        assertEquals("2006 -2014", info.year)
    }

    @Test
    fun parseInfoFull() {
        val parser = Parser()
        val info = parser.parseInfo(TestData.infoFull)

        assertEquals("Предлагаем вашему вниманию двадцатый сезон знаменитого проекта \"Южный парк\". Сюжет развивается вокруг жизни и приключений четверки друзей, их товарищей и знакомых. Все они живут в небольшом городке Южный Парк, это где-то в штате К...", info.description)
        assertEquals(hashSetOf("комедия", "анимационные"), info.genres)
        assertEquals("http://cdn.seasonvar.ru/oblojka/14258.jpg", info.imgUrl)
        assertEquals(20.toShort(), info.numSeasons)
        assertEquals("South Park", info.originalName)
        assertEquals("2016", info.year)
    }

    @Test
    fun parseInfoEmpty() {
        val parser = Parser()
        val info = parser.parseInfo(TestData.infoEmpty)

        assertNull("description", info.description)
        assertEquals("genres", hashSetOf<String>(), info.genres)
        assertNull("imgUrl", info.imgUrl)
        assertNull("numSeasons", info.numSeasons)
        assertNull("originalName", info.originalName)
        assertNull("year", info.year)
    }

    @Test
    fun parseInfoGenreEmpty() {
        val parser = Parser()
        val info = parser.parseInfo(TestData.infoGenreEmpty)

        assertEquals("genres", hashSetOf<String>(), info.genres)
    }

}