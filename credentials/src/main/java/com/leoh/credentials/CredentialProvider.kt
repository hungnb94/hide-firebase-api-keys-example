package com.leoh.credentials

class CredentialProvider {
    external fun getApiKey(): String

    external fun getApplicationId(): String

    external fun getDatabaseUrl(): String

    external fun getGcmSenderId(): String

    external fun getStorageBucket(): String

    external fun getProjectId(): String

    companion object {
        // Used to load the 'credentials' library on application startup.
        init {
            System.loadLibrary("credentials")
        }
    }
}
