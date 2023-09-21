package com.api.schedule.services

import com.api.schedule.entities.Event
import com.api.schedule.repositories.EventRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Service
class EventService {

  @Autowired
  lateinit var eventRepository: EventRepository

  fun findAll(): List<Event> {
    return eventRepository.findAll()
  }

  fun findByTitle(title: String): List<Event> {
    return eventRepository.findByTitle(title)
  }

  fun findUnique(id: Long): Event {
    return eventRepository.findById(id).get()
  }

  fun save(event: Event): Event {
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
    eventRepository.deleteById(id)
  }
}