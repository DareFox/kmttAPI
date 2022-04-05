package kmtt.impl

import kmtt.api.comment.IAuthCommentAPI
import kmtt.api.comment.IPublicCommentAPI
import kmtt.api.entry.IAuthEntryAPI
import kmtt.api.entry.IPublicEntryAPI

/**
 * Provides public API for cmtt.ru websites
 */
interface IPublicKmtt {
    val entry: IPublicEntryAPI
    val comments: IPublicCommentAPI
}

/**
 * Provides authenticated API for cmtt.ru websites. It also can get around of non-auth users restrictions of [public API][IPublicKmtt]
 */
interface IAuthKmtt: IPublicKmtt {
    override val entry: IAuthEntryAPI
    override val comments: IAuthCommentAPI
}