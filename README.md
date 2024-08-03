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


### Step 5: Generate resource file
- Run the command
```
./gradlew assembleDebug
```

- The main result of the JSON processing is to produce XML files which you can reference as Android resources in your Java code:

```app/build/generated/res/google-services/{build_type}/values/values.xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <! -- Present in all applications -->
    <string name="google_app_id" translatable="false">1:1035469437089:android:73a4fb8297b2cd4f</string>

    <! -- Present in applications with the appropriate services configured -->
    <string name="gcm_defaultSenderId" translatable="false">1035469437089</string>
    <string name="default_web_client_id" translatable="false">337894902146-e4uksm38sne0bqrj6uvkbo4oiu4hvigl.apps.googleusercontent.com</string>
    <string name="ga_trackingId" translatable="false">UA-65557217-3</string>
    <string name="firebase_database_url" translatable="false">https://example-url.firebaseio.com</string>
    <string name="google_api_key" translatable="false">AIzbSyCILMsOuUKwN3qhtxrPq7FFemDJUAXTyZ8</string>
    <string name="google_crash_reporting_api_key" translatable="false">AIzbSyCILMsOuUKwN3qhtxrPq7FFemDJUAXTyZ8</string>
    <string name="project_id" translatable="false">mydemoapp</string>
<string name="google_storage_bucket" translatable="false">mydemoapp.appspot.com</string>
</resources>
```
- You can create this file by yourself follow this guide: https://developers.google.com/android/guides/google-services-plugin


### Step 6: Disable auto init

```AndroidManifest.xml
<provider
    android:name="com.google.firebase.provider.FirebaseInitProvider"
    android:authorities="${applicationId}.firebaseinitprovider"
    tools:node="remove"
/>
```


### Step 7: Init firebase manually
- Use values from app/build/generated/res/google-services/{build_type}/values/values.xml, init FirebaseApp manually
```
FirebaseOptions.Builder builder = new FirebaseOptions.Builder()
    .setApiKey("google_api_key")
    .setApplicationId("google_app_id")
    .setDatabaseUrl("firebase_database_url")
    .setGcmSenderId("gcm_defaultSenderId")
    .setStorageBucket("google_storage_bucket");
    .setProjectId("project_id");
FirebaseApp.initializeApp(this, builder.build());
```


### Step 8: Remove plugin
```app/build.gradle
// apply plugin: 'com.google.gms.google-services' --> Remove this line
```

```build.gradle (project-level)
// classpath 'com.google.gms:google-services:4.4.2' --> Remove this line (Optional)
```

- You can delete google-service.json now


### Step 9: Secure Firebase API keys
- You can put Firebase API keys in server or whatever you want. In this example, I will put it under .so file


## Troubleshooting
- If you using firebase analytics, add google_app_id to strings.xml
```strings.xml
<string name="google_app_id" translatable="false">1:1035469437089:android:73a4fb8297b2cd4f</string>
```



## References:
- https://firebase.blog/posts/2017/03/take-control-of-your-firebase-init-on/
- https://firebase.blog/posts/2016/12/working-with-multiple-firebase-projects-in-an-android-app
- https://developers.google.com/android/guides/google-services-plugin
- https://stackoverflow.com/questions/42926624/i-am-using-multiple-firebase-projects-in-an-android-app-i-am-getting-this-error/62155919#62155919