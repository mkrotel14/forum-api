package br.com.mkrotel.forum.features.course.infra.persistence.mapper

import br.com.mkrotel.forum.features.course.domain.model.Course
import br.com.mkrotel.forum.features.course.infra.persistence.CourseEntity
import org.springframework.stereotype.Component

@Component
class CourseEntityMapper {
    fun toDomain(entity: CourseEntity): Course {
        return Course(
            id = entity.id,
            name = entity.name,
            category = entity.category
        )
    }

    fun toEntity(domain: Course): CourseEntity {
        return CourseEntity(
            id = domain.id,
            name = domain.name,
            category = domain.category,
            createdAt = domain.createdAt,
            updatedAt = domain.updatedAt
        )
    }
}