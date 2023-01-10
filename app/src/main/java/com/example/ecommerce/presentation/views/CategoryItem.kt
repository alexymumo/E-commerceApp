package com.example.ecommerce.presentation.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CategoryItem(category: List<String>) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(category) { item ->
            Text(
                text = item,
                modifier = Modifier
                    .background(Color.Green)
                    .padding(10.dp)
                    .clip(
                    shape = RoundedCornerShape(size = 8.dp)
                )
            )
        }
    }
}



@Preview
@Composable
fun CategoryPreview() {
    CategoryItem(category = list)
}

val list = listOf<String>("jewellery", "Footwear", "Fake", "Original")