# androidversions
---
这是一个安卓项目依赖库版本的汇总，包含了项目使用的库及其版本。可以只用它作为一个项目的子模块，通过配置来统一管理所有的库依赖。

2017.10.19 根据谷歌的[sample项目](https://github.com/googlesamples/android-architecture-components)重新修改，配置更加集中

### 配置步骤
* 将这个项目添加为子项目（我一般会把它命名为dependencies）
 ```shell
 git submodule add git@github.com:ggggxiaolong/androidversions.git dependencies
 //或者直接在项目中使用
 apply from: "https://raw.github.com/ggggxiaolong/androidversions/master/versions.gradle"
 ```
* 修改主项目根目录下的build.gradle文件，在第一行添加下面的代码（注意子模块的名称）
```groovy
...
buildscript {
  apply from: "dependencies/versions.gradle"
  addRepos(repositories)
  dependencies {
    classpath deps.android_gradle_plugin
    classpath deps.grgit
    //检查版本更新  ./gradlew dependencyUpdates -Drevision=release
    classpath deps.lib_versions
    classpath deps.kotlin.plugin
    classpath deps.kotlin.android_extensions
  }
}
...
```

一个完整的build文件示例

```groovy
//项目地址  https://github.com/ggggxiaolong/Hencode
apply plugin: 'com.github.ben-manes.versions'
import org.ajoberstar.grgit.Grgit

buildscript {
  apply from: "dependencies/versions.gradle"

  addRepos(repositories)
  dependencies {
    classpath deps.android_gradle_plugin
    classpath deps.grgit
    //检查版本更新  ./gradlew dependencyUpdates -Drevision=release
    classpath deps.lib_versions
    classpath deps.kotlin.plugin
    classpath deps.kotlin.android_extensions
  }
}

allprojects {
  def git = Grgit.open(currentDir: projectDir)
  addGitVersion(git.describe(), git.tag.list().size())

  addRepos(repositories)
}

subprojects {
  def isAppModule = isModule.toBoolean() || it.name.equals("app")
  def dataBindingModules = ["app"]
  //使用dataBinding的模块
  def enableDataBinding = dataBindingModules.contains(it.name)

  apply plugin: isAppModule ? 'com.android.application' : 'com.android.library'

  apply plugin: 'kotlin-android'
  apply plugin: 'kotlin-android-extensions' // 拓展

  apply plugin: 'kotlin-kapt'

  android {
    compileSdkVersion build_versions.compile_sdk
    buildToolsVersion build_versions.build_tools
    defaultConfig {
      applicationId "com.mrtan.hencode"
      minSdkVersion build_versions.min_sdk
      targetSdkVersion build_versions.target_sdk

      versionCode build_versions.androidVersionCode
      versionName build_versions.androidVersionName
      testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
      multiDexEnabled true
      vectorDrawables.useSupportLibrary = true //drawable支持

      //arouter
      //      javaCompileOptions {
      //        annotationProcessorOptions {
      //          arguments = [ moduleName : project.getName() ]
      //        }
      //      }
    }
    buildTypes {
      debug {
        proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules-debug.pro'
        minifyEnabled true
        zipAlignEnabled true
        jniDebuggable true
      }
      release {
        minifyEnabled true
        proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
      }
    }

    //    flavorDimensions "mode"
    //    productFlavors {
    //      dev {
    //        applicationIdSuffix ".dev"
    //      }
    //      prod {
    //      }
    //    }

    compileOptions {
      sourceCompatibility JavaVersion.VERSION_1_8
      targetCompatibility JavaVersion.VERSION_1_8
    }

    if (enableDataBinding) {
      dataBinding {
        enabled true
      }
    }
  }

  dependencies {
    implementation deps.kotlin.stdlib

    implementation deps.rxjava2
    implementation deps.rx_android
    debugImplementation deps.leackCanary
  }
}

task clean(type: Delete) {
  delete rootProject.buildDir
}
```

* 在子模块中配置

```groovy
dependencies {
  implementation deps.support.app_compat
  implementation deps.support.design
  implementation deps.support.constraint_layout
  testImplementation deps.junit
  androidTestImplementation deps.atsl.runner
  androidTestImplementation deps.espresso.core
}
```
* 示例项目   https://github.com/ggggxiaolong/Hencode