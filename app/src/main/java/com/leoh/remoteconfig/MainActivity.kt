package com.leoh.remoteconfig

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.remoteconfig.FirebaseRemoteConfig

class MainActivity : AppCompatActivity() {
    private lateinit var tvMessage: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        tvMessage = findViewById(R.id.tvMessage)
        showConfig()
    }

    private fun showConfig() {
        tvMessage.text = getString(R.string.message_config, getMessage())
    }

//    private fun getMessage(): String = FirebaseRemoteConfig.getInstance().getString("message")
    private fun getMessage(): String = FirebaseRemoteConfig.getInstance(getApp().firebaseApp).getString("message")

    private fun getApp() = application as App

    private fun isSecureEnable(): Boolean = FirebaseRemoteConfig.getInstance().getBoolean("flag_secure")
}
