package com.zmosoft.composenavigationplayground.ui.compose.utils

class NavConstants {
    enum class NavItem(val route: String, val label: String, val iconRes: Int) {
        HOME(
            route = "home",
            label = "Home",
            iconRes = android.R.drawable.ic_menu_help
        ),
        WEATHER(
            "weather",
            label = "Weather",
            iconRes = android.R.drawable.ic_menu_upload
        ),
        MOVIES(
            route = "movies",
            label = "Movies",
            iconRes = android.R.drawable.ic_media_play
        )
    }
}