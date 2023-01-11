package com.example.ecommerce.presentation.views

import android.graphics.drawable.Icon
import android.widget.ImageButton
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.ecommerce.domain.model.Product


@Composable
fun ProductItem(
    product: Product,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = 5.dp,
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Color.White,
        modifier = Modifier
            .padding(4.dp)
            .clickable { }
    ) {
        Column(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(product.image)
                    .crossfade(true)
                    .build(),
                contentScale = ContentScale.Inside,
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp)
                    .align(CenterHorizontally)
                ,
                contentDescription = "product image"
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = product.title,
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "$ ${product.price}",
                fontSize = 16.sp,
                maxLines = 1,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(10.dp))
            Icon(
                Icons.Outlined.FavoriteBorder,
                tint = Color.Green,
                contentDescription = "favorite"
            )
        }
    }

}

@Preview
@Composable
fun ProductItemPreview() {
    //ProductItem()
}