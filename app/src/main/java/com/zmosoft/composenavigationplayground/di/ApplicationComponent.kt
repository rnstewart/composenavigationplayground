package com.zmosoft.composenavigationplayground.di

import com.zmosoft.composenavigationplayground.ComposeNavigationPlaygroundApplication
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class
])
interface ApplicationComponent {
    fun inject(application: ComposeNavigationPlaygroundApplication)
}