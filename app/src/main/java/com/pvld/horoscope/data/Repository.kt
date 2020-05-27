package com.pvld.horoscope.data

import android.util.Log.i
import androidx.lifecycle.LiveData
import com.pvld.horoscope.data.database.Horoscope
import com.pvld.horoscope.data.mappers.HoroscopeEntityMapper
import com.pvld.horoscope.data.network.RetrofitClient
import com.pvld.horoscope.util.App
import com.pvld.horoscope.util.CONSTANTS.MY_LOG_ERROR
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


object Repository {

    private val retrofitClient = RetrofitClient.create()
    private val database = App.database.getHoroscopeDao()


    fun loadTodayHoroscope(): Unit {

        // TODO: better error handling
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = retrofitClient.loadToday()
                if (response.isSuccessful) {
                    val horoscopes = response.body()?.let { HoroscopeEntityMapper.from(it) }
                    if (horoscopes != null) {
                        database.insertMany(horoscopes)
                    }
                } else {
                    i(MY_LOG_ERROR, "Error: ${response.code()}")
                }
            } catch (e: Exception) {
                i(MY_LOG_ERROR, "Error: $e")
            }
        }
    }

    fun getAll(): LiveData<List<Horoscope>> {
        return database.getAll()
    }

    fun getSign(sign: String): LiveData<Horoscope> {
        return database.getSign(sign)
    }

}
