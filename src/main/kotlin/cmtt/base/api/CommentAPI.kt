package cmtt.base.api

import cmtt.base.ktor.IHttpClient
import io.ktor.client.*

class CommentAPI(private val httpClient: IHttpClient)