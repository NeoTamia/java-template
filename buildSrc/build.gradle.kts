plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
}

kotlin {
    jvmToolchain(21)
}

dependencies {
    implementation(libs.shadowGradlePlugin)
    implementation(libs.spotlessGradlePlugin)
}
