package cmtt.base.models

import kotlinx.serialization.json.JsonNames

/**
 *
 *
 * @param result
 * @param message
 */

data class ContentResponse(

    @JsonNames("result")
    val result: Entry? = null,

    @JsonNames("message")
    val message: String? = null

)

