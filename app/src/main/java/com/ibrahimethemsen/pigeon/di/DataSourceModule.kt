package com.ibrahimethemsen.pigeon.di

import com.ibrahimethemsen.pigeon.datasource.NetworkDataSource
import com.ibrahimethemsen.pigeon.datasource.NetworkDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {
    @Binds
    fun binds(impl : NetworkDataSourceImpl) : NetworkDataSource
}