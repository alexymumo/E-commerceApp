package com.example.ecommerce.data.cache.mappers

import com.example.ecommerce.data.cache.entity.ProductEntity
import com.example.ecommerce.data.cache.entity.RatingEntity
import com.example.ecommerce.data.remote.dto.ProductDto
import com.example.ecommerce.data.remote.dto.RatingDto

fun ProductDto.toEntity(): ProductEntity {
    return ProductEntity(
        this.id,
        this.category,
        this.description,
        this.image,
        this.price,
        this.title,
        this.rating.toEntity()
    )
}

fun RatingDto.toEntity(): RatingEntity {
    return RatingEntity(
        this.count,
        this.rate
    )
}
