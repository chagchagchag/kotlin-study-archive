import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.2.0"
	id("io.spring.dependency-management") version "1.1.4"
	id("org.springframework.cloud.contract") version "4.1.0-RC1"
	kotlin("jvm") version "1.9.20"
	kotlin("plugin.spring") version "1.9.20"
}

group = "com.demo.spring_cloud_contract"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
	maven { url = uri("https://repo.spring.io/milestone") }
}

extra["springCloudVersion"] = "2023.0.0-RC1"

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.cloud:spring-cloud-starter-contract-verifier")
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
	}
}

contracts {
	contractsDslDir = file("/src/test/resources/contracts")
//	packageWithBaseClasses = "com.demo.spring_cloud_contract.demo_contract_producer.contracts"
	baseClassForTests.set("com.demo.spring_cloud_contract.demo_contract_producer.contracts.EvenOddContractBaseTestClass")
//	generatedTestJavaSourcesDir.set(file("/build/generated-test-sources/contractTest/java/com.demo.spring_cloud_contract.demo_contract_producer.contracts"))
//	baseClassMappings {
//		baseClassMapping(
//			".*contracts.*",
//			"com.demo.spring_cloud_contract.demo_contract_producer.contracts.ContractBaseTestClass"
//		)
//	}
//	baseClassForTests.set("com.demo.spring_cloud_contract.demo_contract_producer.controller.ContractBaseTestClass")
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

tasks.contractTest {
	useJUnitPlatform()
}