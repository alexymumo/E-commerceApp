package com.example.ecommerce.data.repository

import com.example.ecommerce.data.models.Product
import com.example.ecommerce.utils.NetworkResult
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    suspend fun getProducts(): Flow<NetworkResult<List<Product>>>
}