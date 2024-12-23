package br.com.mkrotel.forum.shared.exceptions

import br.com.mkrotel.forum.shared.dto.ExceptionResponse
import jakarta.servlet.http.HttpServletRequest
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.WebRequest
import java.time.LocalDateTime

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNotFoundException(
        exception: NotFoundException,
        request: HttpServletRequest
    ): ExceptionResponse {
        return ExceptionResponse(
            timestamp = LocalDateTime.now(),
            status = HttpStatus.NOT_FOUND.value(),
            error = HttpStatus.NOT_FOUND.reasonPhrase,
            message = exception.message,
            path = request.servletPath,
            details = mapOf(
                "resourceType" to (exception.resourceType ?: "Unknown"),
                "resourceId" to (exception.resourceId?.toString() ?: "Unknown")
            )
        )
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleValidationException(
        exception: MethodArgumentNotValidException,
        request: HttpServletRequest
    ): ExceptionResponse {
        val fieldErrors = exception.bindingResult.fieldErrors.associate { error ->
            error.field to (error.defaultMessage ?: "Invalid value")
        }

        return ExceptionResponse(
            timestamp = LocalDateTime.now(),
            status = HttpStatus.BAD_REQUEST.value(),
            error = HttpStatus.BAD_REQUEST.reasonPhrase,
            message = "Validation failed",
            path = request.servletPath,
            details = fieldErrors
        )
    }

    @ExceptionHandler(DataIntegrityViolationException::class)
    @ResponseStatus(HttpStatus.CONFLICT)
    fun handleDataIntegrityViolation(
        exception: DataIntegrityViolationException,
        request: HttpServletRequest
    ): ExceptionResponse {
        return ExceptionResponse(
            timestamp = LocalDateTime.now(),
            status = HttpStatus.CONFLICT.value(),
            error = HttpStatus.CONFLICT.reasonPhrase,
            message = "Data integrity violation",
            path = request.servletPath,
            details = mapOf("cause" to (exception.mostSpecificCause.message ?: "Unknown"))
        )
    }

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleGenericException(
        exception: Exception,
        request: HttpServletRequest
    ): ExceptionResponse {
        return ExceptionResponse(
            timestamp = LocalDateTime.now(),
            status = HttpStatus.INTERNAL_SERVER_ERROR.value(),
            error = HttpStatus.INTERNAL_SERVER_ERROR.reasonPhrase,
            message = "An unexpected error occurred",
            path = request.servletPath,
            details = mapOf(
                "exceptionType" to exception.javaClass.simpleName,
                "cause" to (exception.message ?: "Unknown")
            )
        )
    }
}
