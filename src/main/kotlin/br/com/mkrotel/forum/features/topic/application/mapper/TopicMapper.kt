package br.com.mkrotel.forum.features.topic.application.mapper

import br.com.mkrotel.forum.features.course.domain.repostiory.CourseRepository
import br.com.mkrotel.forum.shared.exceptions.CourseNotFoundException
import br.com.mkrotel.forum.shared.exceptions.UserNotFoundException
import br.com.mkrotel.forum.features.topic.domain.model.Topic
import br.com.mkrotel.forum.features.topic.application.dto.topic.TopicRequest
import br.com.mkrotel.forum.features.topic.application.dto.topic.TopicResponse
import br.com.mkrotel.forum.features.user.domain.repository.UserRepository
import org.springframework.stereotype.Component

@Component
class TopicMapper(
    private val courseRepository: CourseRepository,
    private val userRepository: UserRepository,
) {

    fun toDomain(body: TopicRequest): Topic {
        val author = userRepository.findById(body.authorId)
                ?: throw UserNotFoundException(body.authorId)
        val course = courseRepository.findById(body.courseId)
                ?: throw CourseNotFoundException(body.courseId)

        return Topic(
            id = 0,
            title = body.title,
            message = body.message,
            course = course,
            author = author,
        )
    }

    fun toResponse(topic: Topic): TopicResponse {
        return TopicResponse(
            id = topic.id,
            title = topic.title,
            status = topic.status,
            createdAt = topic.createdAt,
            updatedAt = topic.updatedAt
        )
    }
}