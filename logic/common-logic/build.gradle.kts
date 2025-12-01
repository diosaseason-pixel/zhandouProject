plugins {
    id("java-library")
}

dependencies {
    // 通用模块
    api(project(":common"))
    api(project(":provide:common-provide"))

    // 逻辑服
    api(libs.iohao.bolt.client)

    // 房间
    api(libs.iohao.light.game.room)
}