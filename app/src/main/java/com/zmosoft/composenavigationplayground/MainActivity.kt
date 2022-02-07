package com.zmosoft.composenavigationplayground

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.zmosoft.composenavigationplayground.mvvm.viewmodels.MainActivityViewModel
import com.zmosoft.composenavigationplayground.ui.compose.MainScreen
import com.zmosoft.composenavigationplayground.ui.theme.ComposeNavigationPlaygroundTheme
import com.zmosoft.composenavigationplayground.utils.hideSoftKeyboard
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (applicationContext as ComposeNavigationPlaygroundApplication).appComponent.inject(this)

        setContent {
            ComposeNavigationPlaygroundTheme {
                mainActivityViewModel.apply {
                    MainScreen(
                        mainScreenInterface = mainScreenInterface,
                        homeData = homeViewModel.homeData.value,
                        weatherDataValues = weatherViewModel.weatherDataValues.value
                    )
                }
            }
        }

        mainActivityViewModel.hideKeyboard = {
            hideSoftKeyboard()
        }
    }
}
