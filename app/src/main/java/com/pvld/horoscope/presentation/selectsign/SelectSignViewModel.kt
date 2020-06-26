package com.pvld.horoscope.presentation.selectsign

import androidx.lifecycle.ViewModel
import com.pvld.horoscope.data.Repository

class SelectSignViewModel : ViewModel() {

    fun setCurrentSign(sign: String) {
        Repository.setCurrentSign(sign)
    }
}