package cmtt.util

import kotlinx.serialization.json.Json

/**
 *  Ignore unknown keys
 */
val JsonUnk = Json { ignoreUnknownKeys = true }