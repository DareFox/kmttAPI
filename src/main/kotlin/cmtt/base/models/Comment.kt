package cmtt.base.models

import kotlinx.serialization.json.JsonNames

/**
 *
 *
 * @param id
 * @param author
 * @param date
 * @param lastModificationDate
 * @param isFavorited
 * @param dateFavorite
 * @param isEdited
 * @param likes
 * @param entry
 * @param media
 * @param level
 * @param isPinned
 * @param isIgnored
 * @param isRemoved
 * @param replyTo
 * @param text
 * @param etcControls
 * @param donate
 */

data class Comment(

    @JsonNames("id")
    val id: java.math.BigDecimal? = null,

    @JsonNames("author")
    val author: SubsiteSmall? = null,

    @JsonNames("date")
    val date: java.math.BigDecimal? = null,

    @JsonNames("lastModificationDate")
    val lastModificationDate: java.math.BigDecimal? = null,

    @JsonNames("isFavorited")
    val isFavorited: Boolean? = null,

    @JsonNames("dateFavorite")
    val dateFavorite: java.math.BigDecimal? = null,

    @JsonNames("isEdited")
    val isEdited: Boolean? = null,

    @JsonNames("likes")
    val likes: Likes? = null,

    @JsonNames("entry")
    val entry: EntrySmall? = null,

    @JsonNames("media")
    val media: List<String>? = null,

    @JsonNames("level")
    val level: Int? = null,

    @JsonNames("isPinned")
    val isPinned: Boolean? = null,

    @JsonNames("isIgnored")
    val isIgnored: Boolean? = null,

    @JsonNames("isRemoved")
    val isRemoved: Boolean? = null,

    @JsonNames("replyTo")
    val replyTo: java.math.BigDecimal? = null,

    @JsonNames("text")
    val text: String? = null,

    @JsonNames("etcControls")
    val etcControls: EtcControls? = null,

    @JsonNames("donate")
    val donate: CommentDonate? = null

)

