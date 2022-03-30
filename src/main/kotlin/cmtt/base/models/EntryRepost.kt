package cmtt.base.models

import kotlinx.serialization.json.JsonNames

/**
 *
 *
 * @param author
 */

data class EntryRepost(

    @JsonNames("author")
    val author: Subsite? = null

)

