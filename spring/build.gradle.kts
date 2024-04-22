plugins {
    java
    jacoco
    id("org.springframework.boot") version "3.2.4"
    id("io.spring.dependency-management") version "1.1.4"
}

group = "com.service"
version = "1.0.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_21
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

@Suppress("SpellCheckingInspection") dependencies {
    // spring-service-payment
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springdoc:springdoc-openapi-starter-webflux-ui:2.5.0")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    developmentOnly("org.springframework.boot:spring-boot-starter-actuator")
    developmentOnly("org.springframework.boot:spring-boot-docker-compose")

    // spring-concurrency-jpa
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    compileOnly("org.projectlombok:lombok")
    runtimeOnly("com.mysql:mysql-connector-j")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    // spring-thread-concurrency
    implementation("org.springframework.boot:spring-boot-starter")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testRuntimeOnly("org.reactivestreams:reactive-streams")
    testRuntimeOnly("org.apache.logging.log4j:log4j-core")
}

tasks.all {
    outputs.cacheIf { true }
}

fun Test.addActiveProfiles(profile: String) {
    doFirst {
        val activeProfiles = System.getProperty("spring.profiles.active")
        val newActiveProfiles = if (activeProfiles.isNullOrBlank()) {
            profile
        } else {
            "$activeProfiles,$profile"
        }
        systemProperty("spring.profiles.active", newActiveProfiles)
    }
}

tasks {
    test {
        @Suppress("SpellCheckingInspection") jvmArgs("-Xshare:off", "-XX:+EnableDynamicAgentLoading")
        addActiveProfiles("test")
        useJUnitPlatform()
        finalizedBy(jacocoTestReport)
    }
    jacocoTestReport {
        dependsOn(test)
        reports {
            xml.required = true
            csv.required = false
            html.required = false
        }
    }
}

tasks.withType<Test>().configureEach {
    maxParallelForks = (Runtime.getRuntime().availableProcessors() / 2).coerceAtLeast(1)
}

apply(from = "dumpJsa.gradle.kts")
tasks.withType<JavaExec> {
    dependsOn("dumpJsa")
}