package cmtt.base.models

import kotlinx.serialization.json.JsonNames

/**
 *
 *
 * @param type Тип блока
 * @param `data` информация о блоке
 * @param cover
 * @param anchor
 */

data class EntryBlock(

    /* Тип блока */
    @JsonNames("type")
    val type: String? = null,

    /* информация о блоке */
    @JsonNames("data")
    val `data`: Any? = null,

    @JsonNames("cover")
    val cover: Boolean? = null,

    @JsonNames("anchor")
    val anchor: String? = null

)

