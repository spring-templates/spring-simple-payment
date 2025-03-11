# 📖 (서비스 타이틀)

![image](https://github.com/spring-templates/spring-simple-payment/assets/96914905/99eb3687-37e5-4960-8bf7-78a519f0661f)

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?logo=springboot&logoColor=white)
![Java](https://img.shields.io/badge/Java-ED8B00?logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-02303A?logo=gradle&logoColor=white)
![JUnit5](https://img.shields.io/badge/JUnit5-25A162?logo=junit5&logoColor=white)
![JaCoCo](https://img.shields.io/badge/JaCoCo-D22128?logo=jacoco&logoColor=white)
![Codecov](https://img.shields.io/badge/Codecov-F01F7A?logo=codecov&logoColor=white)
![GitHub Actions](https://img.shields.io/badge/GitHub%20Actions-2088FF?logo=githubactions&logoColor=white)

[![codecov](https://codecov.io/gh/spring-templates/spring-simple-payment/graph/badge.svg?token=tGi5xmvIhW)](https://codecov.io/gh/spring-templates/spring-simple-payment)

- 배포 URL : [AWS EC2](http://payment.oomia.click:8080)

<br>

## 프로젝트 소개

-

<br>

## 팀원 구성

|                                                           **김현학**                                                           |
| :----------------------------------------------------------------------------------------------------------------------------: |
| [<img src="https://avatars.githubusercontent.com/u/96914905?v=4" height=150 width=150> <br/> @oomia](https://github.com/oomia) |

<br>

## 1. 개발 환경

- 버전 및 이슈관리 : Github, Github Issues, Github Project
- 협업 툴 : Discord, Notion, Github Wiki
- 서비스 배포 환경 :
-

디자인

- [커밋 컨벤션]
- [코드 컨벤션]
- [스프라이트]
  <br>

## 2. 채택한 개발 기술과 브랜치 전략

### Spring WebFlux

- 설명

### 브랜치 전략

- 설명

<br>

## 3. 프로젝트 구조

- Windows CMD에서 `tree /F | clip` 명령어 사용

```
spring-simple-payment
│
│  .gitignore
│  docker-compose.prod.yaml
│  docker-compose.yaml
│  README.md
│
├─.github
│  │  PULL_REQUEST_TEMPLATE.md
│  │
│  ├─ISSUE_TEMPLATE
│  │      bug_report.md
│  │      custom.md
│  │      feature_request.md
│  │
│  └─workflows
│          docker-publish.yml
│          gradle-test-main.yml
│          gradle-test.yml
│
└─spring
    │  .dockerignore
    │  .gitignore
    │  .gitmessage
    │  build.gradle.kts
    │  codecov.yml
    │  dev.Dockerfile
    │  Dockerfile
    │  dumpJsa.gradle.kts
    │  gradlew
    │  gradlew.bat
    │  LICENSE
    │  settings.gradle.kts
    │  SunStyle_edited.xml
    │
    ├─gradle
    │  └─wrapper
    │          gradle-wrapper.jar
    │          gradle-wrapper.properties
    │
    └─src
        ├─main
        │  ├─java
        │  │  └─com
        │  │      └─service
        │  │          │  package-info.java
        │  │          │  PaymentServiceApplication.java
        │  │          │
        │  │          ├─customer
        │  │          │  │  CustomerRequestDto.java
        │  │          │  │  package-info.java
        │  │          │  │
        │  │          │  └─entity
        │  │          │          Customer.java
        │  │          │          Email.java
        │  │          │          Name.java
        │  │          │          package-info.java
        │  │          │
        │  │          └─payment
        │  │              │  package-info.java
        │  │              │  PaymentController.java
        │  │              │  PaymentRepository.java
        │  │              │  PaymentService.java
        │  │              │  PaymentServiceImpl.java
        │  │              │
        │  │              ├─dto
        │  │              │      package-info.java
        │  │              │      PaymentInitialRequestDto.java
        │  │              │      PaymentStatus.java
        │  │              │      PaymentStatusDto.java
        │  │              │
        │  │              └─entity
        │  │                      AbstractPayment.java
        │  │                      package-info.java
        │  │                      Payment.java
        │  │
        │  └─resources
        │          application-default.yml
        │          application-dev.yml
        │          application-init-sql.yml
        │          application-test.yml
        │          application.yml
        │          data.sql
        │          schema.sql
        │
        └─test
            └─java
                └─com
                    └─service
                            package-info.java
                            PaymentServiceApplicationTest.java
```

<br>

## 4. 역할 분담

### 🍊이름

- **파트**
  - 내용
    <br>

## 5. 개발 기간 및 작업 관리

### 개발 기간

- 전체 개발 기간 :

<br>

### 작업 관리

- CONTENT
  <br>

## 6. 신경 쓴 부분

- 링크

<br>

## 7. 페이지별 기능

### [초기화면]

- DESCRITPION : README 서비스의 초기화면입니다.

| 초기화면 |
| -------- |
| gif      |

<br>

<br>

## 8. 트러블 슈팅

- 링크

<br>

## 9. 개선 목표

- 문제 -> 할 일 -> 결과

<br>

## 10. 프로젝트 후기

### 🍊 이름

- 후기
