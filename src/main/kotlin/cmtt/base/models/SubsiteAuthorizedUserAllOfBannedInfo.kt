package cmtt.base.models

import kotlinx.serialization.json.JsonNames

/**
 *
 *
 * @param text
 * @param until
 * @param reason
 */

data class SubsiteAuthorizedUserAllOfBannedInfo(

    @JsonNames("text")
    val text: String? = null,

    @JsonNames("until")
    val until: java.math.BigDecimal? = null,

    @JsonNames("reason")
    val reason: String? = null

)

