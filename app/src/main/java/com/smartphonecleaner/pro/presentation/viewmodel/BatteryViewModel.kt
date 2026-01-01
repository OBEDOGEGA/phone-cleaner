package com.smartphonecleaner.pro.presentation.viewmodel

import android.app.Application
import android.content.ContentResolver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.os.PowerManager
import android.provider.Settings
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BatteryViewModel @Inject constructor(
    application: Application
) : AndroidViewModel(application) {

    private val context: Context = application

    private val _batteryLevel = MutableLiveData<Int>()
    val batteryLevel: LiveData<Int> = _batteryLevel

    private val _batteryHealth = MutableLiveData<String>()
    val batteryHealth: LiveData<String> = _batteryHealth

    private val _screenTimeout = MutableLiveData<Int>()
    val screenTimeout: LiveData<Int> = _screenTimeout

    private val _isBatterySaverEnabled = MutableLiveData<Boolean>()
    val isBatterySaverEnabled: LiveData<Boolean> = _isBatterySaverEnabled

    private val _isAutoSyncEnabled = MutableLiveData<Boolean>()
    val isAutoSyncEnabled: LiveData<Boolean> = _isAutoSyncEnabled

    init {
        loadBatteryInfo()
        loadSystemSettings()
    }

    fun loadBatteryInfo() {
        val batteryIntent = context.registerReceiver(null, IntentFilter(Intent.ACTION_BATTERY_CHANGED))
        batteryIntent?.let {
            val level = it.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
            val scale = it.getIntExtra(BatteryManager.EXTRA_SCALE, -1)
            val batteryPct = level * 100 / scale.toFloat()
            _batteryLevel.value = batteryPct.toInt()

            val health = it.getIntExtra(BatteryManager.EXTRA_HEALTH, BatteryManager.BATTERY_HEALTH_UNKNOWN)
            _batteryHealth.value = when (health) {
                BatteryManager.BATTERY_HEALTH_GOOD -> "Good"
                BatteryManager.BATTERY_HEALTH_OVERHEAT -> "Overheat"
                BatteryManager.BATTERY_HEALTH_DEAD -> "Dead"
                BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE -> "Over Voltage"
                BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE -> "Failure"
                BatteryManager.BATTERY_HEALTH_COLD -> "Cold"
                else -> "Unknown"
            }
        }
    }

    fun loadSystemSettings() {
        try {
            // Load screen timeout
            val screenTimeout = Settings.System.getInt(
                context.contentResolver,
                Settings.System.SCREEN_OFF_TIMEOUT,
                30000
            )
            _screenTimeout.value = screenTimeout

            // Load battery saver status
            val powerManager = context.getSystemService(Context.POWER_SERVICE) as PowerManager
            _isBatterySaverEnabled.value = powerManager.isPowerSaveMode

            // Load auto-sync status
            val autoSync = ContentResolver.getMasterSyncAutomatically()
            _isAutoSyncEnabled.value = autoSync
        } catch (e: Exception) {
            // Handle any exceptions when reading system settings
            // Use default values if settings cannot be read
        }
    }

    fun setBatterySaverEnabled(enabled: Boolean) {
        // Note: Actually enabling/disabling battery saver requires system permissions
        // This is just for UI state management
        _isBatterySaverEnabled.value = enabled

        // In a real implementation, you would need to:
        // - Request WRITE_SECURE_SETTINGS permission (system app only)
        // - Or guide user to system settings
    }

    fun setAutoSyncEnabled(enabled: Boolean) {
        ContentResolver.setMasterSyncAutomatically(enabled)
        _isAutoSyncEnabled.value = enabled
    }

    fun setScreenTimeout(timeout: Int) {
        try {
            Settings.System.putInt(
                context.contentResolver,
                Settings.System.SCREEN_OFF_TIMEOUT,
                timeout
            )
            _screenTimeout.value = timeout
        } catch (e: Exception) {
            // Requires WRITE_SETTINGS permission
            // In real app, request permission or guide to settings
        }
    }
}