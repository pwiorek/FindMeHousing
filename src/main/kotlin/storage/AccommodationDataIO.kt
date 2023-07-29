package storage

import com.fasterxml.jackson.databind.JsonNode
import entities.Accommodation
import request.Converter
import java.io.File

class AccommodationDataIO {
    companion object {
        private const val ACCOMMODATION_DATA = "./src/json/accommodation-data.json"

        fun writeToStorage(data: List<Accommodation>) {
            Converter.mapper.writeValue(File(ACCOMMODATION_DATA), data)
        }

        fun getFromStorage(): List<Accommodation> {
            val bufferedReader = File(ACCOMMODATION_DATA).bufferedReader()
            val accommodationsJson = bufferedReader.use { it.readText() }

            // TODO: Move to Converter
            return Converter.mapper
                .readTree(accommodationsJson)
                .asIterable()
                .map(JsonNode::toString)
                .map { Converter.mapper.readValue(it, Accommodation::class.java) }
        }

    }
}