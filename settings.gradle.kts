rootProject.name = "netease-cloudmusic-api"
include("apis")
dependencyResolutionManagement {
    repositories {
        mavenCentral()
        mavenLocal()
        maven(url = "https://jitpack.io")
    }
}