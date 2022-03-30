package cmtt.base.models

import kotlinx.serialization.json.JsonNames

/**
 *
 *
 * @param result
 * @param message
 */

data class SubsiteResponse(

    @JsonNames("result")
    val result: Subsite? = null,

    @JsonNames("message")
    val message: String? = null

)

