// Common configuration shared by all chaos-starter submodules.
// Each submodule's own build.gradle.kts adds plugins and module-specific dependencies on top of this.
subprojects {
    dependencies {
        "implementation"(platform(project(":chaos-parent")))
        "implementation"("org.jetbrains.kotlin:kotlin-reflect")
        "testImplementation"("org.springframework.boot:spring-boot-starter-test")
    }
}
