package cmtt.base.models

import kotlinx.serialization.json.JsonNames

/**
 *
 *
 * @param result
 * @param message
 */

data class TimelineResponse(

    @JsonNames("result")
    val result: TimelineResponseResult? = null,

    @JsonNames("message")
    val message: String? = null

)

