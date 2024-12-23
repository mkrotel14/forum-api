package br.com.mkrotel.forum.features.user.domain.model

import java.time.LocalDateTime

data class User (
    val id: Long,
    val name: String,
    val email: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime? = null
)
