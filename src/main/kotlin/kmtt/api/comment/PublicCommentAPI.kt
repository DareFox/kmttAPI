package kmtt.api.comment

import io.ktor.client.request.*
import io.ktor.http.*
import kmtt.ktor.IHttpClient
import kmtt.ktor.request
import kmtt.models.Liker
import kmtt.models.comment.Comment
import kmtt.models.comment.CommentsLevelLimited
import kmtt.models.enums.SortingType
import kmtt.models.enums.Website
import kmtt.models.generic.SuccessArrayResponse
import kmtt.models.generic.SuccessResponse
import kmtt.util.addTokenIfNotNull
import kmtt.util.apiURL
import kmtt.util.defaultResponse
import kmtt.util.jsonParser
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.decodeFromJsonElement

internal class PublicCommentAPI(private val httpClient: IHttpClient, private val site: Website) : IPublicCommentAPI {

    // Some public requests have restrictions without authentication.
    // For example:
    // User hid his account from anonymous users, and you can't get data about this user without authentication
    internal var token: String? = null

    // This authentication API is *internal* because it only used by authenticated API for delegation
    internal constructor(httpClient: IHttpClient, site: Website, token: String) : this(httpClient, site) {
        this.token = token
    }

    /**
     * Получить комментарии к записи
     */
    override suspend fun getEntryComments(entryID: Long, sorting: SortingType): List<Comment> {
        val endpointURL = "/entry/$entryID/comments/${sorting.typeValue}"

        val response = httpClient.request<SuccessResponse<List<Comment>>> {
            url(site.apiURL() + endpointURL)
            addTokenIfNotNull(token)
            method = HttpMethod.Get
        }

        return response.result
    }

    /**
     * Получить комментарии к записи с ограничением по веткам
     */
    override suspend fun getLevelComments(entryID: Long, sorting: SortingType): CommentsLevelLimited {
        val endpointURL = "/entry/$entryID/comments/levels/${sorting.typeValue}"

        val response = httpClient.request<SuccessResponse<CommentsLevelLimited>> {
            url(site.apiURL() + endpointURL)
            addTokenIfNotNull(token)
            method = HttpMethod.Get
        }

        return response.result
    }

    /**
     * Получить комментарии к записи с ограничением по веткам
     */
    override suspend fun getThreadComments(entryID: Long, commentID: Long): List<Comment> {
        val endpointURL = "/entry/$entryID/comments/thread/${commentID}"

        val response = httpClient.request<SuccessArrayResponse<List<Comment>>> {
            url(site.apiURL() + endpointURL)
            addTokenIfNotNull(token)
            method = HttpMethod.Get
        }

        return response.result.items
    }

    /**
     * Получить список лайкнувших комментарий
     */
    override suspend fun getCommentVotes(commentID: Long): Map<String, Liker> {
        val endpointURL = "/comment/likers/$commentID"

        val response = httpClient.request<JsonObject> {
            url(site.apiURL() + endpointURL)
            addTokenIfNotNull(token)
            method = HttpMethod.Get
        }.defaultResponse(mapOf<String, Liker>())

        return jsonParser.decodeFromJsonElement<SuccessResponse<Map<String, Liker>>>(response).result
    }
}