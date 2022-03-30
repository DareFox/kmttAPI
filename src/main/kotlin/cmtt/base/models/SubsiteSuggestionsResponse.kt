package cmtt.base.models

import kotlinx.serialization.json.JsonNames

/**
 *
 *
 * @param result
 * @param message
 */

data class SubsiteSuggestionsResponse(

    @JsonNames("result")
    val result: List<SubsiteSmall>? = null,

    @JsonNames("message")
    val message: String? = null

)

