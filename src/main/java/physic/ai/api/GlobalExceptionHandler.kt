package physic.ai.api

import jakarta.ws.rs.core.Response
import jakarta.ws.rs.ext.ExceptionMapper
import jakarta.ws.rs.ext.Provider
import physic.ai.services.exceptions.ApiException

@Provider
class GlobalExceptionHandler : ExceptionMapper<ApiException> {
    override fun toResponse(exception: ApiException): Response {
        return Response.status(exception.status)
            .entity(mapOf("error" to exception.message))
            .build()
    }

@Provider
class UncaughtExceptionMapper : ExceptionMapper<Throwable> {
    override fun toResponse(exception: Throwable): Response {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR.statusCode)
            .entity(mapOf("error" to "Unexpected error: ${exception.message}"))
            .build()
    }
}

}
