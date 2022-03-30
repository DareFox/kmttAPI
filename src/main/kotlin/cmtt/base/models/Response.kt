package cmtt.base.models

data class Response<T>(val result: T, val message: String)
data class ErrorResponse<T>(val result: T, val message: String)