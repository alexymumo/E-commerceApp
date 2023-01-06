package com.example.ecommerce.presentation.screens

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.ecommerce.presentation.navigation.BottomNav
import com.example.ecommerce.presentation.navigation.NavigationGraph
import com.example.ecommerce.presentation.theme.EcommerceTheme
import com.example.ecommerce.presentation.views.TopBar

@Composable
fun MainScreen() {
    EcommerceTheme {
        val navController = rememberNavController()
        Scaffold(
            topBar = {
                TopBar()
            },
            bottomBar = {
                BottomNav(navController = navController)
            }
        ) {
            NavigationGraph(navController = navController)
        }
    }
}


@Preview
@Composable
fun MainScreenPreview() {
    EcommerceTheme {
        MainScreen()
    }
}