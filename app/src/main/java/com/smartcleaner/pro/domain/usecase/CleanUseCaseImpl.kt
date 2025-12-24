package com.smartcleaner.pro.domain.usecase

import com.smartcleaner.pro.domain.model.JunkItem
import com.smartcleaner.pro.domain.repository.ICleanRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CleanUseCaseImpl @Inject constructor(
    private val cleanRepository: ICleanRepository
) : ICleanUseCase {

    override fun scanForJunk(): Flow<List<JunkItem>> {
        return cleanRepository.scanForJunk()
    }

    override suspend fun cleanJunk(items: List<JunkItem>): Long {
        return cleanRepository.cleanJunk(items)
    }

    override suspend fun getTotalJunkSize(): Long {
        return cleanRepository.getTotalJunkSize()
    }
}