package com.example.ecommerce.di

import com.example.ecommerce.data.api.ApiService
import com.example.ecommerce.data.cache.dao.FavoriteDao
import com.example.ecommerce.data.repository.FavoriteRepository
import com.example.ecommerce.data.repository.FavoriteRepositoryImpl
import com.example.ecommerce.data.repository.ProductRepository
import com.example.ecommerce.data.repository.ProductRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Provides
    @Singleton
    fun providesProductRepository(apiService: ApiService) : ProductRepository {
        return ProductRepositoryImpl(apiService)
    }

    @Provides
    @Singleton
    fun providesFavoriteRepository(favoriteDao: FavoriteDao): FavoriteRepository {
        return FavoriteRepositoryImpl(favoriteDao)
    }
}