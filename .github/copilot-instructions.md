# Java Multi-Module Template

Always follow these instructions first and fallback to search or bash commands only when you encounter unexpected information that does not match the info here.

## Working Effectively

- Bootstrap from the template:
  - Java 17 is already installed and configured
  - Maven 3.9.11 is already installed and configured  
  - Gradle 9.0.0 is available but Maven is the primary build tool
  - Create multi-module project: `mvn archetype:generate -DgroupId=com.neotamia.template -DartifactId=java-multi-module -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false`
  - Convert to multi-module by updating `java-multi-module/pom.xml` packaging to `pom` and adding Java 17 configuration
  - Create modules: `cd java-multi-module && mvn archetype:generate -DgroupId=com.neotamia.template -DartifactId=core -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false`
  - Repeat for additional modules (api, app, etc.)
  - Add modules to parent POM `<modules>` section

- Build the repository:
  - `cd java-multi-module` -- navigate to the project directory
  - `mvn clean compile` -- compiles all modules. Takes ~2-7 seconds. NEVER CANCEL. Set timeout to 60+ seconds.
  - `mvn clean test` -- compiles and runs all tests. Takes ~3-8 seconds. NEVER CANCEL. Set timeout to 60+ seconds.
  - `mvn clean install` -- full build with package and install to local repository. Takes ~2-6 seconds. NEVER CANCEL. Set timeout to 60+ seconds.

- Run the application:
  - ALWAYS run the build steps first
  - `cd java-multi-module/app && java -cp target/classes com.neotamia.template.App` -- runs main app directly
  - `cd java-multi-module && mvn exec:java -Dexec.mainClass="com.neotamia.template.App" -pl app` -- runs app via Maven exec plugin

## Project Structure

This repository is an empty template. When bootstrapped, it creates a Maven multi-module project with the following structure:
- `java-multi-module/` -- root project directory (created during bootstrap)
  - `pom.xml` -- parent POM with module definitions
  - `core/` -- core library module
  - `api/` -- API module  
  - `app/` -- application module with main class
  - `src/` -- legacy source directory (can be ignored)

## Template Bootstrap Process

1. Create parent project: `mvn archetype:generate -DgroupId=com.neotamia.template -DartifactId=java-multi-module -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false`

2. Convert to multi-module by editing `java-multi-module/pom.xml`:
   - Change `<packaging>jar</packaging>` to `<packaging>pom</packaging>`
   - Add Java 17 properties and compiler configuration
   - Add dependency management section
   - Add modules section (initially empty)

3. Create sub-modules:
   ```bash
   cd java-multi-module
   mvn archetype:generate -DgroupId=com.neotamia.template -DartifactId=core -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
   mvn archetype:generate -DgroupId=com.neotamia.template -DartifactId=api -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
   mvn archetype:generate -DgroupId=com.neotamia.template -DartifactId=app -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
   ```

4. Update parent POM to include modules:
   ```xml
   <modules>
     <module>core</module>
     <module>api</module>
     <module>app</module>
   </modules>
   ```

5. Test the setup: `mvn clean install`

## Build System Details

- **Java Version**: 17 (Temurin OpenJDK)
- **Maven Version**: 3.9.11
- **Build Tool**: Maven (primary), Gradle available as alternative
- **Test Framework**: JUnit (currently 3.8.1, can be upgraded to JUnit 5)
- **Compiler**: Maven Compiler Plugin 3.11.0 targeting Java 17

## Validation

- ALWAYS manually validate any new code by running the application scenarios after making changes
- Basic validation scenario: Run `mvn clean install` followed by running the app to verify "Hello World!" output
- ALWAYS test both direct Java execution and Maven exec plugin execution methods
- Run `mvn clean test` to verify all tests pass before committing changes

## Build Timing and Warnings

- Initial project creation: `mvn archetype:generate` takes ~10-15 seconds per module. Set timeout to 120+ seconds. NEVER CANCEL.
- `mvn clean compile` -- ~2-7 seconds (first run may take 60+ seconds for dependency downloads). Set timeout to 120+ seconds minimum. NEVER CANCEL.
- `mvn clean test` -- ~3-8 seconds. Set timeout to 120+ seconds minimum. NEVER CANCEL.
- `mvn clean install` -- ~2-6 seconds. Set timeout to 120+ seconds minimum. NEVER CANCEL.
- First build may take significantly longer due to dependency downloads (up to 5 minutes)

## Common Tasks

### Creating Project from Template
1. `mvn archetype:generate -DgroupId=com.neotamia.template -DartifactId=java-multi-module -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false`
2. `cd java-multi-module`
3. Edit `pom.xml` to convert to multi-module (change packaging to `pom`, add Java 17 config)
4. Create modules using archetype:generate
5. Add modules to parent POM
6. `mvn clean install` to verify setup

### Building from Scratch (after project exists)
1. `cd java-multi-module`
2. `mvn clean install`
3. Verify build completes successfully with "BUILD SUCCESS"

### Running Tests
1. `cd java-multi-module` 
2. `mvn test`
3. Verify "Tests run: 3, Failures: 0, Errors: 0, Skipped: 0"

### Running the Application (after project exists)
1. Build first: `mvn clean install`
2. Method 1: `cd app && java -cp target/classes com.neotamia.template.App`
3. Method 2: `mvn exec:java -Dexec.mainClass="com.neotamia.template.App" -pl app`
4. Expected output: "Hello World!"

### Adding New Modules
1. Use Maven archetype: `mvn archetype:generate -DgroupId=com.neotamia.template -DartifactId=<module-name> -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false`
2. Add module to parent `pom.xml` in `<modules>` section
3. Build and test: `mvn clean install`

## Repository Overview

### ls -la (repo root)
```
.git/
.github/
.gitignore
LICENSE
README.md
java-multi-module/  (created after bootstrap)
```

### cat README.md
```
# java-template
Java multi module template for our projects
```

### Key Files to Know (after bootstrap)
- `java-multi-module/pom.xml` -- Parent POM controlling all modules
- `java-multi-module/*/pom.xml` -- Individual module POMs
- `java-multi-module/app/src/main/java/com/neotamia/template/App.java` -- Main application class
- `java-multi-module/*/src/test/java/` -- Test classes in each module

## Environment Information
- Operating System: Linux (Ubuntu)
- Java: OpenJDK 17.0.16 (Temurin)
- Maven: 3.9.11
- Gradle: 9.0.0 (available but not primary)
- Available in PATH: java, javac, mvn, gradle

## Troubleshooting
- If build fails with "Child module does not exist", ensure modules are created before adding to parent POM
- If tests fail, check JUnit version compatibility (upgrade from 3.8.1 to 5.x if needed)
- If application doesn't run, verify main class exists and is compiled: `ls java-multi-module/app/target/classes/com/neotamia/template/`
- For dependency issues, run `mvn dependency:resolve` to download missing dependencies