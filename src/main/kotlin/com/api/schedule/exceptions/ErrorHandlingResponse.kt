package com.api.schedule.exceptions

import org.springframework.http.ResponseEntity

class ErrorHandlingResponse(
  val message: String,
  private val status: Int
) {
  fun resError(): ResponseEntity<Any> {
    return ResponseEntity.status(this.status).body(this)
  }
}