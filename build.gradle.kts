import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.util.Properties

plugins {
    id("java-library")
    id("maven-publish")
    kotlin("jvm") version "1.6.20"
    kotlin("plugin.serialization") version "1.6.20"
}

group = "me.darefox"
version = "0.1.0"

repositories {
    mavenCentral()
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = rootProject.group.toString()
            artifactId = rootProject.name
            version = rootProject.version.toString()

            from(components["java"])
        }
    }
}

val ktor_version = "1.6.8"

dependencies {
    testImplementation(kotlin("test"))

    implementation("io.ktor:ktor-client-core:$ktor_version")
    implementation("io.ktor:ktor-client-cio:$ktor_version")
    implementation("io.ktor:ktor-client-serialization:$ktor_version")

    implementation("io.github.resilience4j:resilience4j-ratelimiter:1.7.1")
    implementation("io.github.resilience4j:resilience4j-kotlin:1.7.1")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")
}


tasks.test {
    doFirst {
        val localEnv = rootProject.file("local.properties")
        val prop = Properties()


        if (localEnv.exists()) {
            prop.load(localEnv.inputStream())
        }

        val token = prop["test.dtf.token"]
        environment("TEST_DTF_TOKEN", token ?: System.getenv("TEST_DTF_TOKEN"))
    }
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.create("fatJar", Jar::class) {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    val dependencies = configurations
        .runtimeClasspath
        .get()
        .map(::zipTree)
    from(dependencies)
    with(tasks.jar.get())
}
