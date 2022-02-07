package com.zmosoft.composenavigationplayground.config

import android.content.Context
import com.google.gson.Gson
import java.io.InputStreamReader

class APIKeys {
    val openWeatherMap: OpenWeatherMap = OpenWeatherMap()
    val googleMaps: GoogleMaps = GoogleMaps()

    class OpenWeatherMap {
        val apiKey = ""
        val apiHost = ""
    }

    class GoogleMaps {
        val apiKey = ""
    }

    companion object {
        fun load(context: Context): APIKeys {
            return context.assets?.open("config/apiKeys.json").use { stream ->
                Gson().fromJson(InputStreamReader(stream), APIKeys::class.java)
            }
        }
    }
}