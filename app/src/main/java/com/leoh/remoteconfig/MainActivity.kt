package com.leoh.remoteconfig

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.analytics.analytics
import com.google.firebase.crashlytics.crashlytics
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

private const val TAG = "MainActivity"

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
        val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss XXX", Locale.US)
        tvMessage.setOnClickListener {
            val time = dateFormat.format(Date())
            Firebase.crashlytics.recordException(Exception("Test crash at $time"))
            Firebase.analytics.logEvent(
                "click_button",
                Bundle().apply {
                    putString("time", time)
                },
            )
            Log.w(TAG, "Log event to firebase analytics")
        }
        showConfig()
    }

    private fun showConfig() {
        tvMessage.text = getString(R.string.message_config, getMessage())
    }

    private fun getMessage(): String = FirebaseRemoteConfig.getInstance().getString("message")

    private fun getApp() = application as App
}
