package com.example.ecommerce.presentation.navigation

import com.example.ecommerce.R

sealed class NavigationItem(var title: String, var icon: Int?, var route: String) {
    object Home : NavigationItem("Home", R.drawable.ic_home, "home")
    object Cart : NavigationItem("Cart", R.drawable.ic_cart, "cart")
    object Notification: NavigationItem("Notifications", R.drawable.ic_notifications, "notifications")
    object Favorites : NavigationItem("Favorites", R.drawable.ic_favorite, "favorites")
    //object Detail : NavigationItem(null, null, "details")
}
