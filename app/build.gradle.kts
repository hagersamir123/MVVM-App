plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "com.example.retrofitapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.retrofitapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.room.common)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)


    //Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.6.2")
    implementation ("com.google.code.gson:gson:2.8.6")
    implementation ("com.squareup.retrofit2:converter-gson:2.6.2")
    implementation ("com.squareup.okhttp3:logging-interceptor:3.12.0")

    //Coroutines
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.4.0")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.0")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.2")

    //Glide
    implementation ("com.github.bumptech.glide:glide:4.12.0")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.12.0")
    val lifecycle_version = "2.4.3"
    val activity_version = "1.2.2"

    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    implementation ("androidx.activity:activity-ktx:$activity_version")


    val room_version = "2.5.0"
    implementation ("androidx.room:room-runtime:$room_version")
    implementation ("androidx.room:room-rxjava2:$room_version")
    implementation ("androidx.room:room-guava:$room_version")
    testImplementation ("androidx.room:room-testing:$room_version")
    implementation ("androidx.room:room-ktx:2.2.6")
}