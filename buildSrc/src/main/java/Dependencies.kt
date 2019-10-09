object Versions{

    // Build Config
    const val minSDK = 14
    const val compileSDK = 29
    const val targetSDK = 29

    // App version
    const val appVersionCode = 1
    const val appVersionName = "1.0.0"

    const val buildToolVersion = "29.0.2"

    // Plugins
    const val androidGradlePlugin = "3.5.0"

    const val kotlin = "1.3.50"
    const val compat = "1.1.0"
    const val constraint = "1.1.3"
    const val jUnit = "4.12"
    const val runner = "1.2.0"
    const val espresso = "3.2.0"
    const val lifecycle_version = "2.2.0-alpha04"
    const val kotlinCoroutine = "1.2.1"
    const val koin = "2.0.1"
    const val coil = "0.7.0"
    const val retrofit = "2.6.0"
    const val okhttp = "4.2.0"

    const val gson = "2.8.1"

    const val material = "1.1.0-alpha07"
}

object Deps{
    const val gradle = "com.android.tools.build:gradle:${Versions.androidGradlePlugin}"
    const val kotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"

    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.compat}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.compat}"
    const val constraint = "androidx.constraintlayout:constraintlayout:${Versions.constraint}"

    //test
    const val jUnit = "junit:junit:${Versions.jUnit}"
    const val runner = "androidx.test:runner:${Versions.runner}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"

    // ViewModel and LiveData
    const val lifecycleExtension = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle_version}"
    const val lifecycleViewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle_version}"
    const val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle_version}"
    const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle_version}"

    //Kotlin Coroutines
    const val coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinCoroutine}"
    const val coroutineCore =  "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCoroutine}"

    // DI
    const val koin  = "org.koin:koin-android:${Versions.koin}"
    const val koinViewModel  = "org.koin:koin-android-viewmodel:${Versions.koin}"

    //  Image Loader
    const val coil = "io.coil-kt:coil:${Versions.coil}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"

    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    const val okhttpLogging = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"

    const val gson = "com.google.code.gson:gson:${Versions.gson}"
    const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"

    const val material = "com.google.android.material:material:${Versions.material}"
}