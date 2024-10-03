package com.hyuk.portfolio.presentation.dto

import com.hyuk.portfolio.domain.entity.Link

class LinkDTO(
  val name: String,
  val content: String
) {
  constructor(link: Link) : this(
    name = link.name.lowercase(),
    content = link.content
  )
}