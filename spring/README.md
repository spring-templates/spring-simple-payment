# 📖 (서비스 타이틀)

![image](https://github.com/spring-templates/spring-simple-payment/assets/96914905/99eb3687-37e5-4960-8bf7-78a519f0661f)



![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?logo=springboot&logoColor=white)
![Java](https://img.shields.io/badge/Java-ED8B00?logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-02303A?logo=gradle&logoColor=white)
![JUnit5](https://img.shields.io/badge/JUnit5-25A162?logo=junit5&logoColor=white)
![JaCoCo](https://img.shields.io/badge/JaCoCo-D22128?logo=jacoco&logoColor=white)
![Codecov](https://img.shields.io/badge/Codecov-F01F7A?logo=codecov&logoColor=white)
![GitHub Actions](https://img.shields.io/badge/GitHub%20Actions-2088FF?logo=githubactions&logoColor=white)

- 배포 URL :
- Test ID : readme@test.com
- Test PW : 123123

<br>

## 프로젝트 소개

-

<br>

## 팀원 구성

<div style="display: flex; justify-content: center">
<div>

|                                                            **김현학**                                                             |
|:------------------------------------------------------------------------------------------------------------------------------:| 
| [<img src="https://avatars.githubusercontent.com/u/96914905?v=4" height=150 width=150> <br/> @oomia](https://github.com/oomia) | 

</div>

</div>

<br>

## 1. 개발 환경

- 버전 및 이슈관리 : Github, Github Issues, Github Project
- 협업 툴 : Discord, Notion, Github Wiki
- 서비스 배포 환경 :
-

디자인 : [Figma](https://www.figma.com/file/fAisC2pEKzxTOzet9CfqML/README(oh-my-code)?node-id=39%3A1814)

- [커밋 컨벤션](https://github.com/likelion-project-README/README/wiki/%EC%BB%A4%EB%B0%8B-%EC%BB%A8%EB%B2%A4%EC%85%98)
- [코드 컨벤션](https://github.com/likelion-project-README/README/wiki/%EC%BD%94%EB%93%9C-%EC%BB%A8%EB%B2%A4%EC%85%98)
- [스프라이트](https://github.com/likelion-project-README/README/wiki/%EC%8A%A4%ED%94%84%EB%9D%BC%EC%9D%B4%ED%8A%B8)
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
spring-simple-payment\spring
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
│  README.md
│  settings.gradle.kts
│  SunStyle_edited.xml
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

- 전체 개발 기간 : 2022-12-09 ~ 2022-12-31
- UI 구현 : 2022-12-09 ~ 2022-12-16
- 기능 구현 : 2022-12-17 ~ 2022-12-31

<br>

### 작업 관리

- CONTENT
  <br>

## 6. 신경 쓴 부분

- [접근제한 설정](https://github.com/likelion-project-README/README/wiki/README-6.%EC%8B%A0%EA%B2%BD-%EC%93%B4-%EB%B6%80%EB%B6%84_%EC%A0%91%EA%B7%BC%EC%A0%9C%ED%95%9C-%EC%84%A4%EC%A0%95)

- [Recoil을 통한 상태관리 및 유지](https://github.com/likelion-project-README/README/wiki/README-6.%EC%8B%A0%EA%B2%BD-%EC%93%B4-%EB%B6%80%EB%B6%84_Recoil%EC%9D%84-%ED%86%B5%ED%95%9C-%EC%83%81%ED%83%9C%EA%B4%80%EB%A6%AC-%EB%B0%8F-%EC%9C%A0%EC%A7%80)

<br>

## 7. 페이지별 기능

### [초기화면]

- DESCRITPION : README 서비스의 초기화면입니다.

| 초기화면                                                                                                              |
|-------------------------------------------------------------------------------------------------------------------|
| ![splash](https://user-images.githubusercontent.com/112460466/210172920-aef402ed-5aef-4d4a-94b9-2b7147fd8389.gif) |

<br>

<br>

## 8. 트러블 슈팅

- [탭메뉴 프로필 버튼 이슈](https://github.com/likelion-project-README/README/wiki/README-8.%ED%8A%B8%EB%9F%AC%EB%B8%94-%EC%8A%88%ED%8C%85_%ED%83%AD%EB%A9%94%EB%89%B4-%ED%94%84%EB%A1%9C%ED%95%84-%EB%B2%84%ED%8A%BC-%EC%9D%B4%EC%8A%88)

- [프로필 수정 이슈](https://github.com/likelion-project-README/README/wiki/README-8.%ED%8A%B8%EB%9F%AC%EB%B8%94-%EC%8A%88%ED%8C%85_%ED%94%84%EB%A1%9C%ED%95%84-%EC%88%98%EC%A0%95-%EC%9D%B4%EC%8A%88)

<br>

## 9. 개선 목표

- (원인)

  ![KakaoTalk_Photo_2023-01-04-16-55-30](https://user-images.githubusercontent.com/112460466/210591134-09bf8efd-3c34-4b99-a3d7-895ca99e1457.png)

- **2023/01/17 성능 개선 내용**

  ![성능개선 후](https://user-images.githubusercontent.com/106502312/212872369-7ceeb2cf-d551-41d2-bfb0-01e35e9903fe.png)

  - (개선 내용 요약)

<br>

## 10. 프로젝트 후기

### 🍊 이름

- 후기

