package fetchers

import utilities.Config
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

class DistanceFetcher {
    companion object {
        private val client = OkHttpClient();

        fun fetch(destination: String, origin: String): Response {
            val request = Request.Builder()
                .url("https://maps.googleapis.com/maps/api/distancematrix/json" +
                        "?destinations=$destination" +
                        "&origins=$origin" +
                        "&key=${Config.MAPS_API_KEY}")
                .get()
                .build()

            return client.newCall(request).execute()
        }
    }
}