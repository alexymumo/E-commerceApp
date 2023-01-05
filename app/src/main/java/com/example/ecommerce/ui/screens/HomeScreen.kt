package com.example.ecommerce.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ecommerce.ui.viewmodels.ProductViewModel
import com.example.ecommerce.ui.views.BannerItem
import com.example.ecommerce.ui.views.ProductItem

@Composable
fun HomeScreen(
    viewModel: ProductViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        BannerItem()


        LazyColumn {
            if (state.loading) {
                item {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .fillMaxSize()
                            .wrapContentSize(align = Alignment.Center)
                    )
                }
            }
            items(state.items) { items ->
                ProductItem(product = items)
            }
        }

    }
}