plugins {
    id("java-library")
}

dependencies {
    // 通用模块
    api(project(":logic:common-logic"))
    // 登录
    api(project(":logic:login-logic"))
    // 玩家
    api(project(":logic:player-logic"))
    // 大地图
    api(project(":logic:big-screen-logic"))
    // 活动
    api(project(":logic:activity-logic"))
}