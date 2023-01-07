package com.example.ecommerce.presentation.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.rememberAsyncImagePainter
import com.example.ecommerce.data.cache.entity.FavoriteEntity

@Composable
fun FavoriteItem(
    favoriteItem: FavoriteEntity
) {
    Column {
        Image(
            painter = rememberAsyncImagePainter(model = favoriteItem.image),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Fit
        )
    }
}