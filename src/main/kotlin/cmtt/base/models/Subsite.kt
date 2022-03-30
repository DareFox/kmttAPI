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
 * @param created
 * @param url
 * @param hashtags
 * @param isSubscribed
 * @param isVerified
 * @param isOnline
 * @param isMuted
 * @param isUnsubscribable
 * @param isEnableWriting
 * @param isSubscribedToNewPosts
 * @param rating
 * @param contacts
 * @param commentEditor
 * @param isAvailableForMessenger
 * @param isPlus
 * @param counters
 * @param threeSubscribers
 * @param threeSubscriptions
 * @param rules
 * @param isFavorited
 * @param counterSubscribers
 * @param isRecommended
 */

data class Subsite(

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

    @JsonNames("created")
    val created: java.math.BigDecimal? = null,

    @JsonNames("url")
    val url: String? = null,

    @JsonNames("hashtags")
    val hashtags: List<String>? = null,

    @JsonNames("isSubscribed")
    val isSubscribed: Boolean? = null,

    @JsonNames("isVerified")
    val isVerified: Boolean? = null,

    @JsonNames("isOnline")
    val isOnline: Boolean? = null,

    @JsonNames("isMuted")
    val isMuted: Boolean? = null,

    @JsonNames("isUnsubscribable")
    val isUnsubscribable: Boolean? = null,

    @JsonNames("isEnableWriting")
    val isEnableWriting: Boolean? = null,

    @JsonNames("isSubscribedToNewPosts")
    val isSubscribedToNewPosts: Boolean? = null,

    @JsonNames("rating")
    val rating: java.math.BigDecimal? = null,

    @JsonNames("contacts")
    val contacts: SubsiteContacts? = null,

    @JsonNames("commentEditor")
    val commentEditor: CommentEditor? = null,

    @JsonNames("isAvailableForMessenger")
    val isAvailableForMessenger: Boolean? = null,

    @JsonNames("isPlus")
    val isPlus: Boolean? = null,

    @JsonNames("counters")
    val counters: SubsiteCounters? = null,

    @JsonNames("threeSubscribers")
    val threeSubscribers: List<SubsiteSmall>? = null,

    @JsonNames("threeSubscriptions")
    val threeSubscriptions: List<SubsiteSmall>? = null,

    @JsonNames("rules")
    val rules: String? = null,

    @JsonNames("isFavorited")
    val isFavorited: Boolean? = null,

    @JsonNames("counterSubscribers")
    val counterSubscribers: Int? = null,

    @JsonNames("isRecommended")
    val isRecommended: Boolean? = null

)

