package com.artsafin.shared.dto

import org.bson.BsonReader
import org.bson.BsonType
import org.bson.BsonWriter
import org.bson.codecs.Codec
import org.bson.codecs.DecoderContext
import org.bson.codecs.EncoderContext

class SeasonCodec: Codec<Season> {
    override fun encode(writer: BsonWriter?, value: Season?, encoderContext: EncoderContext?) {
    }

    override fun decode(reader: BsonReader?, decoderContext: DecoderContext?): Season {
        if (reader == null) {
            throw NullPointerException("reader")
        }
        reader.readStartDocument()
/*
{
    "_id" : 3047,
    "id" : 3047,
    "commonName" : "100 подвигов Эдди Макдауда",
    "name" : "Сериал 100 подвигов Эдди Макдауда/100 Deeds for Eddie McDowd 3 сезон",
    "url" : "/serial-3047-100_podvigov_Eddi_Makdauda-3-season.html",
    "description" : "Фантастический комедийный сериал о том, как одного несносного мальчишку за все его выходки превратили в собаку. Нести свой крест Эдди Макдауду, а именно так зовут нашего главного героя, придется до тех пор, пока он не совершит сто...",
    "genres" : [
        "комедия",
        "семейные"
    ],
    "year" : "2002",
    "img" : "http://cdn.seasonvar.ru/oblojka/3047.jpg",
    "originalName" : "100 Deeds for Eddie McDowd",
    "numSeasons" : 3
}
 */
        reader.readInt32("_id")
        val id = reader.readInt32("id")
        val commonName = reader.readString("commonName")
        val name = reader.readString("name")
        val url = reader.readString("url")

        val link = SeasonLink(id, name, url)
        val info = SeasonInfo.Builder {
            description = reader.readString("description")

            reader.readStartArray()
            val genresMutable = mutableSetOf<String>()
            while (reader.readBsonType() != BsonType.END_OF_DOCUMENT) {
                genresMutable.add(reader.readString())
            }
            reader.readEndArray()
            genres = genresMutable.toSet()

            year = reader.readString("year")
            imgUrl = reader.readString("img")
            originalName = reader.readString("originalName")
            numSeasons = reader.readInt32("numSeasons").toShort()

        }.build()


        reader.readEndDocument()

        return Season(commonName ?: "", link, info)
    }

    override fun getEncoderClass() = Season::class.java
}