package com.smartcleaner.pro.domain.usecase

import com.smartcleaner.pro.domain.model.JunkItem
import com.smartcleaner.pro.domain.model.JunkType
import com.smartcleaner.pro.domain.repository.ICleanRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.io.File

class CleanUseCaseTest {

    private lateinit var cleanRepository: ICleanRepository
    private lateinit var cleanUseCase: CleanUseCaseImpl

    @Before
    fun setUp() {
        cleanRepository = mockk()
        cleanUseCase = CleanUseCaseImpl(cleanRepository)
    }

    @Test
    fun `scanForJunk returns flow from repository`() = runBlocking {
        val junkItems = listOf(
            JunkItem(File("test1"), 100L, JunkType.CACHE, "Cache")
        )
        coEvery { cleanRepository.scanForJunk() } returns flowOf(junkItems)

        val result = cleanUseCase.scanForJunk()

        result.collect { items ->
            assertEquals(junkItems, items)
        }

        coVerify { cleanRepository.scanForJunk() }
    }

    @Test
    fun `cleanJunk calls repository and returns size`() = runBlocking {
        val items = listOf(
            JunkItem(File("test1"), 100L, JunkType.CACHE, "Cache")
        )
        val cleanedSize = 100L
        coEvery { cleanRepository.cleanJunk(items) } returns cleanedSize

        val result = cleanUseCase.cleanJunk(items)

        assertEquals(cleanedSize, result)
        coVerify { cleanRepository.cleanJunk(items) }
    }

    @Test
    fun `getTotalJunkSize returns size from repository`() = runBlocking {
        val totalSize = 500L
        coEvery { cleanRepository.getTotalJunkSize() } returns totalSize

        val result = cleanUseCase.getTotalJunkSize()

        assertEquals(totalSize, result)
        coVerify { cleanRepository.getTotalJunkSize() }
    }
}