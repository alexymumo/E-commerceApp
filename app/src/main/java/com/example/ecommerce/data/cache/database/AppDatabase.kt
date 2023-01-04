package com.example.ecommerce.data.cache.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ecommerce.data.cache.dao.FavoriteDao
import com.example.ecommerce.data.cache.model.FavoriteEntity

@Database(entities = [FavoriteEntity::class], exportSchema = false, version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun favoriteDao() : FavoriteDao
}