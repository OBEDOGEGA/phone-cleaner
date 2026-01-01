package com.smartphonecleaner.pro.utils

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.provider.Settings
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.smartphonecleaner.pro.R

class PermissionManager(private val context: Context) {

    companion object {
        val REQUIRED_PERMISSIONS = arrayOf(
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.MANAGE_EXTERNAL_STORAGE, // For Android 11+
            Manifest.permission.QUERY_ALL_PACKAGES,
            Manifest.permission.REQUEST_DELETE_PACKAGES,
            Manifest.permission.KILL_BACKGROUND_PROCESSES
        )

        // Special permissions that need system settings
        const val PACKAGE_USAGE_STATS = "android.permission.PACKAGE_USAGE_STATS"
        const val BATTERY_STATS = "android.permission.BATTERY_STATS"
    }

    fun hasAllPermissions(): Boolean {
        val regularPermissionsGranted = REQUIRED_PERMISSIONS.all { permission ->
            if (permission == Manifest.permission.MANAGE_EXTERNAL_STORAGE) {
                // Special check for MANAGE_EXTERNAL_STORAGE
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                    android.os.Environment.isExternalStorageManager()
                } else {
                    ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED
                }
            } else {
                ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED
            }
        }
        return regularPermissionsGranted && hasPackageUsageStatsPermission() && hasBatteryStatsPermission()
    }

    fun hasPackageUsageStatsPermission(): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            try {
                val appOps = context.getSystemService(Context.APP_OPS_SERVICE) as android.app.AppOpsManager
                val mode = appOps.checkOpNoThrow(
                    android.app.AppOpsManager.OPSTR_GET_USAGE_STATS,
                    android.os.Process.myUid(),
                    context.packageName
                )
                mode == android.app.AppOpsManager.MODE_ALLOWED
            } catch (e: Exception) {
                false
            }
        } else {
            true
        }
    }

    fun hasBatteryStatsPermission(): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            try {
                val appOps = context.getSystemService(Context.APP_OPS_SERVICE) as android.app.AppOpsManager
                val mode = appOps.checkOpNoThrow(
                    android.app.AppOpsManager.OPSTR_READ_PHONE_STATE, // Battery stats might use this
                    android.os.Process.myUid(),
                    context.packageName
                )
                mode == android.app.AppOpsManager.MODE_ALLOWED
            } catch (e: Exception) {
                false
            }
        } else {
            true
        }
    }

    fun requestPermissions(activity: Activity, launcher: ActivityResultLauncher<Array<String>>) {
        val missingPermissions = REQUIRED_PERMISSIONS.filter { permission ->
            // Skip MANAGE_EXTERNAL_STORAGE as it needs special handling
            permission != Manifest.permission.MANAGE_EXTERNAL_STORAGE &&
            ContextCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED
        }.toTypedArray()

        if (missingPermissions.isNotEmpty()) {
            launcher.launch(missingPermissions)
        }

        // Handle MANAGE_EXTERNAL_STORAGE separately for Android 11+
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R &&
            !android.os.Environment.isExternalStorageManager()) {
            requestManageExternalStoragePermission(activity)
        }
    }

    fun requestPackageUsageStatsPermission(activity: Activity) {
        if (!hasPackageUsageStatsPermission()) {
            showPermissionRationaleDialog(activity, "Usage Access", "This permission is required to analyze app usage statistics.") {
                val intent = Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS)
                activity.startActivity(intent)
            }
        }
    }

    fun requestBatteryStatsPermission(activity: Activity) {
        if (!hasBatteryStatsPermission()) {
            showPermissionRationaleDialog(activity, "Battery Stats", "This permission is required to monitor battery usage.") {
                val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
                    data = Uri.parse("package:${context.packageName}")
                }
                activity.startActivity(intent)
            }
        }
    }

    fun requestManageExternalStoragePermission(activity: Activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && !android.os.Environment.isExternalStorageManager()) {
            showPermissionRationaleDialog(activity, "All Files Access", "This permission is required to clean all files on your device.") {
                val intent = Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION).apply {
                    data = Uri.parse("package:${context.packageName}")
                }
                activity.startActivity(intent)
            }
        }
    }

    private fun showPermissionRationaleDialog(activity: Activity, title: String, message: String, onPositive: () -> Unit) {
        AlertDialog.Builder(activity)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("Grant") { _, _ -> onPositive() }
            .setNegativeButton("Deny", null)
            .show()
    }

    fun shouldShowRationale(activity: Activity, permission: String): Boolean {
        return ActivityCompat.shouldShowRequestPermissionRationale(activity, permission)
    }
}