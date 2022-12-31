package com.example.ecommerce.ui.viewmodels

import com.example.ecommerce.data.models.Product

data class UiState(
    val success: List<Product> = emptyList(),
    val loading: Boolean = false,
    val error: String? = null
)
