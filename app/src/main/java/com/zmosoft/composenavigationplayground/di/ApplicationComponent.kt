package com.zmosoft.composenavigationplayground.di

import com.zmosoft.composenavigationplayground.ComposeNavigationPlaygroundApplication
import com.zmosoft.composenavigationplayground.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class
])
interface ApplicationComponent {
    fun inject(application: ComposeNavigationPlaygroundApplication)
    fun inject(mainActivity: MainActivity)
}