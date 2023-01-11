package com.example.ecommerce.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.ecommerce.presentation.viewmodels.ProductViewModel
import com.example.ecommerce.presentation.views.BannerItem
import com.example.ecommerce.presentation.views.CustomSearchBar
import com.example.ecommerce.presentation.views.ProductItem
import com.example.ecommerce.presentation.views.TopBar

@Composable
fun HomeScreen(
    viewModel: ProductViewModel = hiltViewModel(),
    navController: NavController
) {
    val state = viewModel.state.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        //TopBar()
        //Spacer(modifier = Modifier.height(10.dp))
        //BannerItem()
        //Spacer(modifier = Modifier.height(10.dp))
        CustomSearchBar()
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Select Category",
            fontSize = 18.sp,
            color = Color.Black,
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Popular Products",
            fontSize = 18.sp,
            color = Color.Gray,
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(10.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(2)
        ) {
            items(state.products) { product ->
                ProductItem(
                    product = product,
                    modifier = Modifier.width(150.dp)
                )
                //ItemImage(product = product)
            }

        }
    }
}