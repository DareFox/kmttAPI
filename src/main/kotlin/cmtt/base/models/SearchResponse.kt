package cmtt.base.models

import kotlinx.serialization.json.JsonNames

/**
 *
 *
 * @param result
 */

data class SearchResponse(

    @JsonNames("result")
    val result: SearchResponseResult? = null

)

