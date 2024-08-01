#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_leoh_credentials_CredentialProvider_getApiKey(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "AIzaSyBhH6gE7wb_rAGW8iv49OyeRBJreQEwIs0";
    return env->NewStringUTF(hello.c_str());
}

extern "C" JNIEXPORT jstring JNICALL
Java_com_leoh_credentials_CredentialProvider_getApplicationId(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "1:185353233953:android:27852780e95accdcca2560";
    return env->NewStringUTF(hello.c_str());
}

extern "C" JNIEXPORT jstring JNICALL
Java_com_leoh_credentials_CredentialProvider_getDatabaseUrl(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "https://cleanarchitecture-49552.firebaseio.com";
    return env->NewStringUTF(hello.c_str());
}

extern "C" JNIEXPORT jstring JNICALL
Java_com_leoh_credentials_CredentialProvider_getGcmSenderId(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "185353233953";
    return env->NewStringUTF(hello.c_str());
}

extern "C" JNIEXPORT jstring JNICALL
Java_com_leoh_credentials_CredentialProvider_getStorageBucket(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "cleanarchitecture-49552.appspot.com";
    return env->NewStringUTF(hello.c_str());
}

extern "C" JNIEXPORT jstring JNICALL
Java_com_leoh_credentials_CredentialProvider_getProjectId(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "cleanarchitecture-49552";
    return env->NewStringUTF(hello.c_str());
}