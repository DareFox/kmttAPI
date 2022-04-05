package kmtt.models.generic

import kotlinx.serialization.ExperimentalSerializationApi

@OptIn(ExperimentalSerializationApi::class)
@kotlinx.serialization.Serializable
data class SuccessResponse<T>(val result: T)

@OptIn(ExperimentalSerializationApi::class)
@kotlinx.serialization.Serializable
data class SuccessNullableResponse<T>(val result: T?)