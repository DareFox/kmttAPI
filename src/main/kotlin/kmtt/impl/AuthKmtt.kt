package kmtt.impl

import kmtt.api.comment.AuthCommentAPI
import kmtt.api.comment.IAuthCommentAPI
import kmtt.api.entry.AuthEntryAPI
import kmtt.api.entry.IAuthEntryAPI
import kmtt.api.user.AuthUserAPI
import kmtt.api.user.IAuthUserAPI
import kmtt.api.user.IPublicUserAPI
import kmtt.models.enums.Website

internal class AuthKmtt(val website: Website, val token: String): AbstractKmtt(), IAuthKmtt {
    override val entry: IAuthEntryAPI = AuthEntryAPI(client, website, token)
    override val comments: IAuthCommentAPI = AuthCommentAPI(client, website, token)
    override val user: IAuthUserAPI = AuthUserAPI(client, website, token)
}