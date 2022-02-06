package com.zmosoft.composenavigationplayground.mvvm.utils

import com.zmosoft.composenavigationplayground.mvvm.viewmodels.MainActivityViewModel
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class ViewModelFactory @Inject constructor(viewModelSubcomponent: ViewModelSubcomponent) :
    ViewModelFactoryBase(
        mapOf(
            MainActivityViewModel::class.java to { viewModelSubcomponent.mainActivityViewModel() }
        )
    )