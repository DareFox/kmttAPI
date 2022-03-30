package cmtt.base.models

import kotlinx.serialization.json.JsonNames

/**
 *
 *
 * @param result
 * @param message
 */

data class CommentsResponse(

    @JsonNames("result")
    val result: CommentsResponseResult? = null,

    @JsonNames("message")
    val message: String? = null

)

