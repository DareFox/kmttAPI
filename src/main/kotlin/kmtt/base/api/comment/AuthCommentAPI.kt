package kmtt.base.api.comment

import io.ktor.client.request.*
import io.ktor.http.*
import kmtt.base.ktor.IHttpClient
import kmtt.base.ktor.request
import kmtt.base.models.Liker
import kmtt.base.models.comment.Comment
import kmtt.base.models.comment.CommentsLevelLimited
import kmtt.base.models.enums.SortingType
import kmtt.base.models.enums.Website
import kmtt.base.models.generic.SuccessArrayResponse
import kmtt.base.models.generic.SuccessResponse
import kmtt.constants.Content
import kmtt.util.addTokenIfNotNull
import kmtt.util.apiURL
import kmtt.util.defaultResponse
import kmtt.util.jsonParser
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.decodeFromJsonElement

class AuthCommentAPI(private val httpClient: IHttpClient, private val site: Website, override var token: String) :
    IAuthCommentAPI, IPublicCommentAPI by PublicCommentAPI(httpClient, site, token) {

    // Not working in API 1.9
    // API 2.1 doesn't support
    // TODO: Make it with User-api
//    suspend fun postLike(id: Long, type: OsnovaContentType, vote: Vote): Likes {
////     USER-API. COOKIE VALUE REQUIRED
//        @kotlinx.serialization.Serializable
//        data class LikeData(
//            val id: Long,
//            val sign: String,
//            val mode: String,
//            val type: String, // 4 for Comment, 1 for Entry
//        )
//
//        val endpointURL = "/vote/like"
//
//        val data = LikeData(
//            id = id,
//            sign = vote.value.toString(),
//            mode = "raw",
//            type = when (type) {
//                OsnovaContentType.COMMENT -> "4"
//                OsnovaContentType.ENTRY -> "1"
//            }
//        )
//
//        val response = httpClient.request<SuccessResponse<Likes>> {
//            contentType(Content.JSON)
//            url("https://" + site.baseURL + endpointURL)
//            header("x-device-token", token)
//            method = HttpMethod.Post
//            body = jsonParser.encodeToString(data)
//        }
//
//        return response.result
//    }

    // Not working in API 1.9
    // API 2.1 doesn't support
    // TODO: Make it with User-api
//    suspend fun postCommentEdit(entryID: Long, commentID: Long, text: String, attachments: List<Attach>): List<Subsite> {
//        val data = mutableMapOf<String, JsonElement>()
//        val endpointURL = "/comment/edit"
//
//        data["entryID"] = JsonPrimitive(entryID)
//        data["commentID"] = JsonPrimitive(commentID)
//        data["text"] = JsonPrimitive(text)
//        data["attachments"] = jsonParser.encodeToJsonElement(attachments)
//
//        val response = httpClient.request<SuccessResponse<List<Subsite>>> {
//            contentType(Content.JSON)
//            url(site.apiURL() + endpointURL)
//            method = HttpMethod.Post
//            body = data
//        }
//
//        return response.result
//    }

    // Not working in API 1.9
    // API 2.1 doesn't support
    // TODO: Make it with User-api
    /**
     * Отправить комментарий. Чтобы создать комментарий с прикреплениями, в запросе нужно передать поле attachments. Внутри должен быть JSON-массив с приложениями, предварительно загруженными через API в том же формате, который был получен при загрузке.
     *
     * При отправке комментариев с помощью API у вас есть возможность создать ссылку в формате markdown: [text on place of link](https://ya.ru/)
     */
//    suspend fun postCommentAdd(id: Long, text: String, replyToID: Long, attachments: List<Attach>): Comment {
//        @kotlinx.serialization.Serializable
//        data class CommentData(
//            val id: String,
//            val text: String,
//            val reply_to: String,
//            val attachments: List<Attach>
//        )
//
//        val endpointURL = "/comment/add"
//        val data = CommentData(id.toString(), text, replyToID.toString(), attachments)
//
//        val response = httpClient.request<SuccessResponse<Comment>> {
//            contentType(Content.JSON)
//            url(site.apiURL() + endpointURL)
//            header("x-device-token", token)
//            method = HttpMethod.Post
//            body = jsonParser.encodeToString(data)
//        }
//        return response.result
//    }

    /**
     * Отправить количество увиденных комментариев
     */
    override suspend fun postSeenComments(entryID: Long, count: Long) {
        val endpointURL = "/comment/saveCommentsSeenCount"
        val data = mapOf(
            "content_id" to entryID,
            "count" to count,
        )

        httpClient.request<JsonObject> {
            contentType(Content.JSON)
            addTokenIfNotNull(token)
            url(site.apiURL() + endpointURL)
            method = HttpMethod.Post
            body = data
        }
    }
}