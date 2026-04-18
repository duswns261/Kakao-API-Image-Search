import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.cret.kakaoimagesearch"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.cret.kakaoimagesearch"
        minSdk = 26
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        val properties = Properties()
        val propertiesFile = rootProject.file("apikey.properties")

        if (propertiesFile.exists()) {
            properties.load(propertiesFile.inputStream())
        }
        val kakao_api_key = properties.getProperty("kakao_api_key") ?: ""
        // 매니페스트 플레이스홀더 설정
        manifestPlaceholders["KAKAO_API_KEY"] = kakao_api_key
        // 코드 상에서 local.properties 변수 사용
        buildConfigField("String", "KAKAO_API_KEY", kakao_api_key)
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    val retrofit_version = "3.0.0"
    implementation("com.squareup.retrofit2:retrofit:${retrofit_version}")
    implementation("com.squareup.retrofit2:converter-gson:${retrofit_version}")

    implementation("com.github.bumptech.glide:glide:5.0.5")
}