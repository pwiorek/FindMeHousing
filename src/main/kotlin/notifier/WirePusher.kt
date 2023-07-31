package notifier

import entities.Notification
import entities.WirePusherNotification
import okhttp3.OkHttpClient
import okhttp3.Request

class WirePusher(private val id: String) : Notifier {
    private val client = OkHttpClient()

    override fun notify(content: Notification) {}

    fun notify(content: WirePusherNotification) {
        val request = Request.Builder()
            .url("https://wirepusher.com/send?id=$id" +
                "&title=${content.title}" +
                "&message=${content.message}" +
                "&type=${content.type}")
            .get()
            .build()

        client.newCall(request).execute()
    }
}