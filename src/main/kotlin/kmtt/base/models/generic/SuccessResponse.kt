package kmtt.base.models.generic

@kotlinx.serialization.Serializable
data class SuccessResponse<T>(val result: T)
