package com.pvld.horoscope.data.mappers

import com.pvld.horoscope.data.database.Favorite
import com.pvld.horoscope.data.model.FavoriteItem

object FavoritesMapper {

    suspend fun from (inputList: List<Favorite>): List<FavoriteItem> {
        val outputList = ArrayList<FavoriteItem>()
        for (fav in inputList){
            outputList.add(
                FavoriteItem(
                    fav.sign,
                    fav.date,
                    fav.text
                )
            )
        }
        return outputList
    }
}