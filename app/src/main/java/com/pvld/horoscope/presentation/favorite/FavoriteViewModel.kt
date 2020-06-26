package com.pvld.horoscope.presentation.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pvld.horoscope.data.Repository
import com.pvld.horoscope.domain.entities.FavoriteItem
import kotlinx.coroutines.launch

class FavoriteViewModel : ViewModel() {

    suspend fun getFavoriteItems(): List<FavoriteItem> {
        return Repository.getAllFavorites()
    }

    fun deleteFavorite(sign: String, date: String) {
        viewModelScope.launch {
            Repository.deleteFavorite(sign, date)
        }
    }

}
