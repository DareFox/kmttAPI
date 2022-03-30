package cmtt.base.models

import kotlinx.serialization.json.JsonNames

/**
 *
 *
 * @param result
 * @param message
 */

data class RepostCreateResponse(

    @JsonNames("result")
    val result: RepostCreateResponseResult? = null,

    @JsonNames("message")
    val message: String? = null

)

