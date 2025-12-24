package com.smartcleaner.pro.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smartcleaner.pro.domain.model.RunningApp
import com.smartcleaner.pro.domain.usecase.IBoostUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MemoryBoosterViewModel @Inject constructor(
    private val boostUseCase: IBoostUseCase
) : ViewModel() {

    private val _runningApps = MutableLiveData<List<RunningApp>>()
    val runningApps: LiveData<List<RunningApp>> = _runningApps

    private val _isBoosting = MutableLiveData<Boolean>()
    val isBoosting: LiveData<Boolean> = _isBoosting

    private val _boostResult = MutableLiveData<Long>()
    val boostResult: LiveData<Long> = _boostResult

    private val _whitelist = MutableLiveData<Set<String>>()
    val whitelist: LiveData<Set<String>> = _whitelist

    init {
        loadRunningApps()
        loadWhitelist()
    }

    private fun loadRunningApps() {
        viewModelScope.launch {
            boostUseCase.getRunningApps().collectLatest { apps ->
                _runningApps.value = apps
            }
        }
    }

    private fun loadWhitelist() {
        viewModelScope.launch {
            boostUseCase.getWhitelist().collectLatest { list ->
                _whitelist.value = list
            }
        }
    }

    fun boostMemory() {
        viewModelScope.launch {
            _isBoosting.value = true
            try {
                val freedMemory = boostUseCase.boostMemory()
                _boostResult.value = freedMemory
                loadRunningApps() // Refresh list after boost
            } catch (e: Exception) {
                // Handle error
            } finally {
                _isBoosting.value = false
            }
        }
    }

    fun toggleWhitelist(packageName: String) {
        viewModelScope.launch {
            boostUseCase.toggleWhitelist(packageName)
            loadRunningApps() // Refresh to update whitelist status
        }
    }

    fun scheduleAutoBoost(intervalHours: Int) {
        viewModelScope.launch {
            boostUseCase.scheduleAutoBoost(intervalHours)
        }
    }

    fun cancelAutoBoost() {
        viewModelScope.launch {
            boostUseCase.cancelAutoBoost()
        }
    }
}