package com.example.ecommerce.data.remote.api

import com.example.ecommerce.data.remote.dto.ProductDto
import com.google.gson.annotations.SerializedName
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface FakeStoreApi {
    @GET("products")
    suspend fun getProducts(): List<ProductDto>

    @POST("auth/login")
    suspend fun loginUser(@Body user: User): AuthResponse
}


data class AuthResponse(
    val auth_token: String
)
data class User(
    @SerializedName("username")
    val username: String,
    @SerializedName("password")
    val password: String
)