package com.example.ecommerce.presentation.screens

//import coil.compose.AsyncImage
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.ecommerce.R
import com.example.ecommerce.data.cache.entity.FavoriteEntity
import com.example.ecommerce.domain.model.Product
import com.example.ecommerce.presentation.viewmodels.FavoriteViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun DetailScreen(
    product: Product,
    navigator: DestinationsNavigator,
    favoriteViewModel: FavoriteViewModel = hiltViewModel()
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
                    favoriteViewModel.saveFavorite(
                        FavoriteEntity(
                            id = product.id,
                            category = product.category,
                            description = product.description,
                            image = product.image,
                            price = product.price,
                            title = product.title
                        )
                    )
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

@Composable
fun DetailItem(
    product: Product
) {
    Column(modifier = Modifier.fillMaxSize()) {
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
                    .height(100.dp)
                    .width(100.dp)
                ,
                contentDescription = "product image"
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        Card(
            backgroundColor = MaterialTheme.colors.primary,
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
        ) {
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                Text(
                    text = product.title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = product.category,
                    fontWeight = FontWeight.Normal,
                    color = Color.Gray,
                    fontSize = 14.sp
                )
                Text(
                    text = "Size",
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Row {
                    Text(
                        text = "M",
                        modifier = Modifier.border(
                            width = 1.dp,
                            shape = CircleShape,
                            color = Color.LightGray
                        )
                    )
                    Text(
                        fontSize = 16.sp,
                        text = "S",
                        modifier = Modifier.border(
                            width = 1.dp,
                            shape = CircleShape,
                            color = Color.LightGray
                        )
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
                    //text = "Slim-fitting style, contrast raglan long sleeve, three-button henley placket, light weight & soft fabric for breathable and comfortable wearing. And Solid stitched shirts with round neck made for durability and a great fit for casual fashion wear and diehard baseball fans. The Henley style round neckline includes a three-button placket."
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

                        }
                    )
                }

            }

        }
    }
}


@Composable
fun DetailICode() {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.img),
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp)
                    .background(Color.White),
                contentDescription = "product image",
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        Card(
            backgroundColor = MaterialTheme.colors.primary,
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
        ) {
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                Text(
                    text = "Green Bracelet",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Jewellery",
                    fontWeight = FontWeight.Normal,
                    color = Color.Gray,
                    fontSize = 18.sp,
                    modifier = Modifier.border(
                        width = 2.dp,
                        shape = CircleShape,
                        color = Color.LightGray
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
                        text = "4.6",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "86 Reviews",
                        fontSize = 18.sp,
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
                    //text = product.description
                    text = "Slim-fitting style, contrast raglan long sleeve, three-button henley placket, light weight & soft fabric for breathable and comfortable wearing. And Solid stitched shirts with round neck made for durability and a great fit for casual fashion wear and diehard baseball fans. The Henley style round neckline includes a three-button placket."
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
                            text = "$ 34",
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

                        }
                    )
                }

            }

        }
    }

}

@Preview
@Composable
fun DetailCodePreview() {
    DetailICode()
}

@Preview
@Composable
fun DetailItemPreview() {
    //DetailItem()
}