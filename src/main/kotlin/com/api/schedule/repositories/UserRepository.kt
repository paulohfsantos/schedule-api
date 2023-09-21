package com.api.schedule.repositories

import com.api.schedule.entities.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface UserRepository: JpaRepository<User, Long> {
  fun findByEmail(email: String): Optional<User>

  fun findByUsername(username: String): Optional<User>

  fun existsByEmail(email: String): Boolean
}