package com.zmosoft.composenavigationplayground.di

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.zmosoft.composenavigationplayground.ComposeNavigationPlaygroundApplication
import com.zmosoft.composenavigationplayground.mvvm.utils.ViewModelFactory
import com.zmosoft.composenavigationplayground.mvvm.utils.ViewModelSubcomponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [ViewModelSubcomponent::class])
class AppModule(private val app: ComposeNavigationPlaygroundApplication) {
    @Singleton
    @Provides
    fun provideViewModelFactory(viewModelSubcomponent: ViewModelSubcomponent.Builder): ViewModelProvider.Factory {
        return ViewModelFactory(
            viewModelSubcomponent.build()
        )
    }

    @Provides
    fun provideApplication(): ComposeNavigationPlaygroundApplication {
        return app
    }

    @Provides
    fun provideContext(): Context {
        return app.applicationContext
    }
}