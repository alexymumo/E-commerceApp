package com.example.ecommerce.ui.uistates

import com.example.ecommerce.data.api.models.Product

data class UiState(
    val items: List<Product> = emptyList(),
    val loading: Boolean = false,
    val error: String? = null
)
