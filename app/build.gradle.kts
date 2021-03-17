plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs.kotlin")
    id("com.google.secrets_gradle_plugin") version "0.5"
}

android {
    compileSdkVersion(Dependencies.Apps.compileSdk)
    buildToolsVersion(Dependencies.Apps.buildTools)

    defaultConfig {
        applicationId = "com.eniro.netgururecruitment"
        minSdkVersion(Dependencies.Apps.minSdk)
        targetSdkVersion(Dependencies.Apps.targetSdk)
        versionCode = Dependencies.Apps.versionCode
        versionName = Dependencies.Apps.versionName
        vectorDrawables.useSupportLibrary = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Dependencies.Libs.kotlin)
    implementation(Dependencies.Libs.coreKtx)
    implementation(Dependencies.Libs.appcompat)
    implementation(Dependencies.Libs.constraintLayout)
    implementation(Dependencies.Libs.navigationFragment)
    implementation(Dependencies.Libs.navigationUi)
    implementation(Dependencies.Libs.hilt)
    implementation(Dependencies.Libs.hiltViewModel)
    implementation(Dependencies.Libs.rxAndroid)
    implementation(Dependencies.Libs.rxKotlin)
    implementation(Dependencies.Libs.material)
    implementation(Dependencies.Libs.maps)

    kapt(Dependencies.Libs.androidxHiltCompiler)
    kapt(Dependencies.Libs.hiltCompiler)

    testImplementation(Dependencies.TestLibs.junit)

    androidTestImplementation(Dependencies.AndroidTestLibs.junit)
    androidTestImplementation(Dependencies.AndroidTestLibs.espressoCore)

}