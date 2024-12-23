package br.com.mkrotel.forum.shared.mapper

import br.com.mkrotel.forum.features.course.domain.model.Course
import br.com.mkrotel.forum.features.course.infra.persistence.CourseEntity
import br.com.mkrotel.forum.features.topic.domain.model.Topic
import br.com.mkrotel.forum.features.topic.infra.persistence.TopicEntity
import br.com.mkrotel.forum.features.user.domain.model.User
import br.com.mkrotel.forum.features.user.infra.persistence.UserEntity

object EntityMapperUtils {
    fun userToDomain(entity: UserEntity): User {
        return User(
            id = entity.id,
            name = entity.name,
            email = entity.email
        )
    }

    fun userToEntity(domain: User): UserEntity {
        return UserEntity(
            id = domain.id,
            name = domain.name,
            email = domain.email,
            createdAt = domain.createdAt,
            updatedAt = domain.updatedAt
        )
    }

    fun courseToDomain(entity: CourseEntity): Course {
        return Course(
            id = entity.id,
            name = entity.name,
            category = entity.category
        )
    }

    fun courseToEntity(domain: Course): CourseEntity {
        return CourseEntity(
            id = domain.id,
            name = domain.name,
            category = domain.category,
            createdAt = domain.createdAt,
            updatedAt = domain.updatedAt
        )
    }

    fun topicToDomain(entity: TopicEntity): Topic {
        return Topic(
            id = entity.id,
            title = entity.title,
            message = entity.message,
            course = courseToDomain(entity.course),
            author = userToDomain(entity.author)
        )
    }

    fun topicToEntity(domain: Topic): TopicEntity {
        return TopicEntity(
            id = domain.id,
            title = domain.title,
            message = domain.message,
            course = courseToEntity(domain.course),
            author = userToEntity(domain.author),
            createdAt = domain.createdAt,
            updatedAt = domain.updatedAt
        )
    }
}