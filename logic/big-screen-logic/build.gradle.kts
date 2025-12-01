plugins {
    id("java-library")
}

dependencies {
    implementation(project(":logic:common-logic"))
    implementation(project(":provide:screen-provide"))
    implementation(project(":provide:player-provide"))
}