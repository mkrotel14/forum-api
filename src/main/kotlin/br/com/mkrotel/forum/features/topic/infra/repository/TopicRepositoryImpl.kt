package br.com.mkrotel.forum.features.topic.infra.repository

import br.com.mkrotel.forum.features.topic.application.dto.topic.UpdateTopicRequest
import br.com.mkrotel.forum.features.topic.domain.model.Topic
import br.com.mkrotel.forum.features.topic.domain.repository.TopicRepository
import br.com.mkrotel.forum.features.topic.infra.persistence.JpaTopicRepository
import br.com.mkrotel.forum.features.topic.infra.persistence.mapper.TopicEntityMapper
import br.com.mkrotel.forum.shared.exceptions.TopicNotFoundException
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
class TopicRepositoryImpl(
    private val repository: JpaTopicRepository,
    private val mapper: TopicEntityMapper
): TopicRepository {

    override fun findAll(pageable: Pageable): Page<Topic> {
        return repository.findAll(pageable)
            .map { mapper.toDomain(it) }
    }

    override fun findById(id: Long): Topic? {
        return repository.findById(id)
            .map { mapper.toDomain(it) }
            .orElse(null)
    }

    override fun save(topic: Topic): Topic {
        val entity = mapper.toEntity(topic)
        return mapper.toDomain(repository.save(entity))
    }

    override fun update(id: Long, request: UpdateTopicRequest): Topic {
        val entity = repository.findById(id)
            .orElseThrow { TopicNotFoundException(id) }

        val updatedEntity = entity.copy(
            title = request.title,
            message = request.message,
            updatedAt = LocalDateTime.now()
        )

        return mapper.toDomain(repository.save(updatedEntity))
    }

    override fun delete(id: Long) {
        return repository.deleteById(id)
    }

}
