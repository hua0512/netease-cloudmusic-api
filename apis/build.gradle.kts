plugins {
  alias(libs.plugins.kotlinMultiplatform)
  alias(libs.plugins.androidLibrary)
  alias(libs.plugins.kotlin.serialization)
}

group = "github.hua0512.ncm"
version = "0.1.0-SNAPSHOT"

kotlin {
  // JVM
  jvm()

  // Android
  androidTarget {
    compilations.all {
      kotlinOptions.jvmTarget = "11"
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
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
  }
  defaultConfig {
    minSdk = libs.versions.android.minSdk.get().toInt()
  }
}
