package kmtt.api.comment

import kmtt.api.common.Authable
import kmtt.models.Liker
import kmtt.models.comment.Comment
import kmtt.models.comment.CommentsLevelLimited
import kmtt.models.enums.SortingType

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

interface IAuthCommentAPI: IPublicCommentAPI, Authable {
    /**
     * Отправить количество увиденных комментариев
     */
    suspend fun postSeenComments(entryID: Long, count: Long)
}