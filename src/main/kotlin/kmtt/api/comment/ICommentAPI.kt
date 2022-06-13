package kmtt.api.comment

import kmtt.api.common.Authable
import kmtt.api.entry.IPublicEntryAPI
import kmtt.models.Liker
import kmtt.models.comment.Comment
import kmtt.models.comment.CommentsLevelLimited
import kmtt.models.entry.Entry
import kmtt.models.enums.SortingType

/**
 * Public API for getting [comments][Comment] information
 */
interface IPublicCommentAPI {
    /**
     * Get comments to an entry
     */
    suspend fun getEntryComments(entryID: Long, sorting: SortingType): List<Comment>

    /**
     * Get comments of the record with thread level restriction
     */
    suspend fun getLevelComments(entryID: Long, sorting: SortingType): CommentsLevelLimited

    /**
     * Get comments of the record with thread restriction
     */
    suspend fun getThreadComments(entryID: Long, commentID: Long): List<Comment>

    /**
     * Get a list of people who liked the comment
     */
    suspend fun getCommentVotes(commentID: Long): Map<String, Liker>
}

/**
 * Authenticated API for getting and manipulating [comments][Comment] information.
 *
 * Also provides access to [public API][IPublicCommentAPI]
 */
interface IAuthCommentAPI: IPublicCommentAPI, Authable {
    /**
     * Send the number of comments seen
     */
    suspend fun postSeenComments(entryID: Long, count: Long)
}