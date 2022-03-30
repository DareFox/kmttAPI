package cmtt.base.models

import kotlinx.serialization.json.JsonNames

/**
 *
 *
 * @param news
 * @param lastId
 */

data class NewsResponseResult(

    @JsonNames("news")
    val news: List<Entry>? = null,

    @JsonNames("lastId")
    val lastId: java.math.BigDecimal? = null

)

