package com.smartcleaner.pro.presentation.ui.appmanager

import android.os.Bundle
import androidx.navigation.NavDirections
import com.smartcleaner.pro.R
import kotlin.Int
import kotlin.String

public class AppListFragmentDirections private constructor() {
  private data class ActionAppListFragmentToAppDetailFragment(
    public val packageName: String,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_appListFragment_to_appDetailFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("packageName", this.packageName)
        return result
      }
  }

  public companion object {
    public fun actionAppListFragmentToAppDetailFragment(packageName: String): NavDirections =
        ActionAppListFragmentToAppDetailFragment(packageName)
  }
}
