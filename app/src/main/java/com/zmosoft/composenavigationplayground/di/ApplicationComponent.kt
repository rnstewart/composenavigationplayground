package com.zmosoft.composenavigationplayground.di

import com.zmosoft.composenavigationplayground.ComposeNavigationPlaygroundApplication
import com.zmosoft.composenavigationplayground.MainActivity
import com.zmosoft.composenavigationplayground.ui.fragments.HomeFragment
import com.zmosoft.composenavigationplayground.ui.fragments.MoviesFragment
import com.zmosoft.composenavigationplayground.ui.fragments.WeatherFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class
])
interface ApplicationComponent {
    fun inject(application: ComposeNavigationPlaygroundApplication)
    fun inject(mainActivity: MainActivity)
    fun inject(homeFragment: HomeFragment)
    fun inject(weatherFragment: WeatherFragment)
    fun inject(moviesFragment: MoviesFragment)
}