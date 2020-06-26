package com.pvld.horoscope.presentation.favorite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pvld.horoscope.R
import com.pvld.horoscope.domain.entities.FavoriteItem

class FavoriteItemAdapter(
    private val inflater: LayoutInflater,
    private val items: List<FavoriteItem>,
    private val listener: OnFavoriteClickListener
) : RecyclerView.Adapter<FavoriteItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteItemViewHolder {
        return FavoriteItemViewHolder(
            inflater.inflate(R.layout.item_favorite, parent, false),
            listener
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: FavoriteItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    interface OnFavoriteClickListener {
        fun onFavoriteClick(position: Int)
    }
}