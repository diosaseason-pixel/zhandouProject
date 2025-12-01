dependencies {
    // 通用模块
    implementation(project(":common"))
    // DTO、POJO、业务数据载体等
    implementation(project(":provide:all-provide"))
    // ioGame对外服
    implementation(libs.iohao.external.netty)
}