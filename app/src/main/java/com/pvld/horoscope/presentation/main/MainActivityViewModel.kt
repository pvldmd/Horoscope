package com.pvld.horoscope.presentation.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.pvld.horoscope.data.Repository
import com.pvld.horoscope.data.database.Horoscope

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = Repository
    init {
        repository.loadTodayHoroscope()
    }

    fun getSign(sign: String): LiveData<Horoscope> {
        return repository.getSign(sign)
    }

}
