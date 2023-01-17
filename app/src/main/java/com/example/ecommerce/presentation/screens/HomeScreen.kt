package com.example.ecommerce.presentation.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ecommerce.presentation.viewmodels.ProductViewModel
import com.example.ecommerce.presentation.views.CustomSearchBar
import com.example.ecommerce.presentation.views.ProductItem
import com.example.ecommerce.presentation.views.TopBar
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination(start = true)
@Composable
fun HomeScreen(
    navigator: DestinationsNavigator,
    viewModel: ProductViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {
            Row(
                horizontalArrangement = Arrangement.Center
            ) {
                TopAppBar(
                    modifier = Modifier.fillMaxWidth(),
                    contentColor = Color.Black,
                    backgroundColor = Color.White
                ) {
                    Text(
                        text = "Explore",
                        textAlign = TextAlign.Center,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    ) {
        val state = viewModel.state.value
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
                .testTag("HomeScreen")
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
        text = "All Shoes",
        maxLines = 1,
        modifier = Modifier.
        clip(RoundedCornerShape(8.dp))
    )
}
@Preview
@Composable
fun CategoryItemPreview() {
        CategoryItem()

}