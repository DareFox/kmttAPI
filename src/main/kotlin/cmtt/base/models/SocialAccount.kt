package cmtt.base.models

import kotlinx.serialization.json.JsonNames

/**
 *
 *
 * @param id
 * @param type
 * @param username
 * @param title
 * @param url
 */

data class SocialAccount(

    @JsonNames("id")
    val id: java.math.BigDecimal? = null,

    @JsonNames("type")
    val type: Int? = null,

    @JsonNames("username")
    val username: String? = null,

    @JsonNames("title")
    val title: String? = null,

    @JsonNames("url")
    val url: String? = null

)

