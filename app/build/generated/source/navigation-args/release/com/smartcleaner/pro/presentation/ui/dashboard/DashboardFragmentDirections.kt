package com.smartcleaner.pro.presentation.ui.dashboard

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.smartcleaner.pro.R

public class DashboardFragmentDirections private constructor() {
  public companion object {
    public fun actionDashboardFragmentToScanFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_dashboardFragment_to_scanFragment)
  }
}
