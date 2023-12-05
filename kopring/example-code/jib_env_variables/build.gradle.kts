import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.2.0"
	id("io.spring.dependency-management") version "1.1.4"
	kotlin("jvm") version "1.9.20"
	kotlin("plugin.spring") version "1.9.20"
	id("com.google.cloud.tools.jib") version "3.4.0"
}

group = "com.example.jib"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

jib{
//	val profile : String = System.getProperty("DOCKER_SPRING_PROFILES_ACTIVE") as? String ?: "local"
	val envProfile : String = System.getenv("DOCKER_SPRING_PROFILES_ACTIVE") as? String ?: "local"

	from {
		image = "amazoncorretto:17"
	}
	to {
		image = "chagchagchag/foobar-jib-env-variables-demo"
		tags = setOf("latest")
	}
	container {
		creationTime = "USE_CURRENT_TIMESTAMP"

		environment = mapOf(

		)

		// jvm 옵션
		jvmFlags = listOf(
			"-Dspring.profiles.active=${envProfile}",
			"-XX:+UseContainerSupport",
//            "-XX:+UseG1GC",
//            "-verbose:gc",
//            "-XX:+PrintGCDetails",
			"-Dserver.port=8080",
			"-Dfile.encoding=UTF-8",
		)

		// 컨테이너 입장에서 외부로 노출할 포트
		ports = listOf("8080")

		labels = mapOf(
			"maintainer" to "chagachagchag.dev@gmail.com"
		)
	}
}
