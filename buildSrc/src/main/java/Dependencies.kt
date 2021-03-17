object Dependencies {
    object Apps {
        const val compileSdk = 30
        const val minSdk = 21
        const val targetSdk = 30
        const val versionCode = 1
        const val versionName = "1.0.0"
        const val buildTools = "30.0.1"
    }

    object Versions {
        const val gradle = "4.1.1"
        const val kotlin = "1.4.31"
        const val playServicesGradle = "4.3.5"

        const val appcompat = "1.2.0"
        const val coreKtx = "1.3.2"
        const val constraintLayout = "2.0.2"
        const val navigationKtx = "2.1.0"
        const val hilt = "2.33-beta"
        const val androidxHilt = "1.0.0-alpha03"
        const val rxKotlin = "2.3.0"
        const val rxAndroid = "2.1.1"
        const val material = "1.3.0"
        const val maps = "17.0.0"

        /* test */
        const val junit = "4.12"

        /* android test */
        const val androidxJunit = "1.1.2"
        const val espressoCore = "3.3.0"
    }

    object Libs {
        const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
        const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
        const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
        const val material = "com.google.android.material:material:${Versions.material}"

        const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigationKtx}"
        const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigationKtx}"

        const val rxKotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.rxKotlin}"
        const val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroid}"

        const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
        const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
        const val hiltViewModel = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.androidxHilt}"
        const val androidxHiltCompiler = "androidx.hilt:hilt-compiler:${Versions.androidxHilt}"
        const val maps = "com.google.android.gms:play-services-maps:${Versions.maps}"
    }

    object TestLibs {
        const val junit = "junit:junit:${Versions.junit}"
    }

    object AndroidTestLibs {
        const val junit = "androidx.test.ext:junit:${Versions.androidxJunit}"
        const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    }
}