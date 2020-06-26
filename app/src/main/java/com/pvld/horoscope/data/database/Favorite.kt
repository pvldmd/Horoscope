package com.pvld.horoscope.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite")
data class Favorite(

    var sign: String,

    var date: String,

    var text: String

) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}