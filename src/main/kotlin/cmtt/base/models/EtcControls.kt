package cmtt.base.models

import kotlinx.serialization.json.JsonNames

/**
 *
 *
 * @param editEntry
 * @param pinContent
 * @param unpublishEntry
 * @param banSubsite
 * @param pinComment
 * @param removeThread
 */

data class EtcControls(

    @JsonNames("editEntry")
    val editEntry: Boolean? = null,

    @JsonNames("pinContent")
    val pinContent: Boolean? = null,

    @JsonNames("unpublishEntry")
    val unpublishEntry: Boolean? = null,

    @JsonNames("banSubsite")
    val banSubsite: Boolean? = null,

    @JsonNames("pinComment")
    val pinComment: Boolean? = null,

    @JsonNames("removeThread")
    val removeThread: Boolean? = null

)

