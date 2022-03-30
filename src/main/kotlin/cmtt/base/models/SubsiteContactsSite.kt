package cmtt.base.models

import kotlinx.serialization.json.JsonNames

/**
 *
 *
 * @param title
 * @param url
 */

data class SubsiteContactsSite(

    @JsonNames("title")
    val title: String? = null,

    @JsonNames("url")
    val url: String? = null

)

