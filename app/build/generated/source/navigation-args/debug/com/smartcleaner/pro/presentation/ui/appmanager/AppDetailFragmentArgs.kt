package com.smartcleaner.pro.presentation.ui.appmanager

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.String
import kotlin.jvm.JvmStatic

public data class AppDetailFragmentArgs(
  public val packageName: String,
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putString("packageName", this.packageName)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("packageName", this.packageName)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): AppDetailFragmentArgs {
      bundle.setClassLoader(AppDetailFragmentArgs::class.java.classLoader)
      val __packageName : String?
      if (bundle.containsKey("packageName")) {
        __packageName = bundle.getString("packageName")
        if (__packageName == null) {
          throw IllegalArgumentException("Argument \"packageName\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"packageName\" is missing and does not have an android:defaultValue")
      }
      return AppDetailFragmentArgs(__packageName)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): AppDetailFragmentArgs {
      val __packageName : String?
      if (savedStateHandle.contains("packageName")) {
        __packageName = savedStateHandle["packageName"]
        if (__packageName == null) {
          throw IllegalArgumentException("Argument \"packageName\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"packageName\" is missing and does not have an android:defaultValue")
      }
      return AppDetailFragmentArgs(__packageName)
    }
  }
}
