package com.example.ecommerce.presentation.screens

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ecommerce.presentation.viewmodels.ProductViewModel
import com.example.ecommerce.presentation.views.CustomSearchBar
import com.example.ecommerce.presentation.views.ProductItem
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.example.ecommerce.R
import com.example.ecommerce.presentation.views.HomeToolBar

@Destination(start = true)
@Composable
fun HomeScreen(
    navigator: DestinationsNavigator,
    viewModel: ProductViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {
            HomeToolBar()
        }
    ) {
        val state = viewModel.state.value
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
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
                        navigator = navigator,
                        product = product,
                        modifier = Modifier.width(150.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun CategoryItem() {
    Text(
        text = "Shoes",
        maxLines = 1,
        modifier = Modifier
            .border(
                width = 1.dp,
                shape = CircleShape,
                color = Color.Gray
            )
            .background(Color.White)
    )
}
@Preview
@Composable
fun CategoryItemPreview() {
        CategoryItem()

}