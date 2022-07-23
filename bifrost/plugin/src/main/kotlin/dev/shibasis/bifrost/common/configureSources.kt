package dev.shibasis.bifrost.common


import dev.shibasis.bifrost.android.androidCoroutines
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet
import org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler

fun KotlinSourceSet.webRequire(configure: KotlinDependencyHandler.() -> Unit = {}) {
    dependencies {
        configure()
    }
}


fun KotlinSourceSet.jvmRequire(configure: KotlinDependencyHandler.() -> Unit = {}) {
    dependencies {
        configure()
    }
}



fun KotlinSourceSet.androidRequire(configure: KotlinDependencyHandler.() -> Unit = {}) {
    dependencies {
        androidKoin()
        androidCoroutines()
        configure()
    }
}

fun KotlinSourceSet.commonRequire(configure: KotlinDependencyHandler.() -> Unit = {}) {
    dependencies {
        commonKoin()
        configure()
    }
}


fun KotlinSourceSet.testRequire(configure: KotlinDependencyHandler.() -> Unit = {}) {
    dependencies {
        implementation(kotlin("test"))
        configure()
    }
}
