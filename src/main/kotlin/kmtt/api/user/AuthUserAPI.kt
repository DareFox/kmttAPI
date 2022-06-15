package kmtt.api.user

import io.ktor.client.request.*
import io.ktor.http.*
import kmtt.ktor.IHttpClient
import kmtt.ktor.request
import kmtt.models.Notification
import kmtt.models.comment.Comment
import kmtt.models.entry.Entry
import kmtt.models.enums.Website
import kmtt.models.generic.SuccessResponse
import kmtt.models.subsite.Subsite
import kmtt.util.addTokenIfNotNull
import kmtt.util.apiURL
import kotlinx.coroutines.yield

internal class AuthUserAPI(
    private val httpClient: IHttpClient,
    private val site: Website,
    override val token: String,
): IAuthUserAPI, IPublicUserAPI by PublicUserAPI(httpClient, site, token) {
    override suspend fun getMe(): Subsite {
        val endpointURL = "/user/me"

        val response = httpClient.request<SuccessResponse<Subsite>> {
            url(site.apiURL() + endpointURL)
            addTokenIfNotNull(token)
            method = HttpMethod.Get
        }

        return response.result
    }

    override suspend fun getMyNotifications(): List<Notification> {
        val endpointURL = "/user/me/updates"

        val response = httpClient.request<SuccessResponse<List<Notification>>> {
            url(site.apiURL() + endpointURL)
            addTokenIfNotNull(token)
            method = HttpMethod.Get
        }

        return response.result
    }

    override suspend fun getMyNotificationsCount(): Int {
        @kotlinx.serialization.Serializable
        data class Count(val count: Int)

        val endpointURL = "/user/me/updates/count"

        val response = httpClient.request<SuccessResponse<Count>> {
            url(site.apiURL() + endpointURL)
            addTokenIfNotNull(token)
            method = HttpMethod.Get
        }

        return response.result.count
    }

    override suspend fun readNotificationsById(id: Long): Boolean {
        val endpointURL = "/user/me/updates/read/$id"

        val response = httpClient.request<SuccessResponse<SuccessResponse<Boolean>>> {
            url(site.apiURL() + endpointURL)
            addTokenIfNotNull(token)
            method = HttpMethod.Post
        }

        return response.result.result
    }

    override suspend fun readAllNotifications(): List<Notification> {
        val endpointURL = "/user/me/updates?is_read=1"

        val response = httpClient.request<SuccessResponse<List<Notification>>> {
            url(site.apiURL() + endpointURL)
            addTokenIfNotNull(token)
            method = HttpMethod.Get
        }

        return response.result
    }

    override suspend fun getMyComments(count: Int, offset: Int): List<Comment> {
        val endpointURL = "/user/me/comments"
        val params = mutableListOf<Pair<String, String>>()

        params.add("count" to count.toString())
        params.add("offset" to offset.toString())

        val query = params.formUrlEncode().let {
            "?$it"
        }

        val response = httpClient.request<SuccessResponse<List<Comment>>> {
            url(site.apiURL() + endpointURL + query)
            addTokenIfNotNull(token)
            method = HttpMethod.Get
        }

        return response.result
    }

    override suspend fun getAllMyComments(): List<Comment> {
       return getAllMyComments { }
    }

    override suspend fun <T> getAllMyComments(eachGetOperation: suspend (List<Comment>) -> T): List<Comment> {
        val user = getMe()

        val commentCount = user.counters?.comments
        requireNotNull(commentCount) {
            "comment count is null"
        }

        val comments = mutableListOf<Comment>()

        for (offset in 0 until commentCount step 50) {
            yield()
            val comment = getMyComments(50, offset.toInt())
            eachGetOperation(comment)
            comments += comment
        }

        return comments
    }

    override suspend fun getMyEntries(count: Int, offset: Int): List<Entry> {
        val endpointURL = "/user/me/comments"
        val params = mutableListOf<Pair<String, String>>()

        params.add("count" to count.toString())
        params.add("offset" to offset.toString())

        val query = params.formUrlEncode().let {
            "?$it"
        }

        val response = httpClient.request<SuccessResponse<List<Entry>>> {
            url(site.apiURL() + endpointURL + query)
            addTokenIfNotNull(token)
            method = HttpMethod.Get
        }

        return response.result
    }

    override suspend fun getAllMyEntries(): List<Entry> {
        return getAllMyEntries {  }
    }

    override suspend fun <T> getAllMyEntries(eachGetOperation: suspend (List<Entry>) -> T): List<Entry> {
        val user = getMe()

        val entriesCounter = user.counters?.entries
        requireNotNull(entriesCounter) {
            "entry count is null"
        }

        val entries = mutableListOf<Entry>()

        for (offset in 0 until entriesCounter step 50) {
            yield()
            val entry = getMyEntries(50, offset.toInt())
            eachGetOperation(entry)
            entries += entry
        }

        return entries
    }

    override suspend fun getMyFavoriteEntries(count: Int, offset: Int): List<Entry> {
        val endpointURL = "/user/me/favorites/entries"
        val params = mutableListOf<Pair<String, String>>()

        params.add("count" to count.toString())
        params.add("offset" to offset.toString())

        val query = params.formUrlEncode().let {
            "?$it"
        }

        val response = httpClient.request<SuccessResponse<List<Entry>>> {
            url(site.apiURL() + endpointURL + query)
            addTokenIfNotNull(token)
            method = HttpMethod.Get
        }

        return response.result
    }

    override suspend fun getAllMyFavoriteEntries(): List<Entry> {
        return getAllMyFavoriteEntries {  }
    }

    override suspend fun <T> getAllMyFavoriteEntries(eachGetOperation: suspend (List<Entry>) -> T): List<Entry> {
        val user = getMe()

        val entriesCounter = user.counters?.favorites
        requireNotNull(entriesCounter) {
            "entry count is null"
        }

        val entries = mutableListOf<Entry>()

        for (offset in 0 until entriesCounter step 50) {
            yield()
            val entry = getMyFavoriteEntries(50, offset.toInt())
            eachGetOperation(entry)
            entries += entry
        }

        return entries
    }

    override suspend fun getMyFavoriteComments(count: Int, offset: Int): List<Comment> {
        val endpointURL = "/user/me/favorites/comments"
        val params = mutableListOf<Pair<String, String>>()

        params.add("count" to count.toString())
        params.add("offset" to offset.toString())

        val query = params.formUrlEncode().let {
            "?$it"
        }

        val response = httpClient.request<SuccessResponse<List<Comment>>> {
            url(site.apiURL() + endpointURL + query)
            addTokenIfNotNull(token)
            method = HttpMethod.Get
        }

        return response.result
    }

    override suspend fun getAllMyFavoriteComments(): List<Comment> {
        return getAllMyFavoriteComments {  }
    }

    override suspend fun <T> getAllMyFavoriteComments(eachGetOperation: suspend (List<Comment>) -> T): List<Comment> {
        val user = getMe()

        val entriesCounter = user.counters?.favorites
        requireNotNull(entriesCounter) {
            "comment count iы null"
        }

        val comments = mutableListOf<Comment>()

        for (offset in 0 until entriesCounter step 50) {
            yield()
            val comment = getMyFavoriteComments( 50, offset.toInt())
            eachGetOperation(comment)
            comments += comment
        }

        return comments
    }

}