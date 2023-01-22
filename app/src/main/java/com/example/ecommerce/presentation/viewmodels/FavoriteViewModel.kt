package com.example.ecommerce.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommerce.domain.model.Favorite
import com.example.ecommerce.domain.repository.FavoriteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavoriteViewModel(private val favoriteRepository: FavoriteRepository): ViewModel() {

    val favorites = favoriteRepository.getFavorites()

    fun saveFavorite(favorite: Favorite) {
        viewModelScope.launch(Dispatchers.IO) {
            favoriteRepository.saveProduct(favorite)
        }
    }

    fun deleteFavorite(favorite: Favorite) {
        viewModelScope.launch(Dispatchers.IO) {
            favoriteRepository.deleteFavorite(favorite)
        }
    }
}