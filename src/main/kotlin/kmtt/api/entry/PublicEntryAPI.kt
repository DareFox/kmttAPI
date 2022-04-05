package kmtt.api.entry

import io.ktor.client.request.*
import io.ktor.http.*
import kmtt.ktor.IHttpClient
import kmtt.ktor.request
import kmtt.models.attach.Attach
import kmtt.models.entry.Entry
import kmtt.models.enums.Website
import kmtt.models.generic.SuccessResponse
import kmtt.constants.Content
import kmtt.util.addTokenIfNotNull
import kmtt.util.apiURL

internal class PublicEntryAPI(private val httpClient: IHttpClient, private val site: Website): IPublicEntryAPI {

    // Some public requests have restrictions without authentication.
    // For example:
    // User hid his account from anonymous users, and you can't get data about this user without authentication
    internal var token: String? = null

    // This authentication API is *internal* because it only used by authenticated API for delegation
    internal constructor(httpClient: IHttpClient, site: Website, token: String) : this(httpClient, site) {
        this.token = token
    }

    override suspend fun getEntry(id: Long): Entry {
        val endpointURL = "/entry/$id"

        val response = httpClient.request<SuccessResponse<Entry>> {
            url(site.apiURL() + endpointURL)
            addTokenIfNotNull(token)
            method = HttpMethod.Get
        }

        return response.result
    }

    override suspend fun getEntry(url: String): Entry {
        val endpointURL = "/entry/locate"
        val urlEncodedQuery = site.apiURL() + endpointURL + "?url=$url"

        val response = httpClient.request<SuccessResponse<Entry>> {
            url(urlEncodedQuery)
            addTokenIfNotNull(token)
            method = HttpMethod.Get
        }

        return response.result
    }

    override suspend fun getPopularEntriesByEntry(id: Long): List<Entry> {
        val endpointURL = "/entry/$id/popular"

        val response = httpClient.request<SuccessResponse<List<Entry>>> {
            url(site.apiURL() + endpointURL)
            addTokenIfNotNull(token)
            method = HttpMethod.Get
        }

        return response.result
    }

//    override suspend fun getAttachEmbedData(embedURL: String): Attach {
//        val endpointURL = "/entry/attachEmbed"
//        val data = mapOf(
//            "url" to embedURL
//        )
//
//        val response = httpClient.request<SuccessResponse<Attach>> {
//            contentType(Content.JSON)
//            addTokenIfNotNull(token)
//            url(site.apiURL() + endpointURL)
//            method = HttpMethod.Post
//            body = data
//        }
//
//        return response.result
//    }

}