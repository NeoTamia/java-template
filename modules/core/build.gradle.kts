plugins {
    id("java-common")
}

description = "Core module with common functionality"

dependencies {
    implementation("org.slf4j:slf4j-api:2.0.7")
    implementation("ch.qos.logback:logback-classic:1.4.8")
}