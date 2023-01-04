package com.example.ecommerce.ui.views

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.ecommerce.data.api.models.Product

@Composable
fun ProductCard(product: Product) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(170.dp)
            .padding(4.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = 5.dp,
        backgroundColor = Color.Gray
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            val imagePainter = rememberImagePainter(data = product.image)
            Image(
                painter = imagePainter,
                modifier = Modifier
                    .height(110.dp)
                    .width(110.dp),
                contentScale = ContentScale.Crop,
                contentDescription = "Product image"
            )
            Column {
                Text(
                    fontSize = 14.sp,
                    maxLines = 1,
                    text = product.category,
                    //style = MaterialTheme.typography.h4,
                    color = MaterialTheme.colors.primary
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    fontSize = 14.sp,
                    maxLines = 1,
                    text = "$${product.price}",
                    //style = MaterialTheme.typography.h4,
                    color = MaterialTheme.colors.primary
                )
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