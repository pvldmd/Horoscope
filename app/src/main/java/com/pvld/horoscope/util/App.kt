package com.pvld.horoscope.util

import android.app.Application
import androidx.room.Room
import com.facebook.stetho.Stetho
import com.pvld.horoscope.data.database.AppDatabase
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

        Stetho.initializeWithDefaults(this);
    }

    companion object {
        lateinit var instance: App
        private set

        lateinit var database: AppDatabase
        private set
    }


}