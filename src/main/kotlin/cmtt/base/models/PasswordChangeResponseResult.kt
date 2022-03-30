package cmtt.base.models

import kotlinx.serialization.json.JsonNames

/**
 *
 *
 * @param message
 */

data class PasswordChangeResponseResult(

    @JsonNames("message")
    val message: String? = null

)

