package com.example.ecommerce.presentation.screens

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.tooling.preview.Preview
import com.example.ecommerce.domain.model.Product
import com.example.ecommerce.presentation.views.DetailItem
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@ExperimentalTextApi
@Destination
@Composable
fun DetailScreen(
    product: Product,
    navigator: DestinationsNavigator
   //favoriteViewModel: FavoriteViewModel = hiltViewModel()
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
                IconButton(onClick = {
                    /*favoriteViewModel.saveFavorite(
                        Favorite(
                            id = product.id,
                            category = product.category,
                            description = product.description,
                            image = product.image,
                            price = product.price,
                            title = product.title,
                            favorite = true,
                            rating = product.rating.toRating()
                        )
                    )*/
                }) {
                    Icon(
                        Icons.Outlined.FavoriteBorder,
                        tint = Color.Green,
                        contentDescription = null
                    )
                }
            }
        }
    ){
        DetailItem(product = product)
    }
}

@Preview
@Composable
fun DetailItemPreview() {
    //DetailItem()
}