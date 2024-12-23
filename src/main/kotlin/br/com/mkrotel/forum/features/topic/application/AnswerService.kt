package br.com.mkrotel.forum.features.topic.application

import br.com.mkrotel.forum.shared.exceptions.AnswerNotFoundException
import br.com.mkrotel.forum.features.topic.application.dto.answer.AnswerRequest
import br.com.mkrotel.forum.features.topic.application.dto.answer.AnswerResponse
import br.com.mkrotel.forum.features.topic.application.dto.answer.UpdateAnswerRequest
import br.com.mkrotel.forum.features.topic.application.mapper.AnswerMapper
import br.com.mkrotel.forum.features.topic.domain.model.Answer
import br.com.mkrotel.forum.features.topic.domain.repository.AnswerRepository
import org.springframework.stereotype.Service

@Service
class AnswerService(
    private val repository: AnswerRepository,
    private val mapper: AnswerMapper,
) {
    fun getAnswerById(id: Long): Answer {
        return repository.findById(id)
                ?: throw AnswerNotFoundException(id)
    }

    fun createAnswer(topicId: Long, body: AnswerRequest): AnswerResponse {
        val answer = mapper.toDomain(topicId, body)
        return mapper.toResponse(repository.save(answer))
    }

    fun updateAnswer(request: UpdateAnswerRequest): AnswerResponse {
        val answer = getAnswerById(request.id)
        val updatedAnswer = answer.copy(
            message = request.message
        )

        return mapper.toResponse(repository.update(updatedAnswer))
    }

    fun deleteAnswer(id: Long) {
        return repository.delete(id)
    }
}