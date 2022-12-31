package com.example.ecommerce.ui.screens

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.ecommerce.ui.navigation.BottomNav
import com.example.ecommerce.ui.navigation.NavigationGraph
import com.example.ecommerce.ui.theme.EcommerceTheme

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNav(navController = navController)
        }
    ) {
        NavigationGraph(navController = navController)
    }
}


@Preview
@Composable
fun MainScreenPreview() {
    EcommerceTheme {
        MainScreen()
    }
}