package com.zmosoft.composenavigationplayground.mvvm.viewmodels

import androidx.lifecycle.AndroidViewModel
import com.zmosoft.composenavigationplayground.ComposeNavigationPlaygroundApplication
import com.zmosoft.composenavigationplayground.mvvm.utils.MainScreenInterface
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    application: ComposeNavigationPlaygroundApplication,
    val homeViewModel: HomeViewModel,
    val weatherViewModel: WeatherViewModel
): AndroidViewModel(application) {
    var hideKeyboard: () -> Unit = {}

    val mainScreenInterface = object: MainScreenInterface {
        override fun onHomeLoaded() {
            homeViewModel.init()
        }

        override fun onWeatherLoaded() {
            weatherViewModel.init()
        }

        override fun onWeatherLocationEntered(location: String) {
            weatherViewModel.weatherDataValues.value = weatherViewModel.weatherDataValues.value.copy(
                location = location
            )
        }

        override fun onWeatherSearch(location: String) {
            hideKeyboard()
            weatherViewModel.checkWeather(location)
        }
    }
}