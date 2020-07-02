package com.pvld.horoscope.di.modules

import android.content.SharedPreferences
import com.pvld.horoscope.data.database.AppDatabase
import com.pvld.horoscope.data.network.HoroscopeApi
import com.pvld.horoscope.util.App
import com.pvld.horoscope.util.CONSTANTS
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideRetrofitClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(CONSTANTS.RETROFIT_BASE_URL)
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideApi(retrofit: Retrofit): HoroscopeApi {
        return retrofit.create<HoroscopeApi>(HoroscopeApi::class.java)
    }

    @Singleton
    @Provides
    fun provideDatabase(): AppDatabase {
        return App.database
    }

    @Singleton
    @Provides
    fun providePreferences(): SharedPreferences {
        return App.preferences
    }


}