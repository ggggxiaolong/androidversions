import com.mrtan.buildsrc.configurations.ProjectConfigs

plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    compileSdk = ProjectConfigs.compileSdkVersion

    defaultConfig {
        minSdk = ProjectConfigs.minSdkVersion
        targetSdk = ProjectConfigs.targetSdkVersion
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = ProjectConfigs.kotlinCompileExtensionVersion
    }
}
