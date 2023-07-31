package notifier

import entities.Notification

interface Notifier {
    fun notify(content: Notification): Unit
}