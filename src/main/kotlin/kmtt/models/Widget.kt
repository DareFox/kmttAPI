//package kmtt.models
//
//import kmtt.models.attach.Attach
//import kmtt.models.comment.CommentsLoadMore
//import kmtt.models.entry.Entry
//import kmtt.models.entry.EntryContent
//import kmtt.models.subsite.Subsite
//import kotlinx.serialization.SerialName
//import kotlinx.serialization.json.JsonArray
//import kotlinx.serialization.json.JsonObject
//import kotlinx.serialization.*
//import kotlinx.serialization.descriptors.SerialDescriptor
//import kotlinx.serialization.descriptors.*
//import kotlinx.serialization.encoding.*
//
//@Serializable
//data class Widget (
//    val id: Long,
//    val url: String? = null,
//    val author: Author,
//    val badges: List<Badge>? = null,
//    val commentsCount: Long? = null,
//    val commentsSeenCount: JsonObject? = null,
//    val favoritesCount: Long? = null,
//    val cover: Cover? = null,
//    val date: Long,
//    val dateRFC: String,
//
//    @SerialName("date_favorite")
//    val dateFavorite: JsonObject? = null,
//
//    @SerialName("last_modification_date")
//    val lastModificationDate: Long? = null,
//
//    val hitsCount: Long? = null,
//    val intro: String? = null,
//    val introInFeed: JsonObject? = null,
//    val isEnabledComments: Boolean? = null,
//    val isEnabledLikes: Boolean? = null,
//    val isFavorited: Boolean,
//    val isRepost: Boolean? = null,
//    val likes: Likes,
//    val subsite: Subsite? = null,
//    val similar: JsonArray? = null,
//    val title: String? = null,
//    val type: Long? = null,
//    val entryContent: EntryContent? = null,
//    val commentatorsAvatars: List<String>? = null,
//
//    @SerialName("webviewUrl")
//    val webviewURL: JsonObject? = null,
//
//    val isPinned: Boolean? = null,
//    val canEdit: Boolean? = null,
//    val etcControls: EtcControls,
//    val highlight: String,
//    val blocks: List<ItemBlock>? = null,
//    val subscribedToTreads: Boolean? = null,
//
//    @SerialName("is_show_thanks")
//    val isShowThanks: Boolean? = null,
//
//    @SerialName("is_still_updating")
//    val isStillUpdating: Boolean? = null,
//
//    @SerialName("is_filled_by_editors")
//    val isFilledByEditors: Boolean? = null,
//
//    val isEditorial: Boolean? = null,
//
//    @SerialName("audioUrl")
//    val audioURL: String? = null,
//
//    val hotness: Long? = null,
//    val commentEditor: CommentEditor? = null,
//    val summarize: String? = null,
//    val isEdited: Boolean? = null,
//    val media: List<Media>? = null,
//    val level: Long? = null,
//
//    @SerialName("is_pinned")
//    val itemIsPinned: Boolean? = null,
//
//    @SerialName("is_ignored")
//    val isIgnored: Boolean? = null,
//
//    @SerialName("is_removed")
//    val isRemoved: Boolean? = null,
//
//    val replyTo: Long? = null,
//    val text: String? = null,
//
//    @SerialName("text_wo_md")
//    val textWoMd: String? = null,
//
//    val html: String? = null,
//    val attaches: List<Attach>? = null,
//
//    @SerialName("source_id")
//    val sourceID: Long? = null,
//
//    val entry: Entry? = null,
//
//    @SerialName("load_more")
//    val loadMore: CommentsLoadMore? = null,
//
//    val donate: JsonObject? = null
//)
//
//@OptIn(ExperimentalSerializationApi::class)
//@kotlinx.serialization.Serializable
//data class CommentEditor (
//    val enabled: Boolean
//)
//
//@OptIn(ExperimentalSerializationApi::class)
//@kotlinx.serialization.Serializable
//data class ItemBlock (
//    val type: BlockType,
//    val data: PurpleData,
//    val cover: Boolean,
//    val hidden: Boolean,
//    val anchor: String
//)
//
//@Serializable
//enum class BlockType(val value: String) {
//    Link("link"),
//    Media("media"),
//    Quote("quote"),
//    Text("text"),
//    TypeList("list");
//
//    companion object : KSerializer<BlockType> {
//        override val descriptor: SerialDescriptor get() {
//            return PrimitiveSerialDescriptor("quicktype.BlockType", PrimitiveKind.STRING)
//        }
//        override fun deserialize(decoder: Decoder): BlockType = when (val value = decoder.decodeString()) {
//            "link"  -> Link
//            "media" -> Media
//            "quote" -> Quote
//            "text"  -> Text
//            "list"  -> TypeList
//            else    -> throw IllegalArgumentException("BlockType could not parse: $value")
//        }
//        override fun serialize(encoder: Encoder, value: BlockType) {
//            return encoder.encodeString(value.value)
//        }
//    }
//}
//
//
//@OptIn(ExperimentalSerializationApi::class)
//@kotlinx.serialization.Serializable
//data class PurpleData (
//    val text: String? = null,
//
//    @SerialName("text_truncated")
//    val textTruncated: TextTruncated? = null,
//
//    val items: List<ItemUnion>? = null,
//    val type: String? = null,
//    val subline1: String? = null,
//    val subline2: String? = null,
//
//    @SerialName("text_size")
//    val textSize: String? = null,
//
//    val image: JsonObject? = null,
//
//    @SerialName("with_background")
//    val withBackground: Boolean? = null,
//
//    @SerialName("with_border")
//    val withBorder: Boolean? = null
//)
//
//@Serializable
//sealed class ItemUnion {
//    class ItemItemValue(val value: ItemItem) : ItemUnion()
//    class StringValue(val value: String)     : ItemUnion()
//}
//
//@Serializable
//data class ItemItem (
//    val title: String,
//    val image: Attach
//)
//
//@Serializable
//enum class TextTruncated(val value: String) {
//    Same("<<<same>>>");
//
//    companion object : KSerializer<TextTruncated> {
//        override val descriptor: SerialDescriptor
//            get() {
//            return PrimitiveSerialDescriptor("quicktype.TextTruncated", PrimitiveKind.STRING)
//        }
//        override fun deserialize(decoder: Decoder): TextTruncated = when (val value = decoder.decodeString()) {
//            "<<<same>>>" -> Same
//            else         -> throw IllegalArgumentException("TextTruncated could not parse: $value")
//        }
//        override fun serialize(encoder: Encoder, value: TextTruncated) {
//            return encoder.encodeString(value.value)
//        }
//    }
//}