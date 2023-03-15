# Gradle multi module project example

## Project structure
```text
sub1 - subproject 1 (port 3030)
|
sub2 - subproject 2 (port 8080)
|
build.gradle
|
gradle.properties
|
settings.gradle
```

## Configuration

1) First, we need to configure build.gradle in root catalog:
```groovy
plugins {
    id 'java'
    id 'org.springframework.boot' version '3.0.4'
    id 'io.spring.dependency-management' version '1.1.0'
}

group 'org.example'
version '1.0-SNAPSHOT'

repositories {
    mavenCentral()
}

dependencies {
    testImplementation 'org.junit.jupiter:junit-jupiter-api:5.8.1'
    testRuntimeOnly 'org.junit.jupiter:junit-jupiter-engine:5.8.1'

    implementation 'org.springframework.boot:spring-boot-starter-web'
    developmentOnly 'org.springframework.boot:spring-boot-devtools'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
}

tasks.register('startBoot', GradleBuild) {
    tasks = [
            ':sub1:bootRun',
            ':sub2:bootRun'
    ]
}

subprojects {
    apply plugin: 'java'

    repositories {
        mavenCentral()
    }
}

test {
    useJUnitPlatform()
}
```

2) Then, we need to add our subprojects to settings.gradle:
```groovy
rootProject.name = 'GradleMulti'
include 'sub1'
include 'sub2'
```

3) Then, we need to configure parallel work of Gradle:
* Create gradle.properties in root catalog
* Add this code in there:
```properties
org.gradle.parallel=true
```

4) And the last step is run our project:
```text
gradle startBoot
```
or you can add this command in Intelij IDEA run configs

### You can find more info below (RU):
https://zelenka.guru/threads/5082412/