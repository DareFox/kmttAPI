package kmtt.base.api.auth

import kmtt.base.models.enums.SocialAccountType
import kmtt.base.models.subsite.Subsite

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