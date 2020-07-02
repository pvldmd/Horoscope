package com.pvld.horoscope.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.pvld.horoscope.data.Repository
import com.pvld.horoscope.data.database.Horoscope
import com.pvld.horoscope.util.CONSTANTS.PREFS_FIRST_START
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    init {
        repository.loadActualHoroscope()
    }

    val horoscopeAllObservable: LiveData<List<Horoscope>> = repository.getAllData()

    fun isFirstLaunch(): Boolean {
        return repository.getPreferenceBoolean(PREFS_FIRST_START, true)
    }

    fun setFirstLaunchFalse() {
        repository.setPreferenceBoolean(PREFS_FIRST_START, false)
    }

}
