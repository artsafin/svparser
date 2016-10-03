import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import parser.Database
import parser.loader.TestLoader
import parser.Parser

@SpringBootApplication
open class Application

fun main(args: Array<String>) {
//    SpringApplication.run(Application::class.java, *args)

    val db = Database()

    val parser = Parser()
    parser.parse({
        println("Serial: " + it)
        db.insert(it)
    })
}