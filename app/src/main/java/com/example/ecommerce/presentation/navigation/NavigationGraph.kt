package com.example.ecommerce.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ecommerce.presentation.screens.FavoriteScreen
import com.example.ecommerce.presentation.screens.HomeScreen
import com.example.ecommerce.presentation.screens.LoginScreen
import com.example.ecommerce.presentation.screens.RegisterScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomNavItem.Home.route) {
        composable(BottomNavItem.Home.route) {
            HomeScreen(navController = navController)
        }
        /*
        composable("$route/{product}", arguments = listOf(
                navArgument("product") {
                    type = NavType.StringType
                }
            )
        ) { navBackStackEntry ->
            navBackStackEntry.arguments?.getString("product")?.let { json ->
                val product = Gson().fromJson(json, Product::class.java)
                DetailScreen(product, navController)
            }
        }
         */

        composable(BottomNavItem.Favorite.route) {
            FavoriteScreen()
        }
        composable(BottomNavItem.Account.route) {
            RegisterScreen()
        }
        composable(BottomNavItem.Cart.route) {
            LoginScreen()
        }
    }

}