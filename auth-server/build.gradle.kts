import proguard.gradle.ProGuardTask

dependencies {
    // SpringBoot 启动器
    implementation(libs.spring.boot.starter.web)
    // thymeleaf 模板
    implementation(libs.spring.boot.starter.thymeleaf)
    // redis
    implementation(libs.spring.boot.starter.data.redis)
    // mangodb
    implementation(libs.spring.boot.starter.data.mongodb)
    // utils
    implementation(libs.hutool)
    
    // JWT 依赖
    implementation("io.jsonwebtoken:jjwt-api:0.11.5")
    runtimeOnly("io.jsonwebtoken:jjwt-impl:0.11.5")
    runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.11.5")
}