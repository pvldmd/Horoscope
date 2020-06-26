package com.pvld.horoscope.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pvld.horoscope.util.CONSTANTS.DATABASE_VERSION

@Database(
    entities = [Horoscope::class, Favorite::class],
    version = DATABASE_VERSION
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getHoroscopeDao(): HoroscopeDao

    abstract fun getFavoriteDao(): FavoriteDao
}