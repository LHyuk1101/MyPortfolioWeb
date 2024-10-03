package com.hyuk.portfolio.presentation.dto

import com.hyuk.portfolio.domain.entity.Introduction

data class IntroductionDTO(
  val content: String
) {
  constructor(introduction: Introduction) : this(
    content = introduction.content
  )
}