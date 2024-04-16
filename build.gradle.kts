import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
}

allprojects {
    tasks.withType<KotlinCompile>().configureEach {
        compilerOptions {
            val arguments = mutableListOf<String>()
            // https://kotlinlang.org/docs/compiler-reference.html#progressive
            arguments += "-progressive"
            // Generate smaller bytecode by not generating runtime not-null assertions.
            arguments += "-Xno-call-assertions"
            arguments += "-Xno-param-assertions"
            arguments += "-Xno-receiver-assertions"
            arguments += "-Xexpect-actual-classes"
            arguments += "-opt-in=kotlin.RequiresOptIn"
            arguments += "-opt-in=kotlin.ExperimentalStdlibApi"
            freeCompilerArgs.addAll(arguments)
        }
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_11.toString()
        }
    }
}