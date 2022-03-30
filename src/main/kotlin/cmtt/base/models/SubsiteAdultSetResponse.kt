package cmtt.base.models

import kotlinx.serialization.json.JsonNames

/**
 *
 *
 * @param result
 * @param message
 */

data class SubsiteAdultSetResponse(

    @JsonNames("result")
    val result: SubsiteAdultSetResponseResult? = null,

    @JsonNames("message")
    val message: String? = null

)

