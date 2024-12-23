package br.com.mkrotel.forum.features.user.infra.persistence

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface JpaUserRepository : JpaRepository<UserEntity, Long>