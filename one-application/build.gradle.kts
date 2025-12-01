import proguard.gradle.ProGuardTask

dependencies {
    // 通用模块
    implementation(project(":common"))
    // 对外服
    implementation(project(":external"))
    // broker
    implementation(project(":broker"))
    // DTO、POJO、业务数据载体等
    implementation(project(":provide:all-provide"))
    // 逻辑服
    implementation(project(":logic:all-logic"))

    // SpringBoot 启动器
    implementation(libs.spring.boot.starter)
    // 单体服务
    implementation(libs.iohao.run.one.netty)

    implementation(libs.spring.boot.starter.actuator)
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

// 配置 Spring Boot bootRun 任务的编码
tasks.named("bootRun") {
    (this as JavaExec).jvmArgs = listOf(
        "-Dfile.encoding=UTF-8",
        "-Dconsole.encoding=UTF-8",
        "-Duser.language=zh",
        "-Duser.country=CN"
    )
}