plugins {
    id("application")
}

val mainClassName = "ai.arcblroth.cargo.example.Main"

val backend: Configuration by configurations.creating {
    isCanBeConsumed = false
    isCanBeResolved = true
}

dependencies {
    // Depend on our native code
    backend(project(":native"))
}

tasks.processResources {
    // Copy the native library into the final jar
    from(backend)
}

tasks.jar {
    manifest {
        attributes += mapOf("Main-Class" to mainClassName)
    }
}
