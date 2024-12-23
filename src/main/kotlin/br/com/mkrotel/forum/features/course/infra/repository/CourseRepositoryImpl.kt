package br.com.mkrotel.forum.features.course.infra.repository

import br.com.mkrotel.forum.features.course.application.mapper.CourseMapper
import br.com.mkrotel.forum.features.course.domain.repostiory.CourseRepository
import br.com.mkrotel.forum.features.course.domain.model.Course
import br.com.mkrotel.forum.features.course.infra.persistence.CourseEntity
import br.com.mkrotel.forum.features.course.infra.persistence.JpaCourseRepository
import br.com.mkrotel.forum.features.course.infra.persistence.mapper.CourseEntityMapper
import br.com.mkrotel.forum.shared.exceptions.CourseNotFoundException
import org.springframework.data.domain.Example
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.repository.query.FluentQuery
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
class CourseRepositoryImpl(
    private val repository: JpaCourseRepository,
    private val mapper: CourseEntityMapper
) : CourseRepository {
    override fun findAll(): List<Course> {
        return repository.findAll()
            .map { mapper.toDomain(it) }
    }

    override fun findById(id: Long): Course? {
        return repository.findById(id)
            .map { mapper.toDomain(it) }
            .orElse(null)
    }

    override fun save(course: Course): Course {
        val entity = mapper.toEntity(course)
        return mapper.toDomain(repository.save(entity))
    }

    override fun update(course: Course): Course {
        val entity = repository.findById(course.id)
            .orElseThrow { CourseNotFoundException(course.id) }

        val updatedEntity = entity.copy(
            name = course.name,
            category = course.category,
            updatedAt = LocalDateTime.now()
        )

        return mapper.toDomain(repository.save(updatedEntity))
    }
}