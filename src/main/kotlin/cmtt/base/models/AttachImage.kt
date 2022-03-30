package cmtt.base.models

import kotlinx.serialization.json.JsonNames

/**
 *
 *
 * @param type
 * @param `data`
 */

data class AttachImage(

    @JsonNames("type")
    val type: String? = null,

    @JsonNames("data")
    val `data`: AttachImage? = null

)

