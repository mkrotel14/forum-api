package br.com.mkrotel.forum.features.user.application

import br.com.mkrotel.forum.shared.exceptions.UserNotFoundException
import br.com.mkrotel.forum.features.user.application.dto.UserRequest
import br.com.mkrotel.forum.features.user.application.dto.UserResponse
import br.com.mkrotel.forum.features.user.application.mapper.UserMapper
import br.com.mkrotel.forum.features.user.domain.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val repository: UserRepository,
    private val mapper: UserMapper
) {

    fun getUserById(id: Long): UserResponse {
        return repository.findById(id)
            ?.let { mapper.toResponse(it) }
            ?: throw UserNotFoundException(id)
    }

    fun createUser(request: UserRequest): UserResponse {
        val user = mapper.toDomain(request)
        return mapper.toResponse(repository.save(user))
    }
}