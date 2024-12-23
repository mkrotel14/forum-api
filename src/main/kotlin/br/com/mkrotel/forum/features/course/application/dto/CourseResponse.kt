package br.com.mkrotel.forum.features.course.application.dto

import java.time.LocalDateTime

data class CourseResponse(
    val id: Long,
    val name: String,
    val category: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime?
)