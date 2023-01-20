package com.example.ecommerce.data.cache.database

import androidx.room.*
import com.example.ecommerce.data.cache.dao.FavoriteDao
import com.example.ecommerce.data.cache.dao.ProductDao
import com.example.ecommerce.data.cache.entity.FavoriteEntity
import com.example.ecommerce.data.cache.entity.FavoriteRatingEntity
import com.example.ecommerce.data.cache.entity.ProductEntity
import com.google.gson.Gson

@Database(entities = [FavoriteEntity::class,ProductEntity::class], exportSchema = false, version = 2)
abstract class AppDatabase: RoomDatabase() {
    abstract val favoriteDao : FavoriteDao
    abstract val productsDao: ProductDao
}

@ProvidedTypeConverter
class RatingConverter(private val json: Gson) {
    @TypeConverter
    fun fromRating(ratingEntity: FavoriteRatingEntity): String {
        return json.toJson(ratingEntity)
    }
    @TypeConverter
    fun toRating(ratingEntity: String): FavoriteRatingEntity {
        return json.fromJson(ratingEntity, FavoriteRatingEntity::class.java)
    }
}