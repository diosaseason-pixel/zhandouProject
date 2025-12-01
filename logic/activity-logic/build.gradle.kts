plugins {
    id("java-library")
}

dependencies {
    implementation(project(":logic:common-logic"))
    implementation(project(":provide:activity-provide"))
    implementation(project(":provide:player-provide"))
}