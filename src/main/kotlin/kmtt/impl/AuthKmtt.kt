package kmtt.impl

import kmtt.api.comment.AuthCommentAPI
import kmtt.api.comment.IAuthCommentAPI
import kmtt.api.entry.AuthEntryAPI
import kmtt.api.entry.IAuthEntryAPI
import kmtt.models.enums.Website

class AuthKmtt(val website: Website, val token: String): AbstractKmtt(), IAuthKmtt {
    override val entry: IAuthEntryAPI = AuthEntryAPI(client, website, token)
    override val comments: IAuthCommentAPI = AuthCommentAPI(client, website, token)
}