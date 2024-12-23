package br.com.mkrotel.forum.features.course.infra.persistence

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface JpaCourseRepository : JpaRepository<CourseEntity, Long>