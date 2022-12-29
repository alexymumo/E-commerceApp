package com.example.ecommerce.di


import com.example.ecommerce.data.repository.ProductRepository
import com.example.ecommerce.data.repository.ProductRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun providesProductRepository(productRepositoryImpl: ProductRepositoryImpl): ProductRepository
}