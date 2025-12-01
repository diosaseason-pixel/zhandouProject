plugins {
    id("java-library")
}


dependencies {
    // 通用模块
    api(project(":provide:common-provide"))
    // 登录
    api(project(":provide:login-provide"))
    // 玩家
    api(project(":provide:player-provide"))
    // 场景
    api(project(":provide:screen-provide"))
    // 活动
    api(project(":provide:activity-provide"))
}