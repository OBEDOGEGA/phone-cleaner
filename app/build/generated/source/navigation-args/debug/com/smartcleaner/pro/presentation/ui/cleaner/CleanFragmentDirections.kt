package com.smartcleaner.pro.presentation.ui.cleaner

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.smartcleaner.pro.R

public class CleanFragmentDirections private constructor() {
  public companion object {
    public fun actionCleanFragmentToSummaryFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_cleanFragment_to_summaryFragment)
  }
}
