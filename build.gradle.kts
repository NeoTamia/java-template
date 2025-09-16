plugins {
    id("java")
    id("application")
}

allprojects {
    group = "com.neotamia"
    version = "1.0.0"
}

subprojects {
    apply(plugin = "java")
    
    java {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    
    repositories {
        mavenCentral()
    }
    
    dependencies {
        testImplementation("org.junit.jupiter:junit-jupiter:5.9.2")
        testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    }
    
    tasks.named<Test>("test") {
        useJUnitPlatform()
    }
}

application {
    mainClass.set("com.neotamia.Main")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":modules:core"))
    implementation(project(":modules:api"))
    implementation("org.slf4j:slf4j-api:2.0.7")
    implementation("ch.qos.logback:logback-classic:1.4.8")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}