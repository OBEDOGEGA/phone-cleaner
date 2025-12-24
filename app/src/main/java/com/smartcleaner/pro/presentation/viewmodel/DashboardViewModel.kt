package com.smartcleaner.pro.presentation.viewmodel

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
        loadBatteryInfo()
        loadStorageInfo()
        loadMockStats()
    }

    private fun loadBatteryInfo() {
        val context = getApplication<Application>()
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

    private fun loadStorageInfo() {
        val stat = StatFs("/data")
        val blockSize = stat.blockSizeLong
        val totalBlocks = stat.blockCountLong
        val availableBlocks = stat.availableBlocksLong

        val totalStorage = totalBlocks * blockSize
        val usedStorage = (totalBlocks - availableBlocks) * blockSize

        _totalStorage.value = totalStorage
        _storageUsed.value = usedStorage
    }

    private fun loadMockStats() {
        _todaySavings.value = "2.5 GB"
        _weeklyPerformance.value = "85%"
    }
}