package com.example.ecommerce.presentation.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommerce.data.cache.entity.FavoriteEntity
import com.example.ecommerce.data.repository.FavoriteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(private val favoriteRepository: FavoriteRepository): ViewModel() {

    private val _favorites = MutableStateFlow<List<FavoriteEntity>>(emptyList())
    val favorite = _favorites.asStateFlow()

    init {
        getFavorites()
    }

    private fun getFavorites() {
        viewModelScope.launch(Dispatchers.IO) {
            favoriteRepository.getAllFavorites().distinctUntilChanged().collect { favoriteList ->
                if (favoriteList.isEmpty()) {
                    _favorites.value = emptyList()
                } else {
                    _favorites.value = favoriteList
                }
            }

        }
    }

    fun saveFavorite(favoriteEntity: FavoriteEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            favoriteRepository.saveProduct(favoriteEntity)
        }
    }

    fun deleteFavorite(favoriteEntity: FavoriteEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            favoriteRepository.deleteFavorite(favoriteEntity)
        }
    }
}