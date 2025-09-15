plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.pantruka.libreriaonline"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.pantruka.libreriaonline"
        minSdk = 26
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    // Dependencias existentes (mantenlas)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)

    // ✅ NUEVAS DEPENDENCIAS NECESARIAS - AGREGAR ESTAS:
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    implementation("androidx.cardview:cardview:1.0.0")
    implementation("androidx.fragment:fragment:1.6.2")
    implementation("androidx.core:core-ktx:1.12.0")

    // Testing (mantenlas)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}