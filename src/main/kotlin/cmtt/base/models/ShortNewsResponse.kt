package cmtt.base.models

import kotlinx.serialization.json.JsonNames

/**
 *
 *
 * @param result
 * @param message
 */

data class ShortNewsResponse(

    @JsonNames("result")
    val result: List<Entry>? = null,

    @JsonNames("message")
    val message: String? = null

)

