plugins {
    id("java-library")
}

dependencies {
    // 通用模块
    api(project(":provide:common-provide"))
    api(project(":provide:player-provide"))
}