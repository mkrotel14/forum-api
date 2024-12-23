package br.com.mkrotel.forum.features.course.application

import br.com.mkrotel.forum.features.course.application.dto.CourseRequest
import br.com.mkrotel.forum.features.course.application.dto.CourseResponse
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/courses")
class CourseController(private val service: CourseService) {

    @GetMapping("/{id}")
    fun getCourseById(@PathVariable id: Long): ResponseEntity<CourseResponse> {
        val response = service.getCourseById(id)
        return ResponseEntity.ok(response)
    }

    @GetMapping()
    fun getAllCourses(): ResponseEntity<List<CourseResponse>> {
        val response = service.getAllCourses()
        return ResponseEntity.ok(response)
    }

    @PostMapping
    fun createCourse(@RequestBody @Valid body: CourseRequest): ResponseEntity<CourseResponse> {
        val response = service.createCourse(body)
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(response)
    }

    @PutMapping
    fun updateCourse(@RequestBody @Valid body: CourseRequest): ResponseEntity<CourseResponse> {
        val response = service.updateCourse(body)
        return ResponseEntity.ok(response)
    }
}