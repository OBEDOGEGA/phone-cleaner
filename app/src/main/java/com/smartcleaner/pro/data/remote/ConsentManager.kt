package com.smartcleaner.pro.data.remote

import android.app.Activity
import android.content.Context
import android.util.Log
import com.google.android.ump.ConsentDebugSettings
import com.google.android.ump.ConsentForm
import com.google.android.ump.ConsentInformation
import com.google.android.ump.ConsentRequestParameters
import com.google.android.ump.UserMessagingPlatform
import com.smartcleaner.pro.data.local.UserPreference
import com.smartcleaner.pro.data.local.UserPreferenceDao
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.coroutines.resume

@Singleton
class ConsentManager @Inject constructor(
    @ApplicationContext private val context: Context,
    private val userPreferenceDao: UserPreferenceDao
) {

    private val TAG = "ConsentManager"

    private val consentInformation: ConsentInformation = UserMessagingPlatform.getConsentInformation(context)

    private var consentForm: ConsentForm? = null

    // Keys for storing consent status
    private val CONSENT_STATUS_KEY = "consent_status"
    private val CONSENT_GIVEN_KEY = "consent_given"

    init {
        // Load stored consent status
        CoroutineScope(Dispatchers.IO).launch {
            val status = getStoredConsentStatus()
            val given = getStoredConsentGiven()
            Log.d(TAG, "Loaded consent status: $status, given: $given")
        }
    }

    /**
     * Initialize consent and show form if needed
     */
    fun initializeConsent(activity: Activity, onConsentComplete: (() -> Unit)? = null) {
        val params = ConsentRequestParameters.Builder()
            .setTagForUnderAgeOfConsent(false)
            .build()

        consentInformation.requestConsentInfoUpdate(
            activity,
            params,
            {
                Log.d(TAG, "Consent info updated")
                if (consentInformation.isConsentFormAvailable) {
                    loadAndShowConsentForm(activity, onConsentComplete)
                } else {
                    Log.d(TAG, "Consent form not available")
                    storeConsentStatus("not_available")
                    onConsentComplete?.invoke()
                }
            },
            { error ->
                Log.e(TAG, "Consent info update failed: ${error.message}")
                storeConsentStatus("error")
                onConsentComplete?.invoke()
            }
        )
    }

    private fun loadAndShowConsentForm(activity: Activity, onConsentComplete: (() -> Unit)? = null) {
        UserMessagingPlatform.loadConsentForm(
            context,
            { form ->
                consentForm = form
                Log.d(TAG, "Consent form loaded")
                showConsentForm(activity, onConsentComplete)
            },
            { error ->
                Log.e(TAG, "Consent form load failed: ${error.message}")
                storeConsentStatus("load_failed")
                onConsentComplete?.invoke()
            }
        )
    }

    private fun showConsentForm(activity: Activity, onConsentComplete: (() -> Unit)? = null) {
        consentForm?.show(activity) { formError ->
            if (formError != null) {
                Log.e(TAG, "Consent form show failed: ${formError.message}")
                storeConsentStatus("show_failed")
            } else {
                Log.d(TAG, "Consent form completed")
                storeConsentStatus("obtained")
                storeConsentGiven(true)
            }
            onConsentComplete?.invoke()
        }
    }

    /**
     * Check if ads can be requested
     */
    fun canRequestAds(): Boolean {
        return consentInformation.canRequestAds()
    }

    /**
     * Check if personalized ads are allowed
     */
    fun isPersonalizedAdsAllowed(): Boolean {
        return consentInformation.consentStatus == ConsentInformation.ConsentStatus.OBTAINED
    }

    /**
     * Reset consent (for testing or user request)
     */
    fun resetConsent() {
        consentInformation.reset()
        storeConsentStatus("reset")
        storeConsentGiven(false)
        Log.d(TAG, "Consent reset")
    }

    private fun storeConsentStatus(status: String) {
        CoroutineScope(Dispatchers.IO).launch {
            userPreferenceDao.insert(UserPreference(key = CONSENT_STATUS_KEY, value = status))
        }
    }

    private suspend fun getStoredConsentStatus(): String {
        return withContext(Dispatchers.IO) {
            userPreferenceDao.getValueByKey(CONSENT_STATUS_KEY) ?: "unknown"
        }
    }

    private fun storeConsentGiven(given: Boolean) {
        CoroutineScope(Dispatchers.IO).launch {
            userPreferenceDao.insert(UserPreference(key = CONSENT_GIVEN_KEY, value = given.toString()))
        }
    }

    private suspend fun getStoredConsentGiven(): Boolean {
        return withContext(Dispatchers.IO) {
            userPreferenceDao.getValueByKey(CONSENT_GIVEN_KEY)?.toBoolean() ?: false
        }
    }
}