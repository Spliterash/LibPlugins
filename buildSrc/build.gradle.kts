import org.gradle.kotlin.dsl.`kotlin-dsl`

plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
    mavenCentral()
}
dependencies{
    implementation("gradle.plugin.com.github.johnrengelman:shadow:7.1.2")
}