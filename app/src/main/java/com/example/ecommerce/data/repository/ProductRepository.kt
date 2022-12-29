package com.example.ecommerce.data.repository

import com.example.ecommerce.data.models.Product
import retrofit2.Response

interface ProductRepository {
    suspend fun getProducts(): Response<List<Product>>
}