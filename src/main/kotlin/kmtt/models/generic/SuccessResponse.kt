package kmtt.models.generic

@kotlinx.serialization.Serializable
data class SuccessResponse<T>(val result: T)

@kotlinx.serialization.Serializable
data class SuccessNullableResponse<T>(val result: T?)