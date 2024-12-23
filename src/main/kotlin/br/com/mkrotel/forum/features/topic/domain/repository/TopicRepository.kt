package br.com.mkrotel.forum.features.topic.domain.repository

import br.com.mkrotel.forum.features.topic.application.dto.topic.UpdateTopicRequest
import br.com.mkrotel.forum.features.topic.domain.model.Topic
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface TopicRepository {
    fun findAll(pageable: Pageable): Page<Topic>
    fun findById(id: Long): Topic?
    fun save(topic: Topic): Topic
    fun update(id: Long, request: UpdateTopicRequest): Topic
    fun delete(id: Long)
}