package com.example.ecommerce.domain.repository

import com.example.ecommerce.common.Resource
import com.example.ecommerce.data.remote.dto.ProductDto
import com.example.ecommerce.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    suspend fun getProducts(): List<ProductDto>
    suspend fun fetchProducts(): Flow<Resource<List<Product>>>
}