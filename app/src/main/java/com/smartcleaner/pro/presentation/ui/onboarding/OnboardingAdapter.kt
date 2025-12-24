package com.smartcleaner.pro.presentation.ui.onboarding

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class OnboardingAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> WelcomeFragment()
            1 -> PermissionsFragment()
            2 -> DemoFragment()
            3 -> TourFragment()
            else -> WelcomeFragment()
        }
    }
}