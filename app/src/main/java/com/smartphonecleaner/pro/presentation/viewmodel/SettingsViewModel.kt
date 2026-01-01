package com.smartphonecleaner.pro.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smartphonecleaner.pro.domain.usecase.ICleanUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val cleanUseCase: ICleanUseCase
) : ViewModel() {

    fun scheduleAutoClean(intervalHours: Int) {
        viewModelScope.launch {
            cleanUseCase.scheduleAutoClean(intervalHours)
        }
    }

    fun cancelAutoClean() {
        viewModelScope.launch {
            cleanUseCase.cancelAutoClean()
        }
    }
}