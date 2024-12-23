package br.com.mkrotel.forum.features.topic.infra.persistence.mapper

import br.com.mkrotel.forum.features.topic.domain.model.Topic
import br.com.mkrotel.forum.features.topic.infra.persistence.TopicEntity
import br.com.mkrotel.forum.shared.mapper.EntityMapperUtils
import org.springframework.stereotype.Component

@Component
class TopicEntityMapper {
    fun toDomain(entity: TopicEntity): Topic {
        return Topic(
            id = entity.id,
            title = entity.title,
            message = entity.message,
            author = EntityMapperUtils.userToDomain(entity.author),
            course = EntityMapperUtils.courseToDomain(entity.course),
            status = entity.status,
            createdAt = entity.createdAt,
            updatedAt = entity.updatedAt
        )
    }

    fun toEntity(domain: Topic): TopicEntity {
        return TopicEntity(
            id = domain.id,
            title = domain.title,
            message = domain.message,
            author = EntityMapperUtils.userToEntity(domain.author),
            course = EntityMapperUtils.courseToEntity(domain.course),
            status = domain.status,
            createdAt = domain.createdAt,
            updatedAt = domain.updatedAt
        )
    }
}