package com.api.schedule.controllers

import com.api.schedule.dto.EventDTO
import com.api.schedule.entities.Event
import com.api.schedule.exceptions.ResponseException
import com.api.schedule.services.EventService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/events")
class EventController {
  @Autowired
  lateinit var eventService: EventService

  @GetMapping
  fun findAll(): List<Event> {
    try {
      return eventService.findAll()
    } catch (e: ResponseException) {
      throw e
    }
  }

  @GetMapping("/{id}")
  fun findUnique(@PathVariable id: Long): Event {
    try {
      return eventService.findUnique(id)
    } catch (e: ResponseException) {
      throw e
    }
  }

  @GetMapping("/search")
  fun findByTitle(@RequestParam title: String): List<Event> {
    try {
      return eventService.findByTitle(title)
    } catch (e: ResponseException) {
      throw e
    }
  }

  @PostMapping
  fun save(@RequestBody event: EventDTO): Event {
    try {
      return eventService.save(event)
    } catch (e: ResponseException) {
      throw e
    }
  }

  @PutMapping("/{id}")
  fun update(@PathVariable id: Long, @RequestBody event: Event): Event {
    try {
      return eventService.update(id, event)
    } catch (e: ResponseException) {
      throw e
    }
  }

  @DeleteMapping("/{id}")
  fun delete(@PathVariable id: Long) {
    try {
      eventService.delete(id)
    } catch (e: ResponseException) {
      throw e
    }
  }
}