import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.1.5"
	id("io.spring.dependency-management") version "1.1.3"
	id("org.asciidoctor.jvm.convert") version "3.3.2"
	id("com.google.cloud.tools.jib") version "3.4.0"
	kotlin("jvm") version "1.8.22"
	kotlin("plugin.spring") version "1.8.22"
}

group = "com.example"
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

tasks.bootBuildImage {
	builder.set("paketobuildpacks/builder-jammy-base:latest")
}

jib {
	val profile : String = project.findProperty("env") as? String ?: "local"

	// from {} : 애플리케이션을 빌드할 base 이미지
	from {
		image = "amazoncorretto:17"

		// M1 Mac을 사용할 경우 아래 내용을 추가.
//		platforms {
//			platform {
//				architecture = "arm64"
//				os = "linux"
//			}
//		}
	}

	// to {} : 애플리케이션을 빌드할 Target 이미지
	to {
		// 이미지 명 (도커 이미지 명에는 대문자 사용이 불가능하기에 소문자로 지정)
//		image = "chagchagchag/${project.name}-${project.version.toString().lowercase()}"
		image = "chagchagchag/kotlin-jib-example"
		// image tag 는 여러개 지정 가능하다.
		tags = setOf("latest")
	}

	// container{} 빌드된 이미지에서 실행되는 컨테이너
	container{
		creationTime = "USE_CURRENT_TIMESTAMP"

		// jvm 옵션
		jvmFlags = listOf(
			"-Dspring.profiles.active=local",
			"-XX:+UseContainerSupport",
			"-Dserver.port=8080",
			"-Dfile.encoding=UTF-8",
		)

		// 컨테이너 입장에서 외부로 노출할 포트
		ports = listOf("8080")

		labels = mapOf(
			"maintainer" to "chagachagchag.dev@gmail.com"
		)
	}

	// extraDirectories {} : 이미지에 임의의 파일을 추가하는 데 사용되는 디렉터리를 구성
	extraDirectories{

	}
}