package com.example.ecommerce.data.cache.typeconverter

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.ecommerce.data.cache.entity.FavoriteRatingEntity
import com.google.gson.Gson

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