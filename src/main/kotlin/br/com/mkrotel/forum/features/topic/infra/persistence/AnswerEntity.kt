package br.com.mkrotel.forum.features.topic.infra.persistence

import br.com.mkrotel.forum.features.user.infra.persistence.UserEntity
import br.com.mkrotel.forum.features.topic.infra.persistence.TopicEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import jakarta.persistence.JoinColumn
import java.time.LocalDateTime

@Entity
@Table(name = "answer")
data class AnswerEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val message: String,

    @Column(name = "is_correct_answer", nullable = false)
    val isCorrectAnswer: Boolean = false,

    @ManyToOne
    @JoinColumn(name = "topic_id")
    val topic: TopicEntity,

    @ManyToOne
    @JoinColumn(name = "author_id")
    val author: UserEntity,

    @Column(name = "created_at", nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "updated_at")
    val updatedAt: LocalDateTime? = null
)