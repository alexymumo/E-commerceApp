package com.example.ecommerce.data.cache.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ecommerce.data.cache.dao.ProductDao
import com.example.ecommerce.data.cache.entity.ProductEntity


@Database(entities = [ProductEntity::class], exportSchema = false, version = 5)
abstract class AppDatabase: RoomDatabase() {
    abstract val productsDao: ProductDao
}

