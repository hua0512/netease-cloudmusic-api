import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion.KOTLIN_2_0

plugins {
  alias(libs.plugins.kotlinMultiplatform)
  alias(libs.plugins.androidLibrary)
  alias(libs.plugins.kotlin.serialization)
}

group = "github.hua0512.ncm"
version = "0.1.0-SNAPSHOT"

val targetJvmVersion = JvmTarget.JVM_11

kotlin {
  // JVM
  jvm()

  // Android
  androidTarget {
    compilations.all {
      kotlinOptions.jvmTarget = targetJvmVersion.target
    }
    publishLibraryVariants("release", "debug")
  }

  // iOS
  val iosTargets = listOf(iosX64(), iosArm64(), iosSimulatorArm64())
  iosTargets.forEach { iosTarget ->
    iosTarget.binaries.framework {
      baseName = "Shared"
      isStatic = true
    }
  }

  sourceSets {
    commonMain.dependencies {
      implementation(libs.io.ktor.client.core)
      implementation(libs.io.ktor.serialization.kotlinx.json)
      implementation(libs.io.ktor.client.logging)
      implementation(libs.org.jetbrains.kotlinx.datetime)
      implementation(libs.org.jetbrains.kotlinx.serialization.json)
      implementation(libs.org.jetbrains.kotlinx.coroutines.core)
      implementation(libs.dev.whyoleg.cryptography.core)
      implementation(libs.io.exoquery.pprint.kmp)
    }
    commonTest.dependencies {
      implementation(libs.bundles.test.jvm)
    }
    jvmMain.dependencies {
      implementation(libs.dev.whyoleg.cryptography.provider.jdk)
      implementation(libs.io.ktor.client.okhttp)
    }
    androidMain.dependencies {
      implementation(libs.io.ktor.client.okhttp)
      implementation(libs.org.jetbrains.kotlinx.coroutines.android)
      implementation(libs.dev.whyoleg.cryptography.provider.jdk)
    }
    appleMain.dependencies {
      implementation(libs.io.ktor.client.darwin)
      implementation(libs.dev.whyoleg.cryptography.provider.apple)
    }
  }
}

android {
  namespace = "github.hua0512.ncm.apis"
  compileSdk = libs.versions.android.compileSdk.get().toInt()
  compileOptions {
    sourceCompatibility = JavaVersion.toVersion(targetJvmVersion.target)
    targetCompatibility = JavaVersion.toVersion(targetJvmVersion.target)
  }
  defaultConfig {
    minSdk = libs.versions.android.minSdk.get().toInt()
  }
}

kotlin {
  @OptIn(ExperimentalKotlinGradlePluginApi::class)
  compilerOptions {
    optIn.addAll(
      "kotlin.RequiresOptIn",
      "kotlin.ExperimentalStdlibApi",
      "kotlinx.serialization.ExperimentalSerialization",
      "kotlinx.coroutines.ExperimentalCoroutinesApi",
    )
    freeCompilerArgs.addAll(
      "-Xexpect-actual-classes",
      "-Xno-call-assertions",
      "-Xno-param-assertions",
      "-Xno-receiver-assertions",
    )
    progressiveMode = true
    apiVersion.set(KOTLIN_2_0)
    jvmToolchain(targetJvmVersion.target.toInt())
  }
}