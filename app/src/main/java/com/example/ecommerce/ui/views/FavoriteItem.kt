package com.example.ecommerce.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.rememberImagePainter
import com.example.ecommerce.data.cache.model.FavoriteEntity

@Composable
fun FavoriteItem(
    favoriteItem: FavoriteEntity
) {
    Column {
        Image(
            painter = rememberImagePainter(data = favoriteItem.image),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Fit
        )
    }
}