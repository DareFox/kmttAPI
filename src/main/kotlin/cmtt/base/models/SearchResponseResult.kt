package cmtt.base.models

import kotlinx.serialization.json.JsonNames

/**
 *
 *
 * @param subsites
 * @param contents
 * @param lastId
 */

data class SearchResponseResult(

    @JsonNames("subsites")
    val subsites: SearchResponseResultSubsites? = null,

    @JsonNames("contents")
    val contents: List<Entry>? = null,

    @JsonNames("lastId")
    val lastId: java.math.BigDecimal? = null

)

