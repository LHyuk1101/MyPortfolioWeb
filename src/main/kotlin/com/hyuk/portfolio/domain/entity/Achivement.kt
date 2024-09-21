package com.hyuk.portfolio.domain.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
class Achievement(
  title: String,
  description: String,
  achievement: LocalDateTime?,
  host: String,
  isActive: Boolean
): BaseEntity() {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "achievement_id")
  var id: Long? = null

  var title: String = title

  var description: String = description

  var achievement: LocalDateTime? = achievement

  var host: String = host

  var isActive: Boolean = isActive

}