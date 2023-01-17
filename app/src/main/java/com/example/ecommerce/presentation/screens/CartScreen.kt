
package com.example.ecommerce.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecommerce.R
import com.example.ecommerce.presentation.views.FavoriteItem
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun CartScreen(
    navigator: DestinationsNavigator
) {
    Scaffold(
        topBar = {
            Row(
                modifier = Modifier.fillMaxWidth()
            ){
                IconButton(onClick = { navigator.popBackStack() }) {
                    Icon(
                        Icons.Default.ArrowBack,
                        contentDescription = null
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "My Cart",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    ){
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            LazyColumn(modifier = Modifier.padding(5.dp)) {
                items(10) {
                    CartItem()
                }
            }
        }
    }
}


@Composable
fun CartItem() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(5.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = 20.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.img),
                contentScale = ContentScale.Inside,
                modifier = Modifier
                    .height(80.dp)
                    .width(80.dp).clip(RoundedCornerShape(8.dp)),
                contentDescription = "favorite image",
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = "Gray Jacket",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview
@Composable
fun CartItemPreview() {
    CartItem()
}

@Preview
@Composable
fun CartScreenPreview() {

}