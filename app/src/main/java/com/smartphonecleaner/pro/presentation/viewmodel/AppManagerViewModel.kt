package com.smartphonecleaner.pro.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smartphonecleaner.pro.domain.model.AppInfo
import com.smartphonecleaner.pro.domain.usecase.IAnalyzeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppManagerViewModel @Inject constructor(
    private val analyzeUseCase: IAnalyzeUseCase
) : BaseViewModel() {

    private val _apps = MutableStateFlow<List<AppInfo>>(emptyList())
    val apps: StateFlow<List<AppInfo>> = _apps

    private val _filteredApps = MutableStateFlow<List<AppInfo>>(emptyList())
    val filteredApps: StateFlow<List<AppInfo>> = _filteredApps

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _selectedApps = MutableLiveData<Set<String>>(emptySet())
    val selectedApps: LiveData<Set<String>> = _selectedApps

    private val _sortBy = MutableLiveData<SortBy>(SortBy.NAME)
    val sortBy: LiveData<SortBy> = _sortBy

    private val _filterBy = MutableLiveData<FilterBy>(FilterBy.ALL)
    val filterBy: LiveData<FilterBy> = _filterBy

    init {
        loadApps()
    }

    fun loadApps() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                analyzeUseCase.getInstalledApps().collectLatest { appList ->
                    _apps.value = appList
                    applyFiltersAndSorting()
                }
            } catch (e: Exception) {
                // Handle error
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun setSortBy(sortBy: SortBy) {
        _sortBy.value = sortBy
        applyFiltersAndSorting()
    }

    fun setFilterBy(filterBy: FilterBy) {
        _filterBy.value = filterBy
        applyFiltersAndSorting()
    }

    fun toggleAppSelection(packageName: String) {
        val currentSelected = _selectedApps.value ?: emptySet()
        val newSelected = if (currentSelected.contains(packageName)) {
            currentSelected - packageName
        } else {
            currentSelected + packageName
        }
        _selectedApps.value = newSelected
    }

    fun selectAllApps() {
        _selectedApps.value = _filteredApps.value.map { it.packageName }.toSet()
    }

    fun clearSelection() {
        _selectedApps.value = emptySet()
    }

    fun uninstallSelectedApps() {
        viewModelScope.launch {
            val selected = _selectedApps.value ?: emptySet()
            selected.forEach { packageName ->
                analyzeUseCase.uninstallApp(packageName)
            }
            clearSelection()
            loadApps() // Refresh the list
        }
    }

    fun getAppDetails(packageName: String): LiveData<AppInfo?> {
        val liveData = MutableLiveData<AppInfo?>()
        viewModelScope.launch {
            val appInfo = analyzeUseCase.getAppDetails(packageName)
            liveData.value = appInfo
        }
        return liveData
    }

    fun uninstallApp(packageName: String) {
        viewModelScope.launch {
            analyzeUseCase.uninstallApp(packageName)
            loadApps() // Refresh the list
        }
    }

    fun moveAppToSdCard(packageName: String) {
        viewModelScope.launch {
            analyzeUseCase.moveAppToSdCard(packageName)
        }
    }

    private fun applyFiltersAndSorting() {
        var filteredList = when (_filterBy.value) {
            FilterBy.ALL -> _apps.value
            FilterBy.USER -> _apps.value.filter { !it.isSystemApp }
            FilterBy.SYSTEM -> _apps.value.filter { it.isSystemApp }
            null -> _apps.value
        }

        filteredList = when (_sortBy.value) {
            SortBy.NAME -> filteredList.sortedBy { it.appName }
            SortBy.SIZE -> filteredList.sortedByDescending { it.size }
            SortBy.LAST_USED -> filteredList.sortedByDescending { it.lastUpdateTime }
            null -> filteredList
        }

        _filteredApps.value = filteredList
    }

    enum class SortBy {
        NAME, SIZE, LAST_USED
    }

    enum class FilterBy {
        ALL, USER, SYSTEM
    }
}