package cmtt.base

import cmtt.base.ktor.HttpClientAdapter
import cmtt.base.ktor.IHttpClient
import io.github.resilience4j.ratelimiter.RateLimiterConfig
import io.github.resilience4j.ratelimiter.RateLimiterRegistry
import io.ktor.client.*
import java.io.Closeable
import java.time.Duration
import java.util.*

abstract class AbstractOsnova(token: String) : Closeable {
    abstract val serverURL: String

    private val rateLimitConfig = RateLimiterConfig
        .custom()
        .limitRefreshPeriod(Duration.ofSeconds(1))
        .limitForPeriod(3)
        .timeoutDuration(Duration.ofHours(100))
        .build()


    private val client: IHttpClient = HttpClientAdapter(HttpClient(), rateLimitConfig)

    override fun close() {
        client.close()
    }
}