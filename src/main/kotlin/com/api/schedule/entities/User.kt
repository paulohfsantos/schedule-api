package com.api.schedule.entities

import com.api.schedule.dto.UserResponseDTO
import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "users")
data class User(
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  var id: Long = 0,

  @NotNull(message = "Username is required")
  @Column(name = "name", nullable = false)
  var username: String = "",

  @NotNull(message = "Email is required")
  @Column(name = "email", nullable = false, unique = true)
  var email: String = "",

  @NotNull(message = "Password is required")
  @Column(name = "password", nullable = false)
  @JsonIgnore
  var password: String = ""
) {
  fun encodePassword() {
    val encoder = BCryptPasswordEncoder()
    this.password = encoder.encode(this.password)
  }
}
