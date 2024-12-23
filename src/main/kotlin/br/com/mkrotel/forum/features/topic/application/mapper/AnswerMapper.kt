package br.com.mkrotel.forum.features.topic.application.mapper

import br.com.mkrotel.forum.shared.exceptions.TopicNotFoundException
import br.com.mkrotel.forum.shared.exceptions.UserNotFoundException
import br.com.mkrotel.forum.features.topic.domain.model.Answer
import br.com.mkrotel.forum.features.topic.application.dto.answer.AnswerRequest
import br.com.mkrotel.forum.features.topic.application.dto.answer.AnswerResponse
import br.com.mkrotel.forum.features.topic.domain.repository.TopicRepository
import br.com.mkrotel.forum.features.user.domain.repository.UserRepository
import org.springframework.stereotype.Component

@Component
class AnswerMapper(
    private val userRepository: UserRepository,
    private val topicRepository: TopicRepository
) {
    fun toDomain(topicId: Long, body: AnswerRequest): Answer {
        val author = userRepository.findById(body.authorId)
            ?: throw UserNotFoundException(body.authorId)
        val topic = topicRepository.findById(topicId)
            ?: throw TopicNotFoundException(body.topicId)

        return Answer(
            id = 0,
            message = body.message,
            author,
            topic
        )
    }

    fun toResponse(answer: Answer): AnswerResponse {
        return AnswerResponse(
            id = answer.id,
            message = answer.message,
            author = answer.author,
            isCorrectAnswer = answer.isCorrectAnswer,
            topicTitle = answer.topic.title,
            createdAt = answer.createdAt,
            updatedAt = answer.updatedAt
        )
    }
}