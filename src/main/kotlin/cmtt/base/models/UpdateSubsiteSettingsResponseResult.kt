package cmtt.base.models

import kotlinx.serialization.json.JsonNames

/**
 *
 *
 * @param description
 * @param isBlurNsfw
 */

data class UpdateSubsiteSettingsResponseResult(

    @JsonNames("description")
    val description: String? = null,

    @JsonNames("is_blur_nsfw")
    val isBlurNsfw: Boolean? = null

)

