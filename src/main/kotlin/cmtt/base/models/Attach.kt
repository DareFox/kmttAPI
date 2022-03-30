package cmtt.base.models

import kotlinx.serialization.json.JsonNames

/**
 *
 *
 * @param id
 * @param uuid
 * @param additionalData
 * @param type
 * @param color
 * @param width
 * @param height
 * @param propertySize
 * @param name
 * @param origin
 * @param title
 * @param description
 * @param url
 * @param image
 */

data class Attach(

    @JsonNames("id")
    val id: String? = null,

    @JsonNames("uuid")
    val uuid: String? = null,

    @JsonNames("additionalData")
    val additionalData: String? = null,

    @JsonNames("type")
    val type: String? = null,

    @JsonNames("color")
    val color: String? = null,

    @JsonNames("width")
    val width: java.math.BigDecimal? = null,

    @JsonNames("height")
    val height: java.math.BigDecimal? = null,

    @JsonNames("size")
    val propertySize: java.math.BigDecimal? = null,

    @JsonNames("name")
    val name: String? = null,

    @JsonNames("origin")
    val origin: String? = null,

    @JsonNames("title")
    val title: String? = null,

    @JsonNames("description")
    val description: String? = null,

    @JsonNames("url")
    val url: String? = null,

    @JsonNames("image")
    val image: AttachImage? = null

)

