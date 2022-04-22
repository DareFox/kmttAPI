package kmtt.api.user

import kmtt.api.common.Authable
import kmtt.models.Notification
import kmtt.models.comment.Comment
import kmtt.models.entry.Entry
import kmtt.models.subsite.Subsite

interface IPublicUserAPI {
    /**
     * Получить информацию о пользователе
     */
    suspend fun getUserByID(userID: Long): Subsite

    /**
     * Получить комментарии пользователя
     */
    suspend fun getUserComments(userID: Long, count: Int, offset: Int): List<Comment>

    /**
     * Получить записи пользователя
     */
    suspend fun getUserEntries(userID: Long, count: Int, offset: Int): List<Entry>
}

interface IAuthUserAPI : IPublicUserAPI, Authable {

    /**
     * Получить информацию о текущем пользователе
     */
    suspend fun getMe(): Subsite

    /**
     * Получить список уведомлений
     */
    suspend fun getMyNotifications(): List<Notification>

    /**
     * Получить количество непрочитанных уведомлений у текущего пользователя
     */
    suspend fun getMyNotificationsCount(): Int

    /**
     * Сделать уведомление прочитанным
     */
    suspend fun readNotificationsById(id: Long): Boolean

    /**
     * Сделать уведомления прочитанными
     */
    suspend fun readAllNotifications(): List<Notification>

    /**
     * Получить комментарии текущего пользователя
     */
    suspend fun getMyComments(count: Int, offset: Int): List<Comment>

    /**
     * Получить записи текущего пользователя
     */
    suspend fun getMyEntries(count: Int, offset: Int): List<Entry>

    /**
     * Получить избранные записи текущего пользователя
     */
    suspend fun getMyFavoriteEntries(count: Int, offset: Int): List<Entry>

    /**
     * Получить избранные комментарии текущего пользователя
     */
    suspend fun getMyFavoriteComments(count: Int, offset: Int): List<Comment>
}