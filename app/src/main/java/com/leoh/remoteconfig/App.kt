package com.leoh.remoteconfig

import android.app.Application
import com.google.firebase.FirebaseApp
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.remoteConfigSettings

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        configFirebase()
    }

    private fun configFirebase() {
        FirebaseApp.initializeApp(this)
        val remoteConfig: FirebaseRemoteConfig = FirebaseRemoteConfig.getInstance()
        val configSettings =
            remoteConfigSettings {
                minimumFetchIntervalInSeconds = 60
            }
        remoteConfig.setConfigSettingsAsync(configSettings)
        remoteConfig.fetchAndActivate()
    }
}
