package com.smartphonecleaner.pro.presentation.ui.cleaner

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.smartphonecleaner.pro.R

public class ScanFragmentDirections private constructor() {
  public companion object {
    public fun actionScanFragmentToResultsFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_scanFragment_to_resultsFragment)
  }
}
