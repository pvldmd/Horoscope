package com.pvld.horoscope.data

import android.content.SharedPreferences
import android.util.Log.i
import androidx.lifecycle.LiveData
import com.pvld.horoscope.data.database.AppDatabase
import com.pvld.horoscope.data.database.Favorite
import com.pvld.horoscope.data.database.Horoscope
import com.pvld.horoscope.data.mappers.FavoritesMapper
import com.pvld.horoscope.data.mappers.HoroscopeEntityMapper
import com.pvld.horoscope.data.model.FavoriteItem
import com.pvld.horoscope.data.network.HoroscopeApi
import com.pvld.horoscope.data.preferences.SharedPreferenceStringLiveData
import com.pvld.horoscope.util.CONSTANTS.MY_LOG_ERROR
import com.pvld.horoscope.util.CONSTANTS.PREFS_CURRENT_SIGN
import com.pvld.horoscope.util.CONSTANTS.PREFS_CURRENT_SIGN_DEFAULT
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


class Repository @Inject constructor(
    private val retrofitApi: HoroscopeApi,
    private val database: AppDatabase,
    private val preferences: SharedPreferences
) {

    fun loadActualHoroscope(): Unit {
        // TODO: better error handling
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = retrofitApi.loadToday()
                if (response.isSuccessful) {
                    val horoscopes = response.body()?.let { HoroscopeEntityMapper.from(it) }
                    if (horoscopes != null) {
                        database.getHoroscopeDao().insertMany(horoscopes)
                    }
                } else {
                    i(MY_LOG_ERROR, "Error: ${response.code()}")
                }
            } catch (e: Exception) {
                i(MY_LOG_ERROR, "Error: $e")
            }
        }
    }

    fun getAllData(): LiveData<List<Horoscope>> {
        return database.getHoroscopeDao().getAll()
    }

    fun getSignData(sign: String): LiveData<Horoscope> {
        return database.getHoroscopeDao().getSign(sign)
    }

    fun getCurrentSign(): LiveData<String> {
        return SharedPreferenceStringLiveData(PREFS_CURRENT_SIGN, PREFS_CURRENT_SIGN_DEFAULT)
    }

    fun setCurrentSign(sign: String) {
        preferences.edit().putString(PREFS_CURRENT_SIGN, sign).apply()
    }

    fun getPreferenceBoolean(key: String, defaultValue: Boolean): Boolean {
        return preferences.getBoolean(key, defaultValue)
    }

    fun setPreferenceBoolean(key: String, value: Boolean) {
        preferences.edit().putBoolean(key, value).apply()
    }

    suspend fun getAllFavorites(): List<FavoriteItem> {
        return FavoritesMapper.from(database.getFavoriteDao().getAll())
    }

    fun getOneFavorite(sign: String, date: String): LiveData<List<Favorite>> {
        return database.getFavoriteDao().getOne(sign, date)
    }

    suspend fun insertFavorite(favorite: Favorite) {
        database.getFavoriteDao().insert(favorite)
    }

    suspend fun deleteFavorite(sign: String, date: String) {
        database.getFavoriteDao().deleteBySignAndDate(sign, date)
    }

}
