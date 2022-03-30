package cmtt.base.models

import kotlinx.serialization.json.JsonNames

/**
 *
 *
 * @param result
 * @param message
 */

data class CredentialsResponse(

    @JsonNames("result")
    val result: CredentialsResponseResult? = null,

    @JsonNames("message")
    val message: String? = null

)

