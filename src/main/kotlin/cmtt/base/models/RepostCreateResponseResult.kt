package cmtt.base.models

import kotlinx.serialization.json.JsonNames

/**
 *
 *
 * @param result
 * @param count
 * @param mineCount
 * @param subsiteName
 */

data class RepostCreateResponseResult(

    @JsonNames("result")
    val result: Boolean? = null,

    @JsonNames("count")
    val count: Int? = null,

    @JsonNames("mine_count")
    val mineCount: Int? = null,

    @JsonNames("subsite_name")
    val subsiteName: String? = null

)

