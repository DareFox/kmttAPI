package cmtt.base

import io.github.resilience4j.ratelimiter.RateLimiterConfig
import io.github.resilience4j.ratelimiter.RateLimiterRegistry
import io.ktor.client.*
import java.io.Closeable
import java.time.Duration
import java.util.*

abstract class OsnovaAPI(token: String) : Closeable {
    abstract val serverURL: String

    private val rateLimitConfig = RateLimiterConfig
        .custom()
        .limitRefreshPeriod(Duration.ofSeconds(1))
        .limitForPeriod(3)
        .timeoutDuration(Duration.ofHours(100))
        .build()

    private val rateLimitID = UUID.randomUUID().toString()
    private val rateLimiterRegistry = RateLimiterRegistry.of(rateLimitConfig)
    private val rateLimiter = rateLimiterRegistry.rateLimiter(rateLimitID)

    private val client = HttpClient()

    override fun close() {
        client.close()
        rateLimiterRegistry.remove(rateLimitID)
    }


}