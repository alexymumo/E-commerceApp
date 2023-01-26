package com.example.ecommerce.presentation.views

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.ecommerce.R
import com.example.ecommerce.domain.model.Product


@ExperimentalTextApi
@Composable
fun DetailItem(product: Product) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(product.image)
                    .crossfade(true)
                    .build(),
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                contentDescription = "product image"
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        Card(
            backgroundColor = MaterialTheme.colors.primaryVariant,
            elevation = 20.dp,
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
        ) {
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(20.dp)
            ) {
                var gradientColors = listOf(Color.Cyan, Color.LightGray, Color.Yellow)
                Text(
                    text = product.title,
                    fontSize = 18.sp,
                    style =  TextStyle(
                        brush = Brush.linearGradient(colors = gradientColors)
                    ),
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = product.category,
                    fontWeight = FontWeight.Normal,
                    color = Color.Gray,
                    fontSize = 18.sp,
                    modifier = Modifier.border(
                        width = 2.dp,
                        shape = CircleShape,
                        color = Color.Cyan
                    )
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.star),
                        contentDescription = null,
                        tint = Color.Cyan
                    )
                    Text(
                        text = product.rating.rate.toString(),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "${product.rating.count}",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "Reviews",
                        fontSize = 18.sp,
                        style = TextStyle(
                            brush = Brush.linearGradient(colors = gradientColors)
                        ),
                        fontWeight = FontWeight.Bold
                    )
                }
                Text(
                    text = "Description",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black
                )
                Text(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Gray,
                    text = product.description
                )
                Spacer(modifier = Modifier.height(20.dp))
                Row {
                    Column {
                        Text(
                            text = "Total Price",
                            fontSize = 12.sp,
                            color = Color.LightGray,
                            fontWeight = FontWeight.Thin
                        )
                        Text(
                            text = product.price.toString(),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    }
                    Spacer(modifier = Modifier.width(40.dp))
                    ExtendedFloatingActionButton(
                        backgroundColor = Color.Black,
                        icon = {
                            Icon(
                                Icons.Filled.ShoppingCart,
                                contentDescription = null
                            )
                        },
                        text = {
                            Text(
                                text = "Add to cart",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )
                        },
                        onClick = {
                            // add to cart functionality
                        }
                    )
                }
            }
        }
    }
}
