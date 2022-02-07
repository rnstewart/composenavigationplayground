package com.zmosoft.composenavigationplayground.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.zmosoft.composenavigationplayground.ComposeNavigationPlaygroundApplication
import com.zmosoft.composenavigationplayground.mvvm.utils.MainScreenInterface
import com.zmosoft.composenavigationplayground.mvvm.viewmodels.WeatherViewModel
import com.zmosoft.composenavigationplayground.ui.compose.home.WeatherScreen
import com.zmosoft.composenavigationplayground.ui.theme.ComposeNavigationPlaygroundTheme
import javax.inject.Inject

class WeatherFragment : Fragment() {
    @Inject
    lateinit var weatherViewModel: WeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(inflater.context).apply {
            setContent {
                ComposeNavigationPlaygroundTheme {
                    WeatherScreen(
                        weatherDataValues = weatherViewModel.weatherDataValues.value,
                        mainScreenInterface = object: MainScreenInterface {
                            override fun onHomeLoaded() {
                            }

                            override fun onWeatherLoaded() {
                            }

                            override fun onWeatherLocationEntered(location: String) {
                                weatherViewModel.weatherDataValues.value = weatherViewModel.weatherDataValues.value.copy(
                                    location = location
                                )
                            }

                            override fun onWeatherSearch(location: String) {
                                weatherViewModel.checkWeather(location)
                            }
                        }
                    )
                }
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        (context.applicationContext as ComposeNavigationPlaygroundApplication)
            .appComponent.inject(this)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            WeatherFragment()
    }
}