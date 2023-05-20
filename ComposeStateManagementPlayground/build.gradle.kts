// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.0.1" apply false
    id("org.jetbrains.kotlin.android") version "1.8.21" apply false
    id("com.google.dagger.hilt.android") version "2.44" apply false
}

// 参考資料: https://qiita.com/Nabe1216/items/322caa7acf11dbe032ca
allprojects {
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>()
        .configureEach {
            kotlinOptions {
                // targetCompatibilityと揃える
                jvmTarget = JavaVersion.VERSION_1_8.toString()
            }
        }
}