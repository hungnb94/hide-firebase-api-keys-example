# Secure Your Firebase API Keys
## Guidelines for Hiding Firebase API Keys

### Step 1: Create your android project
### Step 2: Register your app with Firebase
### Step 3: Add Firebase configuration file
- Download and then add the Firebase Android configuration file (google-services.json) to your app
    - Click Download google-services.json to obtain your Firebase Android config file
    - Move your config file into the module (app-level) root directory of your app
### Step 4: Add Firebase SDKs to your app
#### Make following changes to the project
##### Groovy
- build.gradle (project-level)
```Add rules to include the Google Services Gradle plugin:
classpath 'com.google.gms:google-services:4.4.2'
classpath 'com.google.firebase:firebase-crashlytics-gradle:3.0.2'
```
- app/build.gradle
```Apply the Google Services Gradle plugin:
apply plugin: 'com.google.gms.google-services'
apply plugin: 'com.google.firebase.crashlytics'
```
```Add the library dependency:
// Import the BoM for the Firebase platform
implementation(platform("com.google.firebase:firebase-bom:33.1.2"))

// Add the dependencies for the Crashlytics and Analytics libraries
// When using the BoM, you don't specify versions in Firebase library dependencies
implementation("com.google.firebase:firebase-crashlytics")
implementation("com.google.firebase:firebase-analytics")

```
##### Kotlin
- build.gradle.kts (project-level)
```
plugins {
  id("com.android.application") version "7.3.0" apply false

  // Add the dependency for the Google services Gradle plugin
  id("com.google.gms.google-services") version "4.4.2" apply false
}
```
- app/build.gradle.kts
```
plugins {
  id("com.android.application")

  // Add the Google services Gradle plugin
  id("com.google.gms.google-services")
}
```