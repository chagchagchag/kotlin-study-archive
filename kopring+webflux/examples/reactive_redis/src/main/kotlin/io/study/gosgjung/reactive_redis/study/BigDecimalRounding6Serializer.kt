package io.study.gosgjung.reactive_redis.study

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import java.math.BigDecimal
import java.math.RoundingMode

class BigDecimalRounding6Serializer : JsonSerializer<BigDecimal>(){

    companion object {
        const val SCALE_SIX = 6
        val ROUNDING_MODE = RoundingMode.HALF_EVEN
    }

    override fun serialize(value: BigDecimal?, gen: JsonGenerator?, serializers: SerializerProvider?) {
//        MediaType
//        ResponseEntity
        gen?.writeString(value?.setScale(SCALE_SIX, ROUNDING_MODE).toString())
    }

}