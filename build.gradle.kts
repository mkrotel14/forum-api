plugins {
	alias(libs.plugins.kotlin.jvm)
	alias(libs.plugins.kotlin.spring)
	alias(libs.plugins.spring.boot)
	alias(libs.plugins.spring.dependency)
	alias(libs.plugins.kotlin.jpa)
}

group = "br.com.mkrotel"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation(libs.spring.boot.data.jpa)
	implementation(libs.spring.boot.validation)
	implementation(libs.spring.boot.web)
	implementation(libs.h2.database)
	implementation(libs.flyway.core)
	implementation(libs.jackson.kotlin)
	implementation(libs.kotlin.reflect)
	implementation(libs.kotlin.coroutine)
	implementation(libs.kotlin.stdlib.jdk8)

	developmentOnly(libs.spring.boot.devtools)
	testImplementation(libs.spring.boot.test)
	testImplementation(libs.kotlin.test.junit5)
	testRuntimeOnly(libs.junit.platform)
}

kotlin {
	jvmToolchain(21)
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

allOpen {
	annotation("jakarta.persistence.Entity")
	annotation("jakarta.persistence.MappedSuperclass")
	annotation("jakarta.persistence.Embeddable")
}

noArg {
	annotation("jakarta.persistence.Entity")
	annotation("jakarta.persistence.MappedSuperclass")
	annotation("jakarta.persistence.Embeddable")
}
