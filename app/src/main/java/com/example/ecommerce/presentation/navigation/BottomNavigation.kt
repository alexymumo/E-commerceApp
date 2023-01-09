package com.example.ecommerce.presentation.navigation

import androidx.compose.foundation.layout.displayCutoutPadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNav(navController: NavController) {

    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Favorites,
        NavigationItem.Notification,
        NavigationItem.Cart
    )
    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = Color.Black,
        modifier = Modifier
            .clip(RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp))
            .fillMaxWidth()
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                       Icon(painterResource(id = item.icon!!), contentDescription = null)
                },
                alwaysShowLabel = false,
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
                        restoreState
                    }
                }
            )
        }

    }
}