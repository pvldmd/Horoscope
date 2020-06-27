package com.pvld.horoscope.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.pvld.horoscope.data.Repository
import com.pvld.horoscope.data.database.Horoscope
import com.pvld.horoscope.util.CONSTANTS.PREFS_FIRST_START

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    init {
        Repository.loadActualHoroscope()
    }

    val horoscopeAllObservable: LiveData<List<Horoscope>> = Repository.getAllData()

    fun isFirstLaunch(): Boolean {
        return Repository.getPreferenceBoolean(PREFS_FIRST_START, true)
    }

    fun setFirstLaunchFalse() {
        Repository.setPreferenceBoolean(PREFS_FIRST_START, false)
    }

}
