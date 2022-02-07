package com.zmosoft.composenavigationplayground.api

import com.zmosoft.composenavigationplayground.api.models.WeatherData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherService {

    @GET("weather")
    suspend fun getCurrentWeatherDataByCity(@Query("q") city: String): Response<WeatherData>

    @GET("weather")
    suspend fun getCurrentWeatherDataByLatLong(@Query("lat") lat: Double, @Query("lon") long: Double): Response<WeatherData>

}