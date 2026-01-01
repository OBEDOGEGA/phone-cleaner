package com.smartphonecleaner.pro.presentation.ui.appmanager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.smartphonecleaner.pro.databinding.FragmentAppDetailBinding
import com.smartphonecleaner.pro.presentation.common.BaseFragment
import com.smartphonecleaner.pro.presentation.viewmodel.AppManagerViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class AppDetailFragment : BaseFragment() {

    private var _binding: FragmentAppDetailBinding? = null
    private val binding get() = _binding!!

    private val viewModel: AppManagerViewModel by viewModels()
    private lateinit var permissionsAdapter: PermissionsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAppDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val packageName = arguments?.getString("packageName") ?: return

        setupPermissionsRecyclerView()
        setupActionButtons(packageName)
        loadAppDetails(packageName)
    }

    private fun setupPermissionsRecyclerView() {
        permissionsAdapter = PermissionsAdapter()
        binding.permissionsRecycler.layoutManager = LinearLayoutManager(requireContext())
        binding.permissionsRecycler.adapter = permissionsAdapter
    }

    private fun setupActionButtons(packageName: String) {
        binding.uninstallBtn.setOnClickListener {
            viewModel.uninstallApp(packageName)
            requireActivity().onBackPressed()
        }

        binding.moveToSdBtn.setOnClickListener {
            viewModel.moveAppToSdCard(packageName)
        }
    }

    private fun loadAppDetails(packageName: String) {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getAppDetails(packageName).observe(viewLifecycleOwner) { appInfo ->
                appInfo?.let { displayAppDetails(it) }
            }
        }
    }

    private fun displayAppDetails(appInfo: com.smartphonecleaner.pro.domain.model.AppInfo) {
        binding.appIcon.setImageDrawable(appInfo.icon)
        binding.appName.text = appInfo.appName
        binding.packageName.text = appInfo.packageName
        binding.versionInfo.text = "Version: ${appInfo.versionName} (${appInfo.versionCode})"
        binding.storageInfo.text = "Total Size: ${formatSize(appInfo.size)}"
        binding.installDate.text = "Installed: ${formatDate(appInfo.firstInstallTime)}"

        // Display additional storage breakdown
        binding.cacheSize.text = "Cache: ${formatSize(appInfo.cacheSize)}"
        binding.dataSize.text = "Data: ${formatSize(appInfo.dataSize)}"
        binding.apkSize.text = "APK: ${formatSize(appInfo.apkSize)}"

        // Display SDK information
        binding.sdkInfo.text = "Target SDK: ${appInfo.targetSdkVersion} | Min SDK: ${appInfo.minSdkVersion}"

        // Display app status
        binding.appStatus.text = when {
            !appInfo.isEnabled -> "Disabled"
            appInfo.isRunning -> "Running"
            else -> "Stopped"
        }

        permissionsAdapter.submitList(appInfo.permissions)
    }

    private fun formatSize(bytes: Long): String {
        val units = arrayOf("B", "KB", "MB", "GB")
        var size = bytes.toDouble()
        var unitIndex = 0

        while (size >= 1024 && unitIndex < units.size - 1) {
            size /= 1024
            unitIndex++
        }

        return "%.1f %s".format(size, units[unitIndex])
    }

    private fun formatDate(timestamp: Long): String {
        val sdf = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault())
        return sdf.format(Date(timestamp))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}