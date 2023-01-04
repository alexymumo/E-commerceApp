package com.example.ecommerce.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommerce.data.cache.model.FavoriteEntity
import com.example.ecommerce.data.repository.FavoriteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(private val favoriteRepository: FavoriteRepository): ViewModel() {
    fun saveProduct(favoriteEntity: FavoriteEntity) {
        viewModelScope.launch {
            favoriteRepository.saveProduct(favoriteEntity)
        }
    }
    val favoriteProducts = favoriteRepository.getAllFavorites()
}