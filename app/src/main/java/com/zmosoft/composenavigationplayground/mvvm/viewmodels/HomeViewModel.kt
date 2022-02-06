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
    val date: MutableState<Date?> = mutableStateOf(null)

    fun init() {
        date.value = Date()
    }
}