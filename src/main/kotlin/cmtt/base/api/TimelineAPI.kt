package cmtt.base.api

import cmtt.base.ktor.IHttpClient
import io.ktor.client.*

class TimelineAPI(private val httpClient: IHttpClient)