package br.com.mkrotel.forum.features.user.application.dto

import java.time.LocalDateTime

data class UserResponse(
    val id: Long,
    val name: String,
    val email: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime?
)