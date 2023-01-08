package com.example.ecommerce.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.ecommerce.presentation.viewmodels.ProductViewModel
import com.example.ecommerce.presentation.views.ProductItem

@Composable
fun HomeScreen(
    viewModel: ProductViewModel = hiltViewModel(),
    navController: NavController
) {
    val state = viewModel.state.value

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(state.products) { product ->
                ProductItem(
                    product = product,
                    onClick = {
                        //product -> navController.navigate(NavigationItem.Detail.route)
                    }
                )
            }
        }
    }
}