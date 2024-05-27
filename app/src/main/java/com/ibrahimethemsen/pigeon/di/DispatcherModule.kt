package com.ibrahimethemsen.pigeon.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier

@Qualifier
annotation class Dispatcher(val type: Type) {
    enum class Type {
        IO,
        Main
    }
}

@Module
@InstallIn(SingletonComponent::class)
object DispatcherModule {
    @Provides
    @Dispatcher(Dispatcher.Type.IO)
    fun io(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    @Dispatcher(Dispatcher.Type.Main)
    fun main(): CoroutineDispatcher = Dispatchers.Main
}