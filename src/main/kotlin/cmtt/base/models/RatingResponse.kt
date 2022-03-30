package cmtt.base.models

import kotlinx.serialization.json.JsonNames

/**
 *
 *
 * @param result
 * @param message
 */

data class RatingResponse(

    @JsonNames("result")
    val result: RatingResponseResult? = null,

    @JsonNames("message")
    val message: String? = null

)

