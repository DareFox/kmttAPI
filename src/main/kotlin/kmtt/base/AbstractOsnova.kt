package kmtt.base

import kmtt.base.ktor.HttpClientAdapter
import kmtt.base.ktor.IHttpClient
import io.github.resilience4j.ratelimiter.RateLimiterConfig
import io.ktor.client.*
import java.io.Closeable
import java.time.Duration

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