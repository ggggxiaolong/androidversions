package com.mrtan.buildsrc.dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.add

fun DependencyHandler.addComposeOfficialDependencies() {
    composeOfficialDependencies.forEach {
        add("implementation", it)
    }
}

fun DependencyHandler.addComposeThirdPartyDependencies() {
    composeThirdPartyDependencies.forEach {
        add("implementation", it)
    }
}

fun DependencyHandler.addComposeDebugDependencies() {
    composeDebugDependencies.forEach {
        add("debugImplementation", it)
    }
}

fun DependencyHandler.addKotlinDependencies() {
    kotlinDependencies.forEach {
        add("implementation", it)
    }
}

fun DependencyHandler.addKotlinTestDependencies() {
    kotlinTestDependencies.forEach {
        add("testImplementation", it)
    }
}

fun DependencyHandler.addDataDependencies() {
    add("kapt", Dependencies.roomCompiler){
        exclude(
            mapOf(
                "group" to "org.jetbrains",
                "module" to "annotations"
            )
        )
    }
    dataDependencies.forEach {
        add("implementation", it)
    }
}

fun DependencyHandler.addCoreAndroidDependencies() {
    coreAndroidDependencies.forEach {
        add("implementation", it)
    }
}

fun DependencyHandler.addCoreAndroidUiDependencies() {
    coreAndroidUiDependencies.forEach {
        add("implementation", it)
    }
}

fun DependencyHandler.addGoogleAndroidDependencies() {
    googleAndroidLibraries.forEach {
        add("implementation", it)
    }
}

fun DependencyHandler.addNetworkingDependencies() {
    networkingDependencies.forEach {
        add("implementation", it)
    }
}

fun DependencyHandler.addJunit5TestDependencies() {
  add("testImplementation", Dependencies.junitJupiterApi)
  add("testRuntimeOnly", Dependencies.junitJupiterEngine)
}

fun DependencyHandler.addThirdPartyUnitTestsDependencies() {
    thirdPartyUnitTestsDependencies.forEach {
        add("testImplementation", it)
    }
}

fun DependencyHandler.addAndroidInstrumentationTestsDependencies() {
    androidInstrumentationTestsDependencies.forEach {
        add("androidTestImplementation", it)
    }
}

fun DependencyHandler.addThirdPartyUiDependencies() {
    thirdPartyUiDependencies.forEach {
        add("implementation", it)
    }
}

fun DependencyHandler.addDesugarDependencies(){
    add("coreLibraryDesugaring", Dependencies.desugar)
}

fun DependencyHandler.addAccompanist(){
    accompanist.forEach {
        add("implementation", it)
    }
}
