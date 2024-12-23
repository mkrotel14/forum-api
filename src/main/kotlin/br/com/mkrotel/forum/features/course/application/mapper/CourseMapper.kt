package br.com.mkrotel.forum.features.course.application.mapper

import br.com.mkrotel.forum.features.course.application.dto.CourseRequest
import br.com.mkrotel.forum.features.course.application.dto.CourseResponse
import br.com.mkrotel.forum.features.course.domain.model.Course
import org.springframework.stereotype.Component

@Component
class CourseMapper {
    fun toDomain(request: CourseRequest): Course {
        return Course(
            id = 0,
            name = request.name,
            category = request.category
        )
    }

    fun toResponse(course: Course): CourseResponse {
        return CourseResponse(
            id = course.id,
            name = course.name,
            category = course.category,
            createdAt = course.createdAt,
            updatedAt = course.updatedAt
        )
    }
}