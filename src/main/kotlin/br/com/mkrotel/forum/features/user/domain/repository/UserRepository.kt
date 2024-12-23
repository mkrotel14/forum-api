package br.com.mkrotel.forum.features.user.domain.repository

import br.com.mkrotel.forum.features.user.domain.model.User

interface UserRepository {
    fun findById(id: Long): User?
    fun save(user: User): User
    fun update(user: User): User
}