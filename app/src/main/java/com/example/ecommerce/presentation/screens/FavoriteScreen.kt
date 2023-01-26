package com.example.ecommerce.presentation.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.ecommerce.presentation.views.FavoriteItem
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun FavoriteScreen(
    //viewModel: FavoriteViewModel = hiltViewModel(),
    navigator: DestinationsNavigator
) {
    Scaffold(
        topBar = {
            Row {
                IconButton(onClick = {
                    navigator.popBackStack()
                }) {
                    Icon(
                        Icons.Default.ArrowBack,
                        contentDescription = null
                    )
                }
            }
        }
    ) {
       // val favorite = viewModel.favorites.observeAsState(initial = emptyList())
        LazyColumn(contentPadding = PaddingValues(all = 5.dp)) {
            items(10) {
                FavoriteItem()
            }
        }
    }
}