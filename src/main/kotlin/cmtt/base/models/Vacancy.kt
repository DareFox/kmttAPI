package cmtt.base.models

import kotlinx.serialization.json.JsonNames

/**
 *
 *
 * @param id
 * @param type
 * @param title
 * @param city
 * @param salary
 * @param salaryTo
 * @param salaryFrom
 * @param archived
 * @param area
 * @param areaText
 * @param schedule
 * @param scheduleText
 * @param company
 */

data class Vacancy(

    @JsonNames("id")
    val id: java.math.BigDecimal? = null,

    @JsonNames("type")
    val type: java.math.BigDecimal? = null,

    @JsonNames("title")
    val title: String? = null,

    @JsonNames("city")
    val city: String? = null,

    @JsonNames("salary")
    val salary: String? = null,

    @JsonNames("salaryTo")
    val salaryTo: java.math.BigDecimal? = null,

    @JsonNames("salaryFrom")
    val salaryFrom: java.math.BigDecimal? = null,

    @JsonNames("archived")
    val archived: Boolean? = null,

    @JsonNames("area")
    val area: java.math.BigDecimal? = null,

    @JsonNames("areaText")
    val areaText: String? = null,

    @JsonNames("schedule")
    val schedule: java.math.BigDecimal? = null,

    @JsonNames("scheduleText")
    val scheduleText: String? = null,

    @JsonNames("company")
    val company: SubsiteSmall? = null

)

