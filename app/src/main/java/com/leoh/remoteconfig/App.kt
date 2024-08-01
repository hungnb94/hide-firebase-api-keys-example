package com.leoh.remoteconfig

import android.app.Application
import android.util.Log
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.remoteConfigSettings
import com.leoh.credentials.CredentialProvider

private const val TAG = "MyApp"

class App : Application() {
    private lateinit var firebaseApp: FirebaseApp

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
        val remoteConfig: FirebaseRemoteConfig = FirebaseRemoteConfig.getInstance()

        val configSettings =
            remoteConfigSettings {
                minimumFetchIntervalInSeconds = 3
            }
        remoteConfig.setConfigSettingsAsync(configSettings)
        remoteConfig.fetchAndActivate().addOnCompleteListener {
            Log.w(TAG, "configFirebase: ${it.isSuccessful}")
        }
    }

    private fun firebaseOptions(): FirebaseOptions {
        val credentialProvider = CredentialProvider()
        return FirebaseOptions
            .Builder()
            .setApiKey(credentialProvider.getApiKey())
            .setApplicationId(credentialProvider.getApplicationId())
            .setDatabaseUrl(credentialProvider.getDatabaseUrl())
            .setGcmSenderId(credentialProvider.getGcmSenderId())
            .setStorageBucket(credentialProvider.getStorageBucket())
            .setProjectId(credentialProvider.getProjectId())
            .build()
    }
}
