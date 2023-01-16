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
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun FavoriteScreen(
    viewModel: FavoriteViewModel = hiltViewModel()
) {
    val favorites = viewModel.favorite.collectAsState().value
   // val state = viewModel.favorites.collectAsState(initial = listOf())
    LazyColumn(modifier = Modifier.padding(10.dp)) {
        items(favorites) { item ->
            FavoriteCard(favoriteEntity = item)
            //FavoriteCard(favoriteItem = item)
        }

    }
    
}