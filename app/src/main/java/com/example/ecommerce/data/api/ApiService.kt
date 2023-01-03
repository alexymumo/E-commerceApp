package com.example.ecommerce.data.api

import com.example.ecommerce.data.models.Product
import retrofit2.http.GET

interface ApiService {
    @GET("products")
    suspend fun getProducts(): List<Product>
}