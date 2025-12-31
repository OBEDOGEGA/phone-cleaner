package com.smartcleaner.pro.presentation.ui.cleaner

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.smartcleaner.pro.R

public class ResultsFragmentDirections private constructor() {
  public companion object {
    public fun actionResultsFragmentToCleanFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_resultsFragment_to_cleanFragment)
  }
}
