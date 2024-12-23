package br.com.mkrotel.forum.features.topic.application

import br.com.mkrotel.forum.shared.exceptions.TopicNotFoundException
import br.com.mkrotel.forum.features.topic.domain.model.Topic
import br.com.mkrotel.forum.features.topic.application.dto.topic.TopicRequest
import br.com.mkrotel.forum.features.topic.application.dto.topic.TopicResponse
import br.com.mkrotel.forum.features.topic.application.dto.topic.UpdateTopicRequest
import br.com.mkrotel.forum.features.topic.application.mapper.TopicMapper
import br.com.mkrotel.forum.features.topic.domain.repository.TopicRepository
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class TopicService(
    private val repository: TopicRepository,
    private val mapper: TopicMapper,
) {
    fun getAllTopics(pageable: Pageable): Page<TopicResponse> {
        return repository.findAll(pageable)
            .map { topic -> mapper.toResponse(topic) }
    }

    @Cacheable("topics", key = "#id")
    fun getTopicById(id: Long): Topic {
        return repository.findById(id) ?: throw TopicNotFoundException(id)
    }

    fun createTopic(request: TopicRequest): Topic {
        val newTopic = mapper.toDomain(request)
        return repository.save(newTopic)
    }

    fun updateTopic(id: Long, request: UpdateTopicRequest): Topic {
        return repository.update(id, request)
    }

    fun deleteTopic(id: Long) {
        repository.delete(id)
    }
}