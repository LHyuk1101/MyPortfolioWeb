package com.hyuk.portfolio.domain.repository

import com.hyuk.portfolio.domain.entity.Skill
import org.springframework.data.jpa.repository.JpaRepository

interface SkillRepository : JpaRepository<Skill, Long> {
}