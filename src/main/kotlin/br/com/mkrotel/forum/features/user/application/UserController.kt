package br.com.mkrotel.forum.features.user.application

import br.com.mkrotel.forum.features.user.application.dto.UserRequest
import br.com.mkrotel.forum.features.user.application.dto.UserResponse
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping( "/api/users")
class UserController(private val service: UserService) {

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long): ResponseEntity<UserResponse> {
        val response = service.getUserById(id)
        return ResponseEntity.ok(response)
    }

    @PostMapping
    fun createUser(@RequestBody @Valid request: UserRequest): ResponseEntity<UserResponse> {
        val response = service.createUser(request)
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(response)
    }
}