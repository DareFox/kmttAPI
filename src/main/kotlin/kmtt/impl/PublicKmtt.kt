package kmtt.impl

import kmtt.api.comment.IPublicCommentAPI
import kmtt.api.comment.PublicCommentAPI
import kmtt.api.entry.IPublicEntryAPI
import kmtt.api.entry.PublicEntryAPI
import kmtt.models.enums.Website

internal class PublicKmtt(val website: Website): AbstractKmtt(), IPublicKmtt {
    override val entry: IPublicEntryAPI = PublicEntryAPI(client, website)
    override val comments: IPublicCommentAPI = PublicCommentAPI(client, website)
}