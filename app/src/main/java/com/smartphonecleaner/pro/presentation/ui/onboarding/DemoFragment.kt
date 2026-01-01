package com.smartphonecleaner.pro.presentation.ui.onboarding

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.smartphonecleaner.pro.R
import com.smartphonecleaner.pro.databinding.FragmentDemoBinding

class DemoFragment : Fragment() {

    private var _binding: FragmentDemoBinding? = null
    private val binding get() = _binding!!
    private val handler = Handler(Looper.getMainLooper())
    private var progress = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDemoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvTitle.text = getString(R.string.demo_title)
        binding.tvDescription.text = getString(R.string.demo_description)

        startMockScan()
    }

    private fun startMockScan() {
        binding.progressBar.visibility = View.VISIBLE
        binding.tvScanStatus.text = getString(R.string.scanning)

        val runnable = object : Runnable {
            override fun run() {
                progress += 10
                binding.progressBar.progress = progress
                binding.tvScanStatus.text = getString(R.string.scanning_progress, progress)

                if (progress >= 100) {
                    binding.tvScanStatus.text = getString(R.string.scan_complete)
                    binding.progressBar.visibility = View.GONE
                } else {
                    handler.postDelayed(this, 500)
                }
            }
        }
        handler.post(runnable)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        handler.removeCallbacksAndMessages(null)
        _binding = null
    }
}