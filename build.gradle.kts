plugins {
    java
    id("org.springframework.boot") version "3.0.3"
    id("io.spring.dependency-management") version "1.1.0"
}

group = "com.xiaolin"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
    // Jpa, you can also use Mybatis
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    // web-starter, start a web application
    implementation("org.springframework.boot:spring-boot-starter-web")
    // mysql, make sure your mysql server version is 8.x
    implementation("mysql:mysql-connector-java:8.0.31")
    // hot start
    implementation("org.springframework.boot:spring-boot-devtools")
    // Restful Api
    implementation("org.springframework.boot:spring-boot-starter-hateoas")
    // logger
    implementation("org.springframework.boot:spring-boot-starter-logging")
    // FileUtils tools
    implementation("commons-io:commons-io:2.11.0")

    // Enable SwaggerUI, springdoc and springfox are available, select one.
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.0.2")
    // json web token
    implementation ("io.jsonwebtoken:jjwt:0.9.1")
    // Spring Security
    implementation ("org.springframework.boot:spring-boot-starter-security")

    implementation ("org.springframework.boot:spring-boot-configuration-processor")

    // lombok configuration
    implementation("org.projectlombok:lombok:1.18.22")
    testImplementation("junit:junit:4.13.1")
    annotationProcessor("org.projectlombok:lombok:1.18.22")

    // Add the library to the list of your project dependencies.
//    implementation("org.springdoc:springdoc-openapi-webmvc-core:1.6.14")

    // validation
    implementation("org.springframework.boot:spring-boot-starter-validation")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
