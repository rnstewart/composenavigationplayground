package com.zmosoft.composenavigationplayground.ui.compose.home

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zmosoft.composenavigationplayground.api.models.WeatherData
import com.zmosoft.composenavigationplayground.mvvm.utils.MainScreenInterface
import com.zmosoft.composenavigationplayground.mvvm.viewmodels.WeatherViewModel
import com.zmosoft.composenavigationplayground.ui.theme.ComposeNavigationPlaygroundTheme

@Composable
fun WeatherScreen(
    modifier: Modifier = Modifier,
    weatherDataValues: WeatherViewModel.WeatherDataValues,
    mainScreenInterface: MainScreenInterface
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.white))
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val location = weatherDataValues.location
        val weatherData = weatherDataValues.weatherData

        Text(
            text = "What is your location?"
        )
        Row(
            modifier = Modifier.padding(top = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                modifier = Modifier.padding(end = 8.dp),
                value = location,
                onValueChange = {
                    mainScreenInterface.onWeatherLocationEntered(it)
                }
            )
            if (location.isNotEmpty()) {
                Button(
                    onClick = {
                        mainScreenInterface.onWeatherSearch(location)
                    }
                ) {
                    Text(text = "Check")
                }
            }
        }
        weatherData?.let {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    modifier = Modifier.padding(vertical = 23.dp),
                    text = "Here is today's weather:",
                    style = MaterialTheme.typography.h5
                )
                Row {
                    Text(
                        text = weatherData.getCurrentTempStr(LocalContext.current),
                        style = MaterialTheme.typography.h4
                    )
                    Column(
                        modifier = Modifier.padding(start = 8.dp)
                    ) {
                        Text(
                            text = weatherData.currentWeatherCondition,
                            style = MaterialTheme.typography.subtitle1
                        )
                        Text(
                            text = weatherData.currentWeatherDescription,
                            style = MaterialTheme.typography.subtitle1
                        )
                    }
                    Spacer(modifier = Modifier.weight(1.0f))
                }
            }
        }
        Spacer(modifier = Modifier.weight(1.0f))
    }
}

@Preview
@Composable
fun PreviewWeatherScreen() {
    ComposeNavigationPlaygroundTheme {
        WeatherScreen(
            weatherDataValues = WeatherViewModel.WeatherDataValues(
                location = "Albuquerque",
                weatherData = WeatherData(
                    main = WeatherData.Main(
                        temp = 305.0
                    ),
                    weather = listOf(
                        WeatherData.Weather(
                            main = "Clear"
                        )
                    )
                )
            ),
            mainScreenInterface = object: MainScreenInterface {
                override fun onHomeLoaded() {
                }

                override fun onWeatherLoaded() {
                }

                override fun onWeatherLocationEntered(location: String) {
                }

                override fun onWeatherSearch(location: String) {
                }
            }
        )
    }
}