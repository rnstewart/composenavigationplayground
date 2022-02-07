package com.zmosoft.composenavigationplayground.api

import android.content.Context
import com.zmosoft.composenavigationplayground.R
import com.zmosoft.composenavigationplayground.api.models.WeatherData
import com.zmosoft.openweather.api.APICallsBase
import com.zmosoft.openweather.api.APIResponse

class APIOpenWeather(private val context: Context, private val service: OpenWeatherService): APICallsBase() {

    suspend fun getCurrentWeatherDataByCity(city: String?): APIResponse<WeatherData> {
        return if (city?.isNotEmpty() == true) {
            getResponse(service.getCurrentWeatherDataByCity(city))
        } else {
            getError(context.getString(R.string.error_no_city))
        }
    }

    suspend fun getCurrentWeatherDataByLatLong(lat: Double, long: Double): APIResponse<WeatherData> {
        return getResponse(service.getCurrentWeatherDataByLatLong(lat, long))
    }
}