package cmtt.base.models

import kotlinx.serialization.json.JsonNames

/**
 *
 *
 * @param result
 * @param message
 */

data class SubsiteSubscribersResponse(

    @JsonNames("result")
    val result: SubsiteSubscribersResponseResult? = null,

    @JsonNames("message")
    val message: String? = null

)

