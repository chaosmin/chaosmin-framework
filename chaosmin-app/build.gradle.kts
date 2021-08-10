plugins {
    base
    kotlin("jvm")
    id("org.jetbrains.kotlin.kapt")
}

dependencies {
    api(project(":chaosmin-base"))
    // spring boot web 必要组件
    api("org.springframework.boot:spring-boot-starter:${Version.Deps.springBootVersion}")
    api("org.springframework.boot:spring-boot-starter-web:${Version.Deps.springBootVersion}") {
        // 移除tomcat依赖, 使用undertow服务容器
        exclude("org.springframework.boot", "spring-boot-starter-tomcat")
    }
    api("org.springframework.boot:spring-boot-starter-undertow:${Version.Deps.springBootVersion}")
    api("org.springframework.boot:spring-boot-starter-actuator:${Version.Deps.springBootVersion}")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor:${Version.Deps.springBootVersion}")
}