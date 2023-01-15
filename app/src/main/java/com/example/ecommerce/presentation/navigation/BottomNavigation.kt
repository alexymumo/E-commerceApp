package com.example.ecommerce.presentation.navigation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNav(navController: NavController) {

    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Favorite,
        BottomNavItem.Cart,
        BottomNavItem.Account
    )
    BottomNavigation(
        backgroundColor = Color.Cyan,
        contentColor = Color.Black,
        modifier = Modifier
            .padding(top = 15.dp, end = 15.dp, bottom = 15.dp, start = 15.dp)
            .clip(RoundedCornerShape(15.dp,15.dp,15.dp,15.dp))
            .fillMaxWidth()
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        item.icon,
                        contentDescription = null
                    )
                },
                alwaysShowLabel = true,
                selectedContentColor = Color.Black,
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
                        restoreState = true
                    }
                }
            )
        }

    }
}