package com.example.ecommerce.data.repository

import com.example.ecommerce.data.cache.entity.FavoriteEntity
import kotlinx.coroutines.flow.Flow

interface FavoriteRepository {
    suspend fun saveProduct(favoriteEntity: FavoriteEntity)

    fun getAllFavorites(): Flow<List<FavoriteEntity>>
}