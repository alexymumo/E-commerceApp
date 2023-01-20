package com.example.ecommerce.data.cache.entity

import androidx.room.Entity

@Entity(tableName = "favorite_rating_entity")
data class FavoriteRatingEntity(
    val count: Int,
    val rate: Double
)
