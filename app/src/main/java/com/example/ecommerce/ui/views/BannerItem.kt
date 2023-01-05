package com.example.ecommerce.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ecommerce.R

@Composable
fun BannerItem() {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(all = 4.dp),
            shape = RoundedCornerShape(8.dp),
            elevation = 20.dp,
            backgroundColor = Color.LightGray
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_favorite),
                contentDescription = null
            )
        }
}

@Preview
@Composable
fun BannerItemPreview() {
    BannerItem()
}