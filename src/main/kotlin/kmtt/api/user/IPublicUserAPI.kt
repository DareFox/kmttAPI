package kmtt.api.user

import kmtt.api.common.Authable
import kmtt.models.Notification
import kmtt.models.comment.Comment
import kmtt.models.entry.Entry
import kmtt.models.subsite.Subsite

interface IPublicUserAPI {
    /**
     * Get user information by ID
     */
    suspend fun getUserByID(userID: Long): Subsite

    /**
     * Get user comments
     *
     * Max count: 50
     */
    suspend fun getUserComments(userID: Long, count: Int, offset: Int): List<Comment>

    /**
     * Get all user comments.
     *
     * If user has a lot of comments, it could take a long time to get all of them
     */
    suspend fun getAllUserComments(userID: Long): List<Comment>

    /**
     * Get all user comments and after each get operation, run lambda block with result of get operation.
     *
     * If user has a lot of comments, it could take a long time to get all of them.
     *
     * @sample sampleEachOperation
     */
    suspend fun <T> getAllUserComments(userID: Long, eachGetOperation: suspend (List<Comment>) -> T): List<Comment>

    /**
     * Get user entries
     *
     * Max count: 50
     */
    suspend fun getUserEntries(userID: Long, count: Int, offset: Int): List<Entry>

    /**
     * Get all user entries.
     *
     * If user has a lot of entries, it could take a long time to get all of them
     */
    suspend fun getAllUserEntries(userID: Long): List<Entry>

    /**
     * Get all user entries and after each get operation, run lambda block with result of get operation.
     *
     * If user has a lot of entries, it could take a long time to get all of them.
     *
     * @sample sampleEachOperation
     */
    suspend fun <T> getAllUserEntries(userID: Long, eachGetOperation: suspend (List<Entry>) -> T): List<Entry>
}

interface IAuthUserAPI : IPublicUserAPI, Authable {

    /**
     * Get information about the current user
     */
    suspend fun getMe(): Subsite

    /**
     * Get notification list for the current user
     */
    suspend fun getMyNotifications(): List<Notification>

    /**
     * Get the number of unread notifications for the current user
     */
    suspend fun getMyNotificationsCount(): Int

    /**
     * Mark the notification as read
     */
    suspend fun readNotificationsById(id: Long): Boolean

    /**
     * Mark all notifications as read
     */
    suspend fun readAllNotifications(): List<Notification>

    /**
     * Get the current user's comments
     *
     * Max count: 50
     */
    suspend fun getMyComments(count: Int, offset: Int): List<Comment>

    /**
     * Get all comments of the current user.
     *
     * If user has a lot of comments, it could take a long time to get all of them
     */
    suspend fun getAllMyComments(): List<Comment>

    /**
     * Get all comments of the current user and after each get operation, run lambda block with result of get operation.
     *
     * If user has a lot of comments, it could take a long time to get all of them.
     *
     * @sample sampleEachOperation
     */
    suspend fun <T> getAllMyComments(eachGetOperation: suspend (List<Comment>) -> T): List<Comment>

    /**
     * Get entries of the current user
     *
     * Max count: 50
     */
    suspend fun getMyEntries(count: Int, offset: Int): List<Entry>

    /**
     * Get all entries of the current user.
     *
     * If user has a lot of entries, it could take a long time to get all of them
     */
    suspend fun getAllMyEntries(): List<Entry>

    /**
     * Get all entries of the current user and after each get operation, run lambda block with result of get operation.
     *
     * If user has a lot of entries, it could take a long time to get all of them.
     *
     * @sample sampleEachOperation
     */
    suspend fun <T> getAllMyEntries(eachGetOperation: suspend (List<Entry>) -> T): List<Entry>

    /**
     * Get the current user's favorites
     *
     * Max count: 50
     */
    suspend fun getMyFavoriteEntries(count: Int, offset: Int): List<Entry>

    /**
     * Get all favorites of the current user.
     *
     * If user has a lot of entries, it could take a long time to get all of them
     */
    suspend fun getAllMyFavoriteEntries(): List<Entry>

    /**
     * Get all favorite entries of the current user and after each get operation, run lambda block with result of get operation.
     *
     * If user has a lot of favorites, it could take a long time to get all of them.
     *
     * @sample sampleEachOperation
     */
    suspend fun <T> getAllMyFavoriteEntries(eachGetOperation: suspend (List<Entry>) -> T): List<Entry>

    /**
     * Get the current user's favorite comments.
     *
     * Max count: 50
     */
    suspend fun getMyFavoriteComments(count: Int, offset: Int): List<Comment>

    /**
     * Get all the current user's favorite comments.
     *
     * If user has a lot of entries, it could take a long time to get all of them
     */
    suspend fun getAllMyFavoriteComments(): List<Comment>

    /**
     * Get all favorite comments of the current user and after each get operation, run lambda block with result of get operation.
     *
     * If user has a lot of favorite comments, it could take a long time to get all of them.
     *
     * @sample sampleEachOperation
     */
    suspend fun <T> getAllMyFavoriteComments(eachGetOperation: suspend (List<Comment>) -> T): List<Comment>
}