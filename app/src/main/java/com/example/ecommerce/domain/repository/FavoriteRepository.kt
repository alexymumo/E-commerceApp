package com.example.ecommerce.domain.repository

import androidx.lifecycle.LiveData
import com.example.ecommerce.data.cache.entity.FavoriteEntity
import com.example.ecommerce.domain.model.Favorite

interface FavoriteRepository {
    suspend fun saveProduct(favorite: Favorite)

    suspend fun deleteFavorite(favorite: Favorite)

    fun getFavorites(): LiveData<List<FavoriteEntity>>
}
