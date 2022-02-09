plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}


buildscript {
    repositories {
        maven{ url = uri("https://maven.aliyun.com/repository/google") }
        maven{ url = uri("https://maven.aliyun.com/repository/public") }
        maven{ url = uri("https://maven.aliyun.com/repository/central") }
        maven{ url = uri("https://maven.aliyun.com/repository/gradle-plugin") }
        mavenLocal()
        mavenCentral()
        google()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.0")
    }
}

repositories {
    mavenLocal()
    mavenCentral()
    google()
}

dependencies {
    // in order to be able to use "kotlin-android" in the common script
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.0")

    // in order to recognize the "plugins" block in the common script
    implementation("com.android.tools.build:gradle:7.1.1")

    // in order to recognize the "android" block in the common script
    implementation("com.android.tools.build:gradle-api:7.1.1")
    implementation("com.squareup:javapoet:1.13.0")
}