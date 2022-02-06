package com.zmosoft.composenavigationplayground.mvvm.viewmodels

import androidx.lifecycle.AndroidViewModel
import com.zmosoft.composenavigationplayground.ComposeNavigationPlaygroundApplication
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    application: ComposeNavigationPlaygroundApplication
): AndroidViewModel(application) {
}