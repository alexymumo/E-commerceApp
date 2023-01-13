package com.example.ecommerce.presentation.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ecommerce.presentation.viewmodels.FavoriteViewModel
import com.example.ecommerce.presentation.views.FavoriteCard

@Composable
fun FavoriteScreen(
    viewModel: FavoriteViewModel = hiltViewModel()
) {
    val state = viewModel.favorites.collectAsState(initial = listOf())
    LazyColumn(modifier = Modifier.padding(10.dp)) {
        items(items = state.value) { item ->
            //FavoriteCard(favoriteItem = item)
        }

    }
    
}