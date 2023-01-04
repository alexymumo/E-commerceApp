package com.example.ecommerce.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ecommerce.ui.screens.*

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