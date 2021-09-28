import com.deputy.android.Dependencies
import com.deputy.android.Sdk

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdkVersion(Sdk.compile)

    defaultConfig {
        minSdkVersion(Sdk.min)
        targetSdkVersion(Sdk.target)
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Dependencies.AndroidX.Compose.version
    }
}

dependencies {
    implementation(Dependencies.AndroidX.coreKtx)

    implementation(Dependencies.AndroidX.Compose.activityCompose)
    testImplementation(Dependencies.Test.Unit.junit)
    androidTestImplementation(Dependencies.Test.Android.junit)
    androidTestImplementation(Dependencies.Test.Instrumented.Espresso.core)

    implementation(Dependencies.AndroidX.Compose.material)
    implementation(Dependencies.AndroidX.Compose.ui)
    implementation(Dependencies.AndroidX.Compose.tooling)
    androidTestImplementation(Dependencies.AndroidX.Compose.uiTest)
}
