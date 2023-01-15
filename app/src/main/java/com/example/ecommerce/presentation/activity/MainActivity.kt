package com.example.ecommerce.presentation.activity

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.example.ecommerce.presentation.screens.MainScreen
import com.example.ecommerce.presentation.theme.EcommerceTheme
import com.example.ecommerce.presentation.views.NoInternetItem
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
                        color = MaterialTheme.colors.background
                    ) {
                        MainScreen()
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




