package br.com.mkrotel.forum.features.topic.infra.persistence.mapper

import br.com.mkrotel.forum.features.topic.domain.model.Answer
import br.com.mkrotel.forum.features.topic.infra.persistence.AnswerEntity
import br.com.mkrotel.forum.shared.mapper.EntityMapperUtils
import org.springframework.stereotype.Component

@Component
class AnswerEntityMapper {
    fun toDomain(entity: AnswerEntity): Answer {
        return Answer(
            id = entity.id,
            message = entity.message,
            author = EntityMapperUtils.userToDomain(entity.author),
            topic = EntityMapperUtils.topicToDomain(entity.topic)
        )
    }

    fun toEntity(domain: Answer): AnswerEntity {
        return AnswerEntity(
            id = domain.id,
            message = domain.message,
            author = EntityMapperUtils.userToEntity(domain.author),
            topic = EntityMapperUtils.topicToEntity(domain.topic)
        )
    }
}