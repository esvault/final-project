plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation ("com.fasterxml.jackson.core:jackson-core:2.10.1")
    implementation ("com.fasterxml.jackson.core:jackson-annotations:2.10.1")
    implementation ("com.fasterxml.jackson.core:jackson-databind:2.10.1")
}

tasks.test {
    useJUnitPlatform()
}