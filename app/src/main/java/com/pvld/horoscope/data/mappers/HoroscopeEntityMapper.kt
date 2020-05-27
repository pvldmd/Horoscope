package com.pvld.horoscope.data.mappers

import com.pvld.horoscope.data.database.Horoscope
import com.pvld.horoscope.data.network.entities.HoroscopeEntity

object HoroscopeEntityMapper {

    fun from(input: HoroscopeEntity): List<Horoscope> {
        val outputList = ArrayList<Horoscope>()
        var sign = Horoscope(
            "aries",
            input.date?.yesterday.toString(),
            input.date?.today.toString(),
            input.date?.tomorrow.toString(),
            input.date?.tomorrow02.toString(),
            input.aries?.yesterday.toString(),
            input.aries?.today.toString(),
            input.aries?.tomorrow.toString(),
            input.aries?.tomorrow02.toString()
        )
        outputList.add(sign)
        sign = Horoscope(
            "taurus",
            input.date?.yesterday.toString(),
            input.date?.today.toString(),
            input.date?.tomorrow.toString(),
            input.date?.tomorrow02.toString(),
            input.taurus?.yesterday.toString(),
            input.taurus?.today.toString(),
            input.taurus?.tomorrow.toString(),
            input.taurus?.tomorrow02.toString()
        )
        outputList.add(sign)
        sign = Horoscope(
            "gemini",
            input.date?.yesterday.toString(),
            input.date?.today.toString(),
            input.date?.tomorrow.toString(),
            input.date?.tomorrow02.toString(),
            input.gemini?.yesterday.toString(),
            input.gemini?.today.toString(),
            input.gemini?.tomorrow.toString(),
            input.gemini?.tomorrow02.toString()
        )
        outputList.add(sign)
        sign = Horoscope(
            "cancer",
            input.date?.yesterday.toString(),
            input.date?.today.toString(),
            input.date?.tomorrow.toString(),
            input.date?.tomorrow02.toString(),
            input.cancer?.yesterday.toString(),
            input.cancer?.today.toString(),
            input.cancer?.tomorrow.toString(),
            input.cancer?.tomorrow02.toString()
        )
        outputList.add(sign)
        sign = Horoscope(
            "leo",
            input.date?.yesterday.toString(),
            input.date?.today.toString(),
            input.date?.tomorrow.toString(),
            input.date?.tomorrow02.toString(),
            input.leo?.yesterday.toString(),
            input.leo?.today.toString(),
            input.leo?.tomorrow.toString(),
            input.leo?.tomorrow02.toString()
        )
        outputList.add(sign)
        sign = Horoscope(
            "virgo",
            input.date?.yesterday.toString(),
            input.date?.today.toString(),
            input.date?.tomorrow.toString(),
            input.date?.tomorrow02.toString(),
            input.virgo?.yesterday.toString(),
            input.virgo?.today.toString(),
            input.virgo?.tomorrow.toString(),
            input.virgo?.tomorrow02.toString()
        )
        outputList.add(sign)
        sign = Horoscope(
            "libra",
            input.date?.yesterday.toString(),
            input.date?.today.toString(),
            input.date?.tomorrow.toString(),
            input.date?.tomorrow02.toString(),
            input.libra?.yesterday.toString(),
            input.libra?.today.toString(),
            input.libra?.tomorrow.toString(),
            input.libra?.tomorrow02.toString()
        )
        outputList.add(sign)
        sign = Horoscope(
            "scorpio",
            input.date?.yesterday.toString(),
            input.date?.today.toString(),
            input.date?.tomorrow.toString(),
            input.date?.tomorrow02.toString(),
            input.scorpio?.yesterday.toString(),
            input.scorpio?.today.toString(),
            input.scorpio?.tomorrow.toString(),
            input.scorpio?.tomorrow02.toString()
        )
        outputList.add(sign)
        sign = Horoscope(
            "sagittarius",
            input.date?.yesterday.toString(),
            input.date?.today.toString(),
            input.date?.tomorrow.toString(),
            input.date?.tomorrow02.toString(),
            input.sagittarius?.yesterday.toString(),
            input.sagittarius?.today.toString(),
            input.sagittarius?.tomorrow.toString(),
            input.sagittarius?.tomorrow02.toString()
        )
        outputList.add(sign)
        sign = Horoscope(
            "capricorn",
            input.date?.yesterday.toString(),
            input.date?.today.toString(),
            input.date?.tomorrow.toString(),
            input.date?.tomorrow02.toString(),
            input.capricorn?.yesterday.toString(),
            input.capricorn?.today.toString(),
            input.capricorn?.tomorrow.toString(),
            input.capricorn?.tomorrow02.toString()
        )
        outputList.add(sign)
        sign = Horoscope(
            "aquarius",
            input.date?.yesterday.toString(),
            input.date?.today.toString(),
            input.date?.tomorrow.toString(),
            input.date?.tomorrow02.toString(),
            input.aquarius?.yesterday.toString(),
            input.aquarius?.today.toString(),
            input.aquarius?.tomorrow.toString(),
            input.aquarius?.tomorrow02.toString()
        )
        outputList.add(sign)
        sign = Horoscope(
            "pisces",
            input.date?.yesterday.toString(),
            input.date?.today.toString(),
            input.date?.tomorrow.toString(),
            input.date?.tomorrow02.toString(),
            input.pisces?.yesterday.toString(),
            input.pisces?.today.toString(),
            input.pisces?.tomorrow.toString(),
            input.pisces?.tomorrow02.toString()
        )
        outputList.add(sign)
        return outputList
    }

}