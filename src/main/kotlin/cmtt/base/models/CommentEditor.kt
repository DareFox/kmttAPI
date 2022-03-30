package cmtt.base.models

import kotlinx.serialization.json.JsonNames

/**
 *
 *
 * @param enabled
 * @param who
 * @param text
 * @param until
 * @param reason
 */

data class CommentEditor(

    @JsonNames("enabled")
    val enabled: Boolean? = null,

    @JsonNames("who")
    val who: String? = null,

    @JsonNames("text")
    val text: String? = null,

    @JsonNames("until")
    val until: String? = null,

    @JsonNames("reason")
    val reason: String? = null

)

