package utilities

import java.io.InputStream
import java.util.*

class Config {
    companion object {
        private val secretsProps = this::class.java.classLoader.getResourceAsStream("secrets.properties")
        private val appProps = this::class.java.classLoader.getResourceAsStream("application.properties")
        private val props = Properties()

        // SECRETS
        val MAPS_API_KEY = getProperty("MAPS_API_KEY", secretsProps)
        val WIRE_PUSHER_KEY = getProperty("WIRE_PUSHER_KEY", secretsProps)

        // APP PROPS
        val OTODOM_BASE_URL = getProperty("OTODOM_BASE_URL", appProps)
        val OTODOM_URL = getProperty("OTODOM_URL", appProps)
        val OTODOM_COOKIE = getProperty("OTODOM_COOKIE", appProps)
        val ORIGIN_ADDRESS = getProperty("ORIGIN_ADDRESS", appProps)
        val DESIRED_DISTANCE = getProperty("DESIRED_DISTANCE", appProps)

        private fun getProperty(name: String, source: InputStream?): String {
            props.load(source)
            return props.getProperty(name)
        }
    }
}