package com.smartcleaner.pro.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.smartcleaner.pro.domain.model.DuplicateFile
import com.smartcleaner.pro.domain.model.LargeFile
import com.smartcleaner.pro.domain.usecase.IAnalyzeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ToolsViewModel @Inject constructor(
    private val analyzeUseCase: IAnalyzeUseCase
) : BaseViewModel() {

    private val _duplicateFiles = MutableLiveData<List<DuplicateFile>>()
    val duplicateFiles: LiveData<List<DuplicateFile>> = _duplicateFiles

    private val _largeFiles = MutableLiveData<List<LargeFile>>()
    val largeFiles: LiveData<List<LargeFile>> = _largeFiles

    private val _isScanningDuplicates = MutableLiveData<Boolean>()
    val isScanningDuplicates: LiveData<Boolean> = _isScanningDuplicates

    private val _isScanningLargeFiles = MutableLiveData<Boolean>()
    val isScanningLargeFiles: LiveData<Boolean> = _isScanningLargeFiles

    fun scanForDuplicateFiles() {
        viewModelScope.launch {
            _isScanningDuplicates.value = true
            try {
                val duplicates = analyzeUseCase.findDuplicateFiles()
                _duplicateFiles.value = duplicates
            } catch (e: Exception) {
                // Handle error
                _duplicateFiles.value = emptyList()
            } finally {
                _isScanningDuplicates.value = false
            }
        }
    }

    fun scanForLargeFiles(minSizeBytes: Long = 100 * 1024 * 1024) {
        viewModelScope.launch {
            _isScanningLargeFiles.value = true
            try {
                val largeFiles = analyzeUseCase.findLargeFiles(minSizeBytes)
                _largeFiles.value = largeFiles
            } catch (e: Exception) {
                // Handle error
                _largeFiles.value = emptyList()
            } finally {
                _isScanningLargeFiles.value = false
            }
        }
    }
}