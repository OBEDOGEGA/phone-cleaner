package com.smartphonecleaner.pro.presentation.viewmodel

import android.app.Application
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.os.StatFs
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    application: Application
) : AndroidViewModel(application) {

    private val _batteryLevel = MutableLiveData<Int>()
    val batteryLevel: LiveData<Int> = _batteryLevel

    private val _totalStorage = MutableLiveData<Long>()
    val totalStorage: LiveData<Long> = _totalStorage

    private val _storageUsed = MutableLiveData<Long>()
    val storageUsed: LiveData<Long> = _storageUsed

    private val _todaySavings = MutableLiveData<String>()
    val todaySavings: LiveData<String> = _todaySavings

    private val _weeklyPerformance = MutableLiveData<String>()
    val weeklyPerformance: LiveData<String> = _weeklyPerformance

    private val _batteryHealth = MutableLiveData<String>()
    val batteryHealth: LiveData<String> = _batteryHealth

    init {
        android.util.Log.d("DashboardViewModel", "Initializing DashboardViewModel")
        loadBatteryInfo()
        loadStorageInfo()
        loadMockStats()
        android.util.Log.d("DashboardViewModel", "DashboardViewModel initialized")
    }

    private fun loadBatteryInfo() {
        try {
            android.util.Log.d("DashboardViewModel", "Loading battery info")
            val context = getApplication<Application>()
            val batteryIntent = context.registerReceiver(null, IntentFilter(Intent.ACTION_BATTERY_CHANGED))
            if (batteryIntent != null) {
                val level = batteryIntent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
                val scale = batteryIntent.getIntExtra(BatteryManager.EXTRA_SCALE, -1)
                val batteryPct = level * 100 / scale.toFloat()
                _batteryLevel.value = batteryPct.toInt()
                android.util.Log.d("DashboardViewModel", "Battery level: $batteryPct%")

                val health = batteryIntent.getIntExtra(BatteryManager.EXTRA_HEALTH, BatteryManager.BATTERY_HEALTH_UNKNOWN)
                _batteryHealth.value = when (health) {
                    BatteryManager.BATTERY_HEALTH_GOOD -> "Good"
                    BatteryManager.BATTERY_HEALTH_OVERHEAT -> "Overheat"
                    BatteryManager.BATTERY_HEALTH_DEAD -> "Dead"
                    BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE -> "Over Voltage"
                    BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE -> "Failure"
                    BatteryManager.BATTERY_HEALTH_COLD -> "Cold"
                    else -> "Unknown"
                }
                android.util.Log.d("DashboardViewModel", "Battery health: ${_batteryHealth.value}")
            } else {
                android.util.Log.w("DashboardViewModel", "Battery intent is null")
                _batteryLevel.value = 0
                _batteryHealth.value = "Unknown"
            }
        } catch (e: Exception) {
            android.util.Log.e("DashboardViewModel", "Failed to load battery info", e)
            _batteryLevel.value = 0
            _batteryHealth.value = "Unknown"
        }
    }

    private fun loadStorageInfo() {
        try {
            android.util.Log.d("DashboardViewModel", "Loading storage info")
            val stat = StatFs("/data")
            val blockSize = stat.blockSizeLong
            val totalBlocks = stat.blockCountLong
            val availableBlocks = stat.availableBlocksLong

            val totalStorage = totalBlocks * blockSize
            val usedStorage = (totalBlocks - availableBlocks) * blockSize

            _totalStorage.value = totalStorage
            _storageUsed.value = usedStorage
            android.util.Log.d("DashboardViewModel", "Storage info loaded: total=$totalStorage, used=$usedStorage")
        } catch (e: Exception) {
            android.util.Log.e("DashboardViewModel", "Failed to load storage info", e)
            _totalStorage.value = 1L // Prevent division by zero
            _storageUsed.value = 0L
        }
    }

    private fun loadMockStats() {
        android.util.Log.d("DashboardViewModel", "Loading mock stats - todaySavings: 2.5 GB, weeklyPerformance: 85%")
        _todaySavings.value = "2.5 GB"
        _weeklyPerformance.value = "85%"
    }
}