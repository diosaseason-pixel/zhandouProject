plugins {
    id("java-library")
}

dependencies {
    // 通用模块
    api(project(":provide:common-provide"))
    // 场景
    api(project(":provide:screen-provide"))
}