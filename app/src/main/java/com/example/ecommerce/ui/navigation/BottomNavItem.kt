package com.example.ecommerce.ui.navigation

import com.example.ecommerce.R

sealed class BottomNavItem(var title: String, var icon: Int, var route: String) {
    object Home : BottomNavItem("Home", R.drawable.ic_cart, "home")
    object Cart : BottomNavItem("Cart", R.drawable.ic_cart, "cart")
    object Notification: BottomNavItem("Notifications", R.drawable.ic_cart, "notifications")
    object Chat : BottomNavItem("Chats", R.drawable.ic_cart, "chats")
}
