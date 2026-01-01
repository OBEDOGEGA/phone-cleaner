package com.smartphonecleaner.pro.di

import com.smartphonecleaner.pro.domain.usecase.AnalyzeUseCaseImpl
import com.smartphonecleaner.pro.domain.usecase.BoostUseCaseImpl
import com.smartphonecleaner.pro.domain.usecase.CleanUseCaseImpl
import com.smartphonecleaner.pro.domain.usecase.IAnalyzeUseCase
import com.smartphonecleaner.pro.domain.usecase.IBoostUseCase
import com.smartphonecleaner.pro.domain.usecase.ICleanUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class ViewModelModule {
    // Module for ViewModel dependencies

    @Binds
    abstract fun bindAnalyzeUseCase(useCase: AnalyzeUseCaseImpl): IAnalyzeUseCase

    @Binds
    abstract fun bindBoostUseCase(useCase: BoostUseCaseImpl): IBoostUseCase

    @Binds
    abstract fun bindCleanUseCase(useCase: CleanUseCaseImpl): ICleanUseCase
}