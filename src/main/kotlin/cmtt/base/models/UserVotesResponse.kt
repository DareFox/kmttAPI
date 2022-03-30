package cmtt.base.models

import kotlinx.serialization.json.JsonNames

/**
 *
 *
 * @param result
 * @param message
 */

data class UserVotesResponse(

    @JsonNames("result")
    val result: UserVotesResponseResult? = null,

    @JsonNames("message")
    val message: String? = null

)

