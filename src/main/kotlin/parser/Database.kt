package parser

import com.mongodb.MongoBulkWriteException
import com.mongodb.MongoClient
import com.mongodb.MongoClientOptions
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import com.mongodb.client.model.Filters
import com.mongodb.client.model.InsertManyOptions
import com.mongodb.client.model.InsertOneOptions
import com.mongodb.client.model.UpdateOptions
import org.bson.Document
import parser.dto.Season
import java.util.*

class Database(val name:String) {
    val mclient = MongoClient("localhost")
    val db: MongoDatabase = mclient.getDatabase(name)
    val coll: MongoCollection<Document> = db.getCollection("series")

    fun getDoc(s: Season): Document {
        val doc = Document()
                .append("_id", s.link.id)
                .append("id", s.link.id)
                .append("commonName", s.commonName)
                .append("name", s.link.name)
                .append("url", s.link.pageUrl)

        with(s.info) {
            doc.append("description", description)
                    .append("genres", genres)
                    .append("year", year)
                    .append("img", imgUrl)
                    .append("originalName", originalName)
                    .append("numSeasons", numSeasons)
        }

        return doc
    }

    fun insert(s: Season) {
        coll.replaceOne(Filters.eq("_id", s.link.id), getDoc(s), UpdateOptions().upsert(true))
    }

    fun insert(seasons: List<Season>) {
        val docs = seasons.map { getDoc(it) }
        try {
            coll.insertMany(docs, InsertManyOptions().ordered(false))
        } catch (e: MongoBulkWriteException) {
            // ignoring errors
        }
    }
}