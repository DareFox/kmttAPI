package cmtt.base.models

import kotlinx.serialization.json.JsonNames

/**
 *
 *
 * @param id
 * @param subsiteId
 * @param title Заголовок статьи
 */

data class EntrySmall(

    @JsonNames("id")
    val id: java.math.BigDecimal? = null,

    @JsonNames("subsiteId")
    val subsiteId: java.math.BigDecimal? = null,

    /* Заголовок статьи */
    @JsonNames("title")
    val title: String? = null

)

