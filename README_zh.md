# chaosmin-framework

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.0-6DB33F?logo=springboot&logoColor=white)](https://spring.io/projects/spring-boot)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.20-7F52FF?logo=kotlin&logoColor=white)](https://kotlinlang.org)
[![Gradle](https://img.shields.io/badge/Gradle-8.12-02303A?logo=gradle&logoColor=white)](https://gradle.org)
[![Java](https://img.shields.io/badge/Java-21%2B-ED8B00?logo=openjdk&logoColor=white)](https://openjdk.org)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](LICENSE)

**Language / 语言：** [English](README.md) | 中文

---

基于 Spring Boot 4 构建的框架骨架，采用分层 DDD 架构，提供开箱即用的 Starter 模块。

## 模块说明

| 模块 | 说明 |
|------|------|
| `chaos-starter-parent` | BOM 版本管理，统一引入 `spring-boot-dependencies:4.0.0` |
| `chaos-starter-foundation` | 基础包：DTO、工具类、异常等通用类 |
| `chaos-starter-domain` | 业务层：领域模型与领域服务 |
| `chaos-starter-integration` | 外部请求层：HTTP 客户端与第三方集成 |
| `chaos-starter-facade` | 对外接口层：接口定义与请求/响应类型 |
| `chaos-starter-facade-impl` | 接口实现层：应用服务实现 |
| `chaos-starter-infrastructure` | 持久层：JPA Repository 实现 |
| `chaos-starter-app` | 应用启动类：Spring Boot 入口与配置 |

## 依赖关系

```
app ──► facade-impl ──► facade
                    └──► domain ──► integration
infrastructure ──────────► domain
foundation ◄── （所有模块依赖）
```

## 环境要求

- JDK 21+
- Gradle 8.12（通过 Wrapper 自动下载）

## 构建

```bash
./gradlew build          # 构建所有模块
./gradlew test           # 运行所有测试
./gradlew clean build    # 清理后重新构建
```
