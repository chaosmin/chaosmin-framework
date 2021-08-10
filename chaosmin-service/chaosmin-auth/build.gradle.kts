plugins {
    base
    kotlin("jvm")
    id("org.jetbrains.kotlin.kapt")
}

dependencies {
    api(project(":chaosmin-app"))
}