package com.example.ecommerce.data.repository

import com.example.ecommerce.data.cache.dao.FavoriteDao
import com.example.ecommerce.data.cache.model.FavoriteEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FavoriteRepositoryImpl @Inject constructor(private val favoriteDao: FavoriteDao): FavoriteRepository {
    override suspend fun saveProduct(favoriteEntity: FavoriteEntity) {
        favoriteDao.saveProduct(favoriteEntity)
    }

    override fun getAllFavorites(): Flow<List<FavoriteEntity>> {
        return favoriteDao.getAllProducts()
    }
}