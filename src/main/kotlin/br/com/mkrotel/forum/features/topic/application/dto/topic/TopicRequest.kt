package br.com.mkrotel.forum.features.topic.application.dto.topic

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class TopicRequest(
    @field:NotEmpty
    @field:Size(min = 5, max = 100)
    val title: String,

    @field:NotEmpty
    @field:Size(min = 10)
    val message: String,

    @field:NotNull
    val authorId: Long,

    @field:NotNull
    val courseId: Long
)
