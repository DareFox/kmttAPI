package kmtt.models.generic

import kotlinx.serialization.ExperimentalSerializationApi

@OptIn(ExperimentalSerializationApi::class)
@kotlinx.serialization.Serializable
data class ArrayResponse<T>(val items: T)

@OptIn(ExperimentalSerializationApi::class)
@kotlinx.serialization.Serializable
data class SuccessArrayResponse<T>(val result: ArrayResponse<T>)