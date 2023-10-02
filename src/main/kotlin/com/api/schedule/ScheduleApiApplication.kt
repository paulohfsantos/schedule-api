package com.api.schedule

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [SecurityAutoConfiguration::class])
class ScheduleApiApplication

fun main(args: Array<String>) {
  runApplication<ScheduleApiApplication>(*args)
}
