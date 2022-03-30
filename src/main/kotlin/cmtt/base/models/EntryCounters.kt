package cmtt.base.models

import kotlinx.serialization.json.JsonNames

/**
 *
 *
 * @param comments
 * @param favorites
 * @param reposts
 */

data class EntryCounters(

    @JsonNames("comments")
    val comments: java.math.BigDecimal? = null,

    @JsonNames("favorites")
    val favorites: java.math.BigDecimal? = null,

    @JsonNames("reposts")
    val reposts: java.math.BigDecimal? = null

)

