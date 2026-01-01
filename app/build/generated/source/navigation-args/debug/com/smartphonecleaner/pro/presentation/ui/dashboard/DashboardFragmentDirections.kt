package com.smartphonecleaner.pro.presentation.ui.dashboard

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.smartphonecleaner.pro.R

public class DashboardFragmentDirections private constructor() {
  public companion object {
    public fun actionDashboardFragmentToScanFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_dashboardFragment_to_scanFragment)

    public fun actionDashboardFragmentToBatteryFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_dashboardFragment_to_batteryFragment)

    public fun actionDashboardFragmentToBoostFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_dashboardFragment_to_boostFragment)

    public fun actionDashboardFragmentToAppListFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_dashboardFragment_to_appListFragment)
  }
}
