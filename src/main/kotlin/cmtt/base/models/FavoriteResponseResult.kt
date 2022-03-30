package cmtt.base.models

import kotlinx.serialization.json.JsonNames

/**
 *
 *
 * @param success
 * @param count
 */

data class FavoriteResponseResult(

    @JsonNames("success")
    val success: Boolean? = null,

    @JsonNames("count")
    val count: Int? = null

)

