package com.example.ecommerce.presentation.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.rounded.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecommerce.R

@Composable
fun TopBar() {
    Column(
        horizontalAlignment = Alignment.Start
    ) {
        TopAppBar(
            modifier = Modifier.fillMaxWidth(),
            navigationIcon = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Icon(
                        Icons.Outlined.Person,
                        contentDescription = null
                    )
                    Text(
                        text = "Hi, Alex",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                }
            },
            title = {

            },
            backgroundColor = Color.White,
            )
    }

}

@Preview
@Composable
fun TopBarPreview() {
    TopBar()
}


/*
val navController = rememberNavController()
Column {
    TopAppBar(
        elevation = 4.dp,
        title = {
            Text(text = "E-commerce")
        },
        backgroundColor = MaterialTheme.colors.background,
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Filled.ArrowBack, null)
            }
        }, actions = {
            IconButton(onClick = {
                navController.navigate("cart")
                //navController.navigate(CartScreen())
            }) {
                Icon(Icons.Filled.ShoppingCart, null)
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Filled.Settings, null)
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Filled.Notifications, null)
            }
        }
    )
}
*/