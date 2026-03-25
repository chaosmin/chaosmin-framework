# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Build & Run Commands

```bash
# Build all modules
./gradlew build

# Build without tests
./gradlew build -x test

# Run all tests
./gradlew test

# Run tests for a specific module
./gradlew :chaos-starter:chaos-starter-domain:test

# Run a single test class
./gradlew :chaos-starter:chaos-starter-domain:test --tests "fully.qualified.ClassName"

# Run a single test method
./gradlew :chaos-starter:chaos-starter-domain:test --tests "fully.qualified.ClassName.methodName"

# Clean build
./gradlew clean build

# Publish to local Maven repository
./gradlew publishToMavenLocal
```

**Toolchain:** Gradle 8.12 wrapper · Kotlin 2.1.20 · Spring Boot 4.0.0 · JVM target 21

## Module Architecture

Multi-module Kotlin framework following DDD layered architecture. All modules live under `chaos-starter/`; `chaos-parent` is a standalone Java Platform BOM.

### Modules and Responsibilities

| Module | Role |
|--------|------|
| `chaos-starter-foundation` | Base utilities, DTOs, exceptions, common types — depended on by every other module |
| `chaos-starter-domain` | Domain model and business logic; no framework coupling |
| `chaos-starter-integration` | Outbound HTTP clients (WebFlux `WebClient`); third-party adapters |
| `chaos-starter-facade` | Inbound API contracts: interfaces and request/response types only, no implementation |
| `chaos-starter-facade-impl` | Application services; implements facade, orchestrates domain |
| `chaos-starter-infrastructure` | JPA repository implementations and persistence entities |
| `chaos-starter-app` | Spring Boot entry point; wires all modules; produces executable `bootJar` |

### Dependency Flow

```
app ──► facade-impl ──► facade
                    └──► domain ──► integration
infrastructure ──────────► domain
foundation ◄── (all modules)
```

### Gradle Structure

| File | Purpose |
|------|---------|
| `build.gradle.kts` (root) | Declares all plugin versions (`apply false`); configures Kotlin compiler options (`-Xjsr305=strict`, JVM 21) and JUnit platform globally via `subprojects {}` |
| `chaos-parent/build.gradle.kts` | `java-platform` BOM; re-exports `spring-boot-dependencies:4.0.0` |
| `chaos-starter/build.gradle.kts` | Injects `platform(project(":chaos-parent"))`, `kotlin-reflect`, and `spring-boot-starter-test` into all starter submodules via `subprojects {}` |
| Each module `build.gradle.kts` | Declares `kotlin("jvm")` + `kotlin("plugin.spring")` plugins and module-specific dependencies |

### Key Conventions

- Use `api(...)` for transitive dependencies that module consumers need; `implementation(...)` for internal-only deps.
- `chaos-starter-infrastructure` additionally applies `kotlin("plugin.jpa")` to enable open classes and no-arg constructors for JPA entities.
- `chaos-starter-app` additionally applies `id("org.springframework.boot")` to produce a runnable `bootJar`. Add a JDBC driver (`runtimeOnly`) here.
- Domain objects are immutable; mutations return new instances.
