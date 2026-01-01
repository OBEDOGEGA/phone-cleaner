package com.smartphonecleaner.pro.presentation.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.smartphonecleaner.pro.domain.model.JunkItem
import com.smartphonecleaner.pro.domain.model.JunkType
import com.smartphonecleaner.pro.domain.usecase.ICleanUseCase
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.io.File

@ExperimentalCoroutinesApi
class CleanerViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val testDispatcher = TestCoroutineDispatcher()

    private lateinit var cleanUseCase: ICleanUseCase

    private lateinit var viewModel: CleanerViewModel

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        cleanUseCase = mockk()
        viewModel = CleanerViewModel(cleanUseCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }

    @Test
    fun `startScanning updates progress and junk items`() = testDispatcher.runBlockingTest {
        val junkItems = listOf(
            JunkItem(File("test1"), 100L, JunkType.CACHE, "Cache")
        )
        coEvery { cleanUseCase.scanForJunk() } returns flowOf(junkItems)

        viewModel.startScanning()

        advanceTimeBy(2200) // simulate time for progress

        assertEquals(100, viewModel.scanProgress.value)
        assertFalse(viewModel.isScanning.value!!)
        assertEquals(junkItems, viewModel.junkItems.value)
        assertEquals(100L, viewModel.totalJunkSize.value)
    }

    @Test
    fun `startCleaning cleans selected items and updates progress`() = testDispatcher.runBlockingTest {
        val selectedItems = listOf(
            JunkItem(File("test1"), 100L, JunkType.CACHE, "Cache")
        )
        coEvery { cleanUseCase.cleanJunk(selectedItems) } returns 100L

        viewModel.startCleaning(selectedItems)

        advanceTimeBy(3000)

        assertEquals(100, viewModel.cleanProgress.value)
        assertFalse(viewModel.isCleaning.value!!)
        assertEquals(100L, viewModel.spaceSaved.value)
        coVerify { cleanUseCase.cleanJunk(selectedItems) }
    }

    @Test
    fun `getSelectedItems returns selected junk items`() {
        val item1 = JunkItem(File("test1"), 100L, JunkType.CACHE, "Cache", isSelected = true)
        val item2 = JunkItem(File("test2"), 200L, JunkType.APK, "Apk", isSelected = false)
        viewModel._junkItems.value = listOf(item1, item2)

        val selected = viewModel.getSelectedItems()

        assertEquals(1, selected.size)
        assertEquals(item1, selected[0])
    }

    @Test
    fun `getTotalSelectedSize returns sum of selected items size`() {
        val item1 = JunkItem(File("test1"), 100L, JunkType.CACHE, "Cache", isSelected = true)
        val item2 = JunkItem(File("test2"), 200L, JunkType.APK, "Apk", isSelected = true)
        val item3 = JunkItem(File("test3"), 300L, JunkType.RESIDUAL, "Residual", isSelected = false)
        viewModel._junkItems.value = listOf(item1, item2, item3)

        val totalSize = viewModel.getTotalSelectedSize()

        assertEquals(300L, totalSize)
    }
}