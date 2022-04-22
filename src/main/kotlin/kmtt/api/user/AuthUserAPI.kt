package kmtt.api.user

import io.ktor.client.request.*
import io.ktor.http.*
import kmtt.constants.Content
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

}