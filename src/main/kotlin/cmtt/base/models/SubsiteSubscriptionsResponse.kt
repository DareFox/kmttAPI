package cmtt.base.models

import kotlinx.serialization.json.JsonNames

/**
 *
 *
 * @param result
 * @param message
 */

data class SubsiteSubscriptionsResponse(

    @JsonNames("result")
    val result: SubsiteSubscriptionsResponseResult? = null,

    @JsonNames("message")
    val message: String? = null

)

