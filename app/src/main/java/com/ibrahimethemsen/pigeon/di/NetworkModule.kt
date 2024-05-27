package com.ibrahimethemsen.pigeon.di

import com.ibrahimethemsen.pigeon.network.PigeonService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder().build()

    @Singleton
    @Provides
    fun provideWebSocketRequest(): Request {
        return Request.Builder().url("${BASE_URL}investments").build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(
                Json.asConverterFactory(
                "application/json; charset=UTF8".toMediaType())).build()
    }

    @Singleton
    @Provides
    fun provideRestfulService(
        retrofit: Retrofit
    ): PigeonService {
        return retrofit.create(PigeonService::class.java)
    }

    private const val BASE_URL = "http://10.0.2.2:8080/"

}