package com.api.schedule.entities

import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "events")
data class Event (
  @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_seq")
  @SequenceGenerator(name = "event_seq", sequenceName = "event_sequence")
  var id: Long = 0,

  @Column(name = "title")
  var title: String = "",

  @Column(name = "description")
  var description: String = "",

  @Column(name = "start_date")
  var startDate: LocalDateTime = LocalDateTime.now(),

  @Column(name = "end_date")
  var endDate: LocalDateTime = LocalDateTime.now(),

//  @Column(name = "initial_time")
//  var initialTime: String = "",
//
//  @Column(name = "final_time")
//  var finalTime: String = "",
)