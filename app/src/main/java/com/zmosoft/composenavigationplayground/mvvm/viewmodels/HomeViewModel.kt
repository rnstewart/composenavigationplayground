package com.zmosoft.composenavigationplayground.mvvm.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import com.zmosoft.composenavigationplayground.ComposeNavigationPlaygroundApplication
import java.util.*
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    app: ComposeNavigationPlaygroundApplication
): AndroidViewModel(app) {
    data class HomeData(
        val date: Date? = null
    )

    val homeData = mutableStateOf(HomeData())

    fun init() {
        homeData.value = homeData.value.copy(
            date = Date()
        )
    }
}