# androidversions
---
这是一个安卓项目依赖库版本的汇总，包含了项目使用的库及其版本。可以只用它作为一个项目的子模块，通过配置来统一管理所有的库依赖。

2017.10.19 根据谷歌的[sample项目](https://github.com/googlesamples/android-architecture-components)重新修改，配置更加集中

### 配置步骤
* 将这个项目添加为子项目（我一般会把它命名为dependencies）
 ```shell
 git submodule add git@github.com:ggggxiaolong/androidversions.git dependencies
 ```
* 修改主项目根目录下的build.gradle文件
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

项目根路径完整build文件

```groovy
//项目地址  https://github.com/ggggxiaolong/exampleProject
apply plugin: 'com.github.ben-manes.versions'
import org.ajoberstar.grgit.Grgit

buildscript {
  apply from: "dependencies/versions.gradle"

  addRepos(repositories)
  dependencies {
    classpath deps.android_gradle_plugin
    classpath deps.kotlin.plugin
    classpath deps.grgit
    //检查版本更新  ./gradlew dependencyUpdates -Drevision=release
    classpath deps.lib_versions
    classpath deps.kotlin.android_extensions
  }
}

allprojects {
  def git = Grgit.open(currentDir: projectDir)
  addGitVersion(git.describe(), git.tag.list().size())

  addRepos(repositories)
}

subprojects {
  def isModule = false
  def isAppModule = isModule || it.name.equals("app")
  def dataBindingModules = ["app"]
  //使用dataBinding的模块
  def enableDataBinding = dataBindingModules.contains(it.name)

  apply plugin: isAppModule ? 'com.android.application' : 'com.android.library'

  apply plugin: 'kotlin-android'
  apply plugin: 'kotlin-android-extensions' // 拓展

  apply plugin: 'kotlin-kapt'

  android {
    compileSdkVersion build_versions.compile_sdk
    defaultConfig {
      if(isAppModule) applicationId "com.mrtan.demo" //这里改成项目id
      minSdkVersion build_versions.min_sdk
      targetSdkVersion build_versions.target_sdk

      versionCode build_versions.androidVersionCode
      versionName build_versions.androidVersionName
      testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
      multiDexEnabled true
      vectorDrawables.useSupportLibrary = true //drawable支持
    }

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


android {
  buildTypes {
    debug {
      proguardFiles getDefaultProguardFile('proguard-android.txt'), '../dependencies/proguard-rules-debug.pro'
      minifyEnabled true
      zipAlignEnabled true
      jniDebuggable true
    }
    release {
      debuggable false
      postprocessing {
        removeUnusedCode true
        removeUnusedResources true
        obfuscate true
        optimizeCode true
        proguardFile 'proguard-rules.pro'
      }
      signingConfig signingConfigs.release
    }
  }
}

dependencies {
  kapt deps.dagger.compiler
  kapt deps.glide.compile

  implementation project(':common')
  implementation deps.support.constraint_layout
  implementation deps.support.app_compat
  implementation deps.support.design
  implementation deps.dagger.runtime
  implementation deps.timber
  implementation deps.glide.runtime
  implementation deps.glide.okHttp3
  implementation deps.glide.recyclerView
  implementation deps.arrow
  androidTestImplementation deps.atsl.runner
  testImplementation deps.junit
  testImplementation deps.mockito.core
  testImplementation deps.roboletric
  debugImplementation deps.leackCanary
}
```
* 示例项目   https://github.com/ggggxiaolong/exampleProject

### 发布项目

1. 项目根`build.gradle`添加依赖

```groovy
buildscript {
  apply from: "dependencies/versions.gradle"

  addRepos(repositories)
  dependencies {
    classpath deps.plugin.androidGradle
    classpath deps.plugin.kotlin
    classpath deps.plugin.kotlinSerialization
    //.... 添加发布所需的依赖
    classpath deps.plugin.gradleBinary
    classpath deps.plugin.androidMaven
  }
}
```

2. 解决 JavaDoc 的编码问题, 项目根`build.gradle`

```groovy
allprojects {
  //  def git = Grgit.open(currentDir: projectDir)
  addGitVersion(gitVersionTag(), gitVersionCode())
  addRepos(repositories)
  // 添加下面的代码
  tasks.withType(Javadoc) {
    options.addStringOption('Xdoclint:none', '-quiet')
    options.addStringOption('encoding', 'UTF-8')
    options.addStringOption('charSet', 'UTF-8')
  }
}

//在最后添加 注意替换module名
tasks.getByPath(":taplayout:javadoc").enabled = false
```

3. 在项目模块的 `build.gradle` 添加

```groovy
// 开头添加
apply plugin: 'com.github.dcendents.android-maven'//需添加的
apply plugin: 'com.jfrog.bintray'//需添加的
version = build_versions.androidVersionName//版本号，每次更新记得修改
....
// 结尾添加
ext {
  bintrayRepo = 'Maven' // 对应Bintray网站中，创建Repository的命名
  bintrayName = 'TabLayout' // 对应Bintray网站中，创建的package的命名(會新建)

  publishedGroupId = 'com.mrtan.tablayout' // 随意，对应之后引用工程的 第一段名称
  libraryName = 'tablayout'    // 最好是工程名
  artifact = 'tablayout'    // 最好是工程名，对应之后引用工程的 第二段名称

  libraryDescription = 'Library of tools used in development' // 工程的描述

  siteUrl = 'https://github.com/ggggxiaolong/FlycoTabLayout' // github项目地址
  gitUrl = 'https://github.com/ggggxiaolong/FlycoTabLayout' // github项目地址git

  libraryVersion = this.version // 随意，对应之后工程的 第三段名称

  developerId = 'ggggxiaolong' // 用户名ID，对应创建bintray账号的名称ID
  developerName = 'ggggxiaolong' // 用户名ID，对应创建bintray账号的名称ID
  developerEmail = 'xxxxxx@gmail.com' // 邮箱，对应创建bintray账号的邮箱

  licenseName = 'The Apache Software License, Version 2.0' // 固定
  licenseUrl = 'http://www.apache.org/licenses/LICENSE-2.0.txt' // 固定
  allLicenses = ["Apache-2.0"] // 固定
}

apply from: '../dependencies/install.gradle'
apply from: '../dependencies/publish.gradle'

javadoc { // 引用这个，是为了解决注释中，有中文，然后编译不通过的坑
  options {
    encoding "UTF-8"
    charSet 'UTF-8'
    //author true
    version true
    title 'A LibSDK Support For Android'   // 文档标题
  }
}
```

3.  在 `local.properties` 文件中添加 jcenter 的用户名和 key

```properties
bintray.user=XXXXXX
bintray.apikey=XXXXXX
```

