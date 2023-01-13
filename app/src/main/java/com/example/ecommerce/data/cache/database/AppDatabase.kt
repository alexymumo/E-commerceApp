package com.example.ecommerce.data.cache.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ecommerce.data.cache.dao.FavoriteDao
import com.example.ecommerce.data.cache.dao.ProductDao
import com.example.ecommerce.data.cache.entity.FavoriteEntity
import com.example.ecommerce.data.cache.entity.ProductEntity

@Database(
    entities = [FavoriteEntity::class,ProductEntity::class],
    exportSchema = false,
    version = 2
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun favoriteDao() : FavoriteDao
    abstract val productsDao: ProductDao
}