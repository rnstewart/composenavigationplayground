package com.zmosoft.composenavigationplayground.api.models

import android.content.Context
import com.google.gson.annotations.SerializedName
import com.zmosoft.composenavigationplayground.R
import com.zmosoft.composenavigationplayground.utils.Constants
import com.zmosoft.composenavigationplayground.utils.kelvinToFahrenheit
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.roundToInt

data class WeatherData(
    var id: Long? = null,
    var name: String? = null,
    var cod: Int? = null,
    var coord: Coord? = null,
    var weather: List<Weather>? = null,
    var sys: Sys? = null,
    var base: String? = null,
    var main: Main? = null,
    var visibility: Double? = null,
    var wind: Wind? = null,
    var rain: Rain? = null,
    var dt: Long? = null,
    var timeZone: Long? = null
) {
    private val timeFormat = SimpleDateFormat(Constants.TIME_FORMAT, Locale.getDefault()).apply {
        timeZone = TimeZone.getDefault()
    }

    val timeZoneHours: Int?
        get() = timeZone?.toDouble()?.let {
            it / (3600.0)
        }?.roundToInt()

    data class Coord (
        var lon: Double? = null,
        var lat: Double? = null
    )

    data class Weather (
        var id: Long? = null,
        var main: String? = null,
        var description: String? = null,
        var icon: String? = null
    )
    
    data class Main(
        var temp: Double? = null,
        var pressure: Double? = null,
        var humidity: Double? = null,
        @SerializedName("temp_min")
        var tempMin: Double? = null,
        @SerializedName("temp_max")
        var tempMax: Double? = null,
    )

    data class Wind (
        var speed: Double? = null,
        var deg: Int? = null,
    )

    data class Rain (
        @SerializedName("1h")
        var oneH: Double? = null,
    )

    data class Clouds (
        var all: Double? = null,
    )

    data class Sys (
        var type: Int? = null,
        var id: Long? = null,
        var country: String? = null,
        var sunrise: Long? = null,
        var sunset: Long? = null,
    )


    fun getCurrentTempStr(context: Context?): String {
        return context?.let {
            main?.temp?.kelvinToFahrenheit()?.roundToInt()?.let {
                context.getString(
                    R.string.temperature_x,
                    it
                )
            }
        } ?: ""
    }

    val currentWeatherCondition: String
        get() = weather?.getOrNull(0)?.main ?: ""

    val currentWeatherDescription: String
        get() = weather?.getOrNull(0)?.description ?: ""

    fun getSunriseStr(): String? {
        return sys?.sunrise?.let {
            timeFormat.format(Date(it * 1000))
        } ?: run {
            null
        }
    }

    fun getSunsetStr(): String? {
        val sunset = sys?.sunset
        return sunset?.let {
            timeFormat.format(Date(sunset * 1000))
        } ?: run {
            null
        }
    }

    val sunriseIcon: Int
        get() = R.drawable.ic_sunrise_32dp

    val sunsetIcon: Int
        get() = R.drawable.ic_sunset_32dp

    val windIcon: Int
        get() = R.drawable.ic_wind_32dp

    private fun getWindDirectionString(deg: Int?): String {
        return deg?.toDouble()?.let {
            when {
                (deg >= 22.5 && deg < 67.5) -> "NE"
                (deg >= 67.5 && deg < 112.5) -> "E"
                (deg >= 112.5 && deg < 157.5) -> "SE"
                (deg >= 157.5 && deg < 202.5) -> "S"
                (deg >= 202.5 && deg < 247.5) -> "SW"
                (deg >= 247.5 && deg < 292.5) -> "W"
                (deg >= 292.5 && deg < 337.5) -> "W"
                else -> "N"
            }
        } ?: ""
    }

    fun getWindStr(context: Context): String? {
        return wind?.let {
            val dir = getWindDirectionString(it.deg)
            if (dir.isNotEmpty())
                context.getString(
                    R.string.wind_info_direction,
                    dir,
                    it.speed
                )
            else
                context.getString(
                    R.string.wind_info,
                    it.speed
                )
        }
    }

    fun getWeatherIconUrl(context: Context): String? {
        val icon = weather?.getOrNull(0)?.icon
        return if (icon?.isNotEmpty() == true) {
            val density = context.getString(R.string.icon_factor)
            "$ICON_URL_BASE$icon@${density}x.png"
        } else {
            null
        }
    }

    companion object {
        const val ICON_URL_BASE = "https://openweathermap.org/img/wn/"
    }
}