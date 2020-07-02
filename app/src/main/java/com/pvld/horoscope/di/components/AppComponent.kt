package com.pvld.horoscope.di.components

import android.content.SharedPreferences
import com.pvld.horoscope.data.Repository
import com.pvld.horoscope.data.database.AppDatabase
import com.pvld.horoscope.data.network.HoroscopeApi
import com.pvld.horoscope.di.modules.AppModule
import com.pvld.horoscope.di.modules.ViewModelModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ViewModelModule::class])
interface AppComponent {

    fun getRepository(): Repository

    fun getApi(): HoroscopeApi

    fun getDatabase(): AppDatabase

    fun getPreferences(): SharedPreferences

}