package com.pvld.horoscope.ui.horoscope

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.pvld.horoscope.data.Repository

class HoroscopeViewModel : ViewModel() {

    val currentSign: LiveData<String> = Repository.getCurrentSign()

}