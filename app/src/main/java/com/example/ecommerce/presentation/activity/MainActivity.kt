package com.example.ecommerce.presentation.activity

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.ecommerce.presentation.navigation.MainScreen
import com.example.ecommerce.presentation.screens.NavGraphs
import com.example.ecommerce.presentation.screens.destinations.CartScreenDestination
import com.example.ecommerce.presentation.screens.destinations.FavoriteScreenDestination
import com.example.ecommerce.presentation.screens.destinations.HomeScreenDestination
import com.example.ecommerce.presentation.screens.destinations.NotificationScreenDestination
import com.example.ecommerce.presentation.theme.EcommerceTheme
import com.example.ecommerce.presentation.views.NoInternetItem
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.rememberNavHostEngine
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val connectionManager = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo: NetworkInfo? = connectionManager.activeNetworkInfo
        val isMobileConnected: Boolean = networkInfo?.isConnected == true

        if (isMobileConnected) {
            setContent {
                EcommerceTheme {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colors.onPrimary
                    ) {
                        val navController = rememberNavController()
                        val navHostEngine = rememberNavHostEngine()
                        val navBackStackEntry by navController.currentBackStackEntryAsState()
                        val route = navBackStackEntry?.destination?.route

                        MainScreen(
                            navController = navController,
                            showBottomBar = route in listOf(
                                HomeScreenDestination.route,
                                FavoriteScreenDestination.route,
                                CartScreenDestination.route,
                                NotificationScreenDestination.route
                            )
                        ) { paddingValues ->
                            Box(modifier = Modifier.padding(paddingValues)) {
                                DestinationsNavHost(
                                    navGraph = NavGraphs.root,
                                    navController = navController,
                                    engine = navHostEngine
                                )
                            }
                        }
                    }
                }
            }
        } else {
            setContent {
                EcommerceTheme {
                    Surface(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        NoInternetItem(this)
                    }
                }
            }
        }

    }
}




