package kmtt.api.quiz

import kmtt.api.entry.IAuthEntryAPI
import kmtt.api.entry.IPublicEntryAPI
import kmtt.api.entry.PublicEntryAPI
import kmtt.ktor.IHttpClient
import kmtt.models.enums.Website

internal class AuthQuizAPI(private val httpClient: IHttpClient, private val site: Website, override val token: String)
    : IAuthQuizAPI, IPublicQuizAPI by PublicQuizAPI(httpClient, site, token) {

}