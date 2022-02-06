package com.zmosoft.composenavigationplayground

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.zmosoft.composenavigationplayground.ui.compose.MainScreen
import com.zmosoft.composenavigationplayground.ui.theme.ComposeNavigationPlaygroundTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeNavigationPlaygroundTheme {
                MainScreen()
            }
        }

        (applicationContext as ComposeNavigationPlaygroundApplication).appComponent.inject(this)
    }
}
