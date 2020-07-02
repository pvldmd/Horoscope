package com.pvld.horoscope.ui.selectsign

import androidx.lifecycle.ViewModel
import com.pvld.horoscope.data.Repository
import javax.inject.Inject

class SelectSignViewModel @Inject constructor(private val repository: Repository): ViewModel() {

    fun setCurrentSign(sign: String) {
        repository.setCurrentSign(sign)
    }
}