import kotlin.time.Duration.Companion.seconds

class Scheduler {
    companion object {
        private val MIN_DELAY_BETWEEN_REQUESTS = 5.seconds
        private val MAX_DELAY_BETWEEN_REQUESTS = 6.seconds

        private fun getDelay() = MIN_DELAY_BETWEEN_REQUESTS +
                (MAX_DELAY_BETWEEN_REQUESTS - MIN_DELAY_BETWEEN_REQUESTS) * Math.random()

        fun run(callback: () -> Unit) {
            while (true) {
                callback()
                Thread.sleep(getDelay().inWholeMilliseconds)
            }
        }
    }
}