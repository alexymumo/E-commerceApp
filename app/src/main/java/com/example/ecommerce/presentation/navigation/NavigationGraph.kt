package com.example.ecommerce.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ecommerce.presentation.screens.CartScreen
import com.example.ecommerce.presentation.screens.DetailScreen
import com.example.ecommerce.presentation.screens.HomeScreen
import com.example.ecommerce.presentation.screens.NotificationScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route) {
            HomeScreen(navController = navController)
        }

        /*
        composable(NavigationItem.Detail.route) {
            DetailScreen()
        }
         */
        composable(NavigationItem.Favorites.route) {
            DetailScreen()
        }
        composable(NavigationItem.Notification.route) {
            NotificationScreen()
        }
        composable(NavigationItem.Cart.route) {
            CartScreen()
        }
    }

}