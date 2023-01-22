package com.example.ecommerce.presentation.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.ecommerce.R
import com.example.ecommerce.domain.model.Product
import com.example.ecommerce.presentation.screens.destinations.DetailScreenDestination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


@Composable
fun ProductItem(
    product: Product,
    modifier: Modifier = Modifier,
    navigator: DestinationsNavigator
) {
    Card(
        elevation = 5.dp,
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Color.White,
        modifier = Modifier
            .padding(4.dp)
            .clickable(onClick = {
                navigator.navigate(DetailScreenDestination(product))
            })
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
                    .align(CenterHorizontally),
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
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {

                Icon(
                    painter = painterResource(id = R.drawable.star),
                    tint = Color.Green,
                    contentDescription = null
                )
                Text(
                    text = "${product.rating.rate}",
                    fontSize = 18.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "$ ${product.price}",
                fontSize = 16.sp,
                maxLines = 1,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start,
                color = Color.Black
            )
        }
    }

}

@Preview
@Composable
fun ProductItemPreview() {
    //ProductItem()
}