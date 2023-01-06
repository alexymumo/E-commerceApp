package com.example.ecommerce.data.di

import com.example.ecommerce.common.Constants
import com.example.ecommerce.data.remote.api.FakeStoreApi
import com.example.ecommerce.data.repository.ProductRepositoryImpl
import com.example.ecommerce.domain.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun providesFakeStoreApi(): FakeStoreApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FakeStoreApi::class.java)
    }

    @Provides
    @Singleton
    fun productsProductRepository(fakeStoreApi: FakeStoreApi): ProductRepository {
        return ProductRepositoryImpl(fakeStoreApi)
    }
}