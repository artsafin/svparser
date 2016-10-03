import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import parser.Database
import parser.Parser
import parser.loader.HttpLoader
import java.util.concurrent.Executors
import kotlin.concurrent.thread
import parser.dto.Season

@SpringBootApplication
open class Application

fun main(args: Array<String>) {
//    SpringApplication.run(Application::class.java, *args)

    val db = Database("svparser2")
    val loader = HttpLoader(500)
    val parser = Parser()

    val pool = Executors.newFixedThreadPool(4)

    for (lastSeason in parser.parseFromFilter(loader.loadFilter())) {
        pool.submit {
            val tid = "[" + Thread.currentThread().id.toString() + "] "
            println(tid + "Parsed from filter: " + lastSeason)
            val seasonLinkList = parser.parsePage(loader.loadUrl(lastSeason.pageUrl), Parser.Flags(onlySeasonList = true))
            println(tid + "Season list num: " + seasonLinkList.size)

            val seasonList = seasonLinkList.map {
                val info = parser.parseInfo(loader.loadInfo(it.dataUrl))
                Season(lastSeason.name, it, info)
            }
            db.insert(seasonList)
        }
    }
}