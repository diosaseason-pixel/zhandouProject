plugins {
    id("java-library")
}

dependencies {
    // 通用模块
    api(project(":common"))
    // protobuf
    api(libs.iohao.light.jprotobuf)
}