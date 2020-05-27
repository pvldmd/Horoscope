package com.pvld.horoscope.data.network.entities

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "horoscope", strict = false)
class HoroscopeEntity {

    @field:Element(name = "date")
    var date: DateEntity? = null

    @field:Element(name = "aries")
    var aries: SignEntity? = null

    @field:Element(name = "taurus")
    var taurus: SignEntity? = null

    @field:Element(name = "gemini")
    var gemini: SignEntity? = null

    @field:Element(name = "cancer")
    var cancer: SignEntity? = null

    @field:Element(name = "leo")
    var leo: SignEntity? = null

    @field:Element(name = "virgo")
    var virgo: SignEntity? = null

    @field:Element(name = "libra")
    var libra: SignEntity? = null

    @field:Element(name = "scorpio")
    var scorpio: SignEntity? = null

    @field:Element(name = "sagittarius")
    var sagittarius: SignEntity? = null

    @field:Element(name = "capricorn")
    var capricorn: SignEntity? = null

    @field:Element(name = "aquarius")
    var aquarius: SignEntity? = null

    @field:Element(name = "pisces")
    var pisces: SignEntity? = null

}