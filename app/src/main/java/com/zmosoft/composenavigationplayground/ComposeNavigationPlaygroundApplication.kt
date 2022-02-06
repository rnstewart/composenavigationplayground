package com.zmosoft.composenavigationplayground

import android.app.Application
import com.zmosoft.composenavigationplayground.di.AppModule
import com.zmosoft.composenavigationplayground.di.ApplicationComponent
import com.zmosoft.composenavigationplayground.di.DaggerApplicationComponent

class ComposeNavigationPlaygroundApplication : Application() {
    lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerApplicationComponent.builder()
            .appModule(AppModule(this))
            .build().apply {
                inject(this@ComposeNavigationPlaygroundApplication)
            }
    }
}