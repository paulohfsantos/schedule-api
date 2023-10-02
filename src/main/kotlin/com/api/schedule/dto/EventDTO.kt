package com.api.schedule.dto

import java.time.LocalDateTime

class EventDTO (
  var title: String = "",
  var description: String = "",
  var startDate: LocalDateTime = LocalDateTime.now(),
  var endDate: LocalDateTime = LocalDateTime.now(),
//  var initialTime: String = "",
//  var finalTime: String = "",
)