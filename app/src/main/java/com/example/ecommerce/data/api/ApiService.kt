package com.example.ecommerce.data.api

import com.example.ecommerce.data.models.ProductResponse
import retrofit2.http.GET

interface ApiService {
    @GET("products")
    suspend fun getProducts(): ProductResponse
}