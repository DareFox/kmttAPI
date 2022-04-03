package kmtt.util

import io.ktor.client.request.*

fun HttpRequestBuilder.addTokenIfNotNull(token: String?) {
    if (token != null) {
        this.header("X-Device-Token", token)
    }
}
