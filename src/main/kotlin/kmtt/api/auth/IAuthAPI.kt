package kmtt.api.auth

import kmtt.models.enums.SocialAccountType
import kmtt.models.subsite.Subsite

interface IAuthAPI {
    suspend fun postAuthLogin(login: String, password: String): List<Subsite>

    suspend fun postAuthSocial(
        email: String,
        token: String,
        social: SocialAccountType,
        toLink: Boolean = false,
    ): List<Subsite>

    suspend fun postAuthQR(token: String): List<Subsite>
}