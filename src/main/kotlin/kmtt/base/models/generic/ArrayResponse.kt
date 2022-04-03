package kmtt.base.models.generic

@kotlinx.serialization.Serializable
data class ArrayResponse<T>(val items: T)

@kotlinx.serialization.Serializable
data class SuccessArrayResponse<T>(val result: ArrayResponse<T>)