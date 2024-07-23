package com.leoh.remoteconfig

import android.app.Application
import android.util.Log
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.remoteConfigSettings

private const val TAG = "MyApp"

class App : Application() {
    lateinit var firebaseApp: FirebaseApp

    override fun onCreate() {
        super.onCreate()
        configFirebase()
    }

    private fun configFirebase() {
        firebaseApp =
            FirebaseApp.initializeApp(
                this,
                firebaseOptions(),
            )
        val remoteConfig: FirebaseRemoteConfig = FirebaseRemoteConfig.getInstance(firebaseApp)

        val configSettings =
            remoteConfigSettings {
                minimumFetchIntervalInSeconds = 3
            }
        remoteConfig.setConfigSettingsAsync(configSettings)
        remoteConfig.fetchAndActivate().addOnCompleteListener {
            Log.w(TAG, "configFirebase: ${it.isSuccessful}")
        }
    }

    private fun firebaseOptions(): FirebaseOptions =
        FirebaseOptions
            .Builder()
            .setApiKey("AIzaSyBhH6gE7wb_rAGW8iv49OyeRBJreQEwIs0")
            .setApplicationId("1:185353233953:android:27852780e95accdcca2560")
            .setGcmSenderId("185353233953")
            .setStorageBucket("cleanarchitecture-49552.appspot.com")
            .setProjectId("cleanarchitecture-49552")
            .build()
}
