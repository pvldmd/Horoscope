package com.pvld.horoscope.data.network.entities

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "sign", strict = false)
class SignEntity {

    @field:Element(required = false, name = "yesterday")
    var yesterday: String? = null

    @field:Element(required = false, name = "today")
    var today: String? = null

    @field:Element(required = false, name = "tomorrow")
    var tomorrow: String? = null

    @field:Element(required = false, name = "tomorrow02")
    var tomorrow02: String? = null

}