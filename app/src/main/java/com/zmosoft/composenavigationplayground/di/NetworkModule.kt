package com.zmosoft.composenavigationplayground.di

import android.content.Context
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.zmosoft.composenavigationplayground.api.APIOpenWeather
import com.zmosoft.composenavigationplayground.api.OpenWeatherService
import com.zmosoft.composenavigationplayground.config.APIKeys
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

@Module
class NetworkModule() {

    @Provides
    fun provideApiKeys(context: Context): APIKeys {
        return APIKeys.load(context)
    }

    @Provides
    @Named("okhttp.openweather")
    fun provideOkHttpClientOpenWeather(apiKeys: APIKeys): OkHttpClient {
        return OkHttpClient.Builder().apply {
            addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.HEADERS
            })
            addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            addInterceptor { chain ->
                chain.proceed(
                    chain.request().newBuilder()
                        .header("X-RapidAPI-Host", apiKeys.openWeatherMap.apiHost)
                        .header("X-RapidAPI-Key", apiKeys.openWeatherMap.apiKey)
                        .build()
                )
            }
        }.build()
    }

    @Provides
    @Named("okhttp.googlemaps")
    fun provideOkHttpClientGoogleMaps(apiKeys: APIKeys): OkHttpClient {
        return OkHttpClient.Builder().apply {
            addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.HEADERS
            })
            addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            addInterceptor { chain ->
                val original = chain.request()
                chain.proceed(
                    original.newBuilder().url(
                        original.url
                            .newBuilder()
                            .addQueryParameter("key", apiKeys.googleMaps.apiKey)
                            .build()
                    ).build()
                )
            }
        }.build()
    }

    @Suppress("ConstantConditionIf")
    @Provides
    fun provideOpenWeatherRetrofitService(@Named("okhttp.openweather") httpClient: OkHttpClient): OpenWeatherService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL_OPEN_WEATHER)
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder().create()
                )
            )
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(httpClient)
            .build()
            .create<OpenWeatherService>(OpenWeatherService::class.java)
    }

    @Provides
    fun provideApiOpenWeather(context: Context, service: OpenWeatherService): APIOpenWeather {
        return APIOpenWeather(context, service)
    }

    companion object {
        const val BASE_URL_OPEN_WEATHER = "https://community-open-weather-map.p.rapidapi.com"
        const val BASE_URL_GOOGLE_MAPS = "https://maps.googleapis.com/maps/api/"
    }
}