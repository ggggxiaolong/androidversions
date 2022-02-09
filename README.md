# buildSrc
---
这是一个安卓项目依赖库版本的汇总，包含了项目使用的库及其版本。可以只用它作为一个项目的子模块，通过配置来统一管理所有的库依赖。

2022.02.09 参考[ComposeCookBook项目](https://github.com/Gurupreet/ComposeCookBook),  额外添加了2个签名文件

### 配置步骤
* 将这个项目添加为子项目
 ```shell
 git submodule add git@github.com:ggggxiaolong/androidversions.git buildSrc
 ```
* Application目录下的build.gradle.kts文件
```kotlin
import com.mrtan.buildsrc.configurations.ProjectConfigs
import com.mrtan.buildsrc.dependencies.Dependencies
import com.mrtan.buildsrc.dependencies.addAndroidInstrumentationTestsDependencies
import com.mrtan.buildsrc.dependencies.addJunit5TestDependencies
import com.mrtan.buildsrc.dependencies.addThirdPartyUnitTestsDependencies
...
dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to "*.aar")))
    implementation(Dependencies.appCompat)
    implementation(Dependencies.constraintLayout)
    implementation(Dependencies.recyclerView)
    implementation(Dependencies.swiperefreshlayout)
    implementation(Dependencies.googleMaterial)
...
```

* 签名文件使用

```kotlin
...  
signingConfigs {
        getByName("debug") {
          storeFile = file("../buildSrc/debug.jks")
          storePassword = "VJP94nzjim"
          keyAlias = "android"
          keyPassword = "6RHrfH6uir"
        }
        create("release") {
          storeFile = file("../buildSrc/debug.jks")
          storePassword = "aP47WmCS"
          keyAlias = "front"
          keyPassword = "p6yKpqBV"
        }
    }
...
```



* Library目录下的build.gradle.kts文件

```kotlin
import com.mrtan.buildsrc.configurations.ProjectConfigs
import com.mrtan.buildsrc.dependencies.Dependencies
plugins {
    id("common-kotlin-module-configs-script-plugin")
}
dependencies {
    implementation(Dependencies.appCompat)
    implementation(Dependencies.googleMaterial)
}
```

common-kotlin-module-configs-script-plugin 插件的包含如小

```kotlin
import com.mrtan.buildsrc.configurations.ProjectConfigs

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    compileSdk = ProjectConfigs.compileSdkVersion

    defaultConfig{
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
}
```

common-compose-module-configs-script-plugin 插件包含如下

```kotlin
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

```

