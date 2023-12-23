plugins {
    id("java")
    //id("org.jetbrains.kotlin.jvm' version '1.5.21')
}

tasks.named<Jar>("jar"){
    manifest {
        attributes["Main-Class"] = "com.GPT2inferencePlugin"
    }
}
group = "org.apache.httpcomponents"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation ("org.apache.httpcomponents:httpclient:4.5.13")
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")

}

tasks.test {
    useJUnitPlatform()
}