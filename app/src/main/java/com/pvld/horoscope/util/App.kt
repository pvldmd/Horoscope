package com.pvld.horoscope.util

import android.app.Application
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import androidx.room.Room
import com.facebook.stetho.Stetho
import com.pvld.horoscope.data.database.AppDatabase
import com.pvld.horoscope.di.components.AppComponent
import com.pvld.horoscope.di.components.DaggerAppComponent
import com.pvld.horoscope.util.CONSTANTS.DATABASE_NAME


class App : Application() {

    override fun onCreate() {
        super.onCreate()

        instance = this

        database = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            DATABASE_NAME
        ).build()

        preferences = PreferenceManager.getDefaultSharedPreferences(applicationContext)

        appComponent = DaggerAppComponent.create()

        Stetho.initializeWithDefaults(this)
    }

    companion object {
        lateinit var instance: App
            private set

        lateinit var database: AppDatabase
            private set

        lateinit var preferences: SharedPreferences
            private set

        lateinit var appComponent: AppComponent
            private set
    }


}