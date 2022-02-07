package com.zmosoft.composenavigationplayground.ui.compose.utils

import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.zmosoft.composenavigationplayground.mvvm.utils.MainScreenInterface
import com.zmosoft.composenavigationplayground.mvvm.viewmodels.HomeViewModel
import com.zmosoft.composenavigationplayground.mvvm.viewmodels.WeatherViewModel
import com.zmosoft.composenavigationplayground.ui.compose.home.HomeScreen
import com.zmosoft.composenavigationplayground.ui.compose.home.WeatherScreen

fun NavGraphBuilder.loadRoute(
    navController: NavController,
    backStackEntry: NavBackStackEntry?,
    mainScreenInterface: MainScreenInterface,
    homeData: HomeViewModel.HomeData,
    weatherDataValues: WeatherViewModel.WeatherDataValues
) {
    composable(NavConstants.NavItem.HOME.route) {
        mainScreenInterface.onHomeLoaded()
        HomeScreen(homeData = homeData)
    }
    composable(NavConstants.NavItem.WEATHER.route) {
        mainScreenInterface.onWeatherLoaded()
        WeatherScreen(
            weatherDataValues = weatherDataValues,
            mainScreenInterface = mainScreenInterface
        )
    }
    composable(NavConstants.NavItem.MOVIES.route) {

    }
}