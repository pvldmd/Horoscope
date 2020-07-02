package com.pvld.horoscope.data.network

import com.pvld.horoscope.util.CONSTANTS.RETROFIT_BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

object RetrofitClient {

    private var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(RETROFIT_BASE_URL)
        .addConverterFactory(SimpleXmlConverterFactory.create())
        .build()

    fun create(): HoroscopeApi {
        return retrofit.create<HoroscopeApi>(HoroscopeApi::class.java)
    }
}