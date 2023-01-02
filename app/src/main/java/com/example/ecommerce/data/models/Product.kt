package com.example.ecommerce.data.models

data class Product(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: String,
    val title: String
)

data class ProductResponse(
    val products: List<Product>,
    val errorMessage: String
)