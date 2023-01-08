package com.example.ecommerce.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
//import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.ecommerce.domain.model.Product
import com.example.ecommerce.presentation.views.CategoryItem

@Composable
fun DetailScreen() {
    
    
    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {
            AsyncImage(
                model = "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.height(5.dp))

        Card(
            contentColor = Color.Green,
            backgroundColor = MaterialTheme.colors.primaryVariant,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column {

                Text(text = "Description")
                Text(text = "Slim-fitting style, contrast raglan long sleeve, three-button henley placket, light weight & soft fabric for breathable and comfortable wearing. And Solid stitched shirts with round neck made for durability and a great fit for casual fashion wear and diehard baseball fans. The Henley style round neckline includes a three-button placket.")
                Text(
                    text = "Jewellery",
                    modifier = Modifier.border(
                        width = 1.dp,
                        color = Color.Green,
                        shape = RoundedCornerShape(50.dp)
                    )
                )
            }

        }
    }
}


@Preview
@Composable
fun DetailScreenPreview() {
    DetailScreen()
}