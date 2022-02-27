import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask

// Top-level build file where you can add configuration options common to all sub-projects/modules.

plugins {
    alias(libs.plugins.benmanesversions)
    alias(libs.plugins.versioncatalogupdate)
}

tasks.create<Delete>("clean") {
    group = "build"
    delete = setOf(
        rootProject.buildDir
    )
}

tasks.withType<DependencyUpdatesTask> {
    val alpha = ".*-alpha.*".toRegex()
    val beta = ".*-beta.*".toRegex()
    rejectVersionIf {
        (candidate.version.matches(alpha) && !(currentVersion.matches(alpha)) ||
                (candidate.version.matches(beta) &&
                        !(currentVersion.matches(alpha) || currentVersion.matches(beta)
                                )
                        )
                )
    }
}

versionCatalogUpdate {
    keep {
        keepUnusedVersions.set(true)
    }
}