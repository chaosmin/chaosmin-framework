plugins {
    base
    kotlin("jvm")
    id("org.jetbrains.kotlin.kapt")
}

dependencies {
    implementation(kotlin("reflect"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.Deps.kotlinCoroutinesVersion}")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-common:${Version.Deps.kotlinCoroutinesVersion}")

    // jackson
    implementation("com.fasterxml.jackson.core:jackson-core:${Version.Deps.jacksonVersion}")
    implementation("com.fasterxml.jackson.core:jackson-databind:${Version.Deps.jacksonVersion}")
    implementation("com.fasterxml.jackson.core:jackson-annotations:${Version.Deps.jacksonVersion}")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-joda:${Version.Deps.jacksonVersion}")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:${Version.Deps.jacksonVersion}")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:${Version.Deps.jacksonVersion}")
    implementation("com.fasterxml.jackson.module:jackson-module-parameter-names:${Version.Deps.jacksonVersion}")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-properties:${Version.Deps.jacksonVersion}")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:${Version.Deps.jacksonVersion}")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:${Version.Deps.jacksonVersion}")

    // common tools
    implementation("commons-codec:commons-codec:${Version.Deps.commonsCodecVersion}")
    implementation("org.mapstruct:mapstruct:${Version.Deps.mapStructVersion}")
    kapt("org.mapstruct:mapstruct-processor:${Version.Deps.mapStructVersion}")
    implementation("cn.hutool:hutool-all:${Version.Deps.hutoolVersion}")
    implementation("com.google.guava:guava:${Version.Deps.guavaVersion}")
    implementation("io.jsonwebtoken:jjwt:${Version.Deps.jwtVersion}")
    implementation("org.apache.poi:poi:${Version.Deps.poiVersion}")
    implementation("org.apache.poi:poi-ooxml:${Version.Deps.poiVersion}")

    // logback
    implementation("ch.qos.logback:logback-classic:${Version.Deps.logbackVersion}")
    implementation("org.codehaus.janino:janino:${Version.Deps.janinoVersion}")
    implementation("org.codehaus.janino:commons-compiler:${Version.Deps.janinoVersion}")
}