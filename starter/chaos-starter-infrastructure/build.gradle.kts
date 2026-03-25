plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
    kotlin("plugin.jpa")   // enables open classes and no-arg constructors for JPA entities
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
}
