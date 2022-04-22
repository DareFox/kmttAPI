package kmtt.util

import kotlinx.serialization.json.Json

internal val jsonParser = Json {
    ignoreUnknownKeys = true
}