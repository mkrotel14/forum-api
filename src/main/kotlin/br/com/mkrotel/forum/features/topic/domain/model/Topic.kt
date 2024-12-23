package br.com.mkrotel.forum.features.topic.domain.model

import br.com.mkrotel.forum.features.course.domain.model.Course
import br.com.mkrotel.forum.features.user.domain.model.User
import java.time.LocalDateTime

data class Topic(
    val id: Long,
    val title: String,
    val message: String,
    val course: Course,
    val author: User,
    val status: Status = Status.PENDING_REPLY,
    val answers: List<Answer> = ArrayList(),
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime? = null
)