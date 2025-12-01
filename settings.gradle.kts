dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven("https://maven.aliyun.com/repository/central")
        maven("https://maven.aliyun.com/repository/public")
        maven("https://maven.aliyun.com/repository/gradle-plugin")
        maven("https://jitpack.io")
        google()
        mavenCentral()
        mavenLocal()
    }
}

rootProject.name = "zmxs"

include(":auth-server")

include(":common")
include(":one-application")
include(":external")
include(":broker")

include(":provide:all-provide")
include(":provide:common-provide")
include(":provide:login-provide")
include(":provide:player-provide")
include(":provide:screen-provide")
include(":provide:activity-provide")

include(":logic:all-logic")
include(":logic:common-logic")
include(":logic:login-logic")
include(":logic:player-logic")
include(":logic:big-screen-logic")
include(":logic:activity-logic")
include("logic:battle-logic")
findProject(":logic:battle-logic")?.name = "battle-logic"
