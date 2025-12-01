plugins {
    id("java-library")
}

dependencies {
    // mangodb
    api(libs.spring.boot.starter.data.mongodb)
    api(libs.jetbrains.annotations)
    api(libs.iohao.bolt.core)

    api(libs.spring.boot.starter.data.redis)

    // 领域事件
    api(libs.iohao.light.domain.event)

    // erlang
    api(libs.erlang.jinterface)

    // gson
    api(libs.gson)

    // guava
    api(libs.guava)

    // hutool
    api(libs.hutool)

    // reflections 反射工具
    api(libs.reflections)

    // common-lang
    api(libs.commons.lang3)

    // com.alibaba.easyexcel 读写excel
    api(libs.easyexcel)
}