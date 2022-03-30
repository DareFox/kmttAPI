package cmtt.base.models

import kotlinx.serialization.json.JsonNames

/**
 *
 *
 * @param tabs
 * @param subsites
 */

data class RatingResponseResult(

    @JsonNames("tabs")
    val tabs: List<Any>? = null,

    @JsonNames("subsites")
    val subsites: List<SubsiteSmall>? = null

)

