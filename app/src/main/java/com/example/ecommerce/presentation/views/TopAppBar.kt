package com.example.ecommerce.presentation.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun TopBar() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {


    }
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