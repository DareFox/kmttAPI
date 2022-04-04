package kmtt.base.ktor

import io.github.resilience4j.kotlin.ratelimiter.executeSuspendFunction
import io.github.resilience4j.ratelimiter.RateLimiter
import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.util.*
import kmtt.base.models.generic.ErrorResponse
import kmtt.exception.OsnovaRequestException
import kmtt.util.jsonParser
import kotlinx.coroutines.CoroutineScope
import kotlinx.serialization.decodeFromString
import java.io.Closeable

/**
 * Extracted interface of [Ktor client][HttpClient]. Can be used for implementing extended versions of client
 */
internal interface IHttpClient : CoroutineScope, Closeable {
    val client: HttpClient
    val rateLimiter: RateLimiter

    val requestPipeline: HttpRequestPipeline
    val responsePipeline: HttpResponsePipeline
    val sendPipeline: HttpSendPipeline
    val receivePipeline: HttpReceivePipeline
    val attributes: Attributes
    val engineConfig: HttpClientEngineConfig

    fun isSupported(capability: HttpClientEngineCapability<*>): Boolean
    fun config(block: HttpClientConfig<*>.() -> Unit): io.ktor.client.HttpClient
    override fun toString(): String
}

/**
 * Builder for creating http requests
 */
internal suspend inline fun <reified T> IHttpClient.request(crossinline block: HttpRequestBuilder.() -> Unit): T {
    try {
        return rateLimiter.executeSuspendFunction {
            client.request(block)
        }
    } catch (ex: ClientRequestException) {
        lateinit var parsed: ErrorResponse
        var isParsed = false

        try {
            parsed = jsonParser.decodeFromString<ErrorResponse>(String(ex.response.readBytes()))
            isParsed = true
        } catch (_: Exception) {
        }

        if (isParsed) {
            throw OsnovaRequestException(ex.response, parsed)
        } else {
            throw ex
        }
    }
}