package kmtt.api.user

import io.ktor.client.request.*
import io.ktor.http.*
import kmtt.ktor.IHttpClient
import kmtt.ktor.request
import kmtt.models.comment.Comment
import kmtt.models.entry.Entry
import kmtt.models.enums.Website
import kmtt.models.generic.SuccessResponse
import kmtt.models.subsite.Subsite
import kmtt.util.addTokenIfNotNull
import kmtt.util.apiURL
import kotlinx.coroutines.yield

internal class PublicUserAPI(private val httpClient: IHttpClient, private val site: Website) : IPublicUserAPI {
    // Some public requests have restrictions without authentication.
    // For example:
    // User hid his account from anonymous users, and you can't get data about this user without authentication
    internal var token: String? = null

    // This authentication API is *internal* because it only used by authenticated API for delegation
    internal constructor(httpClient: IHttpClient, site: Website, token: String) : this(httpClient, site) {
        this.token = token
    }

    override suspend fun getUserByID(userID: Long): Subsite {
        val endpointURL = "/user/$userID"

        val response = httpClient.request<SuccessResponse<Subsite>> {
            url(site.apiURL() + endpointURL)
            addTokenIfNotNull(token)
            method = HttpMethod.Get
        }

        return response.result
    }

    override suspend fun getUserComments(userID: Long, count: Int, offset: Int): List<Comment> {
        val endpointURL = "/user/$userID/comments"
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

    override suspend fun getAllUserComments(userID: Long): List<Comment> {
        return getAllUserComments(userID) {}
    }

    override suspend fun <T> getAllUserComments(userID: Long, eachGetOperation: suspend (List<Comment>) -> T): List<Comment> {
        val user = getUserByID(userID)

        val commentCount = user.counters?.comments
        requireNotNull(commentCount) {
            "comment count in null"
        }

        val comments = mutableListOf<Comment>()

        for (offset in 0 until commentCount step 50) {
            yield()
            val comment = getUserComments(userID, 50, offset.toInt())
            eachGetOperation(comment)
            comments += comment
        }

        return comments
    }

    override suspend fun getUserEntries(userID: Long, count: Int, offset: Int): List<Entry> {
        val endpointURL = "/user/$userID/entries"
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

    override suspend fun getAllUserEntries(userID: Long): List<Entry> {
        return getAllUserEntries(userID) {}
    }

    override suspend fun <T> getAllUserEntries(userID: Long, eachGetOperation: suspend (List<Entry>) -> T): List<Entry> {
        val user = getUserByID(userID)

        val entriesCounter = user.counters?.entries
        requireNotNull(entriesCounter) {
            "comment count in null"
        }

        val entries = mutableListOf<Entry>()

        for (offset in 0 until entriesCounter step 50) {
            yield()
            val entry = getUserEntries(userID, 50, offset.toInt())
            eachGetOperation(entry)
            entries += entry
        }

        return entries
    }
}