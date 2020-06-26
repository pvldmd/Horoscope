package com.pvld.horoscope.data.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface FavoriteDao {

    @Query("SELECT * FROM favorite ORDER BY date DESC")
    suspend fun getAll(): List<Favorite>

    @Query("SELECT * FROM favorite WHERE sign = :sign AND date = :date")
    fun getOne(sign: String, date: String): LiveData<List<Favorite>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(favorite: Favorite)

    @Delete
    fun delete(favorite: Favorite)

    @Query("DELETE from favorite WHERE sign = (:sign) AND date = (:date)")
    suspend fun deleteBySignAndDate(sign: String, date: String): Int

}