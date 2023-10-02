package com.api.schedule.services

import com.api.schedule.entities.Event
import com.api.schedule.exceptions.ResponseException
import com.api.schedule.repositories.EventRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus

@Service
class EventService {

  @Autowired
  lateinit var eventRepository: EventRepository

  fun findAll(): List<Event> {
    return eventRepository.findAll()
  }

  fun findByTitle(title: String): List<Event> {
    if (title.isEmpty()) {
      throw ResponseException(HttpStatus.BAD_REQUEST, "Title is required")
    }
    return eventRepository.findByTitle(title)
  }

  fun findUnique(id: Long): Event {
    return eventRepository.findById(id).orElseThrow {
      throw ResponseException(HttpStatus.NOT_FOUND, "Event not found")
    }
  }

  fun save(event: Event): Event {
    if (event.title.isEmpty()) {
      throw ResponseException(HttpStatus.BAD_REQUEST, "Title is required")
    }
    if (event.description.isEmpty()) {
      throw ResponseException(HttpStatus.BAD_REQUEST, "Description is required")
    }
    if (event.startDate.isEmpty()) {
      throw ResponseException(HttpStatus.BAD_REQUEST, "Start date is required")
    }
    if (event.endDate.isEmpty()) {
      throw ResponseException(HttpStatus.BAD_REQUEST, "End date is required")
    }
    return eventRepository.save(event)
  }

  fun update(id: Long, event: Event): Event {
    val eventData = eventRepository.findById(id).get()
    eventData.title = event.title
    eventData.description = event.description
    eventData.startDate = event.startDate
    eventData.endDate = event.endDate
    eventData.initialTime = event.initialTime
    eventData.finalTime = event.finalTime
    return eventRepository.save(eventData)
  }

  fun delete(id: Long) {
    if (!eventRepository.existsById(id)) {
      throw ResponseException(HttpStatus.NOT_FOUND, "Event not found")
    }
    eventRepository.deleteById(id)
  }
}