package com.example.ecommerce.ui.viewmodels

import com.example.ecommerce.data.repository.ProductRepository
import javax.inject.Inject

class ProductViewModel @Inject constructor(private val productRepository: ProductRepository) {
}