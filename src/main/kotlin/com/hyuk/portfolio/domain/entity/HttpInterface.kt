package com.hyuk.portfolio.domain.entity

import jakarta.persistence.*
import jakarta.servlet.http.HttpServletRequest

@Entity
class HttpInterface(
  httpServletRequest: HttpServletRequest
): BaseEntity() {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "httpInterface_id")
  var id: Long? = null

  //쿠키가 가진 키와 밸류를 스트링으로 변환
  var cookies: String? = httpServletRequest.cookies
    ?.map { "${it.name}:${it.value}" }
    ?.toString()

  //http요청 정보에서 referer, 즉 요청이 어디서왔는지 알려줌
  var referer: String? = httpServletRequest.getHeader("referer")

  var localAddr: String? = httpServletRequest.localAddr

  var remoteAddr: String? = httpServletRequest.remoteAddr

  var remoteHost: String? = httpServletRequest.remoteHost

  //어떤 uri로 접속을 했는지
  var requestUri: String? = httpServletRequest.requestURI
  //브라우저 정보 크롬,사파리,모바일,데탑 등등
  var userAgent: String? = httpServletRequest.getHeader("user-agent")
  
}