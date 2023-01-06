package com.example.ecommerce.presentation.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommerce.common.Resource
import com.example.ecommerce.domain.usecase.GetProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(private val getProductsUseCase: GetProductsUseCase) : ViewModel() {
    private val _state = mutableStateOf(ProductState())
    val state: State<ProductState> = _state

    init {
        getProducts()
    }
    private fun getProducts() {
        getProductsUseCase().onEach { item ->
            when(item) {
                is Resource.Success -> {
                    _state.value = ProductState(products = item.data ?: emptyList())
                }
                is Resource.Error -> {

                }
                is Resource.Loading -> {

                }
            }
        }.launchIn(viewModelScope)
    }
}