package com.example.thesport.di

import com.example.thesport.data.repository.SportRepositoryImpl
import com.example.thesport.domain.repository.SportRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindSportRepository (
        sportRepositoryImpl: SportRepositoryImpl
    ): SportRepository
}