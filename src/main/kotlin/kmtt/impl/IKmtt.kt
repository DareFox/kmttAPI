package kmtt.impl

import kmtt.api.comment.IAuthCommentAPI
import kmtt.api.comment.IPublicCommentAPI
import kmtt.api.entry.IAuthEntryAPI
import kmtt.api.entry.IPublicEntryAPI
import kmtt.models.comment.Comment
import kmtt.models.entry.Entry

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
}