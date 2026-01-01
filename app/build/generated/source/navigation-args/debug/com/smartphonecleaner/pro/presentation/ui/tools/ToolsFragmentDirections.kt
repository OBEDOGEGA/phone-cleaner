package com.smartphonecleaner.pro.presentation.ui.tools

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.smartphonecleaner.pro.R

public class ToolsFragmentDirections private constructor() {
  public companion object {
    public fun actionToolsFragmentToDuplicateFinderFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_toolsFragment_to_duplicateFinderFragment)

    public fun actionToolsFragmentToLargeFilesFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_toolsFragment_to_largeFilesFragment)
  }
}
