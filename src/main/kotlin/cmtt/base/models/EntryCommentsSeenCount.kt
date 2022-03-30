package cmtt.base.models

import kotlinx.serialization.json.JsonNames

/**
 *
 *
 * @param count
 * @param date
 */

data class EntryCommentsSeenCount(

    @JsonNames("count")
    val count: java.math.BigDecimal? = null,

    @JsonNames("date")
    val date: java.math.BigDecimal? = null

)

