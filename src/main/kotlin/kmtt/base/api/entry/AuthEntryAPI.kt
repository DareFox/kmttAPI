package kmtt.base.api.entry

import kmtt.base.ktor.IHttpClient
import kmtt.base.models.enums.Website

class AuthEntryAPI(private val httpClient: IHttpClient, private val site: Website, override val token: String)
    : IAuthEntryAPI, IPublicEntryAPI by PublicEntryAPI(httpClient, site, token) {

}