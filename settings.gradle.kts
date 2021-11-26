rootProject.name = "Real World Compose Rest"
rootProject.buildFileName = "build.gradle.kts"

include(":app")
include(":feature_articles")
include(":library_core")
include(":library_test")

enableFeaturePreview("VERSION_CATALOGS")
enableFeaturePreview("ONE_LOCKFILE_PER_PROJECT")

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }

    plugins {
        val agpVersion: String by settings
        id("com.android.application") version agpVersion
        id("com.android.library") version agpVersion
        id("com.android.dynamic-feature") version agpVersion

        val kotlinVersion: String by settings
        id("org.jetbrains.kotlin.jvm") version kotlinVersion
        id("org.jetbrains.kotlin.android") version kotlinVersion
        id("org.jetbrains.kotlin.kapt") version kotlinVersion
        id("org.jetbrains.kotlin.plugin.parcelize") version kotlinVersion
        id("org.jetbrains.kotlin.plugin.serialization") version kotlinVersion

        val detektVersion: String by settings
        id("io.gitlab.arturbosch.detekt") version detektVersion

        val ktlintGradleVersion: String by settings
        id("org.jlleitschuh.gradle.ktlint") version ktlintGradleVersion

        val koverVersion: String by settings
        id("org.jetbrains.kotlinx.kover") version koverVersion

        val androidJUnit5Version: String by settings
        id("de.mannodermaus.android-junit5") version androidJUnit5Version
    }

    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "com.android.application",
                "com.android.library",
                "com.android.dynamic-feature" -> {
                    val agpCoordinates: String by settings
                    useModule(agpCoordinates)
                }
                "de.mannodermaus.android-junit5" -> {
                    val androidJUnit5Coordinates: String by settings
                    useModule(androidJUnit5Coordinates)
                }
            }
        }
    }
}

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)

    repositories {
        google()
        mavenCentral()
    }
}
