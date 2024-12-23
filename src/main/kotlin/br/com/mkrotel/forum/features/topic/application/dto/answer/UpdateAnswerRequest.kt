package br.com.mkrotel.forum.features.topic.application.dto.answer

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull


data class UpdateAnswerRequest(
    @field:NotNull
    val id: Long,
    @field:NotNull
    val topicId: Long,
    @field:NotNull
    val authorId: Long,
    @field:NotEmpty
    val message: String,
)