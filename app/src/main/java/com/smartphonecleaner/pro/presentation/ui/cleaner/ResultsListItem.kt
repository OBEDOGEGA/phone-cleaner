package com.smartphonecleaner.pro.presentation.ui.cleaner

import com.google.android.gms.ads.nativead.NativeAd
import com.smartphonecleaner.pro.domain.model.JunkItem

sealed class ResultsListItem {
    data class JunkItemWrapper(val junkItem: JunkItem) : ResultsListItem()
    data class AdItem(val nativeAd: NativeAd?) : ResultsListItem()
}