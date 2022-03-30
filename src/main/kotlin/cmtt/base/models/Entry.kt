package cmtt.base.models

import kotlinx.serialization.json.JsonNames

/**
 *
 *
 * @param id
 * @param author
 * @param subsiteId
 * @param subsite
 * @param title Заголовок статьи
 * @param date Дата создания статьи
 * @param blocks Список блоков для нативной статьи. Для каждого типа блока формат объекта data разный
 * @param html
 * @param counters
 * @param commentsSeenCount
 * @param dateFavorite
 * @param hitsCount
 * @param isCommentsEnabled
 * @param isLikesEnabled
 * @param isFavorited
 * @param isRepost
 * @param likes
 * @param isPinned
 * @param canEdit
 * @param etcControls
 * @param repost
 * @param isRepostedByMe
 * @param subscribedToTreads
 * @param isFlash
 * @param isBlur
 * @param isShowThanks
 * @param isStillUpdating
 * @param isFilledByEditors
 * @param isEditorial
 * @param isPromoted
 * @param audioUrl
 * @param commentEditor
 * @param coAuthor
 */

data class Entry(

    @JsonNames("id")
    val id: java.math.BigDecimal? = null,

    @JsonNames("author")
    val author: Subsite? = null,

    @JsonNames("subsiteId")
    val subsiteId: java.math.BigDecimal? = null,

    @JsonNames("subsite")
    val subsite: Subsite? = null,

    /* Заголовок статьи */
    @JsonNames("title")
    val title: String? = null,

    /* Дата создания статьи */
    @JsonNames("date")
    val date: java.math.BigDecimal? = null,

    /* Список блоков для нативной статьи. Для каждого типа блока формат объекта data разный */
    @JsonNames("blocks")
    val blocks: List<EntryBlock>? = null,

    @JsonNames("html")
    val html: EntryHtml? = null,

    @JsonNames("counters")
    val counters: EntryCounters? = null,

    @JsonNames("commentsSeenCount")
    val commentsSeenCount: EntryCommentsSeenCount? = null,

    @JsonNames("dateFavorite")
    val dateFavorite: java.math.BigDecimal? = null,

    @JsonNames("hitsCount")
    val hitsCount: java.math.BigDecimal? = null,

    @JsonNames("isCommentsEnabled")
    val isCommentsEnabled: Boolean? = null,

    @JsonNames("isLikesEnabled")
    val isLikesEnabled: Boolean? = null,

    @JsonNames("isFavorited")
    val isFavorited: Boolean? = null,

    @JsonNames("isRepost")
    val isRepost: Boolean? = null,

    @JsonNames("likes")
    val likes: Likes? = null,

    @JsonNames("isPinned")
    val isPinned: Boolean? = null,

    @JsonNames("canEdit")
    val canEdit: Boolean? = null,

    @JsonNames("etcControls")
    val etcControls: EtcControls? = null,

    @JsonNames("repost")
    val repost: EntryRepost? = null,

    @JsonNames("isRepostedByMe")
    val isRepostedByMe: Boolean? = null,

    @JsonNames("subscribedToTreads")
    val subscribedToTreads: Boolean? = null,

    @JsonNames("isFlash")
    val isFlash: Boolean? = null,

    @JsonNames("isBlur")
    val isBlur: Boolean? = null,

    @JsonNames("isShowThanks")
    val isShowThanks: Boolean? = null,

    @JsonNames("isStillUpdating")
    val isStillUpdating: Boolean? = null,

    @JsonNames("isFilledByEditors")
    val isFilledByEditors: Boolean? = null,

    @JsonNames("isEditorial")
    val isEditorial: Boolean? = null,

    @JsonNames("isPromoted")
    val isPromoted: Boolean? = null,

    @JsonNames("audioUrl")
    val audioUrl: String? = null,

    @JsonNames("commentEditor")
    val commentEditor: CommentEditor? = null,

    @JsonNames("coAuthor")
    val coAuthor: Subsite? = null

)

