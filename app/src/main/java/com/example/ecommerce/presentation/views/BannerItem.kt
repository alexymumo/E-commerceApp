package com.example.ecommerce.presentation.views

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BannerItem() {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(all = 4.dp)
    ) {
        Text(
            text = "Welcome,",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Our Fashions App",
            color = Color.Gray.copy(1f),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
    }

}


@Preview
@Composable
fun BannerItemPreview() {
    BannerItem()
}
