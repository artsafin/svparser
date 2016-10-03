import com.mongodb.MongoClient
import org.bson.Document

fun main(args: Array<String>) {
    val mongoClient = MongoClient("localhost")
    mongoClient.listDatabaseNames().forEach { println("db: " + it)  }

    val db = mongoClient.getDatabase("svparser")
    db.listCollectionNames().forEach { println("coll: " + it) }

    val coll = db.getCollection("series")
    println("coll count: " + coll.count())

    coll.insertOne(Document()
                    .append("_id", "a587")
                    .append("url", "/serial-587-Plantatciya-1-season.html")
    )
}