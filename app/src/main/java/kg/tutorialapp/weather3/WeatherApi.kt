package kg.tutorialapp.weather3

import kg.tutorialapp.weather3.ForeCast
import retrofit2.Call
import retrofit2.http.GET

interface WeatherApi {

    @GET("onecall?lat=42.882004&lon=74.582748&exclude=minutely&appid=2dc7a4a8bf32ea93b27312a966b83f18&lang=ru&units=metric")
    fun getWeather(): Call<ForeCast>

}