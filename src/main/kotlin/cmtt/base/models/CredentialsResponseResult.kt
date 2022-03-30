package cmtt.base.models

import kotlinx.serialization.json.JsonNames

/**
 *
 *
 * @param credentials
 */

data class CredentialsResponseResult(

    @JsonNames("credentials")
    val credentials: List<Any>? = null

)

