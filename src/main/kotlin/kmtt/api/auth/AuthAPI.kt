package kmtt.api.auth

import io.ktor.client.request.*
import io.ktor.http.*
import kmtt.ktor.IHttpClient
import kmtt.ktor.request
import kmtt.models.enums.SocialAccountType
import kmtt.models.enums.Website
import kmtt.models.generic.SuccessResponse
import kmtt.models.subsite.Subsite
import kmtt.constants.Content
import kmtt.util.apiURL
import kmtt.util.toInt

internal class AuthAPI(private val httpClient: IHttpClient, private val site: Website) : IAuthAPI {
    override suspend fun postAuthLogin(login: String, password: String): List<Subsite> {
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

    override suspend fun postAuthSocial(
        email: String,
        token: String,
        social: SocialAccountType,
        toLink: Boolean,
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

    override suspend fun postAuthQR(token: String): List<Subsite> {
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