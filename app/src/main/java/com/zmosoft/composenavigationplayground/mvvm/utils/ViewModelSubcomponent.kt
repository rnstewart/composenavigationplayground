package com.zmosoft.composenavigationplayground.mvvm.utils

import com.zmosoft.composenavigationplayground.mvvm.viewmodels.HomeViewModel
import com.zmosoft.composenavigationplayground.mvvm.viewmodels.MainActivityViewModel
import com.zmosoft.composenavigationplayground.mvvm.viewmodels.MoviesViewModel
import com.zmosoft.composenavigationplayground.mvvm.viewmodels.WeatherViewModel
import dagger.Subcomponent

@Subcomponent
interface ViewModelSubcomponent {
    @Subcomponent.Builder
    interface Builder {
        fun build(): ViewModelSubcomponent
    }

    fun mainActivityViewModel(): MainActivityViewModel
    fun homeViewModel(): HomeViewModel
    fun moviesViewModel(): MoviesViewModel
    fun weatherViewModel(): WeatherViewModel
}