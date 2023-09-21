package com.api.schedule.entities

import javax.persistence.*

@Entity
@Table(name = "events")
data class Event (
  @Id @GeneratedValue(strategy = GenerationType.AUTO)
  var id: Long = 0,

  @Column(name = "title")
  var title: String = "",

  @Column(name = "description")
  var description: String = "",

  @Column(name = "start_date")
  var startDate: String = "",

  @Column(name = "end_date")
  var endDate: String = "",

  @Column(name = "initial_time")
  var initialTime: String = "",

  @Column(name = "final_time")
  var finalTime: String = "",
)