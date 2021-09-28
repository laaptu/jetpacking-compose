@file:Suppress("MaximumLineLength")

package com.deputy.android

import org.gradle.api.artifacts.dsl.DependencyHandler

object Versions {
    const val androidPlugin = "7.0.1" // https://developer.android.com/studio/releases/gradle-plugin

    const val kotlin = "1.5.21" // https://kotlinlang.org/docs/reference/using-gradle.html

    const val kotlinCoroutines = "1.5.0" // https://github.com/Kotlin/kotlinx.coroutines

    const val androidxNavigation = "2.3.5" // https://developer.android.com/jetpack/androidx/releases/navigation
    const val androidxLifecycle = "2.3.1" // https://developer.android.com/jetpack/androidx/releases/lifecycle
    const val androidxRoom = "2.3.0" // https://developer.android.com/jetpack/androidx/releases/room

    const val glide = "4.12.0" // https://github.com/bumptech/glide

    const val jacoco = "0.8.7" // https://docs.gradle.org/current/userguide/jacoco_plugin.html
}

object Plugins {
    const val androidPlugin = "com.android.tools.build:gradle:${Versions.androidPlugin}"
    const val googleServices = "com.google.gms:google-services:4.3.8" // https://developers.google.com/android/guides/google-services-plugin
    const val firebaseCrashlytics = "com.google.firebase:firebase-crashlytics-gradle:2.5.2" // https://firebase.google.com/docs/crashlytics/get-started-new-sdk?platform=android
    const val firebasePerf = "com.google.firebase:perf-plugin:1.4.0" // https://firebase.google.com/docs/perf-mon/get-started-android
    const val androidxNavigationSafeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.androidxNavigation}"
    const val jacoco = "org.jacoco:org.jacoco.core:${Versions.jacoco}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val fullStory = "com.fullstory:gradle-plugin-local:1.16.2"
    const val protobuf = "com.google.protobuf:protobuf-gradle-plugin:0.8.17"
}

object Sdk {
    const val min = 24
    const val target = 30
    const val compile = 30
    const val buildTools = "30.0.2" // https://developer.android.com/studio/releases/build-tools
    const val renderscriptTargetApi = 16
}

object Tools {
    object Detekt {
        private const val version = "1.18.0" // https://github.com/arturbosch/detekt
        const val cli = "io.gitlab.arturbosch.detekt:detekt-cli:$version"
        const val formatting = "io.gitlab.arturbosch.detekt:detekt-formatting:$version"
    }
}

object Dependencies {

    object AnnotationProcessors {
        const val dataBinding = "androidx.databinding:databinding-compiler:${Versions.androidPlugin}"
        const val androidXLifecycle = "androidx.lifecycle:lifecycle-compiler:${Versions.androidxLifecycle}"
        const val room = "androidx.room:room-compiler:${Versions.androidxRoom}"
        const val glide = "com.github.bumptech.glide:compiler:${Versions.glide}"
    }

    object Kotlin {
        const val stdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCoroutines}"
        const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinCoroutines}"
        const val reflect = "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}"
    }

    object JsonParsing {

        const val gson = "com.google.code.gson:gson:2.8.6" // https://github.com/google/gson

        const val json = "org.json:json:20201115"

        object Moshi {
            private const val version = "1.12.0" // https://github.com/square/moshi
            const val moshi = "com.squareup.moshi:moshi:$version"
            const val moshiKotlin = "com.squareup.moshi:moshi-kotlin:$version"
            const val adapters = "com.squareup.moshi:moshi-adapters:$version"
            const val codegen = "com.squareup.moshi:moshi-kotlin-codegen:$version"
            val kotlin = listOf(moshi, moshiKotlin)
            val all = listOf(moshi, moshiKotlin, adapters)
        }

        object Jackson {
            private const val version = "2.12.4"
            const val core = "com.fasterxml.jackson.core:jackson-core:$version"
            const val databind = "com.fasterxml.jackson.core:jackson-databind:$version"
            const val moduleKotlin = "com.fasterxml.jackson.module:jackson-module-kotlin:$version"
            val all = listOf(core, databind, moduleKotlin)
        }
    }

    object Kodein {
        // TODO Cant do 6.5.0
        private const val version = "6.2.1" // https://github.com/Kodein-Framework/Kodein-DI#kotlin--jvm-compatibility
        const val generic = "org.kodein.di:kodein-di-generic-jvm:$version"
        const val jsr330 = "org.kodein.di:kodein-di-jxinject-jvm:$version"
    }

    object Javax {
        const val inject = "javax.inject:javax.inject:1"
    }

    object AndroidX {
        const val appCompat = "androidx.appcompat:appcompat:1.3.0" // https://developer.android.com/jetpack/androidx/releases/appcompat
        const val annotations = "androidx.annotation:annotation:1.2.0" // https://developer.android.com/jetpack/androidx/releases/annotation
        const val browser = "androidx.browser:browser:1.3.0" // https://developer.android.com/jetpack/androidx/releases/browser

        // TODO @ian-ellis -beta2 Type mismatch: inferred type is AddUnavailabilityActivity but LifecycleOwner? was expected
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.0.4" // https://developer.android.com/jetpack/androidx/releases/constraintlayout
        const val core = "androidx.core:core:1.5.0" // https://developer.android.com/jetpack/androidx/releases/core
        const val coreKtx = "androidx.core:core-ktx:1.5.0" // https://developer.android.com/kotlin/ktx
        const val fragment = "androidx.fragment:fragment:1.3.4" // https://developer.android.com/jetpack/androidx/releases/fragment
        const val multidex = "androidx.multidex:multidex:2.0.1" // https://developer.android.com/jetpack/androidx/releases/multidex
        const val paging = "androidx.paging:paging-runtime:3.0.0" // https://developer.android.com/jetpack/androidx/releases/paging
        const val preference = "androidx.preference:preference-ktx:1.1.1" // https://developer.android.com/jetpack/androidx/releases/preference
        const val recyclerView = "androidx.recyclerview:recyclerview:1.2.0" // https://developer.android.com/jetpack/androidx/releases/recyclerview
        const val room = "androidx.room:room-runtime:${Versions.androidxRoom}" // https://developer.android.com/jetpack/androidx/releases/room
        const val viewPager2 = "androidx.viewpager2:viewpager2:1.0.0" // https://developer.android.com/jetpack/androidx/releases/viewpager2
        const val work = "androidx.work:work-runtime:2.5.0" // https://developer.android.com/jetpack/androidx/releases/work
        const val swipeRefresh = "androidx.swiperefreshlayout:swiperefreshlayout:1.1.0" // https://developer.android.com/jetpack/androidx/releases/swiperefreshlayout
        const val fragmentKtx = "androidx.fragment:fragment-ktx:1.3.5"

        object Lifecycle {
            const val common = "androidx.lifecycle:lifecycle-common-java8:${Versions.androidxLifecycle}"
            const val runtime = "androidx.lifecycle:lifecycle-runtime:${Versions.androidxLifecycle}"
            const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.androidxLifecycle}"
            const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.androidxLifecycle}"
        }

        object Navigation {
            const val fragment = "androidx.navigation:navigation-fragment-ktx:${Versions.androidxNavigation}"
            const val ui = "androidx.navigation:navigation-ui-ktx:${Versions.androidxNavigation}"
        }

        object Legacy {
            private const val version = "1.0.0" // https://developer.android.com/jetpack/androidx/releases/legacy
            const val v4 = "androidx.legacy:legacy-support-v4:$version"
            const val coreUtils = "androidx.legacy:legacy-support-core-utils:$version"
            const val coreUi = "androidx.legacy:legacy-support-core-ui:$version"
        }

        object Security {
            const val crypto = "androidx.security:security-crypto:1.1.0-alpha03"
        }

        object Compose {
            const val version = "1.0.1"
            const val foundation = "androidx.compose.foundation:foundation:$version"
            const val layout = "androidx.compose.foundation:foundation-layout:$version"
            const val material = "androidx.compose.material:material:$version"
            const val materialIconsCore = "androidx.compose.material:material-icons-core:$version"
            const val materialIconsExtended = "androidx.compose.material:material-icons-extended:$version"
            const val runtime = "androidx.compose.runtime:runtime:$version"
            const val runtimeLiveData = "androidx.compose.runtime:runtime-livedata:$version"
            const val ui = "androidx.compose.ui:ui:$version"
            const val navigation = "androidx.navigation:navigation-compose:2.4.0-alpha06"
            const val tooling = "androidx.compose.ui:ui-tooling:$version"
            const val test = "androidx.compose.ui:ui-test:$version"
            const val uiTest = "androidx.compose.ui:ui-test-junit4:$version"
            const val uiTestManinfest = "androidx.compose.ui:ui-test-manifest:$version"
            const val uiUtil = "androidx.compose.ui:ui-util:$version"
            const val viewBinding = "androidx.compose.ui:ui-viewbinding:$version"
            const val activityCompose = "androidx.activity:activity-compose:1.3.1"
            const val animation = "androidx.compose.animation:animation:$version"
        }
    }

    object Google {
        // https://github.com/material-components/material-components-android/releases
        const val material = "com.google.android.material:material:1.2.1"

        // https://developers.google.com/places/android-sdk/start
        const val places = "com.google.android.libraries.places:places:2.4.0"

        // https://github.com/google/flexbox-layout
        const val flexBox = "com.google.android:flexbox:2.0.1"

        // https://github.com/google/ExoPlayer
        object ExoPlayer {
            private const val version = "2.13.3"
            const val core = "com.google.android.exoplayer:exoplayer-core:$version"
            const val ui = "com.google.android.exoplayer:exoplayer-ui:$version"
            val all = listOf(core, ui)
        }

        // https://firebase.google.com/support/release-notes/android#latest_sdk_versions
        object Firebase {
            // Please avoid using the -ktx libraries
            const val analytics = "com.google.firebase:firebase-analytics:19.0.0"
            const val auth = "com.google.firebase:firebase-auth:21.0.1"
            const val config = "com.google.firebase:firebase-config:21.0.0"
            const val crashlytics = "com.google.firebase:firebase-crashlytics:18.0.0"
            const val dynamicLinks = "com.google.firebase:firebase-dynamic-links:20.0.0"
            const val messaging = "com.google.firebase:firebase-messaging:22.0.0"
            val all = listOf(crashlytics, analytics, auth, messaging, dynamicLinks, config)
        }

        object PlayServices {
            private const val version = "17.0.0" // https://developers.google.com/android/guides/releases
            const val analytics = "com.google.android.gms:play-services-analytics:$version"
            const val auth = "com.google.android.gms:play-services-auth:19.0.0"
            const val location = "com.google.android.gms:play-services-location:18.0.0"
            const val maps = "com.google.android.gms:play-services-maps:$version"
            const val core = "com.google.android.play:core-ktx:1.8.1"
            val all = listOf(analytics, auth, location, maps)
        }
    }

    object ThirdParty {
        object Time {
            const val threetenabp = "com.jakewharton.threetenabp:threetenabp:1.3.1"
        }

        object Presentation {
            const val materialprogressbar = "me.zhanghai.android.materialprogressbar:library:1.6.1" // https://github.com/zhanghai/MaterialProgressBar
            const val materialCalendar = "com.github.prolificinteractive:material-calendarview:2.0.1" // https://github.com/prolificinteractive/material-calendarview

            // const val pageIndicator = "com.romandanylyk:pageindicatorview:1.0.3" // https://github.com/romandanylyk/PageIndicatorView
            const val pageIndicator = "com.github.adrielcafe:PageIndicatorView:1.0.6" // https://github.com/romandanylyk/PageIndicatorView/issues/115
            const val lottie = "com.airbnb.android:lottie:3.7.0" // https://github.com/airbnb/lottie-android/releases
            const val photoViewer = "com.github.chrisbanes:PhotoView:2.3.0" // https://github.com/chrisbanes/PhotoView/releases
            const val materialDrawer = "com.mikepenz:materialdrawer:6.0.9" // https://github.com/mikepenz/MaterialDrawer
            const val multiPicker = "com.kbeanie:multipicker:1.6.2@aar" // https://github.com/coomar2841/android-multipicker-library
            const val balloon = "com.github.skydoves:balloon:1.3.4" // https://github.com/skydoves/Balloon
        }

        object Glide {
            const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
            const val okhttp = "com.github.bumptech.glide:okhttp3-integration:${Versions.glide}"
            val all = listOf(glide, okhttp)
        }

        object Facebook {
            private const val version = "6.1.0" // https://github.com/facebook/facebook-android-sdk

            // https://developers.facebook.com/docs/facebook-login/android
            const val login = "com.facebook.android:facebook-login:$version"

            // https://developers.facebook.com/docs/applinks/android
            const val appLinks = "com.facebook.android:facebook-applinks:$version"

            // https://developers.facebook.com/docs/sharing/android
            const val share = "com.facebook.android:facebook-share:$version"
            val all = listOf(login, appLinks, share)
        }

        object Twitter {
            private const val version = "3.3.0"
            const val core = "com.twitter.sdk.android:twitter-core:$version"
            const val tweetComposer = "com.twitter.sdk.android:tweet-composer:$version"
            val all = listOf(core, tweetComposer)
        }

        // https://github.com/launchdarkly/android-client-sdk
        const val launchDarkly = "com.launchdarkly:launchdarkly-android-client-sdk:2.13.0"

        // https://github.com/openid/AppAuth-Android
        const val openId = "net.openid:appauth:0.7.1"

        // https://mvnrepository.com/artifact/com.pusher/pusher-java-client
        const val pusher = "com.pusher:pusher-java-client:1.8.0"

        const val shimmer = "com.facebook.shimmer:shimmer:0.5.0"

        // https://github.com/coil-kt/coil
        const val coil = "io.coil-kt:coil:1.3.2"
    }

    object Intercom {
        private const val version = "9.0.2"
        const val base = "io.intercom.android:intercom-sdk:$version"
    }

    object Network {
        object OkHttp {
            private const val version = "4.10.0-RC1" // https://github.com/square/okhttp
            const val okHttp = "com.squareup.okhttp3:okhttp:$version"
            const val interceptor = "com.squareup.okhttp3:logging-interceptor:$version"
            val all = listOf(okHttp, interceptor)
        }

        object Retrofit {
            private const val version = "2.9.0" // https://github.com/square/retrofit
            const val retrofit = "com.squareup.retrofit2:retrofit:$version"
            const val gson = "com.squareup.retrofit2:converter-gson:$version"
            const val moshi = "com.squareup.retrofit2:converter-moshi:$version"
            val all = listOf(retrofit, gson, moshi)
        }
    }

    object Flipper {
        private const val version = "0.100.0"
        const val flipper = "com.facebook.flipper:flipper:$version"
        const val networkPlugin = "com.facebook.flipper:flipper-network-plugin:$version"
        const val soLoader = "com.facebook.soloader:soloader:0.10.1"
        val all = listOf(flipper, networkPlugin) // soLoader is purposely excluded from `all` as it's only req'd at Application level
    }

    object Android {
        // https://developer.android.com/google/play/billing/billing_library_overview
        const val billing = "com.android.billingclient:billing:1.0" // TODO update

        // https://developer.android.com/google/play/installreferrer/library
        const val installReferrer = "com.android.installreferrer:installreferrer:1.1"
    }

    object Tracking {
        object Segment {
            // https://github.com/segmentio/analytics-android/blob/master/CHANGELOG.md
            const val analytics = "com.segment.analytics.android:analytics:4.9.0"
        }

        object Datadog {
            // https://github.com/DataDog/dd-sdk-android/blob/master/CHANGELOG.md
            const val logger = "com.datadoghq:dd-sdk-android:1.8.1"
        }
    }

    object Proto {
        const val kotlin = "com.google.protobuf:protobuf-kotlin:3.17.3"
        const val javaUtil = "com.google.protobuf:protobuf-java-util:3.17.3"
    }

    object Test {

        object Android {
            const val archCore = "android.arch.core:core-testing:1.1.1"
            const val room = "androidx.room:room-testing:${Versions.androidxRoom}"
            const val junit = "androidx.test.ext:junit:1.1.3"
        }

        object Unit {
            const val junit = "org.junit.jupiter:junit-jupiter:5.7.2"
            const val junitVintage = "org.junit.vintage:junit-vintage-engine:5.7.2"
            const val mockk = "io.mockk:mockk:1.10.2" // https://github.com/mockk/mockk
            const val kluent = "org.amshove.kluent:kluent:1.64" // https://github.com/MarkusAmshove/Kluent
            const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.kotlinCoroutines}"
            val all = listOf(junit, junitVintage, mockk, kluent, coroutines)
        }

        object Instrumented {
            private const val androidSupportTestVersion = "1.0.2"
            const val supportTestRunner = "com.android.support.test:runner:$androidSupportTestVersion"
            const val supportOrchestrator = "com.android.support.test:orchestrator:$androidSupportTestVersion"

            const val testRunner = "androidx.test:runner:1.3.0"
            const val testRules = "androidx.test:rules:1.3.0"
            const val auiAutomator = "androidx.test.uiautomator:uiautomator:2.2.0"

            const val fragment = "androidx.fragment:fragment-testing:1.3.5"

            const val cucumber = "io.cucumber:cucumber-android:4.8.4"
            const val kluent = "org.amshove.kluent:kluent-android:1.33"

            object Espresso {
                private const val version = "3.3.0" // https://developer.android.com/training/testing/set-up-project
                const val core = "androidx.test.espresso:espresso-core:$version"
                const val contrib = "androidx.test.espresso:espresso-contrib:$version"
                const val intents = "androidx.test.espresso:espresso-intents:$version"

                private const val idlingResouceVersion = "3.0.2"
                const val idlingResouce = "com.android.support.test.espresso.idling:idling-concurrent:$idlingResouceVersion"
                const val idlingConcurrent = "com.android.support.test.espresso.idling:idling-concurrent:$idlingResouceVersion"
            }
        }
    }

    fun DependencyHandler.`implementations`(dependencyNotation: List<Any>) = dependencyNotation.forEach {
        add("implementation", it)
    }

    fun DependencyHandler.`testImplementations`(dependencyNotation: List<Any>) = dependencyNotation.forEach {
        add("testImplementation", it)
    }

    fun DependencyHandler.`debugImplementations`(dependencyNotation: List<Any>) = dependencyNotation.forEach {
        add("debugImplementation", it)
    }

    fun DependencyHandler.`qaImplementation`(dependencyNotation: Any) {
        add("qaImplementation", dependencyNotation)
    }

    fun DependencyHandler.`qaImplementations`(dependencyNotation: List<Any>) = dependencyNotation.forEach {
        add("qaImplementation", it)
    }
}
