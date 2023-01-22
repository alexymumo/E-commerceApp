package com.example.ecommerce.data.cache.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.ecommerce.data.cache.dao.FavoriteDao
import com.example.ecommerce.data.cache.entity.FavoriteEntity
import com.example.ecommerce.data.cache.typeconverter.RatingConverter

@Database(entities = [FavoriteEntity::class], exportSchema = false, version = 1)
@TypeConverters(RatingConverter::class)
abstract class FavoriteDatabase : RoomDatabase() {
    abstract val favoriteDao: FavoriteDao
}