package entities

annotation class NoArg

@NoArg
data class Accommodation(
    val id: Int,
    val title: String,
    val totalPrice: Price,
    val rentPrice: Price,
    val slug: String,
    val location: Location,
)

@NoArg
data class Price(
    val value: Int,
)

@NoArg
data class Location(
    val address: Address
)

@NoArg
data class Address(
    val mapDetails: MapDetails,
    val street: Street,
)

@NoArg
data class Street(
    val name: String,
    val number: String,
)

@NoArg
data class MapDetails(
    val radius: Int,
)