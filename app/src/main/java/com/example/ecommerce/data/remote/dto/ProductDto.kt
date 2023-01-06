package com.example.ecommerce.data.remote.dto

import com.example.ecommerce.domain.model.Product
import com.example.ecommerce.domain.model.Rating

data class ProductDto(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rating: RatingDto,
    val title: String
)

fun RatingDto.toRating(): Rating {
    return Rating(
        count = count,
        rate = rate
    )
}

fun ProductDto.toProduct(): Product {
    return Product(
        category = category,
        description = description,
        id = id,
        image = image,
        price = price,
        rating = rating.toRating(),
        title = title
    )
}