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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.ecommerce.presentation.viewmodels.ProductViewModel
import com.example.ecommerce.presentation.views.BannerItem
import com.example.ecommerce.presentation.views.ItemImage

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
        BannerItem()
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            val value: String by remember { mutableStateOf("") }
            TextField(
                value = value,
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(4.dp, shape = CircleShape)
                    .background(
                        Color.Transparent, CircleShape
                    ),
                shape = MaterialTheme.shapes.medium,
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                placeholder = {
                    Text(
                        text = "Search...",
                        color = Color.Gray,
                        fontSize = 16.sp
                    )
                },
                onValueChange = {
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Rounded.Search,
                        tint = MaterialTheme.colors.onBackground,
                        contentDescription = "Search"
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Rounded.Clear,
                        tint = MaterialTheme.colors.onBackground,
                        contentDescription = null
                    )
                }
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
            items(state.products) { product ->
                ItemImage(product = product)
            }

        }
    }
}