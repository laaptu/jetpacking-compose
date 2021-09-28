import com.deputy.android.Dependencies
import com.deputy.android.Dependencies.implementations
import com.deputy.android.Sdk

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(Sdk.compile)

    defaultConfig {
        minSdkVersion(Sdk.min)
        targetSdkVersion(Sdk.target)
        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            consumerProguardFiles("proguard-rules.pro")
            buildConfigField("Boolean", "enableLogcat", "false")
        }

        register("qa") {
            isMinifyEnabled = true
            consumerProguardFiles("proguard-rules.pro")
            buildConfigField("Boolean", "enableLogcat", "false")
        }
        getByName("debug") {
            isMinifyEnabled = false
            buildConfigField("Boolean", "enableLogcat", "false")
        }
        register("integration") {
            isMinifyEnabled = false
            buildConfigField("Boolean", "enableLogcat", "false")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    lintOptions {
        isAbortOnError = false
    }

    dataBinding {
        isEnabled = true
    }
}

dependencies {
    //kapt(Dependencies.AnnotationProcessors.dataBinding)

    implementation(Dependencies.Kotlin.stdLib)
    implementation(Dependencies.Kotlin.reflect)
    implementation(Dependencies.AndroidX.recyclerView)
    implementation(Dependencies.AndroidX.appCompat)
    implementation(Dependencies.AndroidX.Legacy.v4)
    implementation(Dependencies.AndroidX.viewPager2)
    implementation(Dependencies.Google.material)

    implementation(Dependencies.ThirdParty.Time.threetenabp)
    implementations(Dependencies.ThirdParty.Glide.all)
    implementation(Dependencies.ThirdParty.Presentation.materialprogressbar) {
        exclude(group = "com.android.support", module = "appcompat-v7")
        exclude(group = "com.android.support", module = "support-v4")
    }
}
