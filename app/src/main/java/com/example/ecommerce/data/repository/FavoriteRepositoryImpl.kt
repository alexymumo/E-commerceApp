package com.example.ecommerce.data.repository

import androidx.lifecycle.LiveData
import com.example.ecommerce.data.cache.dao.FavoriteDao
import com.example.ecommerce.data.cache.entity.FavoriteEntity
import com.example.ecommerce.domain.repository.FavoriteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FavoriteRepositoryImpl @Inject constructor(private val favoriteDao: FavoriteDao): FavoriteRepository {
    override suspend fun saveProduct(favoriteEntity: FavoriteEntity) {
        favoriteDao.saveProduct(favoriteEntity)
    }
    override suspend fun deleteFavorite(favoriteEntity: FavoriteEntity) {
        favoriteDao.deleteFavorite(favoriteEntity)
    }

    override fun getFavorites(): LiveData<List<FavoriteEntity>> {
        return favoriteDao.getProducts()
    }
}