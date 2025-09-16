plugins {
    id("java-common")
}

description = "API module with external interfaces"

dependencies {
    implementation(project(":modules:core"))
    implementation("org.slf4j:slf4j-api:2.0.7")
    implementation("ch.qos.logback:logback-classic:1.4.8")
}