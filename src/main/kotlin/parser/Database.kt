package parser

import com.mongodb.MongoBulkWriteException
import com.mongodb.MongoClient
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import com.mongodb.client.model.Filters
import com.mongodb.client.model.InsertManyOptions
import com.mongodb.client.model.InsertOneOptions
import com.mongodb.client.model.UpdateOptions
import org.bson.Document
import java.util.*

class Database {
    val mclient = MongoClient("localhost")
    val db: MongoDatabase = mclient.getDatabase("svparser")
    val coll: MongoCollection<Document> = db.getCollection("series")

    fun getDoc(s: Serial): Document {
        val doc = Document()
                .append("id", s.id)
                .append("name", s.name)
                .append("url", s.url)

        if (s.data != null) {
            with(s.data) {
                doc.append("description", description)
                        .append("genres", genres)
                        .append("year", year)
                        .append("img", imgUrl)
            }
        }

        return doc
    }

    fun insert(s: Serial) {
        coll.replaceOne(Filters.eq("_id", s.id), getDoc(s), UpdateOptions().upsert(true))
    }

    fun insert(serials: ArrayList<Serial>) {
        val docs = serials.map { getDoc(it) }
        try {
            coll.insertMany(docs, InsertManyOptions().ordered(false))
        } catch (e: MongoBulkWriteException) {
            // ignoring errors
        }
    }
}