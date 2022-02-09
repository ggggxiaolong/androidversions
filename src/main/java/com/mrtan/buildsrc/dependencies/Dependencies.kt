package com.mrtan.buildsrc.dependencies

object Dependencies {
    const val kotlinReflect = "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}"
    const val fontAwesomeCompose =
        "com.github.Gurupreet:FontAwesomeCompose:${Versions.fontAwesomeCompose}"
    const val kotlinStandardLibrary = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    const val kotlinSerialization =
        "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.serialization}"
    const val androidCoreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val androidAppCompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val androidPaletteKtx = "androidx.palette:palette-ktx:${Versions.paletteKtx}"
    const val googleMaterial = "com.google.android.material:material:${Versions.material}"
    const val playServicesAds =
        "com.google.android.gms:play-services-ads:${Versions.playServicesAds}"
    const val googleMaps = "com.google.android.libraries.maps:maps:${Versions.googleMaps}"
    const val playServicesMaps =
        "com.google.android.gms:play-services-maps:${Versions.playServicesMaps}"
    const val composeUi = "androidx.compose.ui:ui:${Versions.compose}"
    const val composeUiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    const val composeMaterial = "androidx.compose.material:material:${Versions.compose}"
    const val composeMaterial3 = "androidx.compose.material3:material3:${Versions.material3}"
    const val composeMaterialIconsExtended =
        "androidx.compose.material:material-icons-extended:${Versions.compose}"
    const val composeRuntimeLivedata =
        "androidx.compose.runtime:runtime-livedata:${Versions.compose}"
    const val composeConstraintLayout =
        "androidx.constraintlayout:constraintlayout-compose:${Versions.constraintLayoutCompose}"
    const val composePaging = "androidx.paging:paging-compose:${Versions.pagingCompose}"
    const val composeViewModel =
        "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.lifecycleViewModelCompose}"
    const val composeActivity = "androidx.activity:activity-compose:${Versions.activityCompose}"
    const val composeLottie = "com.airbnb.android:lottie-compose:${Versions.lottie}"
    const val composeNavigation = "androidx.navigation:navigation-compose:${Versions.navCompose}"

    const val composeUiTestJunit4 = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"
    const val composeUiTestManifest = "androidx.compose.ui:ui-test-manifest:${Versions.compose}"

    const val desugar = "com.android.tools:desugar_jdk_libs:${Versions.desugar}"

    const val dialogsCore = "io.github.vanpra.compose-material-dialogs:core:${Versions.dialogs}"
    const val dialogsDatePicker =
        "io.github.vanpra.compose-material-dialogs:datetime:${Versions.dialogs}"

    /**
     * Custom fling behaviour
     * refer to https://github.com/iamjosephmj/flinger for more insights on the library
     */
    const val flinger = "com.github.iamjosephmj:flinger:${Versions.flinger}"

    const val androidPagingRuntime = "androidx.paging:paging-runtime-ktx:${Versions.paging}"
    const val lottie = "com.airbnb.android:lottie:${Versions.lottie}"
    const val androidExoPlayer = "com.google.android.exoplayer:exoplayer:${Versions.exoplayer}"
    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"

    const val coilAccompanist =
        "com.google.accompanist:accompanist-coil:${Versions.accompanistCoil}"
    const val coilCompose = "io.coil-kt:coil-compose:${Versions.coilCompose}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val coroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val viewModelKtx =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.androidLifecycleGrouped}"
    const val liveDataKtx =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.androidLifecycleGrouped}"
    const val lifecycleRuntimeKtx =
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.androidLifecycleGrouped}"
    const val lifecycleSavedState =
        "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.androidLifecycleGrouped}"
    const val junitJupiterApi = "org.junit.jupiter:junit-jupiter-api:${Versions.junit}"
    const val junitJupiterEngine =
        "org.junit.jupiter:junit-jupiter-engine:${Versions.junit}"
    const val truth = "com.google.truth:truth:${Versions.truth}"
    const val kotlinJunit5 = "org.jetbrains.kotlin:kotlin-test-junit5:${Versions.kotlin}"
    const val kotlinTest = "org.jetbrains.kotlin:kotlin-test:${Versions.kotlin}"
    const val androidXJunit = "androidx.test.ext:junit:${Versions.androidXJunit}"
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
    const val composeInsets = "com.google.accompanist:accompanist-insets:${Versions.accompanist}"
    const val composeSystemUiController =
        "com.google.accompanist:accompanist-systemuicontroller:${Versions.accompanist}"
    const val composePager = "com.google.accompanist:accompanist-pager:${Versions.accompanist}"
    const val composePagerIndicator =
        "com.google.accompanist:accompanist-pager-indicators:${Versions.accompanist}"
    const val composePermission =
        "com.google.accompanist:accompanist-permissions:${Versions.accompanist}"
    const val composePlaceholder =
        "com.google.accompanist:accompanist-placeholder:${Versions.accompanist}"
    const val composeFlowlayout =
        "com.google.accompanist:accompanist-flowlayout:${Versions.accompanist}"
    const val composeNavigationAnimation =
        "com.google.accompanist:accompanist-navigation-animation:${Versions.accompanist}"
    const val composeNavigationMaterial =
        "com.google.accompanist:accompanist-navigation-material:${Versions.accompanist}"
    const val composeDrawablePainer =
        "com.google.accompanist:accompanist-drawablepainter:${Versions.accompanist}"
    const val composeSwipeRefresh =
        "com.google.accompanist:accompanist-swiperefresh:${Versions.accompanist}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"
    const val materialDialogsCore =
        "com.afollestad.material-dialogs:core:${Versions.materialDialogs}"
    const val materialDialogsInput =
        "com.afollestad.material-dialogs:input:${Versions.materialDialogs}"
    const val materialDialogsLifecycle =
        "com.afollestad.material-dialogs:lifecycle:${Versions.materialDialogs}"
    const val materialDialogsBottomsheets =
        "com.afollestad.material-dialogs:bottomsheets:${Versions.materialDialogs}"
    const val androidUtils = "com.blankj:utilcode:${Versions.androidUtils}"
    const val commonsIo = "org.apache.commons:commons-io:${Versions.commonsIo}"
    const val documentfile = "androidx.documentfile:documentfile:${Versions.documentfile}"
    const val dfu = "no.nordicsemi.android:dfu:${Versions.dfu}"
    const val permission =
        "com.github.permissions-dispatcher:permissionsdispatcher:${Versions.permission}"
    const val permissionProcessor =
        "com.github.permissions-dispatcher:permissionsdispatcher-processor:${Versions.permission}"
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    const val lifecycleService = "androidx.lifecycle:lifecycle-service:${Versions.lifecycle}"
    const val commonsCodec = "commons-codec:commons-codec:${Versions.commonsCodec}"
    const val hiltRuntime = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    const val hiltWorker = "androidx.hilt:hilt-work:${Versions.hiltWorker}"
    const val hiltWorkerCompiler = "androidx.hilt:hilt-compiler:${Versions.hiltWorker}"
    const val hiltViewModel = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hiltViewModel}"
    const val glideRuntime = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompile = "com.github.bumptech.glide:compiler:${Versions.glide}"
    const val glideOkHttp3 = "com.github.bumptech.glide:okhttp3-integration:${Versions.glide}"
    const val glideRecyclerView = "com.github.bumptech.glide:recyclerview-integration:${Versions.glide}"
    const val photoView = "com.github.chrisbanes:PhotoView:${Versions.photoView}"
    const val mmkv = "com.tencent:mmkv-static:${Versions.mmkv}"
    const val libPhone = "io.michaelrocks:libphonenumber-android:${Versions.libPhone}"
    const val pandora = "com.github.whataa:pandora:${Versions.pandora}"
    const val swiperefreshlayout = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swiperefreshlayout}"
    const val work = "androidx.work:work-runtime-ktx:${Versions.work}"
    const val okhttp3Bom = "com.squareup.okhttp3:okhttp-bom:${Versions.okhttp3}"
    const val okhttp3 = "com.squareup.okhttp3:okhttp"
    const val okHttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor"
    const val MPAndroidChart = "com.github.PhilJay:MPAndroidChart:${Versions.MPAndroidChart}"
    const val navigationUi =  "androidx.navigation:navigation-ui:${Versions.navigation}"
    const val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val navigationFragment = "androidx.navigation:navigation-fragment:${Versions.navigation}"
    const val navigationFragmentKtx = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val flexbox = "com.google.android:flexbox:${Versions.flexbox}"
    const val flexibledivider = "com.yqritc:recyclerview-flexibledivider:${Versions.flexibledivider}"
    const val permissionX = "com.yanzhenjie.permission:x:${Versions.permissionX}"
    const val exifinterface = "androidx.exifinterface:exifinterface:${Versions.exifinterface}"
    const val location = "com.mrtan.android:googlelocation:${Versions.location}"
    const val firebaseBom = "com.google.firebase:firebase-bom:${Versions.firebaseBom}"
    const val firebaseMessage = "com.google.firebase:firebase-messaging-ktx"
    const val ccp = "com.hbb20:ccp:${Versions.ccp}"
    const val flowLayout = "com.github.simonebortolin:FlowLayoutManager:${Versions.flowLayout}"
    const val compressor = "id.zelory:compressor:${Versions.compressor}"
    const val circleImageView = "de.hdodenhof:circleimageview:${Versions.circleImageView}"
    const val bugly = "com.tencent.bugly:crashreport:${Versions.bugly}"
}