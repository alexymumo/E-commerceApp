package com.example.ecommerce.data.repository

import androidx.lifecycle.LiveData
import com.example.ecommerce.data.cache.dao.FavoriteDao
import com.example.ecommerce.data.cache.entity.FavoriteEntity
import com.example.ecommerce.data.cache.mappers.toEntity
import com.example.ecommerce.domain.model.Favorite
import com.example.ecommerce.domain.repository.FavoriteRepository

class FavoriteRepositoryImpl(private val favoriteDao: FavoriteDao): FavoriteRepository {

    override suspend fun saveProduct(favorite: Favorite) {
        favoriteDao.saveProduct(favorite.toEntity())
    }

    override suspend fun deleteFavorite(favorite: Favorite) {
        favoriteDao.deleteFavorite(favorite.toEntity())
    }

    override fun getFavorites(): LiveData<List<FavoriteEntity>> {
        return favoriteDao.getProducts()
    }
}