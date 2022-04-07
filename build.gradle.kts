import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.util.Properties

group = "me.darefox"
version = "0.2.0"


plugins {
    id("java-library")
    id("maven-publish")
    kotlin("jvm") version "1.6.20"
    kotlin("plugin.serialization") version "1.6.20"
    id("org.jetbrains.dokka") version "1.6.10"
}

buildscript {
    dependencies {
        classpath("org.jetbrains.dokka:versioning-plugin:1.6.10")
    }
}


repositories {
    mavenCentral()
}

val ktorVersion = "1.6.8"

dependencies {
    testImplementation(kotlin("test"))

    implementation("io.ktor:ktor-client-core:$ktorVersion")
    implementation("io.ktor:ktor-client-cio:$ktorVersion")
    implementation("io.ktor:ktor-client-serialization:$ktorVersion")

    implementation("io.github.resilience4j:resilience4j-ratelimiter:1.7.1")
    implementation("io.github.resilience4j:resilience4j-kotlin:1.7.1")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")

    dokkaPlugin("org.jetbrains.dokka:versioning-plugin:1.6.10")
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
    kotlinOptions.freeCompilerArgs += "-Xopt-in=kotlin.RequiresOptIn"
}

// Create fat .jar file
tasks.create("fatJar", Jar::class) {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    val dependencies = configurations
        .runtimeClasspath
        .get()
        .map(::zipTree)
    from(dependencies)
    with(tasks.jar.get())
}

// Generate documentation by Dokka
tasks.dokkaHtml.configure {
    val docs = projectDir.resolve("docs")

    // DO NOT INCLUDE THIS FOLDER IN 'docs' FOLDER!!!
    // COPYING FILES CODE WILL FALL IN ENDLESS RECURSION!!!
    val otherVersionDir = projectDir.resolve("otherVersions")

    outputDirectory.set(docs)

    // Enable versioning plugin
    pluginConfiguration<org.jetbrains.dokka.versioning.VersioningPlugin, org.jetbrains.dokka.versioning.VersioningConfiguration> {
        version = rootProject.version.toString()
        olderVersionsDir = otherVersionDir
    }

    // Archive documentation versions
    doLast {
        println("Generated documentation copy stage")

        otherVersionDir.mkdir()
        require(otherVersionDir.isDirectory && otherVersionDir.exists()) {
            "Can't create otherVersions folder"
        }

        require(docs.isDirectory && docs.exists()) {
            "docs folder doesn't exist"
        }

        println("Copying docs to ${otherVersionDir.name}")
        docs.copyRecursively(otherVersionDir.resolve(rootProject.version.toString()), true)
    }
}
