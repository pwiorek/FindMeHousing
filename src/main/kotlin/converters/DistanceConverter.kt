package converters

import com.fasterxml.jackson.databind.JsonNode
import entities.DistanceWithDuration

class DistanceConverter {
    companion object {

        fun getDistanceObject(json: String): DistanceWithDuration = Converter.mapper
            .readTree(json)
            .getItems()
            .asIterable()
            .map(JsonNode::toString)
            .map { Converter.mapper.readValue(it, DistanceWithDuration::class.java) }
            .first()

        private fun JsonNode.getItems() = get("rows").first().get("elements")
    }
}