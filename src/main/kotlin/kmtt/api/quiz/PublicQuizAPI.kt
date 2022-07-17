package kmtt.api.quiz

import io.ktor.client.request.*
import io.ktor.http.*
import kmtt.ktor.IHttpClient
import kmtt.ktor.request
import kmtt.models.QuizResult
import kmtt.models.enums.Website
import kmtt.models.generic.SuccessResponse
import kmtt.util.addTokenIfNotNull
import kmtt.util.apiURL

internal class PublicQuizAPI(private val httpClient: IHttpClient, private val site: Website) : IPublicQuizAPI {
    // Some public requests have restrictions without authentication.
    // For example:
    // User hid his account from anonymous users, and you can't get data about this user without authentication
    internal var token: String? = null

    // This authentication API is *internal* because it only used by authenticated API for delegation
    internal constructor(httpClient: IHttpClient, site: Website, token: String) : this(httpClient, site) {
        this.token = token
    }

    override suspend fun getResults(hash: String): QuizResult {
        val endpointURL = "/quiz/$hash/results"

        val response = httpClient.request<SuccessResponse<QuizResult>> {
            url(site.apiURL() + endpointURL)
            addTokenIfNotNull(token)
            method = HttpMethod.Get
        }

        return response.result
    }
}