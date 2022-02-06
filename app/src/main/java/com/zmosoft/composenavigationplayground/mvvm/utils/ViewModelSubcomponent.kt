package com.zmosoft.composenavigationplayground.mvvm.utils

import com.zmosoft.composenavigationplayground.mvvm.viewmodels.MainActivityViewModel
import dagger.Subcomponent

@Subcomponent
interface ViewModelSubcomponent {
    @Subcomponent.Builder
    interface Builder {
        fun build(): ViewModelSubcomponent
    }

    fun mainActivityViewModel(): MainActivityViewModel
}