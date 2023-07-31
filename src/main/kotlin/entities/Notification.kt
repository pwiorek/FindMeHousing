package entities

interface Notification

data class WirePusherNotification(
    val title: String,
    val message: String,
    val type: String,
) : Notification

