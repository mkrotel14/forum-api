package br.com.mkrotel.forum.features.course.application

import br.com.mkrotel.forum.features.course.application.dto.CourseRequest
import br.com.mkrotel.forum.features.course.application.dto.CourseResponse
import br.com.mkrotel.forum.features.course.application.mapper.CourseMapper
import br.com.mkrotel.forum.features.course.domain.repostiory.CourseRepository
import br.com.mkrotel.forum.shared.exceptions.CourseNotFoundException
import org.springframework.stereotype.Service

@Service
class CourseService(
    private val repository: CourseRepository,
    private val mapper: CourseMapper
) {
    fun getAllCourses(): List<CourseResponse> {
        return repository.findAll()
            .map { course -> mapper.toResponse(course) }
    }

    fun getCourseById(id: Long): CourseResponse {
        return repository.findById(id)
            ?.let { mapper.toResponse(it) }
            ?: throw CourseNotFoundException(id)
    }

    fun createCourse(body: CourseRequest): CourseResponse {
        val course = mapper.toDomain(body)
        return mapper.toResponse(repository.save(course))
    }
    
    fun updateCourse(body: CourseRequest): CourseResponse {
        val course = mapper.toDomain(body)
        return mapper.toResponse(repository.update(course))
    }
}