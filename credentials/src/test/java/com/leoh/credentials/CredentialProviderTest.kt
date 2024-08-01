package com.leoh.credentials

import org.junit.Assert.assertNotNull
import org.junit.Test

class CredentialProviderTest {
    private val credentialProvider = CredentialProvider()

    @Test
    fun getApiKey() {
        assertNotNull(credentialProvider.getApiKey())
    }

    @Test
    fun getApplicationId() {
        assertNotNull(credentialProvider.getApplicationId())
    }

    @Test
    fun getDatabaseUrl() {
        assertNotNull(credentialProvider.getDatabaseUrl())
    }

    @Test
    fun getGcmSenderId() {
        assertNotNull(credentialProvider.getGcmSenderId())
    }

    @Test
    fun getStorageBucket() {
        assertNotNull(credentialProvider.getStorageBucket())
    }

    @Test
    fun getProjectId() {
        assertNotNull(credentialProvider.getProjectId())
    }
}
