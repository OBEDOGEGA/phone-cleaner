package com.smartcleaner.pro.presentation.ui.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.smartcleaner.pro.R
import com.smartcleaner.pro.databinding.FragmentPermissionsBinding
import com.smartcleaner.pro.utils.PermissionManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PermissionsFragment : Fragment() {

    private var _binding: FragmentPermissionsBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var permissionManager: PermissionManager

    private val requestPermissionsLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        // Handle permission results
        val allGranted = permissions.values.all { it }
        android.util.Log.d("PermissionsFragment", "Permission results: $permissions, allGranted: $allGranted")
        android.util.Log.d("PermissionsFragment", "Checking special permissions - Usage Stats: ${permissionManager.hasPackageUsageStatsPermission()}, Battery Stats: ${permissionManager.hasBatteryStatsPermission()}")
        if (allGranted && permissionManager.hasPackageUsageStatsPermission() && permissionManager.hasBatteryStatsPermission()) {
            // All permissions granted
            binding.tvStatus.text = getString(R.string.permissions_granted)
            android.util.Log.d("PermissionsFragment", "All permissions granted including special permissions")
        } else {
            // Some permissions denied
            binding.tvStatus.text = getString(R.string.permissions_denied)
            android.util.Log.w("PermissionsFragment", "Some permissions denied: ${permissions.filter { !it.value }}")
            android.util.Log.w("PermissionsFragment", "Special permissions status - Usage Stats: ${permissionManager.hasPackageUsageStatsPermission()}, Battery Stats: ${permissionManager.hasBatteryStatsPermission()}")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPermissionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvTitle.text = getString(R.string.permissions_title)
        binding.tvDescription.text = getString(R.string.permissions_description)

        binding.btnGrantPermissions.setOnClickListener {
            requestPermissions()
        }

        updatePermissionStatus()
    }

    private fun requestPermissions() {
        activity?.let { act ->
            permissionManager.requestPermissions(act, requestPermissionsLauncher)
            permissionManager.requestPackageUsageStatsPermission(act)
            permissionManager.requestBatteryStatsPermission(act)
        }
    }

    private fun updatePermissionStatus() {
        val hasAll = permissionManager.hasAllPermissions()
        android.util.Log.d("PermissionsFragment", "updatePermissionStatus: hasAllPermissions = $hasAll")
        binding.tvStatus.text = if (hasAll) {
            getString(R.string.permissions_granted)
        } else {
            getString(R.string.permissions_needed)
        }
    }

    override fun onResume() {
        super.onResume()
        updatePermissionStatus()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}