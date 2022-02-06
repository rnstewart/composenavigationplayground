package com.zmosoft.composenavigationplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.zmosoft.composenavigationplayground.ui.compose.MainScreen
import com.zmosoft.composenavigationplayground.ui.theme.ComposeNavigationPlaygroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeNavigationPlaygroundTheme {
                MainScreen()
            }
        }
    }
}
