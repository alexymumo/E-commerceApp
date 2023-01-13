package com.example.ecommerce.presentation.views

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TopBar() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopAppBar(
            elevation = 4.dp,
            title = {
                Text(
                    text = "Explore",
                    color = Color.Black
                )
            },
            backgroundColor = Color.Gray,
            navigationIcon = {
                Icon(
                    Icons.Rounded.Person,
                    contentDescription = null
                )
            }
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