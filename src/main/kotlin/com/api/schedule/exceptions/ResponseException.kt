package com.api.schedule.exceptions

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

open class ResponseException(
  private val status: HttpStatus,
  override val message: String
):RuntimeException(message) {
  fun handleException(): ResponseEntity<Any> {
    return ResponseEntity.status(this.status).body(
      ErrorHandlingResponse(
        message = this.message,
        status = this.status.value()
      )
    )
  }
}