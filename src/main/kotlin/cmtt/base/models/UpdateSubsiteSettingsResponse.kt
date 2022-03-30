package cmtt.base.models

import kotlinx.serialization.json.JsonNames

/**
 *
 *
 * @param result
 * @param message
 */

data class UpdateSubsiteSettingsResponse(

    @JsonNames("result")
    val result: UpdateSubsiteSettingsResponseResult? = null,

    @JsonNames("message")
    val message: String? = null

)

