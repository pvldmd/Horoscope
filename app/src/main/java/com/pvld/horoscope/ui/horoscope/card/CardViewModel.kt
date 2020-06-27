package com.pvld.horoscope.ui.horoscope.card

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pvld.horoscope.data.Repository
import com.pvld.horoscope.data.database.Favorite
import com.pvld.horoscope.data.database.Horoscope
import kotlinx.coroutines.launch

class CardViewModel : ViewModel() {

    val horoscopeAllObservable: LiveData<List<Horoscope>> = Repository.getAllData()

    val currentSign: LiveData<String> = Repository.getCurrentSign()

    fun createFavorite (sign:String, date: String, text: String){
        viewModelScope.launch {
            Repository.insertFavorite(Favorite(sign, date, text))
        }
    }

    fun deleteFavorite (sign: String, date: String){
        viewModelScope.launch {
            Repository.deleteFavorite(sign, date)
        }
    }

    fun getOneFavorite (sign:String, date: String): LiveData<List<Favorite>> {
        return Repository.getOneFavorite(sign, date)
    }

}
