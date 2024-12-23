package br.com.mkrotel.forum.features.topic.domain.model

import br.com.mkrotel.forum.features.user.domain.model.User
import java.time.LocalDateTime

data class Answer (
    val id: Long,
    val message: String,
    val author: User,
    val topic: Topic,
    val isCorrectAnswer: Boolean = false,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime? = null
)
