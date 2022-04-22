package kmtt.api.user

import kmtt.api.common.Authable
import kmtt.models.Notification
import kmtt.models.comment.Comment
import kmtt.models.entry.Entry
import kmtt.models.subsite.Subsite

interface IPublicUserAPI {
    suspend fun getUserByID(userID: Long): Subsite

    suspend fun getUserComments(userID: Long, count: Int, offset: Int): List<Comment>

    suspend fun getUserEntries(userID: Long, count: Int, offset: Int): List<Entry>
}

interface IAuthUserAPI : IPublicUserAPI, Authable {
    suspend fun getMe(): Subsite

    suspend fun getMyNotifications(): List<Notification>

    suspend fun getMyNotificationsCount(): Int

    suspend fun readNotificationsById(id: Long): Boolean

    suspend fun readAllNotifications(): List<Notification>

    suspend fun getMyComments(count: Int, offset: Int): List<Comment>

    suspend fun getMyEntries(count: Int, offset: Int): List<Entry>

    suspend fun getMyFavoriteEntries(count: Int, offset: Int): List<Entry>

    suspend fun getMyFavoriteComments(count: Int, offset: Int): List<Comment>
}