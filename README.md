# Java Template

Java multi-module template for projects using Gradle with Kotlin DSL.

## Project Structure

```
├── buildSrc/                    # Build logic and common plugins
│   ├── build.gradle.kts
│   └── src/main/kotlin/
│       └── java-common.gradle.kts
├── gradle/
│   ├── wrapper/                 # Gradle wrapper files
│   └── libs.versions.toml       # Version catalog for dependency management
├── modules/                     # Application modules
│   ├── core/                    # Core business logic module
│   └── api/                     # API/External interface module
└── src/                         # Main application entry point
    └── main/java/
        └── com/neotamia/
            └── Main.java
```

## Features

- **Multi-module architecture**: Separate modules for different concerns
- **Gradle Kotlin DSL**: Modern build configuration with type safety
- **buildSrc**: Centralized build logic and plugins
- **Version Catalog**: Centralized dependency management (gradle/libs.versions.toml)
- **Java 17**: Modern Java version
- **JUnit 5**: Modern testing framework
- **SLF4J + Logback**: Professional logging setup

## Building and Running

### Build the project
```bash
./gradlew build
```

### Run tests
```bash
./gradlew test
```

### Run the application
```bash
./gradlew run
```

### Clean build
```bash
./gradlew clean build
```

## Modules

- **core**: Contains core business logic and services
- **api**: Contains external interfaces and controllers
- **main application**: Entry point that combines all modules

## Adding New Modules

1. Create a new directory under `modules/`
2. Add a `build.gradle.kts` file with the `java-common` plugin
3. Include the module in `settings.gradle.kts`
4. Add dependencies in the root `build.gradle.kts` if needed

Example:
```kotlin
// modules/new-module/build.gradle.kts
plugins {
    id("java-common")
}

dependencies {
    implementation(project(":modules:core"))
}
```

## Customization

- Update `gradle/libs.versions.toml` to manage dependency versions
- Modify `buildSrc/src/main/kotlin/java-common.gradle.kts` to change common build logic
- Adjust Java version and other settings in the build files