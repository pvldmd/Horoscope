package com.pvld.horoscope.data.model

import com.pvld.horoscope.R

class FavoriteItem (
    val sign:String,
    val date:String,
    val text:String
) {
    val iconId = when (sign){
        "aries" -> R.drawable.ic_zodiac_aries
        "taurus" -> R.drawable.ic_zodiac_taurus
        "gemini" -> R.drawable.ic_zodiac_gemini
        "cancer" -> R.drawable.ic_zodiac_cancer
        "leo" -> R.drawable.ic_zodiac_leo
        "virgo" -> R.drawable.ic_zodiac_virgo
        "libra" -> R.drawable.ic_zodiac_libra
        "scorpio" -> R.drawable.ic_zodiac_scorpio
        "sagittarius" -> R.drawable.ic_zodiac_sagittarius
        "capricorn" -> R.drawable.ic_zodiac_capricorn
        "aquarius" -> R.drawable.ic_zodiac_aquarius
        "pisces" -> R.drawable.ic_zodiac_pisces
        // TODO: бросать ошибку, если else
        else -> 0
    }

    val signNameId = when (sign){
            "aries" -> R.string.aries
            "taurus" -> R.string.taurus
            "gemini" -> R.string.gemini
            "cancer" -> R.string.cancer
            "leo" -> R.string.leo
            "virgo" -> R.string.virgo
            "libra" -> R.string.libra
            "scorpio" -> R.string.scorpio
            "sagittarius" -> R.string.sagittarius
            "capricorn" -> R.string.capricorn
            "aquarius" -> R.string.aquarius
            "pisces" -> R.string.pisces
        else -> 0
    }

}