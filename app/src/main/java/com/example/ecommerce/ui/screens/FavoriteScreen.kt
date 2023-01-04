package com.example.ecommerce.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ecommerce.data.cache.model.FavoriteEntity
import com.example.ecommerce.ui.viewmodels.FavoriteViewModel
import com.example.ecommerce.ui.views.FavoriteItem

@Composable
fun FavoriteScreen(
    viewModel: FavoriteViewModel = hiltViewModel()
) {
    val favoriteProducts = viewModel.favoriteProducts.collectAsState(initial = emptyList())

    LazyColumn {
        items(items =favoriteProducts.value, key = { item: FavoriteEntity -> item.id }) { favoriteProducts ->
            FavoriteItem(favoriteItem = favoriteProducts)
        }
    }

}