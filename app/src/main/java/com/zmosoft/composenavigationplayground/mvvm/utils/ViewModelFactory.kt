package com.zmosoft.composenavigationplayground.mvvm.utils

import com.zmosoft.composenavigationplayground.mvvm.viewmodels.HomeViewModel
import com.zmosoft.composenavigationplayground.mvvm.viewmodels.MainActivityViewModel
import com.zmosoft.composenavigationplayground.mvvm.viewmodels.MoviesViewModel
import com.zmosoft.composenavigationplayground.mvvm.viewmodels.WeatherViewModel
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class ViewModelFactory @Inject constructor(viewModelSubcomponent: ViewModelSubcomponent) :
    ViewModelFactoryBase(
        mapOf(
            MainActivityViewModel::class.java to { viewModelSubcomponent.mainActivityViewModel() },
            HomeViewModel::class.java to { viewModelSubcomponent.homeViewModel() },
            WeatherViewModel::class.java to { viewModelSubcomponent.weatherViewModel() },
            MoviesViewModel::class.java to { viewModelSubcomponent.moviesViewModel() }
        )
    )