import org.gradle.kotlin.dsl.`kotlin-dsl`

plugins {
    `kotlin-dsl`
}
// Required since Gradle 4.10+.
repositories {
    mavenCentral()
}
dependencies {
    implementation( "com.squareup:kotlinpoet:1.6.0")
}
