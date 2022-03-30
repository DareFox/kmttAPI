package cmtt.base.models

import kotlinx.serialization.json.JsonNames

/**
 *
 *
 * @param result
 * @param message
 */

data class AuthorizedUserResponse(

    @JsonNames("result")
    val result: SubsiteAuthorizedUser? = null,

    @JsonNames("message")
    val message: String? = null

)

