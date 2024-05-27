package com.ibrahimethemsen.pigeon.di

import com.ibrahimethemsen.pigeon.repository.NetworkRepository
import com.ibrahimethemsen.pigeon.repository.NetworkRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun binds(impl : NetworkRepositoryImpl) : NetworkRepository
}