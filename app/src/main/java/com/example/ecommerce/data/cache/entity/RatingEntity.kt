package com.example.ecommerce.data.cache.entity

import androidx.room.Entity

@Entity
data class RatingEntity(
    val count: Int,
    val rate: Double
)
