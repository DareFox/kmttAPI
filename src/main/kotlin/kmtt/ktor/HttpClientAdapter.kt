package kmtt.ktor

import io.github.resilience4j.ratelimiter.RateLimiter
import io.github.resilience4j.ratelimiter.RateLimiterConfig
import io.github.resilience4j.ratelimiter.RateLimiterRegistry
import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.util.*
import java.util.*
import kotlin.coroutines.CoroutineContext

class HttpClientAdapter(override val client: HttpClient, rateLimitConfig: RateLimiterConfig) : IHttpClient {
    private val rateLimitID = UUID.randomUUID().toString()
    private val rateLimiterRegistry = RateLimiterRegistry.of(rateLimitConfig)
    override val rateLimiter: RateLimiter = rateLimiterRegistry.rateLimiter(rateLimitID)

    override val coroutineContext: CoroutineContext
        get() = client.coroutineContext
    override val requestPipeline: HttpRequestPipeline
        get() = client.requestPipeline
    override val responsePipeline: HttpResponsePipeline
        get() = client.responsePipeline
    override val sendPipeline: HttpSendPipeline
        get() = client.sendPipeline
    override val receivePipeline: HttpReceivePipeline
        get() = client.receivePipeline
    override val attributes: Attributes
        get() = client.attributes
    override val engineConfig: HttpClientEngineConfig
        get() = client.engineConfig

    override fun isSupported(capability: HttpClientEngineCapability<*>): Boolean = client.isSupported(capability)

    override fun config(block: HttpClientConfig<*>.() -> Unit): HttpClient = client.config(block)

//    suspend inline fun <reified T : Any> request(block: HttpRequestBuilder.() -> Unit): T {
//        return client.request<T>(block)
//    }

    override fun toString(): String = client.toString()

    override fun close() {
        client.close()
        rateLimiterRegistry.remove(rateLimitID)
    }
}