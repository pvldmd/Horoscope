package com.pvld.horoscope.ui.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pvld.horoscope.data.Repository
import com.pvld.horoscope.data.model.FavoriteItem
import kotlinx.coroutines.launch
import javax.inject.Inject

class FavoriteViewModel @Inject constructor(private val repository: Repository): ViewModel() {

    suspend fun getFavoriteItems(): List<FavoriteItem> {
        return repository.getAllFavorites()
    }

    fun deleteFavorite(sign: String, date: String) {
        viewModelScope.launch {
            repository.deleteFavorite(sign, date)
        }
    }

}
