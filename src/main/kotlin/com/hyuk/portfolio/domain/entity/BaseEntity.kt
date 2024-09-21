package com.hyuk.portfolio.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime

@MappedSuperclass
abstract class BaseEntity {

  //엔티티가 생성된시간 자동으로 세팅
  @CreatedDate
  @Column(nullable = false, updatable = false) //null일수 없고 처음 세팅된 값을 변경할 수 없다
  var createdDateTime: LocalDateTime = LocalDateTime.now()

  //마지막으로 수정된 일시는 언제인지
  @LastModifiedDate
  @Column(nullable = false)
  var updatedDateTime: LocalDateTime = LocalDateTime.now()

}