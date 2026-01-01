package com.smartphonecleaner.pro.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smartphonecleaner.pro.domain.model.JunkItem
import com.smartphonecleaner.pro.domain.usecase.ICleanUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CleanerViewModel @Inject constructor(
    private val cleanUseCase: ICleanUseCase
) : ViewModel() {

    private val _scanProgress = MutableLiveData<Int>()
    val scanProgress: LiveData<Int> = _scanProgress

    private val _isScanning = MutableLiveData<Boolean>()
    val isScanning: LiveData<Boolean> = _isScanning

    private val _junkItems = MutableStateFlow<List<JunkItem>>(emptyList())
    val junkItems: StateFlow<List<JunkItem>> = _junkItems

    private val _totalJunkSize = MutableLiveData<Long>()
    val totalJunkSize: LiveData<Long> = _totalJunkSize

    private val _isCleaning = MutableLiveData<Boolean>()
    val isCleaning: LiveData<Boolean> = _isCleaning

    private val _cleanProgress = MutableLiveData<Int>()
    val cleanProgress: LiveData<Int> = _cleanProgress

    private val _spaceSaved = MutableLiveData<Long>()
    val spaceSaved: LiveData<Long> = _spaceSaved

    private val _cleanTime = MutableLiveData<Long>()
    val cleanTime: LiveData<Long> = _cleanTime

    private val _filesCleaned = MutableLiveData<Int>()
    val filesCleaned: LiveData<Int> = _filesCleaned

    private var scanJob: Job? = null
    private var cleanJob: Job? = null

    fun startScanning() {
        if (scanJob?.isActive == true) return

        android.util.Log.d("CleanerViewModel", "Starting scanning process")
        scanJob = viewModelScope.launch {
            _isScanning.value = true
            _scanProgress.value = 0

            // Simulate scanning progress
            for (i in 0..100 step 10) {
                _scanProgress.value = i
                android.util.Log.d("CleanerViewModel", "Scan progress: $i%")
                delay(200)
            }

            android.util.Log.d("CleanerViewModel", "Starting actual junk scan")
            val startTime = System.currentTimeMillis()
            // Get actual junk items
            cleanUseCase.scanForJunk().collect { items ->
                val scanTime = System.currentTimeMillis() - startTime
                android.util.Log.d("CleanerViewModel", "Scan completed in ${scanTime}ms, found ${items.size} items")
                _junkItems.value = items
                val totalSize = items.sumOf { it.size }
                _totalJunkSize.value = totalSize
                android.util.Log.d("CleanerViewModel", "Total junk size: $totalSize bytes")
            }

            _scanProgress.value = 100
            _isScanning.value = false
            android.util.Log.d("CleanerViewModel", "Scanning process finished")
        }
    }

    fun stopScanning() {
        scanJob?.cancel()
        _isScanning.value = false
    }

    fun startCleaning(selectedItems: List<JunkItem>) {
        if (cleanJob?.isActive == true) return

        cleanJob = viewModelScope.launch {
            _isCleaning.value = true
            _cleanProgress.value = 0

            val startTime = System.currentTimeMillis()

            // Simulate cleaning progress
            for (i in 0..90 step 10) {
                _cleanProgress.value = i
                delay(300)
            }

            // Perform actual cleaning
            val cleanedSize = cleanUseCase.cleanJunk(selectedItems)
            _spaceSaved.value = cleanedSize
            _filesCleaned.value = selectedItems.size

            val endTime = System.currentTimeMillis()
            _cleanTime.value = endTime - startTime

            _cleanProgress.value = 100
            _isCleaning.value = false
        }
    }

    fun stopCleaning() {
        cleanJob?.cancel()
        _isCleaning.value = false
    }

    fun updateJunkItemSelection(item: JunkItem, isSelected: Boolean) {
        val currentItems = _junkItems.value.toMutableList()
        val index = currentItems.indexOfFirst { it.file.absolutePath == item.file.absolutePath }
        if (index != -1) {
            currentItems[index] = item.copy(isSelected = isSelected)
            _junkItems.value = currentItems
        }
    }

    fun getSelectedItems(): List<JunkItem> {
        return _junkItems.value.filter { it.isSelected }
    }

    fun getTotalSelectedSize(): Long {
        return getSelectedItems().sumOf { it.size }
    }

    override fun onCleared() {
        super.onCleared()
        scanJob?.cancel()
        cleanJob?.cancel()
    }
}