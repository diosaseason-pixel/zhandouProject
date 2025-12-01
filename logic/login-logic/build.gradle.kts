plugins {
    id("java-library")
}

dependencies {
    implementation(project(":logic:common-logic"))

    implementation(project(":provide:login-provide"))
    implementation(project(":provide:player-provide"))
}