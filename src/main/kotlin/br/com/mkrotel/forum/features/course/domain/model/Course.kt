package br.com.mkrotel.forum.features.course.domain.model

import java.time.LocalDateTime

data class Course (
    val id: Long,
    val name: String,
    val category: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime? = null
)

