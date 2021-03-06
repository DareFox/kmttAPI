package kmtt.models.generic

import kotlinx.serialization.Serializable

@Serializable
data class ErrorResponse(val message: String, val error: ErrorData)

@Serializable
data class ErrorData(val code: Int)