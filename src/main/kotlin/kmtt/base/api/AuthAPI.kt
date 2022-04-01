package kmtt.base.api

import io.ktor.client.request.*
import io.ktor.http.*
import kmtt.base.ktor.IHttpClient
import kmtt.base.ktor.request
import kmtt.base.models.enums.SocialAccountType
import kmtt.base.models.enums.Website
import kmtt.base.models.generic.SuccessResponse
import kmtt.base.models.subsite.Subsite
import kmtt.constants.Content
import kmtt.util.apiURL
import kmtt.util.toInt

class AuthAPI(private val httpClient: IHttpClient, private val site: Website) {
    suspend fun postAuthLogin(login: String, password: String): List<Subsite> {
        val endpointURL = "/auth/login"
        val data = mapOf("login" to login, "password" to password)

        val response = httpClient.request<SuccessResponse<List<Subsite>>> {
            contentType(Content.JSON)
            url(site.apiURL() + endpointURL)
            method = HttpMethod.Post
            body = data
        }

        return response.result
    }

    suspend fun postAuthSocial(
        email: String,
        token: String,
        social: SocialAccountType,
        toLink: Boolean = false,
    ): List<Subsite> {
        val endpointURL = "/auth/login/${social.typeValue}"
        val data = mapOf(
            "token" to token,
            "email" to email,
            "linking" to toLink.toInt()
        )

        val response = httpClient.request<SuccessResponse<List<Subsite>>> {
            contentType(Content.JSON)
            url(site.apiURL() + endpointURL)
            method = HttpMethod.Post
            body = data
        }

        return response.result
    }

    suspend fun postAuthQR(token: String): List<Subsite> {
        val endpointURL = "/auth/qr/"
        val data = mapOf("token" to token)

        val response = httpClient.request<SuccessResponse<List<Subsite>>> {
            contentType(Content.JSON)
            url(site.apiURL() + endpointURL)
            method = HttpMethod.Post
            body = data
        }

        return response.result
    }
}