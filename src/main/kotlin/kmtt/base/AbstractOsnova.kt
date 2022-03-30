package kmtt.base

import kmtt.base.ktor.HttpClientAdapter
import kmtt.base.ktor.IHttpClient
import io.github.resilience4j.ratelimiter.RateLimiterConfig
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
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


    private val client: IHttpClient = HttpClientAdapter(HttpClient() {
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