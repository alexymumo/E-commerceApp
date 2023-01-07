package com.example.ecommerce.data.cache.mappers

import com.example.ecommerce.data.cache.entity.ProductEntity
import com.example.ecommerce.data.cache.entity.RatingEntity
import com.example.ecommerce.domain.model.Product
import com.example.ecommerce.domain.model.Rating

fun ProductEntity.toDomain(): Product {
    return Product(
        this.category,
        this.description,
        this.id,
        this.image,
        this.price,
        this.title,
        this.rating.toDomain()
    )
}

fun RatingEntity.toDomain(): Rating {
    return Rating(
        this.count,
        this.rate
    )
}