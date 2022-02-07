package com.zmosoft.composenavigationplayground.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.zmosoft.composenavigationplayground.mvvm.utils.MainScreenInterface
import com.zmosoft.composenavigationplayground.mvvm.viewmodels.HomeViewModel
import com.zmosoft.composenavigationplayground.mvvm.viewmodels.WeatherViewModel
import com.zmosoft.composenavigationplayground.ui.compose.utils.NavConstants
import com.zmosoft.composenavigationplayground.ui.compose.utils.loadRoute
import com.zmosoft.composenavigationplayground.ui.theme.ComposeNavigationPlaygroundTheme

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    mainScreenInterface: MainScreenInterface,
    homeData: HomeViewModel.HomeData,
    weatherDataValues: WeatherViewModel.WeatherDataValues
) {
    val scaffoldState = rememberScaffoldState()
    val navController = rememberNavController()

    val currentRoute = navController
        .currentBackStackEntryFlow
        .collectAsState(initial = navController.currentBackStackEntry)

    Scaffold(
        modifier = modifier,
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Compose Navigation")
                }
            )
        },
        bottomBar = {
            BottomNavigation {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val route = navBackStackEntry?.destination?.route ?: NavConstants.NavItem.HOME.route

                NavConstants.NavItem.values().forEach { navItem ->
                    BottomNavigationItem(
                        selected = (route == navItem.route),
                        label = {
                            Text(text = navItem.label)
                        },
                        onClick = {
                            navController.navigate(navItem.route)
                        },
                        icon = {
                            Image(
                                painter = painterResource(id = navItem.iconRes),
                                contentDescription = null
                            )
                        }
                    )
                }
            }
        },
        floatingActionButton = {

        },
        content = {
            NavHost(
                navController = navController,
                startDestination = NavConstants.NavItem.HOME.route
            ) {
                loadRoute(
                    navController = navController,
                    backStackEntry = currentRoute.value,
                    mainScreenInterface = mainScreenInterface,
                    homeData = homeData,
                    weatherDataValues = weatherDataValues
                )
            }
        }
    )
}

@Preview
@Composable
fun PreviewMainScreen() {
    ComposeNavigationPlaygroundTheme {
        MainScreen(
            mainScreenInterface = object: MainScreenInterface {
                override fun onHomeLoaded() {
                }

                override fun onWeatherLoaded() {
                }

                override fun onWeatherLocationEntered(location: String) {
                }

                override fun onWeatherSearch(location: String) {
                }
            },
            homeData = HomeViewModel.HomeData(),
            weatherDataValues = WeatherViewModel.WeatherDataValues()
        )
    }
}