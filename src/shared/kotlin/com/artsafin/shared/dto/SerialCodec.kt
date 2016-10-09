package com.artsafin.shared.dto

import org.bson.BsonReader
import org.bson.BsonWriter
import org.bson.codecs.Codec
import org.bson.codecs.DecoderContext
import org.bson.codecs.EncoderContext

class SerialCodec: Codec<Serial> {
    override fun encode(writer: BsonWriter?, value: Serial?, encoderContext: EncoderContext?) {
        writer?.writeStartDocument()
        writer?.writeString("_id", value?.name)
        writer?.writeString("name", value?.name)
        writer?.writeString("image", value?.image)
        writer?.writeEndDocument()
    }

    override fun decode(reader: BsonReader?, decoderContext: DecoderContext?): Serial {
        val ds = reader?.readStartDocument()
        val _id = reader?.readString("_id")
        val image = reader?.readString("image")
        val name = reader?.readString("name")

        val de = reader?.readEndDocument()

        return Serial(name ?: "", image ?: "")
    }

    override fun getEncoderClass() = Serial::class.java
}