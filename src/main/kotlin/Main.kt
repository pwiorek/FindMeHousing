import request.Converter
import request.DataFetcher


fun main() {
    val url = "https://www.otodom.pl/_next/data/osorc0pDBk5XiqrQDP--W/pl/oferty/wynajem/mieszkanie%2C3-pokoje/poznan.json?distanceRadius=0&page=1&limit=36&locations=%5Bcities_6-1%5D&by=DEFAULT&direction=DESC&viewType=listing&searchingCriteria=wynajem&searchingCriteria=mieszkanie%2C3-pokoje&searchingCriteria=poznan"
    val response = DataFetcher.fetch(url)

    println(Converter.getAccommodationObject(response.body!!.string()))
}

