package com.example.ecommerce.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ecommerce.presentation.screens.*

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomNavItem.Home.route) {
        composable(BottomNavItem.Home.route) {
            HomeScreen(navController = navController)
        }

        composable(BottomNavItem.Favorite.route) {
            DetailScreen()
        }
        composable(BottomNavItem.Account.route) {
            RegisterScreen()
        }
        composable(BottomNavItem.Cart.route) {
            ForgotPasswordScreen()
        }
    }

}