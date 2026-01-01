package com.smartcleaner.pro.presentation.ui.boost

import android.content.Context
import android.os.Bundle
import android.os.Vibrator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.smartcleaner.pro.databinding.FragmentMemoryBoosterBinding
import com.smartcleaner.pro.presentation.viewmodel.MemoryBoosterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MemoryBoosterFragment : Fragment() {

    private var _binding: FragmentMemoryBoosterBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MemoryBoosterViewModel by viewModels()
    private lateinit var adapter: RunningAppAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMemoryBoosterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        setupObservers()
        setupClickListeners()
    }

    private fun setupRecyclerView() {
        adapter = RunningAppAdapter { packageName ->
            viewModel.toggleWhitelist(packageName)
        }
        binding.runningAppsRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.runningAppsRecyclerView.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.runningApps.observe(viewLifecycleOwner) { apps ->
            adapter.submitList(apps)
        }

        viewModel.isBoosting.observe(viewLifecycleOwner) { isBoosting ->
            binding.boostButton.isEnabled = !isBoosting
            binding.boostProgressBar.visibility = if (isBoosting) View.VISIBLE else View.GONE
        }

        viewModel.boostResult.observe(viewLifecycleOwner) { freedMemory ->
            Toast.makeText(requireContext(), "Freed ${freedMemory / 1024} MB", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupClickListeners() {
        binding.boostButton.setOnClickListener {
            // Check KILL_BACKGROUND_PROCESSES permission before boosting
            val hasKillPermission = android.content.pm.PackageManager.PERMISSION_GRANTED ==
                requireContext().checkSelfPermission(android.Manifest.permission.KILL_BACKGROUND_PROCESSES)

            if (!hasKillPermission) {
                android.widget.Toast.makeText(
                    requireContext(),
                    "Memory boost permission not granted. Please grant it in settings.",
                    android.widget.Toast.LENGTH_LONG
                ).show()
                return@setOnClickListener
            }

            performHapticFeedback()
            viewModel.boostMemory()
        }
    }

    private fun performHapticFeedback() {
        val vibrator = requireContext().getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        vibrator.vibrate(50)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}