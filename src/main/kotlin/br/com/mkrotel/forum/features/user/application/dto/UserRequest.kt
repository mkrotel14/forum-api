package br.com.mkrotel.forum.features.user.application.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class UserRequest(
    @field:NotBlank(message = "User name is required")
    @field:Size(min = 3, message = "User name must be at least 3 characters")
    val name: String,

    @field:NotBlank(message = "User E-mail is required")
    @field:Email
    val email: String,
)
