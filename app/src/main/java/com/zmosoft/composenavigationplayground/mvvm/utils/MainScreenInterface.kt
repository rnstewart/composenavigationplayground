package com.zmosoft.composenavigationplayground.mvvm.utils

interface MainScreenInterface {
    fun onHomeLoaded()
    fun onWeatherLoaded()
    fun onWeatherLocationEntered(location: String)
    fun onWeatherSearch(location: String)
}