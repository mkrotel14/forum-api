package br.com.mkrotel.forum.features.topic.application.dto.topic

import br.com.mkrotel.forum.features.topic.domain.model.Status
import java.time.LocalDateTime

data class TopicResponse(
    val id: Long,
    val title: String,
    val status: Status,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime?
)