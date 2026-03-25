# chaosmin-framework

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
