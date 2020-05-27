package com.pvld.horoscope.data.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface HoroscopeDao {

    // QUERY
    @Query("SELECT * FROM horoscope WHERE sign = :sign")
    fun getSign(sign: String): LiveData<Horoscope>

    @Query("SELECT * FROM horoscope")
    fun getAll(): LiveData<List<Horoscope>>


    // INSERT
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(sign: Horoscope)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMany(signs: List<Horoscope>)


    // UPDATE
    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(sign: Horoscope)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateMany(signs: List<Horoscope>)

}