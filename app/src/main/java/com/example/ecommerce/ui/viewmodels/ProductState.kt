package com.example.ecommerce.ui.viewmodels

import com.example.ecommerce.data.models.Product

data class ProductState(
    val itemList: List<Product> = emptyList(),
    val loading: Boolean = false,
    val error: String? = null
)
