package com.api.schedule.controllers

import com.api.schedule.entities.Event
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
    } catch (e: Exception) {
      throw e
    }
  }

  @GetMapping("/{id}")
  fun findUnique(@PathVariable id: Long): Event {
    try {
      return eventService.findUnique(id)
    } catch (e: Exception) {
      throw e
    }
  }

  @GetMapping("/search")
  fun findByTitle(@RequestParam title: String): List<Event> {
    try {
      return eventService.findByTitle(title)
    } catch (e: Exception) {
      throw e
    }
  }

  @PostMapping
  fun save(@RequestBody event: Event): Event {
    try {
      return eventService.save(event)
    } catch (e: Exception) {
      throw e
    }
  }

  @PutMapping("/{id}")
  fun update(@PathVariable id: Long, @RequestBody event: Event): Event {
    try {
      return eventService.update(id, event)
    } catch (e: Exception) {
      throw e
    }
  }

  @DeleteMapping("/{id}")
  fun delete(@PathVariable id: Long) {
    try {
      eventService.delete(id)
    } catch (e: Exception) {
      throw e
    }
  }
}