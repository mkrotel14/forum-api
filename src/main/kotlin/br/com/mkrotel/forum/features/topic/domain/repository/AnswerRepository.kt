package br.com.mkrotel.forum.features.topic.domain.repository

import br.com.mkrotel.forum.features.topic.domain.model.Answer

interface AnswerRepository {
    fun findAll(topicId: Long): List<Answer>
    fun findById(id: Long): Answer?
    fun save(answer: Answer): Answer
    fun update(answer: Answer): Answer
    fun delete(id: Long)
}