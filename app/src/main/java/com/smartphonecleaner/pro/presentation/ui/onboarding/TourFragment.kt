package com.smartphonecleaner.pro.presentation.ui.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.smartphonecleaner.pro.R
import com.smartphonecleaner.pro.databinding.FragmentTourBinding

class TourFragment : Fragment() {

    private var _binding: FragmentTourBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTourBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvTitle.text = getString(R.string.tour_title)
        binding.tvDescription.text = getString(R.string.tour_description)

        // Add feature highlights
        binding.tvFeature1.text = getString(R.string.feature_clean)
        binding.tvFeature2.text = getString(R.string.feature_boost)
        binding.tvFeature3.text = getString(R.string.feature_analyze)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}