package com.example.ecommerce.presentation.views

import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.ecommerce.presentation.screens.CartScreen

@Composable
fun TopBar() {
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
}