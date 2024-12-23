package br.com.mkrotel.forum.features.user.application.mapper

import br.com.mkrotel.forum.features.user.domain.model.User
import br.com.mkrotel.forum.features.user.application.dto.UserRequest
import br.com.mkrotel.forum.features.user.application.dto.UserResponse
import org.springframework.stereotype.Component

@Component
class UserMapper {
    fun toDomain(request: UserRequest): User {
        return User(
            id = 0,
            name = request.name,
            email = request.email
        )
    }

    fun toResponse(user: User): UserResponse {
        return UserResponse(
            id = user.id,
            name = user.name,
            email = user.email,
            createdAt = user.createdAt,
            updatedAt = user.updatedAt
        )
    }
}