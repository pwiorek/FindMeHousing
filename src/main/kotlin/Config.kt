import java.util.*

class Config {
    companion object {
        private val file = this::class.java.classLoader.getResourceAsStream("secrets.properties")
        private val props = Properties()

        val MAPS_API_KEY = getProperty("MAPS_API_KEY")
        val WIRE_PUSHER_KEY = getProperty("WIRE_PUSHER_KEY")

        private fun getProperty(name: String): String {
            props.load(file)
            return props.getProperty(name)
        }
    }
}