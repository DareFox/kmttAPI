package cmtt.base.models

import kotlinx.serialization.json.JsonNames

/**
 *
 *
 * @param count
 */

data class CommentDonate(

    @JsonNames("count")
    val count: java.math.BigDecimal? = null

)

