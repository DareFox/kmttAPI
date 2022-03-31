package kmtt.base.ktor

import io.github.resilience4j.kotlin.ratelimiter.executeSuspendFunction
import io.github.resilience4j.ratelimiter.RateLimiter
import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.util.*
import kotlinx.coroutines.CoroutineScope
import java.io.Closeable

interface IHttpClient : CoroutineScope, Closeable {
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

suspend inline fun <reified T> IHttpClient.request(crossinline block: HttpRequestBuilder.() -> Unit): T {
    return rateLimiter.executeSuspendFunction {
        client.request(block)
    }
}