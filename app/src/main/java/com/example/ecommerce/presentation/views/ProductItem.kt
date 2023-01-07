package com.example.ecommerce.presentation.views

import android.content.res.Configuration
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.ecommerce.domain.model.Product

@Composable
fun ProductItem(
    product: Product,
    onClick: (product: Product) -> Unit
) {
    val navController = rememberNavController()
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(170.dp)
            .clickable {
                //navController.navigate("details")
            }
            .padding(all = 4.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = 10.dp,
        backgroundColor = Color.LightGray
    ){
        Row{
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(product.image)
                    .crossfade(true)
                    .build(),
                modifier = Modifier
                    .height(170.dp)
                    .width(130.dp),
                contentScale = ContentScale.Crop,
                contentDescription = "Product image"
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column{
                Text(
                    fontSize = 14.sp,
                    maxLines = 1,
                    text = product.title,
                    //style = MaterialTheme.typography.h4,
                    color = MaterialTheme.colors.primary
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    fontSize = 16.sp,
                    maxLines = 1,
                    fontWeight = FontWeight.Bold,
                    text = "Price $${product.price}",
                    //style = MaterialTheme.typography.h4,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    fontSize = 14.sp,
                    text = product.rating.rate.toString(),
                    color = MaterialTheme.colors.primary
                )
                Spacer(modifier = Modifier.height(4.dp))
                CategoryItem(product)
                Spacer(modifier = Modifier.height(4.dp))
                Box(
                    modifier = Modifier
                        .border(
                            width = 1.dp,
                            color = Color.Green,
                            shape = RoundedCornerShape(50.dp)
                        )
                ) {
                    Text(
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colors.primaryVariant,
                        style = MaterialTheme.typography.body2,
                        text = product.rating.rate.toString()
                    )
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Filled.FavoriteBorder, "favorite")
                }
            }
        }
    }
}


@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Dark Mode",
    showBackground = true
)

@Composable
fun ProductCardPreview() {
    //val product = Product("alex", "alex", 1, "https://fakestoreapi.com/img/71-3HjGNDUL._AC_SY879._SX._UX._SY._UY_.jpg","12", "alex")
    //ProductCard(product = product)
}