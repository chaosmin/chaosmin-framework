subprojects {
    // chaos-starter-parent uses java-platform and does not need Kotlin runtime or test deps
    if (name != "chaos-starter-parent") {
        dependencies {
            "implementation"(platform(project(":starter:chaos-starter-parent")))
            "implementation"("org.jetbrains.kotlin:kotlin-reflect")
            "testImplementation"("org.springframework.boot:spring-boot-starter-test")
        }
    }
}
