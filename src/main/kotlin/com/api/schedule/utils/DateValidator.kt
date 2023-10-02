package com.api.schedule.utils

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

class DateValidator {
  fun isValidDate(date: String): Boolean {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    return try {
      LocalDateTime.parse(date, formatter)
      true
    } catch (e: DateTimeParseException) {
      false
    }
  }
}