package entities

@NoArg
data class DistanceWithDuration(
    val distance: Distance,
    val duration: Duration,
)

@NoArg
data class Distance(
    val text: String,
    val value: Int,
)

@NoArg
data class Duration(
    val text: String,
    val value: Int,
)

