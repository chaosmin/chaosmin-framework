plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
    id("org.springframework.boot")  // produces executable bootJar
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    // Add a JDBC driver here, e.g.:
    // runtimeOnly("com.h2database:h2")
    // runtimeOnly("org.postgresql:postgresql")
}
