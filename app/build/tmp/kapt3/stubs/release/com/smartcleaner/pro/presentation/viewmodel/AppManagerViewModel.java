package com.smartcleaner.pro.presentation.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001:\u000201B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010#\u001a\u00020$H\u0002J\u0006\u0010%\u001a\u00020$J\u0016\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00192\u0006\u0010\'\u001a\u00020\u0011J\u0006\u0010(\u001a\u00020$J\u000e\u0010)\u001a\u00020$2\u0006\u0010\'\u001a\u00020\u0011J\u0006\u0010*\u001a\u00020$J\u000e\u0010+\u001a\u00020$2\u0006\u0010\u0018\u001a\u00020\u000bJ\u000e\u0010,\u001a\u00020$2\u0006\u0010!\u001a\u00020\u0013J\u000e\u0010-\u001a\u00020$2\u0006\u0010\'\u001a\u00020\u0011J\u000e\u0010.\u001a\u00020$2\u0006\u0010\'\u001a\u00020\u0011J\u0006\u0010/\u001a\u00020$R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u001d\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u001bR\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00130\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001b\u00a8\u00062"}, d2 = {"Lcom/smartcleaner/pro/presentation/viewmodel/AppManagerViewModel;", "Lcom/smartcleaner/pro/presentation/viewmodel/BaseViewModel;", "analyzeUseCase", "Lcom/smartcleaner/pro/domain/usecase/IAnalyzeUseCase;", "(Lcom/smartcleaner/pro/domain/usecase/IAnalyzeUseCase;)V", "_apps", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/smartcleaner/pro/domain/model/AppInfo;", "_filterBy", "Landroidx/lifecycle/MutableLiveData;", "Lcom/smartcleaner/pro/presentation/viewmodel/AppManagerViewModel$FilterBy;", "_filteredApps", "_isLoading", "", "_selectedApps", "", "", "_sortBy", "Lcom/smartcleaner/pro/presentation/viewmodel/AppManagerViewModel$SortBy;", "apps", "Lkotlinx/coroutines/flow/StateFlow;", "getApps", "()Lkotlinx/coroutines/flow/StateFlow;", "filterBy", "Landroidx/lifecycle/LiveData;", "getFilterBy", "()Landroidx/lifecycle/LiveData;", "filteredApps", "getFilteredApps", "isLoading", "selectedApps", "getSelectedApps", "sortBy", "getSortBy", "applyFiltersAndSorting", "", "clearSelection", "getAppDetails", "packageName", "loadApps", "moveAppToSdCard", "selectAllApps", "setFilterBy", "setSortBy", "toggleAppSelection", "uninstallApp", "uninstallSelectedApps", "FilterBy", "SortBy", "app_release"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class AppManagerViewModel extends com.smartcleaner.pro.presentation.viewmodel.BaseViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.smartcleaner.pro.domain.usecase.IAnalyzeUseCase analyzeUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.smartcleaner.pro.domain.model.AppInfo>> _apps = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.smartcleaner.pro.domain.model.AppInfo>> apps = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.smartcleaner.pro.domain.model.AppInfo>> _filteredApps = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.smartcleaner.pro.domain.model.AppInfo>> filteredApps = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.Set<java.lang.String>> _selectedApps = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.Set<java.lang.String>> selectedApps = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.smartcleaner.pro.presentation.viewmodel.AppManagerViewModel.SortBy> _sortBy = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.smartcleaner.pro.presentation.viewmodel.AppManagerViewModel.SortBy> sortBy = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.smartcleaner.pro.presentation.viewmodel.AppManagerViewModel.FilterBy> _filterBy = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.smartcleaner.pro.presentation.viewmodel.AppManagerViewModel.FilterBy> filterBy = null;
    
    @javax.inject.Inject()
    public AppManagerViewModel(@org.jetbrains.annotations.NotNull()
    com.smartcleaner.pro.domain.usecase.IAnalyzeUseCase analyzeUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.smartcleaner.pro.domain.model.AppInfo>> getApps() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.smartcleaner.pro.domain.model.AppInfo>> getFilteredApps() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> isLoading() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.Set<java.lang.String>> getSelectedApps() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.smartcleaner.pro.presentation.viewmodel.AppManagerViewModel.SortBy> getSortBy() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.smartcleaner.pro.presentation.viewmodel.AppManagerViewModel.FilterBy> getFilterBy() {
        return null;
    }
    
    public final void loadApps() {
    }
    
    public final void setSortBy(@org.jetbrains.annotations.NotNull()
    com.smartcleaner.pro.presentation.viewmodel.AppManagerViewModel.SortBy sortBy) {
    }
    
    public final void setFilterBy(@org.jetbrains.annotations.NotNull()
    com.smartcleaner.pro.presentation.viewmodel.AppManagerViewModel.FilterBy filterBy) {
    }
    
    public final void toggleAppSelection(@org.jetbrains.annotations.NotNull()
    java.lang.String packageName) {
    }
    
    public final void selectAllApps() {
    }
    
    public final void clearSelection() {
    }
    
    public final void uninstallSelectedApps() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.smartcleaner.pro.domain.model.AppInfo> getAppDetails(@org.jetbrains.annotations.NotNull()
    java.lang.String packageName) {
        return null;
    }
    
    public final void uninstallApp(@org.jetbrains.annotations.NotNull()
    java.lang.String packageName) {
    }
    
    public final void moveAppToSdCard(@org.jetbrains.annotations.NotNull()
    java.lang.String packageName) {
    }
    
    private final void applyFiltersAndSorting() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/smartcleaner/pro/presentation/viewmodel/AppManagerViewModel$FilterBy;", "", "(Ljava/lang/String;I)V", "ALL", "USER", "SYSTEM", "app_release"})
    public static enum FilterBy {
        /*public static final*/ ALL /* = new ALL() */,
        /*public static final*/ USER /* = new USER() */,
        /*public static final*/ SYSTEM /* = new SYSTEM() */;
        
        FilterBy() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public static kotlin.enums.EnumEntries<com.smartcleaner.pro.presentation.viewmodel.AppManagerViewModel.FilterBy> getEntries() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/smartcleaner/pro/presentation/viewmodel/AppManagerViewModel$SortBy;", "", "(Ljava/lang/String;I)V", "NAME", "SIZE", "LAST_USED", "app_release"})
    public static enum SortBy {
        /*public static final*/ NAME /* = new NAME() */,
        /*public static final*/ SIZE /* = new SIZE() */,
        /*public static final*/ LAST_USED /* = new LAST_USED() */;
        
        SortBy() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public static kotlin.enums.EnumEntries<com.smartcleaner.pro.presentation.viewmodel.AppManagerViewModel.SortBy> getEntries() {
            return null;
        }
    }
}