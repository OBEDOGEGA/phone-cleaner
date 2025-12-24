package com.smartcleaner.pro.presentation.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.ApplicationProvider
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class DashboardViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: DashboardViewModel

    @Before
    fun setUp() {
        val application = ApplicationProvider.getApplicationContext<android.app.Application>()
        viewModel = DashboardViewModel(application)
    }

    @Test
    fun `init loads mock stats`() {
        assertEquals("2.5 GB", viewModel.todaySavings.value)
        assertEquals("85%", viewModel.weeklyPerformance.value)
    }

    @Test
    fun `battery level is loaded`() {
        // Robolectric simulates battery
        assertNotNull(viewModel.batteryLevel.value)
    }

    @Test
    fun `storage info is loaded`() {
        assertNotNull(viewModel.totalStorage.value)
        assertNotNull(viewModel.storageUsed.value)
    }
}