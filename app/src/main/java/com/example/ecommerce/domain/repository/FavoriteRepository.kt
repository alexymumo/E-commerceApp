package com.example.ecommerce.domain.repository

import androidx.lifecycle.LiveData
import com.example.ecommerce.data.cache.entity.FavoriteEntity
import kotlinx.coroutines.flow.Flow

interface FavoriteRepository {
    suspend fun saveProduct(favoriteEntity: FavoriteEntity)

    suspend fun deleteFavorite(favoriteEntity: FavoriteEntity)

    fun getFavorites(): LiveData<List<FavoriteEntity>>
}
