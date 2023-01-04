package com.example.ecommerce.ui.navigation

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNav(navController: NavController) {

    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Favorites,
        BottomNavItem.Notification,
        BottomNavItem.Cart
    )
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = Color.Black
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                       Icon(painterResource(id = item.icon), contentDescription = null)
                },
                alwaysShowLabel = true,
                selectedContentColor = Color.Black ,
                unselectedContentColor = Color.Black.copy(0.4f, 0.1f),
                label = { Text(text = item.title, fontSize = 9.sp) },
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { screen ->
                            popUpTo(screen) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState
                    }
                }
            )
        }

    }
}