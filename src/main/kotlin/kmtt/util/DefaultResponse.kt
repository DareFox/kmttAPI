package kmtt.util

import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlinx.serialization.json.jsonArray

/**
 * Convert empty `result` value (empty JSON array) to null or set to default value.
 */
internal inline fun <reified T : Any> defaultResponse(response: JsonObject, default: T? = null): JsonObject {
    val newObject: JsonObject = if (response["result"] is JsonArray && response["result"]!!.jsonArray.isEmpty()) {
        // recreate json object with modified "result" value
        val jsonValues = response.entries.associate {
            if (it.key == "result") {
                Pair(it.key, jsonParser.encodeToJsonElement(default))
            } else {
                it.toPair()
            }
        }

        JsonObject(jsonValues)
    } else {
        response
    }

    return newObject
}


/**
 * Convert empty `result` value (empty JSON array) to null or set to default value.
 */
@JvmName("defaultResponseExtension")
internal inline fun <reified T : Any> JsonObject.defaultResponse(default: T? = null): JsonObject = defaultResponse(this, default)

/**
 * Convert empty `result` value (empty JSON array) to null.
 */
internal fun JsonObject.defaultNullResponse(): JsonObject = defaultResponse(this, null)