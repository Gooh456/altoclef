pluginManagement {
    repositories {
        maven("https://maven.fabricmc.net")
        mavenCentral()
        gradlePluginPortal()
        maven("https://jitpack.io")
    }
    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "com.replaymod.preprocess" -> {
                    useModule("com.github.replaymod:preprocessor:${requested.version}")
                }
            }
        }
    }
}


rootProject.name = "altoclef"
rootProject.buildFileName = "root.gradle.kts"

val versions = mutableListOf(
    "1.21.1",
    "1.21",
    "1.20.6",
    "1.20.5",
    "1.20.4",
    "1.20.2",
    "1.20.1",
    "1.19.4",
    "1.18.2",
    "1.18",
    "1.17.1",
    "1.16.5"
)

// 1.21.11's Baritone isn't published yet, so only wire in that target once you've built it
// yourself and dropped the jar in versions/baritone/dist/ - see the README. Without it, this
// project simply doesn't exist and every other version builds exactly as it did before.
if (file("versions/baritone/dist/baritone-unoptimized-fabric-1.21.11.jar").exists()) {
    versions.add(0, "1.21.11")
}

versions.forEach { version ->
    include(":$version")
    project(":$version").apply {
        projectDir = file("versions/$version")
        buildFileName = "../../build.gradle"
        name = version
    }
}