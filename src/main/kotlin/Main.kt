import utilities.AccommodationFinder
import utilities.Scheduler

fun main() {
    val url = "https://www.otodom.pl/_next/data/VeDas2FQaFynhapWCQjf1/pl/oferty/wynajem/mieszkanie%2C3-pokoje/poznan.json?distanceRadius=0&page=1&limit=36&locations=%5Bcities_6-1%5D&by=DEFAULT&direction=DESC&viewType=listing&searchingCriteria=wynajem&searchingCriteria=mieszkanie%2C3-pokoje&searchingCriteria=poznan"

    Scheduler.run { AccommodationFinder.getNewAccommodations(url) }

}

