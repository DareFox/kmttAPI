package cmtt.base.models

import kotlinx.serialization.json.JsonNames

/**
 *
 *
 * @param layout
 * @param version
 */

data class EntryHtml(

    @JsonNames("layout")
    val layout: String? = null,

    @JsonNames("version")
    val version: java.math.BigDecimal? = null

)

