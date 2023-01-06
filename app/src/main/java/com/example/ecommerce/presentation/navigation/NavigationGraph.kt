package com.example.ecommerce.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ecommerce.presentation.screens.CartScreen
import com.example.ecommerce.presentation.screens.FavoriteScreen
import com.example.ecommerce.presentation.screens.HomeScreen
import com.example.ecommerce.presentation.screens.NotificationScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomNavItem.Home.route) {
        composable(BottomNavItem.Home.route) {
            HomeScreen()
        }
        composable(BottomNavItem.Favorites.route) {
            FavoriteScreen()
        }
        composable(BottomNavItem.Notification.route) {
            NotificationScreen()
        }
        composable(BottomNavItem.Cart.route) {
            CartScreen()
        }
    }

}