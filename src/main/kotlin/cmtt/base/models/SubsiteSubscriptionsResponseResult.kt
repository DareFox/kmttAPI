package cmtt.base.models

import kotlinx.serialization.json.JsonNames

/**
 *
 *
 * @param items
 * @param nextPage
 * @param total
 */

data class SubsiteSubscriptionsResponseResult(

    @JsonNames("items")
    val items: List<Subsite>? = null,

    @JsonNames("nextPage")
    val nextPage: java.math.BigDecimal? = null,

    @JsonNames("total")
    val total: java.math.BigDecimal? = null

)

