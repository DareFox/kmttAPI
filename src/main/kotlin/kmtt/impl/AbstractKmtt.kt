package kmtt.impl

import io.github.resilience4j.ratelimiter.RateLimiterConfig
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import kmtt.ktor.HttpClientAdapter
import kmtt.ktor.IHttpClient
import java.io.Closeable
import java.time.Duration

/**
 * Abstract class that provides [IHttpClient] implementation with rate limit
 */
abstract class AbstractKmtt(
    limitForPeriod: Int = 3,
    limitRefreshPeriod: Duration = Duration.ofSeconds(1),
    timeoutDuration: Duration = Duration.ofHours(100)
) : Closeable {
    private val rateLimitConfig = RateLimiterConfig
        .custom()
        .limitRefreshPeriod(limitRefreshPeriod)
        .limitForPeriod(limitForPeriod)
        .timeoutDuration(timeoutDuration)
        .build()


    protected val client: IHttpClient = HttpClientAdapter(HttpClient {
        install(JsonFeature) {
            serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                ignoreUnknownKeys = true
            })
        }
    }, rateLimitConfig)

    override fun close() {
        client.close()
    }
}