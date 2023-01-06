package com.example.ecommerce.presentation.viewmodels

import com.example.ecommerce.domain.model.Product


data class ProductState(
    val products: List<Product> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
