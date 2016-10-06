package parser

import com.mongodb.MongoBulkWriteException
import com.mongodb.MongoClient
import com.mongodb.MongoClientOptions
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import com.mongodb.client.model.Filters
import com.mongodb.client.model.InsertManyOptions
import com.mongodb.client.model.UpdateOptions
import org.bson.Document
import dto.Season
import dto.SeasonCodec
import dto.Serial
import dto.SerialCodec
import org.bson.codecs.configuration.CodecRegistries
import java.util.regex.Pattern

class Database(private val name: String) {
    private val mgoptions = MongoClientOptions.builder()
            .codecRegistry(CodecRegistries.fromRegistries(
                    CodecRegistries.fromCodecs(SerialCodec(), SeasonCodec()),
                    MongoClient.getDefaultCodecRegistry()
            ))
            .build()
    private val mclient = MongoClient("localhost", mgoptions)
    private val db: MongoDatabase = mclient.getDatabase(name)
    private val coll: MongoCollection<Document> = db.getCollection("series")

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

    /*
        {  $match: {"commonName": {$regex: ".*люб.*"}}  },
        {  $group: { _id: '$commonName', image: {$first: '$img'} }  },
        {  $project:{ name: '$_id', image: '$image' }  }
     */
    fun findAllSerials() = coll.aggregate(listOf(
            Document("\$group", Document(mapOf(
                    "_id" to "\$commonName",
                    "image" to Document("\$first", "\$img")
            ))),
            Document("\$project", Document(mapOf(
                    "name" to "\$_id",
                    "image" to "\$image"
            )))
    ), Serial::class.java).toList()


    fun findSerialsByName(name: String) = coll.aggregate(listOf(
            Document("\$match", Document(mapOf(
                    "commonName" to Document("\$regex", ".*" + Pattern.quote(name) + ".*")
            ))),
            Document("\$group", Document(mapOf(
                    "_id" to "\$commonName",
                    "image" to Document("\$first", "\$img")
            ))),
            Document("\$project", Document(mapOf(
                    "name" to "\$_id",
                    "image" to "\$image"
            )))
    ), Serial::class.java).toList()

    fun findSeasonsByName(name: String) = coll.find(Document("commonName", name), Season::class.java).toList()
}