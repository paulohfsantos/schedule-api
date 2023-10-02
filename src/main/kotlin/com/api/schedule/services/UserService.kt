package com.api.schedule.services

import com.api.schedule.entities.User
import com.api.schedule.exceptions.UserException
import com.api.schedule.repositories.UserRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {
  @Autowired
  lateinit var userRepository: UserRepository
  private val logger: Logger = LoggerFactory.getLogger(UserService::class.java)

  fun getProfile(id: Long): User {
    return userRepository.findById(id).orElseThrow {
      logger.error("User not found")
      throw UserException("User not found")
    }
  }

  fun getUserByEmail(email: String): User {
    return userRepository.findByEmail(email).orElseThrow {
      logger.error("Email not found")
      throw UserException("Email not found")
    }
  }
}