plugins {
    base
    kotlin("jvm")
    id("org.jetbrains.kotlin.kapt")
}

dependencies {
    api(kotlin("reflect"))
    api("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.Deps.kotlinCoroutinesVersion}")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-core-common:${Version.Deps.kotlinCoroutinesVersion}")

    // jackson
    api("com.fasterxml.jackson.core:jackson-core:${Version.Deps.jacksonVersion}")
    api("com.fasterxml.jackson.core:jackson-databind:${Version.Deps.jacksonVersion}")
    api("com.fasterxml.jackson.core:jackson-annotations:${Version.Deps.jacksonVersion}")
    api("com.fasterxml.jackson.datatype:jackson-datatype-joda:${Version.Deps.jacksonVersion}")
    api("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:${Version.Deps.jacksonVersion}")
    api("com.fasterxml.jackson.module:jackson-module-kotlin:${Version.Deps.jacksonVersion}")
    api("com.fasterxml.jackson.module:jackson-module-parameter-names:${Version.Deps.jacksonVersion}")
    api("com.fasterxml.jackson.dataformat:jackson-dataformat-properties:${Version.Deps.jacksonVersion}")
    api("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:${Version.Deps.jacksonVersion}")
    api("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:${Version.Deps.jacksonVersion}")

    // common tools
    api("commons-codec:commons-codec:${Version.Deps.commonsCodecVersion}")
    // bean 转换工具
    api("org.mapstruct:mapstruct:${Version.Deps.mapStructVersion}")
    kapt("org.mapstruct:mapstruct-processor:${Version.Deps.mapStructVersion}")
    // 常用工具集
    api("cn.hutool:hutool-all:${Version.Deps.hutoolVersion}")
    api("com.google.guava:guava:${Version.Deps.guavaVersion}")
    // jwt 工具
    implementation("io.jsonwebtoken:jjwt:${Version.Deps.jwtVersion}")
    // excel 解析工具
    implementation("org.apache.poi:poi:${Version.Deps.poiVersion}")
    implementation("org.apache.poi:poi-ooxml:${Version.Deps.poiVersion}")

    // logback
    runtimeOnly("ch.qos.logback:logback-classic:${Version.Deps.logbackVersion}")
    runtimeOnly("org.codehaus.janino:janino:${Version.Deps.janinoVersion}")
    runtimeOnly("org.codehaus.janino:commons-compiler:${Version.Deps.janinoVersion}")

    // junit5
    testApi("org.junit.jupiter:junit-jupiter-api:${Version.Deps.junitVersion}")
    testApi("org.junit.jupiter:junit-jupiter-engine:${Version.Deps.junitVersion}")
    testApi("org.assertj:assertj-core:${Version.Deps.assertJVersion}")
}