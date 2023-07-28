plugins {
    kotlin("jvm") version "1.8.0"
    application
    kotlin("plugin.noarg") version "1.8.0"
}

noArg {
    invokeInitializers = true
    annotation("entities.NoArg")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.squareup.okhttp3:okhttp:4.10.0")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.15.2")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(11)
}

application {
    mainClass.set("MainKt")
}