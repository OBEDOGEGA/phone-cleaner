package com.smartphonecleaner.pro.presentation.ui.appmanager

import com.google.android.gms.ads.nativead.NativeAd
import com.smartphonecleaner.pro.domain.model.AppInfo

sealed class AppListItem {
    data class AppItem(val appInfo: AppInfo) : AppListItem()
    data class AdItem(val nativeAd: NativeAd?) : AppListItem()
}