package com.example.ecommerce.ui.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommerce.data.repository.ProductRepository
import com.example.ecommerce.ui.uistates.UiState
import com.example.ecommerce.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(private val productRepository: ProductRepository): ViewModel() {

    private val _state = mutableStateOf(UiState())
    val state: State<UiState> = _state


    init {
        getProducts()
    }

    private fun getProducts() {
        viewModelScope.launch {
            productRepository.getProducts().collectLatest { products ->
                when(products) {
                    is NetworkResult.Success -> {
                        _state.value = state.value.copy(items = products.data, loading = false)
                    }
                    is NetworkResult.Failure -> {

                    }
                    is NetworkResult.Loading -> {

                    }

                }
            }
        }
    }

    /*
    private fun getProducts() {
        viewModelScope.launch {
            productRepository.getProducts().collect {
                _productResponse.postValue(it)
            }
        }
    }

     */

    /*
    init {
        viewModelScope.launch {
            val products = productRepository.getProducts()
            _state.value = products
        }
    }*/

}