package cmtt.base.models

import kotlinx.serialization.json.JsonNames

/**
 *
 *
 * @param isAdult
 */

data class SubsiteAdultSetResponseResult(

    @JsonNames("is_adult")
    val isAdult: Boolean? = null

)

