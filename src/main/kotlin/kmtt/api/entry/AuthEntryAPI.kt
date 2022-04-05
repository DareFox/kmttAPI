package kmtt.api.entry

import kmtt.ktor.IHttpClient
import kmtt.models.enums.Website

internal class AuthEntryAPI(private val httpClient: IHttpClient, private val site: Website, override val token: String)
    : IAuthEntryAPI, IPublicEntryAPI by PublicEntryAPI(httpClient, site, token) {

}