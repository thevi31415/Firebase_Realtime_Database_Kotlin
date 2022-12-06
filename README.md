# Firebase_Realtime_Database_Kotlin
# Project
```gradle
  id 'com.google.gms.google-services'
  implementation platform('com.google.firebase:firebase-bom:31.1.0')
  implementation 'com.google.firebase:firebase-database-ktx'
```
# Model
```gradle
buildscript {
    repositories {
        // Make sure that you have the following two repositories
        google()  // Google's Maven repository

        mavenCentral()  // Maven Central repository

    }
    dependencies {

        // Add the dependency for the Google services Gradle plugin
        classpath 'com.google.gms:google-services:4.3.13'

    }
}

```
