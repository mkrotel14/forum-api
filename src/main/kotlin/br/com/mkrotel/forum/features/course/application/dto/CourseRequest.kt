package br.com.mkrotel.forum.features.course.application.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size

data class CourseRequest(
    @field:NotBlank(message = "Course name is required")
    @field:Size(min = 3, message = "Course namee must be at least 3 characters")
    val name: String,

    @field:NotBlank(message = "Course category is required")
    val category: String
)