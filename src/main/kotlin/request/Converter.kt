package request

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import entities.Accommodation

class Converter {
    companion object {
        val mapper = ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

        fun getAccommodationObject(json: String): List<Accommodation> = mapper
            .readTree(json)
            .getItems()
            .asIterable()
            .map(JsonNode::toString)
            .map { mapper.readValue(it, Accommodation::class.java) }


        private fun JsonNode.getItems() = get("pageProps").get("data").get("searchAds").get("items")
    }
}