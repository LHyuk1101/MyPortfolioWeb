package com.hyuk.portfolio.domain.repository

import com.hyuk.portfolio.domain.entity.HttpInterface
import org.springframework.data.jpa.repository.JpaRepository

interface HttpInterfaceRepository : JpaRepository<HttpInterface, Long> {
}