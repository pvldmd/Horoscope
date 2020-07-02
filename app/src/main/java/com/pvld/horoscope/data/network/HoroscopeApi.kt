package com.pvld.horoscope.data.network

import com.pvld.horoscope.data.network.entities.HoroscopeEntity
import retrofit2.Response
import retrofit2.http.GET

interface HoroscopeApi {


    @GET("daily/com.xml")
    suspend fun loadToday(): Response<HoroscopeEntity>

    @GET("weekly/cur.xml")
    suspend fun loadWeek(): Response<HoroscopeEntity>

}