package com.zmosoft.composenavigationplayground.mvvm.viewmodels

import androidx.lifecycle.AndroidViewModel
import com.zmosoft.composenavigationplayground.ComposeNavigationPlaygroundApplication
import javax.inject.Inject

class MoviesViewModel @Inject constructor(
    app: ComposeNavigationPlaygroundApplication
): AndroidViewModel(app) {
}