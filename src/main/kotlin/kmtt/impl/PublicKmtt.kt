package kmtt.impl

import kmtt.api.comment.IPublicCommentAPI
import kmtt.api.comment.PublicCommentAPI
import kmtt.api.entry.IPublicEntryAPI
import kmtt.api.entry.PublicEntryAPI
import kmtt.api.user.IPublicUserAPI
import kmtt.api.user.PublicUserAPI
import kmtt.models.enums.Website

internal class PublicKmtt(val website: Website): AbstractKmtt(), IPublicKmtt {
    override val entry: IPublicEntryAPI = PublicEntryAPI(client, website)
    override val comments: IPublicCommentAPI = PublicCommentAPI(client, website)
    override val user: IPublicUserAPI = PublicUserAPI(client, website)
}