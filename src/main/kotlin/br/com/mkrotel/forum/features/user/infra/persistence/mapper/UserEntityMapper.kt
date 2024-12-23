package br.com.mkrotel.forum.features.user.infra.persistence.mapper

import br.com.mkrotel.forum.features.user.domain.model.User
import br.com.mkrotel.forum.features.user.infra.persistence.UserEntity
import org.springframework.stereotype.Component

@Component
class UserEntityMapper {
    fun toDomain(entity: UserEntity): User {
        return User(
            id = entity.id,
            name = entity.name,
            email = entity.email
        )
    }

    fun toEntity(domain: User): UserEntity {
        return UserEntity(
            id = domain.id,
            name = domain.name,
            email = domain.email,
            createdAt = domain.createdAt,
            updatedAt = domain.updatedAt
        )
    }
}