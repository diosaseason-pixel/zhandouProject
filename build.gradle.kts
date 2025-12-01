buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath(libs.proguard.gradle)
    }
}

plugins {
    id("java")
    id("idea")
    id("maven-publish")
    id("version-catalog")
    alias(libs.plugins.springboot) apply false
    alias(libs.plugins.spring.dependency.management) apply false
    alias(libs.plugins.lombok)
//    id("com.guardsquare.proguard") version "7.6.1" apply false
}

subprojects {
    group = "com.game"
    version = "1.0-SNAPSHOT"

    apply {
        plugin("java")
        plugin("idea")
        plugin("org.springframework.boot")
        plugin("io.spring.dependency-management")
    }

    java {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    dependencies {
        // 测试工具
        testImplementation(platform(rootProject.libs.junit.bom))
        testImplementation(rootProject.libs.junit.jupiter)
        testImplementation(rootProject.libs.spring.boot.starter.test)

        // lombok
        compileOnly(rootProject.libs.lombok)
        annotationProcessor(rootProject.libs.lombok)
        testCompileOnly(rootProject.libs.lombok)
        testAnnotationProcessor(rootProject.libs.lombok)

        // mapstruct
        implementation(rootProject.libs.mapstruct)
        annotationProcessor(rootProject.libs.mapstruct.processor)

        // lombok-mapstruct-binding
        annotationProcessor(rootProject.libs.lombok.mapstruct.binding)
    }

    tasks.test {
        useJUnitPlatform()
    }

    if (name.endsWith("provide")) {
        apply(plugin = "maven-publish")
        publishing {
            publications {
                create<MavenPublication>("mavenJava") {
                    from(components["java"])
                }
            }
            repositories {
                maven {
                    url = uri("../maven-repo")
                }
            }
        }
    }

}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

// 配置运行任务的编码
tasks.withType<JavaExec> {
    jvmArgs = listOf(
        "-Dfile.encoding=UTF-8",
        "-Dconsole.encoding=UTF-8",
        "-Duser.language=zh",
        "-Duser.country=CN"
    )
}

// 配置测试任务的编码
tasks.withType<Test> {
    jvmArgs = listOf(
        "-Dfile.encoding=UTF-8",
        "-Dconsole.encoding=UTF-8",
        "-Duser.language=zh",
        "-Duser.country=CN"
    )
}

// cleanJar
tasks.register("cleanJar", Delete::class) {
    delete("build/libs/*.jar")
}