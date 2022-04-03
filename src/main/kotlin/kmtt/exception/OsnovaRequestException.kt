package kmtt.exception

import io.ktor.client.statement.*
import kmtt.base.models.generic.ErrorResponse

class OsnovaRequestException(val httpResponse: HttpResponse, val parsed: ErrorResponse) : Exception(
    """Client request(${httpResponse.call.request.url}) is invalid.
        Status: ${httpResponse.status.value} ${httpResponse.status.description}
        Parsed: $parsed
    """.trimMargin()
)