package com.pvld.horoscope.ui.horoscope

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.pvld.horoscope.data.Repository
import javax.inject.Inject

class HoroscopeViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    val currentSign: LiveData<String> = repository.getCurrentSign()

}