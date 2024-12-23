package br.com.mkrotel.forum.features.course.domain.repostiory

import br.com.mkrotel.forum.features.course.domain.model.Course

interface CourseRepository {
    fun findAll(): List<Course>
    fun findById(id: Long): Course?
    fun save(course: Course): Course
    fun update(course: Course): Course
}