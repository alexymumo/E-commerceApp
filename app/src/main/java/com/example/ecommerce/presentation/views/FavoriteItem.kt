package com.example.ecommerce.presentation.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.ecommerce.R
import com.example.ecommerce.data.cache.entity.FavoriteEntity


@Composable
fun FavoriteCard(favoriteEntity: FavoriteEntity) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(100.dp)
        .padding(10.dp),
        elevation = 10.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.Start
        ) {
            Card(
                elevation = 10.dp,
                modifier = Modifier
                    .height(80.dp)
                    .width(80.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                Image(
                    modifier = Modifier.clip(RoundedCornerShape(8.dp)),
                    painter = painterResource(id = R.drawable.img),
                    contentScale = ContentScale.Fit,
                    contentDescription = null
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = favoriteEntity.title,
                fontSize = 18.sp,
                color = Color.Green
            )
            Text(
                text = favoriteEntity.description,
                fontSize = 18.sp,
                color = Color.Green
            )
        }
    }
}

@Preview
@Composable
fun FavoriteCardPreview() {
   // FavoriteCard()
}