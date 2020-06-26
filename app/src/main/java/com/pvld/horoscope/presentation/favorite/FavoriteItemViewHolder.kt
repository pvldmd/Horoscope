package com.pvld.horoscope.presentation.favorite

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pvld.horoscope.R
import com.pvld.horoscope.domain.entities.FavoriteItem

class FavoriteItemViewHolder(
    itemView: View,
    private val listener: FavoriteItemAdapter.OnFavoriteClickListener
) : RecyclerView.ViewHolder(itemView) {
    val sign: TextView = itemView.findViewById(R.id.text_favoriteitem_sign)
    val date: TextView = itemView.findViewById(R.id.text_favoriteitem_date)
    val text: TextView = itemView.findViewById(R.id.text_favoriteitem_text)
    private val signIcon: ImageView = itemView.findViewById(R.id.image_favoriteitem_icon)
    private val favIcon: ImageView = itemView.findViewById(R.id.image_favoriteitem_fav)

    fun bind(item: FavoriteItem) {
        sign.setText(item.signNameId)
        date.text = item.date
        text.text = item.text
        signIcon.setImageResource(item.iconId)

        favIcon.setOnClickListener {
            listener.onFavoriteClick(adapterPosition)
        }
    }
}