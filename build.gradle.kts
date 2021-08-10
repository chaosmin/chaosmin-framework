import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    base
    kotlin("jvm") version Version.Plugins.kotlinVersion
    id("org.jetbrains.kotlin.kapt") version Version.Plugins.kotlinVersion
    id("org.sonarqube") version Version.Plugins.sonarqubeVersion
    id("org.hidetake.ssh") version Version.Plugins.hidetakeSSHVersion
    id("org.springframework.boot") version Version.Plugins.springBootVersion
    jacoco
}

allprojects {
    group = "tech.chaosmin"
    version = "0.0.1.SNAPSHOT"

    repositories {
        maven(url = "https://maven.aliyun.com/repository/central")
        maven(url = "https://maven.aliyun.com/repository/gradle-plugin")
        maven(url = "https://maven.aliyun.com/nexus/content/groups/public")
        maven(url = "https://jitpack.io")
        mavenCentral()
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

configurations.all {
    exclude("com.alibaba", "fastjson")
    exclude("com.netflix.archaius", "archaius-core")
    exclude("org.springframework.cloud", "spring-cloud-netflix-archaius")
    exclude("org.springframework.cloud", "spring-cloud-starter-netflix-archaius")
}