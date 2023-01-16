package com.example.ecommerce.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.ecommerce.presentation.screens.destinations.*


sealed class BottomNavItem(var title: String, val icon: ImageVector, var destination:Destination) {
    object Home : BottomNavItem(
        title = "Home",
        icon = Icons.Outlined.Home,
        destination = HomeScreenDestination
    )
    object Cart : BottomNavItem(
        title = "Cart",
        icon = Icons.Outlined.ShoppingCart,
        destination = CartScreenDestination
    )
    object Favorite : BottomNavItem(
        title = "Favorite",
        icon = Icons.Outlined.Favorite,
        destination = FavoriteScreenDestination
    )
    object Account : BottomNavItem(
        title = "Account",
        icon = Icons.Outlined.AccountCircle,
        destination = NotificationScreenDestination
    )
}
