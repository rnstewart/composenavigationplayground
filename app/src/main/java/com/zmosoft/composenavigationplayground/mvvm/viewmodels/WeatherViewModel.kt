package com.zmosoft.composenavigationplayground.mvvm.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.zmosoft.composenavigationplayground.ComposeNavigationPlaygroundApplication
import com.zmosoft.composenavigationplayground.api.OpenWeatherService
import com.zmosoft.composenavigationplayground.api.models.WeatherData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class WeatherViewModel @Inject constructor(
    app: ComposeNavigationPlaygroundApplication,
    private val weatherService: OpenWeatherService
): AndroidViewModel(app) {
    data class WeatherDataValues(
        val location: String = "",
        val weatherData: WeatherData? = null
    )

    fun init() {

    }

    val weatherDataValues = mutableStateOf(WeatherDataValues())

    fun checkWeather(location: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = weatherService.getCurrentWeatherDataByCity(city = location)
            weatherDataValues.value = weatherDataValues.value.copy(
                weatherData = result.body()
            )
        }
    }
}