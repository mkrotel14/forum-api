package br.com.mkrotel.forum.features.topic.infra.persistence

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface JpaTopicRepository : JpaRepository<TopicEntity, Long>