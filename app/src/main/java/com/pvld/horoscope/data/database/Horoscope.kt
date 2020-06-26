package com.pvld.horoscope.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "horoscope")
data class Horoscope(

    @PrimaryKey(autoGenerate = false)
    var sign: String,

    var dateYesterday: String,

    var dateToday: String,

    var dateTommorow: String,

    var dateTommorow02: String,

    var horoscopeYesterday: String,

    var horoscopeToday: String,

    var horoscopeTommorow: String,

    var horoscopeTommorow02: String
)