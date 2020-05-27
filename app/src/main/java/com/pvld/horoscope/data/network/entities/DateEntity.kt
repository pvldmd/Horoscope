package com.pvld.horoscope.data.network.entities

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Root

@Root(name = "date", strict = false)
class DateEntity {

    @field:Attribute(required = false)
    var yesterday: String? = null

    @field:Attribute(required = false)
    var today: String? = null

    @field:Attribute(required = false)
    var tomorrow: String? = null

    @field:Attribute(required = false)
    var tomorrow02: String? = null

    @field:Attribute(required = false)
    var weekly: String? = null

}