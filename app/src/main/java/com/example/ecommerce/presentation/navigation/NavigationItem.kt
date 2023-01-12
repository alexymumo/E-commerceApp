package com.example.ecommerce.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(
    val title: String,
    val route: String,
    val icon: ImageVector
) {
    object Home : BottomNavItem(
        title = "Home",
        route = "home",
        icon = Icons.Outlined.Home
    )
    object Cart : BottomNavItem(
        title = "Cart",
        route = "cart",
        icon = Icons.Outlined.ShoppingCart
    )
    object Favorite : BottomNavItem(
        title = "Favorite",
        route = "favorite",
        icon = Icons.Outlined.Favorite
    )
    object Account : BottomNavItem(
        title = "Account",
        route = "account",
        icon = Icons.Outlined.AccountCircle
    )
}
