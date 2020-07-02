package com.pvld.horoscope.ui.horoscope.card

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pvld.horoscope.data.Repository
import com.pvld.horoscope.data.database.Favorite
import com.pvld.horoscope.data.database.Horoscope
import kotlinx.coroutines.launch
import javax.inject.Inject

class CardViewModel @Inject constructor(private val repository: Repository): ViewModel() {

    val horoscopeAllObservable: LiveData<List<Horoscope>> = repository.getAllData()

    val currentSign: LiveData<String> = repository.getCurrentSign()

    fun createFavorite (sign:String, date: String, text: String){
        viewModelScope.launch {
            repository.insertFavorite(Favorite(sign, date, text))
        }
    }

    fun deleteFavorite (sign: String, date: String){
        viewModelScope.launch {
            repository.deleteFavorite(sign, date)
        }
    }

    fun getOneFavorite (sign:String, date: String): LiveData<List<Favorite>> {
        return repository.getOneFavorite(sign, date)
    }

}
