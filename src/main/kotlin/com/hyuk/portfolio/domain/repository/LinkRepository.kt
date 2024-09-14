package com.hyuk.portfolio.domain.repository

import com.hyuk.portfolio.domain.entity.Link
import org.springframework.data.jpa.repository.JpaRepository

interface LinkRepository : JpaRepository<Link, Long> {
}