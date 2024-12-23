package br.com.mkrotel.forum.features.topic.infra.repository

import br.com.mkrotel.forum.features.topic.domain.model.Answer
import br.com.mkrotel.forum.features.topic.domain.repository.AnswerRepository
import br.com.mkrotel.forum.features.topic.infra.persistence.JpaAnswerRepository
import br.com.mkrotel.forum.features.topic.infra.persistence.mapper.AnswerEntityMapper
import br.com.mkrotel.forum.shared.exceptions.AnswerNotFoundException
import org.springframework.stereotype.Repository

@Repository
class AnswerRepositoryImpl(
    private val repository: JpaAnswerRepository,
    private val mapper: AnswerEntityMapper
): AnswerRepository {

    override fun findAll(topicId: Long): List<Answer> {
        return repository.findAll()
            .map { mapper.toDomain(it) }
    }

    override fun findById(id: Long): Answer? {
        return repository.findById(id)
            .map { mapper.toDomain(it) }
            .orElse(null)
    }

    override fun save(answer: Answer): Answer {
        val entity = mapper.toEntity(answer)
        return mapper.toDomain(repository.save(entity))
    }

    override fun update(answer: Answer): Answer {
        val entity = repository
            .findById(answer.id)
            .orElseThrow { AnswerNotFoundException(answer.id) }

        val updatedAnswer = entity.copy(
            message = answer.message,
            isCorrectAnswer = answer.isCorrectAnswer
        )
        
        return mapper.toDomain(updatedAnswer)
    }

    override fun delete(id: Long) {
        return repository.deleteById(id)
    }
}