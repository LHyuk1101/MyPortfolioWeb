package com.hyuk.portfolio.domain

import com.hyuk.portfolio.domain.constant.SkillType
import com.hyuk.portfolio.domain.entity.*
import com.hyuk.portfolio.domain.repository.*
import jakarta.annotation.PostConstruct
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
@Profile(value = ["default"])
class DataInitializer(
  private val achievementRepository: AchievementRepository,
  private val introductionRepository: IntroductionRepository,
  private val linkRepository: LinkRepository,
  private val skillRepository: SkillRepository,
  private val projectRepository: ProjectRepository,
  private val experienceRepository: ExperienceRepository,
) {
  val log: Logger = LoggerFactory.getLogger(DataInitializer::class.java)

  @PostConstruct // 빈등록 완료 이후 맨 처음 실행되는
  fun initializeData() {

    log.info("스프링이 실행되었음. 테스트 데이터 초기화")
    val achievements = mutableListOf<Achievement>(
      Achievement(
        title = "2024 어쩌고 저쩌고 대회 최우수상",
        description = "강아지 춘식이는 귀여워요", host = "개카오",
        achievedDate = LocalDate.of(2023,11,1),
        isActive = true
      ),
      Achievement(
        title = "정보처리기사 따고싶어요",
        description = "자료구조, 운영체제, 알고리즘, 데이터베이스 등", host = "한국산업인력공단",
        achievedDate = LocalDate.of(2026, 2, 2),
        isActive = true
      )
    )

    achievementRepository.saveAll(achievements)

    val introductions = mutableListOf<Introduction>(
      Introduction(content = "주도적으로 문제를 찾고, 해결하는 강아지입니다.", isActive = true),
      Introduction(content = "기술을 위한 기술이 아닌, 비즈니스 문제를 풀기 위한 기술을 추구합니다.", isActive = true),
      Introduction(content = "기존 소스를 리팩토링하여 더 좋은 구조로 개선하는 작업을 좋아합니다.", isActive = true)
    )

    introductionRepository.saveAll(introductions)

    val links = mutableListOf<Link>(
      Link(name = "Github", content = "https://github.com/LHyuk1101", isActive = true),
      Link(name = "Linkedin", content = "https://www.linkedin.com/in/hyuk-lee-8493b2325/",
        isActive = true),
    )
    linkRepository.saveAll(links)
// experience / experience_detail 초기화
  val experience1 = Experience(
    title = "고려사이버대학교(Korea Cyber Univ.)", description = "소프트웨어공학 전공", startYear = 2023,
    startMonth = 3,
    endYear = 2027,
    endMonth = 2,
    isActive = true,
  )
    experience1.addDetails(
      mutableListOf(
        ExperienceDetail(content = "GPA 4.1/4.5", isActive = true))
    )

    val experience2 = Experience(
      title = "주식회사 개카오(Dogkao Corp.)", description = "소셜서비스팀 백엔드 개발자", startYear = 2024,
      startMonth = 9,
      endYear = null,
      endMonth = null,
      isActive = true,
    )
    experience2.addDetails(
      mutableListOf(
        ExperienceDetail(content = "유기견 위치 공유 서비스 개발", isActive = true)
      ) )
    experienceRepository.saveAll(mutableListOf(experience1, experience2))

    // skill 초기화
    val java = Skill(name = "Java", type = SkillType.LANGUAGE.name, isActive = true)
    val kotlin = Skill(name = "Kotlin", type = SkillType.LANGUAGE.name, isActive = true)
    val python = Skill(name = "Python", type = SkillType.LANGUAGE.name, isActive = true)
    val spring = Skill(name = "Spring", type = SkillType.FRAMEWORK.name, isActive = true)
    val mysql = Skill(name = "MySQL", type = SkillType.DATABASE.name, isActive = true)
    skillRepository.saveAll(mutableListOf(java, kotlin, python, spring, mysql))

    // project / project_detail / project_skill 초기화
    val project1 = Project(
    name = "유기견 발견 정보 공유 서비스",
    description = "유기견 위치의 실시간 공유, 임시보호까지 연결해주는 서비스. 구글 맵스를 연동하여 유기견 위치 정보를 직관적으로 파악할 수 있도록 하는 사용자 경험 개선 작업.",
    startYear = 2024,
    startMonth = 1,
    endYear = 2024,
    endMonth = 12,
    isActive = true
    )
    project1.addDetails(
      mutableListOf(
        ProjectDetail(content = "구글 맵스를 활용한 유기견 발견 지역 정보 제공 API 개발", url = null, isActive = true)
      ))

    project1.skills.addAll(
      mutableListOf(
        ProjectSkill(project = project1, skill = java),
        ProjectSkill(project = project1, skill = spring),
        ProjectSkill(project = project1, skill = mysql)
      ))


    val project2 = Project(
      name = "반려동물 홈 카메라 움직임 감지 분석 모듈",
      description = "카메라에서 서버로 전달되는 신호를 분석하여 움직임이 감지될 경우 클라이언트에게 알림 발송 작업.",
      startYear = 2024,
      startMonth = 1,
      endYear = null,
      endMonth = null,
      isActive = true
    )
    project2.addDetails(
      mutableListOf(
        ProjectDetail(content = "나그네(Nagne) Ai기반 여행계획 자동화 서비스", url = null,
          isActive = true),
        ProjectDetail(content = "나그네(Nagne) Ai기반 여행계획 자동화 서비스", url = null, isActive = true),
          ProjectDetail(content = "Github Repository", url = "https://github.com/nagne-team", isActive = true)
      )
    )
    project2.skills.addAll(
      mutableListOf(
        ProjectSkill(project = project2, skill = python)
      ))
    projectRepository.saveAll(mutableListOf(project1, project2))
  }
}