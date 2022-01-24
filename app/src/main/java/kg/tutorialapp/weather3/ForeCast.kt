package kg.tutorialapp.weather3

import java.io.FileDescriptor
import java.util.*

data class ForeCast(
    var lat: Double? = null,
    var lon: Double? = null,
    var timeZone: String? = null,
    var timezone_offset: Long? = 0L,
    var curren: CurrentForeCast? = null,
    var hourly: List<HourlyForeCast>,
    var daily: List<DailyForeCast>

)
data class CurrentForeCast(
    //@SerializedName("dt")
    var dt:Long?=null,
    var sunrise: Long? = null,
    var sunset: Long? = null,
    var temp: Double? = null,
    var feels_like: Double? = null,
    var humidity: Int? = null,
    var weather: List<Weather>


)
data class Weather(
    var id:Long?= null,
    var description: String? = null,
    var icon: String? = null,
)
data class HourlyForeCast(
    var dt:Long?=null,
    var temp: Double? = null,
    var weather: List<Weather>,
    var pop: Double? = null
)
data class DailyForeCast(
    var dt:Long?=null,
    var temp: Temperature? = null,
    var weather: List<Weather>? = null,
    var pop: Double? = null
)
data class Temperature(
    var min: Double? = null,
    var max: Double? = null
)
