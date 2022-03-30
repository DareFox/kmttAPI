package cmtt.base.models

import kotlinx.serialization.json.JsonNames

/**
 *
 *
 * @param result
 * @param message
 */

data class EmailChangeResponse(

    @JsonNames("result")
    val result: PasswordChangeResponseResult? = null,

    @JsonNames("message")
    val message: String? = null

)

