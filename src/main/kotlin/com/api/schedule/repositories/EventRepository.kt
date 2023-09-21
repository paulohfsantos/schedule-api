package com.api.schedule.repositories

import com.api.schedule.entities.Event
import org.springframework.data.jpa.repository.JpaRepository


interface EventRepository: JpaRepository<Event, Long> {
  fun findByTitle(title: String): List<Event>
}