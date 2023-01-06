package com.example.ecommerce.domain.repository

import com.example.ecommerce.data.remote.dto.ProductDto

interface ProductRepository {
    suspend fun getProducts(): List<ProductDto>
}