package kmtt.impl

import kmtt.api.comment.IAuthCommentAPI
import kmtt.api.comment.IPublicCommentAPI
import kmtt.api.entry.IAuthEntryAPI
import kmtt.api.entry.IPublicEntryAPI
import kmtt.api.user.IAuthUserAPI
import kmtt.api.user.IPublicUserAPI
import kmtt.models.comment.Comment
import kmtt.models.entry.Entry
import kmtt.models.subsite.Subsite

/**
 * Provides public API for cmtt.ru websites
 */
interface IPublicKmtt {
    /**
     * Public API for getting [entries][Entry] information
     */
    val entry: IPublicEntryAPI

    /**
     * Public API for getting [comments][Comment] information
     */
    val comments: IPublicCommentAPI

    /**
     *  Public API for getting [user][Subsite] information
     */
    val user: IPublicUserAPI
}

/**
 * Provides authenticated API for cmtt.ru websites. It also can get around of non-auth users restrictions of [public API][IPublicKmtt]
 */
interface IAuthKmtt: IPublicKmtt {
    /**
     * Authenticated API for getting and manipulating [entries][Entry] information
     */
    override val entry: IAuthEntryAPI
    /**
     * Authenticated API for getting and manipulating [comments][Comment] information
     */
    override val comments: IAuthCommentAPI
    /**
     *  Authenticated API for getting [user][Subsite] information
     */
    override val user: IAuthUserAPI
}