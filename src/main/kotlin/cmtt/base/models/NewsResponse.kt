package cmtt.base.models

import kotlinx.serialization.json.JsonNames

/**
 *
 *
 * @param result
 * @param message
 */

data class NewsResponse(

    @JsonNames("result")
    val result: NewsResponseResult? = null,

    @JsonNames("message")
    val message: String? = null

)

