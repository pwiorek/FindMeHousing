package converters

import com.fasterxml.jackson.databind.JsonNode
import entities.Accommodation

class AccommodationConverter {
    companion object {
        fun getAccommodationObjects(json: String): List<Accommodation> = Converter.mapper
            .readTree(json)
            .getItems()
            .asIterable()
            .map(JsonNode::toString)
            .map { Converter.mapper.readValue(it, Accommodation::class.java) }

        private fun JsonNode.getItems() = get("pageProps").get("data").get("searchAds").get("items")
    }
}