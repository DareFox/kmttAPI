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
     * Получить комментарии к записи
     */
    suspend fun getEntryComments(entryID: Long, sorting: SortingType): List<Comment>

    /**
     * Получить комментарии к записи с ограничением по веткам
     */
    suspend fun getLevelComments(entryID: Long, sorting: SortingType): CommentsLevelLimited

    /**
     * Получить комментарии к записи с ограничением по веткам
     */
    suspend fun getThreadComments(entryID: Long, commentID: Long): List<Comment>

    /**
     * Получить список лайкнувших комментарий
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
     * Отправить количество увиденных комментариев
     */
    suspend fun postSeenComments(entryID: Long, count: Long)
}