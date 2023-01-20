package com.example.ecommerce.domain.model

data class Favorite(
    val id: Int,
    val category: String,
    val description: String,
    val image: String,
    val price: Double,
    val title: String,
    val favorite: Boolean,
    val rating: FavoriteRating
)

