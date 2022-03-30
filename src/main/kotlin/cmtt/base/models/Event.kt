package cmtt.base.models

import kotlinx.serialization.json.JsonNames

/**
 *
 *
 * @param id
 * @param type
 * @param title
 * @param archived
 * @param city
 * @param cityId
 * @param cityName
 * @param price
 * @param date
 * @param company
 * @param interested
 * @param address
 */

data class Event(

    @JsonNames("id")
    val id: java.math.BigDecimal? = null,

    @JsonNames("type")
    val type: Int? = null,

    @JsonNames("title")
    val title: String? = null,

    @JsonNames("archived")
    val archived: Boolean? = null,

    @JsonNames("city")
    val city: String? = null,

    @JsonNames("cityId")
    val cityId: java.math.BigDecimal? = null,

    @JsonNames("cityName")
    val cityName: String? = null,

    @JsonNames("price")
    val price: String? = null,

    @JsonNames("date")
    val date: java.math.BigDecimal? = null,

    @JsonNames("company")
    val company: SubsiteSmall? = null,

    @JsonNames("interested")
    val interested: Int? = null,

    @JsonNames("address")
    val address: String? = null

)

