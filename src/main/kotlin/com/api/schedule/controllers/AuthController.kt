package com.api.schedule.controllers

import com.api.schedule.dto.LoginDTO
import com.api.schedule.dto.LoginResponseDTO
import com.api.schedule.dto.RegisterDTO
import com.api.schedule.entities.User
import com.api.schedule.exceptions.ResponseException
import com.api.schedule.services.AuthService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/public/")
class AuthController {
  @Autowired
  private lateinit var authService: AuthService

  @PostMapping("/login")
  fun login(@RequestBody user: LoginDTO): LoginResponseDTO {
    try {
      return authService.login(user)
    } catch (e: ResponseException) {
      throw e
    }
  }

  @PostMapping("/register")
  fun register(@RequestBody user: RegisterDTO): User {
    try {
      return authService.register(user)
    } catch (e: ResponseException) {
      throw e
    }
  }
}