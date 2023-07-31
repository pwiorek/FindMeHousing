package utilities

import converters.AccommodationConverter
import converters.DistanceConverter
import entities.Accommodation
import entities.WirePusherNotification
import fetchers.AccommodationsFetcher
import fetchers.DistanceFetcher
import notifier.WirePusher
import storage.AccommodationDataComparator
import storage.AccommodationDataIO

class AccommodationFinder {
    companion object {
        private fun isInDistanceRange(accommodation: Accommodation, distanceInMeters: Int): Boolean {
            val location = accommodation.locationLabel.value;
            if (location.isEmpty()) return false;

            val distanceResponse = DistanceFetcher.fetch(location, Config.ORIGIN_ADDRESS)
            val (distance) = DistanceConverter.getDistanceObject(distanceResponse.body!!.string())

            return distance.value <= distanceInMeters
        }

        fun getNewAccommodations(url: String) {
            val accommodationResponse = AccommodationsFetcher.fetch(url)
            val accommodations = AccommodationConverter.getAccommodationObjects(accommodationResponse.body!!.string())
            val newAccommodations = AccommodationDataComparator.getNewAccommodations(AccommodationDataIO.getFromStorage(), accommodations)

            AccommodationDataIO.writeToStorage(accommodations)

            newAccommodations.forEach {
              if (!isInDistanceRange(it, Config.DESIRED_DISTANCE.toInt())) return;

                val title = "${it.totalPrice.value + (it.rentPrice.value ?: 0)}zł - " +
                        "${it.location.address.street.name} ${it.location.address.street.number ?: ""}\n"

                val message =  "${it.title} " + "Link: ${Config.OTODOM_BASE_URL}${it.slug}"

                val wirePusher = WirePusher(Config.WIRE_PUSHER_KEY)
                wirePusher.notify(WirePusherNotification(title, message, "Accommodation"))
            }
        }
    }
}