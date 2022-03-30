package cmtt.base.models

import kotlinx.serialization.json.JsonNames

/**
 *
 *
 * @param result
 * @param message
 */

data class RecommendedSubsitesResponse(

    @JsonNames("result")
    val result: RecommendedSubsitesResponseResult? = null,

    @JsonNames("message")
    val message: String? = null

)

