# androidversions
---
这是一个安卓项目依赖库版本的汇总，包含了项目使用的库及其版本。可以只用它作为一个项目的子模块，通过配置来统一管理所有的库依赖。

### 配置步骤
* 将这个项目添加为子项目（我一般会把它命名为dependencies）
 ```shell
 git submodule add git@github.com:ggggxiaolong/androidversions.git dependencies
 ```
* 修改主项目根目录下的build.gradle文件，在第一行添加下面的代码（注意子模块的名称）
```shell
apply from: 'dependencies/dependencies.gradle'
```
* 在子模块中使用统一的配置

 你可以这样
 ```java
 ...
 android {
  def globalConfiguration = rootProject.ext
  compileSdkVersion globalConfiguration.compileSdkVersion
  buildToolsVersion globalConfiguration.buildToolsVersion
 ...
 ```
 或者这样
 ```java
 ...
 dependencies {
  def appDependencies = rootProject.ext.appDependencies
  implementation appDependencies.appcompat
 ...
 ```

添加debug 的签名
```java
signingConfigs {
    debug {
      storeFile file('../buildsystem/debug.keystore')
      storePassword 'android'
      keyAlias 'androiddebugkey'
      keyPassword 'android'
    }
    ...
}
```