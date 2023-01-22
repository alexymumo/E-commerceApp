package com.example.ecommerce.data.cache.mappers

import com.example.ecommerce.data.cache.entity.FavoriteEntity
import com.example.ecommerce.data.cache.entity.FavoriteRatingEntity
import com.example.ecommerce.data.cache.entity.ProductEntity
import com.example.ecommerce.data.cache.entity.RatingEntity
import com.example.ecommerce.domain.model.Favorite
import com.example.ecommerce.domain.model.FavoriteRating
import com.example.ecommerce.domain.model.Product
import com.example.ecommerce.domain.model.Rating

internal fun FavoriteRatingEntity.toDomain(): FavoriteRating {
    return FavoriteRating(
        count = count,
        rate = rate
    )
}

fun FavoriteRating.toEntity(): FavoriteRatingEntity {
    return FavoriteRatingEntity(
        count = count,
        rate = rate
    )
}

fun Favorite.toEntity(): FavoriteEntity {
    return FavoriteEntity(
        id = id,
        category = category,
        description = description,
        image = image,
        price = price,
        title = title,
        favorite = favorite,
        rating = rating.toEntity()
    )
}

fun FavoriteRating.toRatingEntity(): FavoriteRatingEntity {
    return FavoriteRatingEntity(
        count = count,
        rate = rate
    )
}

fun FavoriteEntity.toDomain(): Favorite {
    return Favorite(
        id = id,
        category = category,
        description = description,
        image = image,
        price = price,
        title = title,
        favorite = favorite,
        rating = rating.toDomain()
    )
}

internal fun Rating.toRating(): FavoriteRating {
    return FavoriteRating(
        count = count,
        rate = rate
    )
}
internal fun Product.toProduct(): Favorite {
    return Favorite(
        id = id,
        category = category,
        description = description,
        image = image,
        price = price,
        title = title,
        rating = rating.toRating()
    )
}
internal fun ProductEntity.toDomain(): Product {
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

internal fun RatingEntity.toDomain(): Rating {
    return Rating(
        this.count,
        this.rate
    )
}

