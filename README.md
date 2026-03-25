# chaosmin-framework

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.0-6DB33F?logo=springboot&logoColor=white)](https://spring.io/projects/spring-boot)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.20-7F52FF?logo=kotlin&logoColor=white)](https://kotlinlang.org)
[![Gradle](https://img.shields.io/badge/Gradle-8.12-02303A?logo=gradle&logoColor=white)](https://gradle.org)
[![Java](https://img.shields.io/badge/Java-21%2B-ED8B00?logo=openjdk&logoColor=white)](https://openjdk.org)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](LICENSE)

**Language / 语言：** English | [中文](README_zh.md)

---

A Spring Boot 4 based framework skeleton with layered DDD architecture, providing out-of-the-box starter modules.

## Module Structure

| Module | Description |
|--------|-------------|
| `chaos-parent` | BOM — re-exports `spring-boot-dependencies:4.0.0` for unified version management |
| `chaos-starter-foundation` | Base package: DTOs, utilities, exceptions, common types |
| `chaos-starter-domain` | Business layer: domain model and domain services |
| `chaos-starter-integration` | Outbound clients: HTTP integrations and third-party adapters |
| `chaos-starter-facade` | API contracts: interfaces and request/response types |
| `chaos-starter-facade-impl` | Application services implementing the facade |
| `chaos-starter-infrastructure` | Persistence layer: JPA repository implementations |
| `chaos-starter-app` | Spring Boot entry point and application configuration |

## Dependency Flow

```
app ──► facade-impl ──► facade
                    └──► domain ──► integration
infrastructure ──────────► domain
foundation ◄── (all modules)
```

## Requirements

- JDK 21+
- Gradle 8.12 (via wrapper)

## Build

```bash
./gradlew build          # build all modules
./gradlew test           # run all tests
./gradlew clean build    # clean build
```
