package br.com.mkrotel.forum.features.topic.application.dto.answer

import br.com.mkrotel.forum.features.user.domain.model.User
import java.time.LocalDateTime

data class AnswerResponse(
    val id: Long,
    val message: String,
    val author: User,
    val isCorrectAnswer: Boolean,
    val topicTitle: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime?
)