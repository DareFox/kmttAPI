package kmtt.common

import io.github.resilience4j.ratelimiter.RateLimiterConfig
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import kmtt.ktor.HttpClientAdapter
import kmtt.ktor.IHttpClient
import kmtt.models.enums.Website
import kmtt.models.EntryComment
import java.time.Duration
import kotlin.properties.Delegates

internal object Shared {
    val httpClient: IHttpClient
    val website: Website = Website.DTF
    val token: String? = System.getenv("TEST_DTF_TOKEN")

    val comments: List<EntryComment> = listOf(
        EntryComment(1123335, 16158631, Website.DTF),
        EntryComment(1110947, 15994992, Website.DTF)
    )

    val publicProfileID = listOf(
        3351
    )

    val privateProfileID = listOf(
        68409
    )

    init {
        val rateLimitConfig = RateLimiterConfig
            .custom()
            .limitRefreshPeriod(Duration.ofSeconds(1))
            .limitForPeriod(3)
            .timeoutDuration(Duration.ofHours(100))
            .build()

        httpClient = HttpClientAdapter(HttpClient {
            install(JsonFeature) {
                serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                    ignoreUnknownKeys = true
                })
            }
        }, rateLimitConfig)
    }
}
