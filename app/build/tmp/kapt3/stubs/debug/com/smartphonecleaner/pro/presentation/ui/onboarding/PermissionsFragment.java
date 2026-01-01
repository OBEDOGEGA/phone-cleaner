package com.smartphonecleaner.pro.presentation.ui.onboarding;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\u001a\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001f\u001a\u00020\u001bH\u0002J\b\u0010 \u001a\u00020\u001bH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/smartphonecleaner/pro/presentation/ui/onboarding/PermissionsFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/smartphonecleaner/pro/databinding/FragmentPermissionsBinding;", "binding", "getBinding", "()Lcom/smartphonecleaner/pro/databinding/FragmentPermissionsBinding;", "permissionManager", "Lcom/smartphonecleaner/pro/utils/PermissionManager;", "getPermissionManager", "()Lcom/smartphonecleaner/pro/utils/PermissionManager;", "setPermissionManager", "(Lcom/smartphonecleaner/pro/utils/PermissionManager;)V", "requestPermissionsLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "", "onResume", "onViewCreated", "view", "requestPermissions", "updatePermissionStatus", "app_debug"})
public final class PermissionsFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private com.smartphonecleaner.pro.databinding.FragmentPermissionsBinding _binding;
    @javax.inject.Inject()
    public com.smartphonecleaner.pro.utils.PermissionManager permissionManager;
    @org.jetbrains.annotations.NotNull()
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> requestPermissionsLauncher = null;
    
    public PermissionsFragment() {
        super();
    }
    
    private final com.smartphonecleaner.pro.databinding.FragmentPermissionsBinding getBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.smartphonecleaner.pro.utils.PermissionManager getPermissionManager() {
        return null;
    }
    
    public final void setPermissionManager(@org.jetbrains.annotations.NotNull()
    com.smartphonecleaner.pro.utils.PermissionManager p0) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void requestPermissions() {
    }
    
    private final void updatePermissionStatus() {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}