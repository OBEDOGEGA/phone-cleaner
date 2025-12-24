package com.smartcleaner.pro.di

import com.smartcleaner.pro.domain.usecase.AnalyzeUseCaseImpl
import com.smartcleaner.pro.domain.usecase.BoostUseCaseImpl
import com.smartcleaner.pro.domain.usecase.IAnalyzeUseCase
import com.smartcleaner.pro.domain.usecase.IBoostUseCase
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
}