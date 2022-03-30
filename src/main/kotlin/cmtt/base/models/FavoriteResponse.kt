package cmtt.base.models

import kotlinx.serialization.json.JsonNames

/**
 *
 *
 * @param result
 * @param message
 */

data class FavoriteResponse(

    @JsonNames("result")
    val result: FavoriteResponseResult? = null,

    @JsonNames("message")
    val message: String? = null

)

