package cmtt.base.models

import kotlinx.serialization.json.JsonNames

/**
 *
 *
 * @param id
 * @param type
 * @param name
 * @param description
 * @param avatar
 * @param cover
 * @param isSubscribed
 * @param isFavorited
 * @param isVerified
 * @param isOnline
 * @param isMuted
 * @param isUnsubscribable
 * @param isEnabledCommentEditor
 * @param commentEditor
 * @param isAvailableForMessenger
 */

data class SubsiteSmall(

    @JsonNames("id")
    val id: java.math.BigDecimal? = null,

    @JsonNames("type")
    val type: Int? = null,

    @JsonNames("name")
    val name: String? = null,

    @JsonNames("description")
    val description: String? = null,

    @JsonNames("avatar")
    val avatar: Attach? = null,

    @JsonNames("cover")
    val cover: Attach? = null,

    @JsonNames("isSubscribed")
    val isSubscribed: Boolean? = null,

    @JsonNames("isFavorited")
    val isFavorited: Boolean? = null,

    @JsonNames("isVerified")
    val isVerified: Boolean? = null,

    @JsonNames("isOnline")
    val isOnline: Boolean? = null,

    @JsonNames("isMuted")
    val isMuted: Boolean? = null,

    @JsonNames("isUnsubscribable")
    val isUnsubscribable: Boolean? = null,

    @JsonNames("isEnabledCommentEditor")
    val isEnabledCommentEditor: Boolean? = null,

    @JsonNames("commentEditor")
    val commentEditor: CommentEditor? = null,

    @JsonNames("isAvailableForMessenger")
    val isAvailableForMessenger: Boolean? = null

)

