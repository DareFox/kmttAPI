package cmtt.base.models

import kotlinx.serialization.json.JsonNames

/**
 *
 *
 * @param items
 * @param lastId
 * @param lastSortingValue
 */

data class UserVotesResponseResult(

    @JsonNames("items")
    val items: List<Entry>? = null,

    @JsonNames("lastId")
    val lastId: java.math.BigDecimal? = null,

    @JsonNames("lastSortingValue")
    val lastSortingValue: java.math.BigDecimal? = null

)

