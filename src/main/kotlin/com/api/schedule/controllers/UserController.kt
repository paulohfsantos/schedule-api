package com.api.schedule.controllers

import com.api.schedule.entities.User
import com.api.schedule.exceptions.ResponseException
import com.api.schedule.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UserController {
  @Autowired
  private lateinit var userService: UserService

  @GetMapping("/profile")
  fun getProfile(@RequestHeader("Authorization") id: Long): User {
    try { return userService.getProfile(id) }
    catch (e: ResponseException) { throw e }
  }

  @GetMapping("/search")
  fun getUserByEmail(@RequestParam email: String): User {
    try { return userService.getUserByEmail(email) }
    catch (e: ResponseException) { throw e }
  }
}