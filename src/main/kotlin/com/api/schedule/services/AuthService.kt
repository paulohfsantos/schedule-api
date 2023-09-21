package com.api.schedule.services

import com.api.schedule.dto.LoginDTO
import com.api.schedule.dto.LoginResponseDTO
import com.api.schedule.dto.RegisterDTO
import com.api.schedule.dto.UserResponseDTO
import com.api.schedule.entities.User
import com.api.schedule.exceptions.UserException
import com.api.schedule.repositories.UserRepository
import com.api.schedule.utils.JWTUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthService {
  @Autowired
  private lateinit var userRepository: UserRepository
  private val jwtUtil = JWTUtil()

  @Autowired
  private lateinit var passwordEncoder: PasswordEncoder

  fun login(user: LoginDTO): LoginResponseDTO {
    val userFound = userRepository.findByEmail(user.email).orElseThrow {
      throw UserException("Email not found")
    }
    if (!passwordEncoder.matches(user.password, userFound.password)) {
      throw UserException("Wrong password")
    }

    val token = jwtUtil.generateToken(userFound.username)

    val userResponse = UserResponseDTO(
      id = userFound.id,
      username = userFound.username,
      email = userFound.email,
    )

    return LoginResponseDTO(token, userResponse)
  }

  fun register(user: RegisterDTO): User {
    if (userRepository.findByEmail(user.email).isPresent) {
      throw UserException("Email already in use")
    }

    val newUser = User(
      username = user.username,
      email = user.email,
      password = user.password
    )

    if (newUser.password.length < 8) {
      throw UserException("Password must be at least 8 characters long")
    }

    newUser.encodePassword()
    return userRepository.save(newUser)
  }
}