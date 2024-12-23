package br.com.mkrotel.forum.features.topic.infra.persistence

import br.com.mkrotel.forum.features.course.infra.persistence.CourseEntity
import br.com.mkrotel.forum.features.topic.domain.model.Status
import br.com.mkrotel.forum.features.user.infra.persistence.UserEntity
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "topic")
data class TopicEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val title: String,

    @Column(nullable = false)
    val message: String,

    @ManyToOne
    @JoinColumn(name = "author_id")
    val author: UserEntity,

    @ManyToOne
    @JoinColumn(name = "course_id")
    val course: CourseEntity,

    @Enumerated(value = EnumType.STRING)
    val status: Status = Status.PENDING_REPLY,

    @OneToMany(mappedBy = "topic")
    val answers: List<AnswerEntity> = ArrayList(),

    @Column(name = "created_at", nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "updated_at")
    val updatedAt: LocalDateTime? = null
)