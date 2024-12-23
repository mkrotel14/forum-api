package br.com.mkrotel.forum.features.user.infra.repository

import br.com.mkrotel.forum.features.user.domain.model.User
import br.com.mkrotel.forum.features.user.domain.repository.UserRepository
import br.com.mkrotel.forum.features.user.infra.persistence.JpaUserRepository
import br.com.mkrotel.forum.features.user.infra.persistence.mapper.UserEntityMapper
import br.com.mkrotel.forum.shared.exceptions.UserNotFoundException
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
class UserRepositoryImpl(
    private val repository: JpaUserRepository,
    private val mapper: UserEntityMapper
) : UserRepository {
    override fun findById(id: Long): User? {
        return repository.findById(id)
            .map { mapper.toDomain(it) }
            .orElse(null)
    }

    override fun save(user: User): User {
        val entity = mapper.toEntity(user)
        return mapper.toDomain(repository.save(entity))
    }

    override fun update(user: User): User {
        val entity = repository.findById(user.id)
            .orElseThrow { UserNotFoundException(user.id) }

        val updatedEntity = entity.copy(
            name = user.name,
            updatedAt = LocalDateTime.now()
        )

        return mapper.toDomain(repository.save(updatedEntity))
    }
}
