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
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor:${Version.Deps.springBootVersion}")
    // nacos
    api("org.springframework.cloud:spring-cloud-starter-alibaba-nacos-discovery:${Version.Deps.nacosVersion}")
    api("org.springframework.cloud:spring-cloud-starter-alibaba-nacos-config:${Version.Deps.nacosVersion}")
    // swagger
    api("io.springfox:springfox-boot-starter:${Version.Deps.swaggerVersion}")
    api("org.apache.httpcomponents:httpclient:4.5.13")
}