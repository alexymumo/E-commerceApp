package com.example.ecommerce.data.repository

import com.example.ecommerce.data.api.ApiService
import com.example.ecommerce.data.models.Product
import retrofit2.Response
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(private val apiService: ApiService): ProductRepository {
    override suspend fun getProducts(): Response<List<Product>> {
        return apiService.getProducts()
    }
}